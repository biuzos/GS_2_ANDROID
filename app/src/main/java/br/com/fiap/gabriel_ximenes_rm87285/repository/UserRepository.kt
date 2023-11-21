package br.com.fiap.gabriel_ximenes_rm87285.repository

import br.com.fiap.gabriel_ximenes_rm87285.db.Users

interface UserRepository {
    suspend fun getAll(): List<Users>

    suspend fun getById(id: Int): Users

    suspend fun getByEmailAndPassword(email: String, password: String): Users?

    suspend fun deleteById(id: Int)

    suspend fun insert(user: Users)

}