# FIREBASE
## Que es?
[Firebase](https://firebase.google.com/docs/database?hl=es****) es una base de datos alojada para desarollo de aplicaciones web y móvil en la nube que almacena y sincroniza datos en una base de datos [NoSQL](https://aws.amazon.com/es/nosql/).
Los datos se almacenan como [JSON](https://www.ibm.com/docs/es/baw/20.x?topic=formats-javascript-object-notation-json-format) y se sincronizan en tiempo real con cada cliente conectado.
Cuando se crea aplicaciones todos los clientes comparten una instancia de Realtime Database y reciben automáticamente actualizaciones con los datos más recientes.

### Capacidades clave
| Capacidad                            | Descripcion                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
|--------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| TIEMPO REAL                          | `Firebase` utiliza sincronización de datos: cada vez que los datos cambianm cualquier dispositivo conectado recibe esa actualización en milisegundos                                                                                                                                                                                                                                                                                                                                                                        |
| DESCONECTADO                         | Las aplicaciones siguen respondiendo incluso cuando están fuera de línea porque el `SDK` de `Firebase`  conserva sus datos en el disco. Cuando se restablezca la conectividad, el cliente recibe cualquier cambio que se haya perdido y lo sicroniza con el estado actual                                                                                                                                                                                                                                                   |
| ACCESIBLE DESDE DISPOSITIVOS CLIENTE | Se puede acceder directamente desde un dispositivo móvil o navegador web. La seguridad y validación de datos están disponibles a través de la base de datos en tiempo real de `Firebase`, reglas basadas en expresiones cuando se leeo escriben datos                                                                                                                                                                                                                                                                       |
| ESCALAR EN MÚLTIPLES BASES DE DATOS  | Con el plan de precios [Blaze](https://firebase.google.com/pricing?hl=es-419#blaze-calculator), puedes satisfacer las necesidades de datos de tu aplicación a escala dividiendo tus datos en múltiples instancias de base de datos en el mismo proyecto de Firebase. Optimice la autenticacion con [Firebase Authentication](https://firebase.google.com/docs/auth?hl=es) en su proyecto. Controle el acceso a los datos en cada base de datos con reglas de seguridad de Firebase personalizadas para cada instancia de DB |


## Implementación en Android
Aquí os explicaré paso a paso como implementar firebase a tu proyecto de android studio

### Crear una base de datos
Para empezar nuestro proyecto primero tendremos que [crear](https://console.firebase.google.com/project/_/database?hl=es&_gl=1*12n5qi0*_ga*MTY1MjI5MDU5OS4xNzA3MjU3NTQ0*_ga_CW55HF8NVT*MTcwNzI5MjUwNy4yLjEuMTcwNzI5NDQyOS41Ny4wLjA.) la base de datos de Firebase.
Le damos a crear un proyecto y rellenamos los campos

<details>
    <summary>Fotos paso a paso de la creación del proyecto</summary>
    <p>
        Primero tendremos que poner el nombre de nuestro proyecto y aceptar las condiciones de Firebase
        <img src="imagenes/Proyecto1.png"/>
        Despues tendremos que habilitar Google Analytics para el proyecto.
        Si hemos aceptado Google Analytics tendremos que configurar esto mismo:
        <img src="imagenes/Proyecto2.png"/>
    </p>
</details>

### Registrar la app con Firebase
Debemos registrarla app con el proyecto de Firebase. El registro de tu app a menudo se conoce como "agregar" la app a tu proyecto.
1. Dirigirse a Firebase console (deberias tenerlo abierto ya que creaste el proyecto)[pinche aqui si no es asi](https://console.firebase.google.com/?hl=es-419&_gl=1*1rvx8u4*_ga*MTY1MjI5MDU5OS4xNzA3MjU3NTQ0*_ga_CW55HF8NVT*MTcwNzI5MjUwNy4yLjEuMTcwNzI5Njc1MC4xOS4wLjA.) y escoges tu base de datos
2. Haz clic en el icono de Android para iniciar el flujo de trabajo de configuración.![](imagenes/Add1.png)
3. Ingresamos el nombre del paquete de tu app en el campo Nombre del paquete de Android![](imagenes/Add2.png)
4. Descargamos el archivo json y lo guardamos en la carpeta app de nuestro proyecto

![](imagenes/Add3.png)
5. Agregamos el [SDK](#agregar-el-sdk-de-realtime-database-en-la-aplicación-android-studio)

### Agregar el sdk de Realtime Database en la aplicación (Android Studio)
Para que los SDKs de Firebase puedan acceder a los valores de nuestro archivo de configuracion `google-services.json` necesitamos agragar lo siguiente:
Agregar el complemento de `Google Services` como dependecia. En el build.gradle.kts (proyecto) de nuestro proyecto añadiremos el siguiente plugin:
```kotlin
plugins {
  // ...

  // Add the dependency for the Google services Gradle plugin
  id("com.google.gms.google-services") version "4.4.0" apply false

}
```

Agregar el complemento de los servicios de Google en el archivo de Gradle de app. En el build.gradle.kts (app) de nuestro proyecto tendremos que añadir un plugin:
```kotlin
plugins {
    ...
  
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}
```

#### Agregar los SDK de Firebase a tu app
En el archivo de Gradle (app) tendremos que agregar las dependencias de los [productos de Firebase](https://firebase.google.com/docs/android/setup?hl=es-419#available-libraries) que quieras usar en tu app. Es recomendado usar la [BoM de Firebase para Android](https://firebase.google.com/docs/android/learn-more?hl=es-419#bom)

En el build.gradle.kts (app) de nuestro proyecto tendremos que añadir un plugin mas las dependencias:
```kotlin
dependencies {
  ...

  // Import the Firebase BoM
  implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

  // When using the BoM, you don't specify versions in Firebase library dependencies

  // Add the dependency for the Firebase SDK for Google Analytics
  implementation("com.google.firebase:firebase-analytics-ktx")

  // TODO: Add the dependencies for any other Firebase products you want to use
  // See https://firebase.google.com/docs/android/setup#available-libraries
  // For example, add the dependencies for Firebase Authentication and Cloud Firestore
  implementation("com.google.firebase:firebase-auth-ktx")
  implementation("com.google.firebase:firebase-firestore-ktx")
}

```
Ahora sincronizaremos el proyecto de Android y ya podremos usarlo.

### Google Analytics
Sirve para obtener estadísticas sobre el comportamiento de los usuarios con [Analytics] 

### Firestore database

#### Creación de la base de datos
Para manejar nuestra base de datos usaremos firestore, para ello tendremos que añadirlo a nuestros accesos directos del proyecto:
![](imagenes/Firestore1.png)

Ahora que tenemos el acceso entramos y le damos a crear una base de datos y tendremos que poner la ubicación del server, en este caso usare uno de europa
![](imagenes/Firestore2.png)
Y en el siguiente paso tendremos que elegir nuestras reglas de seguridad, en este caso como estamos probando firebase usaremos el modo prueba:
![](imagenes/Firestore3.png)

#### Creación de nuestras colecciones
Para usar esta base de datos tendremos que crear una colección. Para esto  le daremos a iniciar y pondremos el nombre de nuestra colección y en el apartado siguiente tendremos que agregar nuestro primer documento (fila).

<details>
    <summary>Fotos de creacion de colecciones</summary>
    <p>
        <img src="imagenes/FirestoreCollection1.png"/>
        <img src="imagenes/FirestoreCollection2.png"/>
    </p>
</details>
Despues de crear esto tendremos una tabla parecida a esta:

![](imagenes/FirestoreCollection3.png)

#### Usar firebase desde Android Studio
En la explicación va a estar basada en el patron MVVM

##### DATA:
En este proyecto solo tendremos 3 variables en este caso una lista de usuarios y una variable nombre y otra edad

##### MODEL:
En esta clase tendremos la clase con la que se crearán los objetos de cada documento y las funciones para crearlos. Necesitamos crear un constructior vacio ya que si no a la hora de coger los datos de firestore nos dará error:
```kotlin
data class User(
    val nombre: String = "",
    val edad: Int = 0
){
    // Constructor vacío requerido por Firebase
    constructor() : this("", 0)
}

object UserModel{
    private val db = FirebaseFirestore.getInstance()

    suspend fun getUsers(): List<User> {
        // Obtiene todos los usuarios de la colección "usuarios" de tipo QuerySnapshot
        val querySnapshot: QuerySnapshot = db.collection("table_prueba").get().await()
        // Convierte el QuerySnapshot a una lista de objetos User y la retorna
        return querySnapshot.documents.map { document ->
            val user = document.toObject(User::class.java)
            user ?: throw IllegalStateException("Error al convertir documento a User")
        }
    }

    fun addUser(user: User): Task<DocumentReference> {
        return db.collection("table_prueba").add(user)
    }

    fun updateUser(documentId: String, user: User): Task<Void> {
        // Actualiza un usuario existente en la colección "usuarios"
        return db.collection("table_prueba").document(documentId).set(user, SetOptions.merge())
    }
}
```

##### ViewModel
Esta clase es la que manejara el model y se llamará desde la view. Esta clase tendrá una [inyección de dependencias](https://developer.android.com/training/dependency-injection?hl=es-419) y tendrá que extender de ViewModel:
```
class UserViewModel(private val userRepository: UserModel): ViewModel() {


    init {
        // Cargar datos del modelo al inicializar el ViewModel
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {

            val userList = userRepository.getUsers()
            // Actualiza la lista de usuarios
            data.users.value = userList
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            userRepository.addUser(user)
            // Actualiza la lista de usuarios después de agregar uno nuevo
            loadUsers()
        }
    }

    fun updateUser(documentId: String, user: User) {
        viewModelScope.launch {
            userRepository.updateUser(documentId, user)
            // Actualiza la lista de usuarios después de actualizar uno existente
            loadUsers()
        }
    }
}
```
Al crear un objeto de esta clase se realizará el init para cargar al principio de la ejecucion todos los datos ya que los estarémos mostrando.

##### VIEW
En esta clase crearemos toda la lógica de vista de nuestro proyecto. A parte de crear toda la view tendremos que llamar a las funciones necesarias de la viewmodel:

```kotlin
@Composable
fun UserScreen(
    viewModel: UserViewModel,
) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTexts()
        Buttons(viewModel)
        UserList(users = data.users.value)
    }
}

// Composable que contiene los botones de añadir y actualizar usuario
@Composable
fun Buttons(viewModel: UserViewModel) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Button(
            onClick = {
                viewModel.addUser(User(data.nombre.value, data.edad.value.toIntOrNull() ?: 0))
            }
        ) {
            Text("Añadir Usuario")
        }

        Button(
            onClick = {
                // Actualizar usuario
            }, modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("Actualizar Usuario")
        }
    }
}

// Composable que contiene los campos de texto para el nombre y la edad
@Composable
fun OutlinedTexts(){
    OutlinedTextField(
        value = data.nombre.value,
        onValueChange = {
            data.nombre.value = it
        },
        label = {
            Text("Nombre")
        },
        modifier = Modifier.padding(16.dp)
    )
    OutlinedTextField(
        value = data.edad.value,
        onValueChange = {
            // Solo coge el valor si es un número
            data.edad.value = it.takeIf {
                    text -> text.all {
                it.isDigit()
            }
            } ?: data.edad.value
        },
        label = {
            Text("Edad")
        },
        modifier = Modifier.padding(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

// Composable que contiene la lista de usuarios
@Composable
fun UserList(users: List<User>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(users) { user ->
            UserListItem(user = user)
        }
    }
}

// Composable que contiene un elemento de la lista de usuarios
@Composable
fun UserListItem(user: User) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Nombre: ${user.nombre}")
            Text(text = "Edad: ${user.edad}")
        }
    }
}
```