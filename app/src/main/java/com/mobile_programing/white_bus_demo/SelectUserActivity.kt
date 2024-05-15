package com.mobile_programing.white_bus_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore

class SelectUserActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_user_determinant)

        auth = FirebaseAuth.getInstance()

        val busdriverbtn = findViewById<ImageView>(R.id.bus_driver_button)
        val blindbtn = findViewById<ImageView>(R.id.visual_impaired_button)

        busdriverbtn.setOnClickListener {
            // Update user's blindtype to 0
            updateUserBlindType(false)
        }

        blindbtn.setOnClickListener {
            // Update user's blindtype to 0
            updateUserBlindType(true)
        }
    }

    private fun updateUserBlindType(isBlind: Boolean) {
        val user = auth.currentUser
        val profileUpdates = UserProfileChangeRequest.Builder()
            .setDisplayName(user?.displayName) // Keep other data unchanged
            .build()

        user?.updateProfile(profileUpdates)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Successfully updated the user's profile
                    // Now update custom data (blindtype) in the database
                    val currentUser = auth.currentUser
                    currentUser?.let {
                        // Assume you have a 'users' collection in Firestore
                        val userRef = FirebaseFirestore.getInstance().collection("users").document(it.uid)
                        userRef.update("blindtype", isBlind)
                            .addOnSuccessListener {
                                // Blind type updated successfully
                            }
                            .addOnFailureListener { e ->
                                // Handle failure
                            }
                    }
                } else {
                    // Handle failure
                }
            }
    }
}

