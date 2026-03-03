plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.micheldev.discovercastilla_lamancha"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.micheldev.discovercastilla_lamancha"
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
}

dependencies {
    // Dependencias principales de Android
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("androidx.activity:activity:1.8.0")
    implementation("androidx.test:core-ktx:1.6.1")

    // Pruebas unitarias (JUnit 4 y Mockito)
    testImplementation("junit:junit:4.13.2") // ✅ JUnit 4
    testImplementation("org.mockito:mockito-core:4.11.0") // ✅ Mockito para pruebas unitarias
    testImplementation("org.robolectric:robolectric:4.9") // ✅ Para pruebas locales con Robolectric

    // Pruebas instrumentadas en Android
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // ✅ JUnit para Android
    androidTestImplementation("androidx.test:rules:1.6.1") // ✅ Reglas de prueba

    // 🔹 Espresso para pruebas de UI
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // ✅ Core de Espresso
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1") // ✅ Para verificar Intents
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1") // 🔹 Para RecyclerView, listas, etc.
    androidTestImplementation("androidx.test.espresso:espresso-accessibility:3.5.1") // 🔹 Para accesibilidad
    androidTestImplementation("androidx.test.espresso:espresso-web:3.5.1") // 🔹 Si pruebas WebViews
    androidTestImplementation("androidx.test.espresso:espresso-idling-resource:3.5.1") // 🔹 Para pruebas asíncronas

    // 🔹 Mockito para pruebas instrumentadas en Android
    androidTestImplementation("org.mockito:mockito-android:4.11.0")

    // 📌 Firebase BoM (gestiona versiones automáticamente)
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))

    // 🔹 Dependencias específicas de Firebase
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
}
