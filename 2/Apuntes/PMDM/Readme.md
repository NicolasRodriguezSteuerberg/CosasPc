 # ROOM
 Room sirve para conservar los datos localmente. El caso de uso más común consiste en almacenar en caché datos relevantes para que el dispositivo no tenga que acceder a la red.

La biblioteca de persistencias de Room brinda una capa de abstracción para SQLite, brinda los siguientes beneficios:
- Verificación del tiempo de compilación de las consultas en SQL
- Anotaciones de conveniencia que minimizan el código estándar repetitivo y propenso a errores
- Rutas de migración de bases de datos optimizadas

(Esto hace que pueda ser mejor que usar las APIs de SQLite)

## Configuración
### Dependencias
```kotlin
dependencies {
	val room_version = "2.5.0"

	implementation("androidx.room:room-runtime:$room_version")
	annotationProcessor("androidx.room:room-compiler:$room_version")

	// To use Kotlin annotation processing tool (kapt)
	kapt("androidx.room:room-compiler:$room_version")
	// To use Kotlin Symbol Processing (KSP)
	ksp("androidx.room:room-compiler:$room_version")

	// optional - Kotlin Extensions and Coroutines support for Room
	implementation("androidx.room:room-ktx:$room_version")

	// optional - RxJava2 support for Room
	implementation("androidx.room:room-rxjava2:$room_version")

	// optional - RxJava3 support for Room
	implementation("androidx.room:room-rxjava3:$room_version")

	// optional - Guava support for Room, including Optional and ListenableFuture
	implementation("androidx.room:room-guava:$room_version")

	// optional - Test helpers
	testImplementation("androidx.room:room-testing:$room_version")

	// optional - Paging 3 Integration
	implementation("androidx.room:room-paging:$room_version")
}
```

### Componentes principales
- La clase de la base de datos que sirve como punto de acceso principal para la conexión subyacente a los datos persistentes de la app.
- (Data) Las entidades de datos que representan tablas de la base de datos de tu app.
- Los objetos de acceso a datos (DAOs) que proporcionan métodos que tu app puede usar para consultar, actualizar, insertar y borrar datos en la base de datos

La clase de *base de datos* proporciona a tu app instancias de los DAOs asociados con esa base de datos. La app puede usar los DAOs para recuperar datos de la base de datos como instancias de objetos de entidad de datos asociados. La app también puede usar las entidades de datos definidas para actualizar filas de las tablas correspondientes o crear filas nuevas para su inserción. 
Las relaciones entre los diferentes componentes de Room:

![imagen](diagrama.png)