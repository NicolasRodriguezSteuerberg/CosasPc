package com.example.testfirebase.model

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await

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