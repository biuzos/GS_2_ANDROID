package br.com.fiap.gabriel_ximenes_rm87285.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface UsersDao {

    @Upsert
    suspend fun insert(user: Users)

    @Delete
    suspend fun delete(user: Users)

    @Update
    suspend fun update(user: Users)

    @Query("SELECT * FROM users ORDER BY name")
    suspend fun getAll(): List<Users>

    @Query("SELECT * FROM users WHERE id = :id")
    suspend fun getById(id: Int): Users

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun getByEmailAndPassword(email: String, password: String): Users?

    @Query("DELETE FROM users WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getByEmail(email: String): Users?

}