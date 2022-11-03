# TestAndroidSuperHero
TestAndroidSuperHero by @ManuelSalinas

Este proyecto fue creado para cumplir los siguientes lineamientos:

Realizar una aplicación, que muestre un listado de super héroes, con las siguientes características.
 - La lista debe ser infinita.
 - La lista debe de mostrar por cada super héroe su imagen y su nombre.
 - Al seleccionar un super héroe se debe de Mostar la información del super héroe (stats, biografía, apariencia,  trabajos y conexiones)

El consumo de la API es el siguiente. 
http://gateway.marvel.com/v1/public/

Se deben cumplir con los siguientes criterios.
 - Uso de Retrofit para realizar los consumos.
 - Uso de modelo de programación Android de preferencia MVVM
 - Programación en Kotlin.
 - Uso de coroutines.
 - Preferentemente utilizar navigation component.

Subir el proyecto a un repositorio Git para poder revisarlo.

-----------------------------------------------------------------------------------------

Se utilizaron las siguiente librerias para realizar el proyecto:

    //ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'

    //LiveData
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'

    //Activity
    implementation 'androidx.activity:activity-ktx:1.6.1'

    //Fragment
    implementation 'androidx.fragment:fragment-ktx:1.5.4'

    //Images
    implementation 'com.github.bumptech.glide:glide:4.14.2'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.14.2'

    //Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"

    //Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1'

    //Navigation
    implementation "androidx.navigation:navigation-fragment-ktx:2.5.3"
    implementation "androidx.navigation:navigation-ui-ktx:2.5.3"

    //SwipeLoad
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
