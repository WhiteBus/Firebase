plugins {
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.mobile_programing.white_bus_demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mobile_programing.white_bus_demo"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation ("com.kakao.sdk:v2-user:2.20.1") // 카카오 로그인
    implementation (platform("com.google.firebase:firebase-bom:33.0.0"))
    implementation ("com.google.firebase:firebase-database-ktx") // Realtime Database library
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.firebaseui:firebase-ui-auth:7.2.0") // gradle_firebase_ui_auth
    implementation ("com.google.android.gms:play-services-auth:21.1.1") // Google Play services library
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}