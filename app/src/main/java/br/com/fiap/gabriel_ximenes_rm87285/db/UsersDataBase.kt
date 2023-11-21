package br.com.fiap.gabriel_ximenes_rm87285.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Users::class],
    version = 2,
    exportSchema = false
)
abstract class UsersDataBase : RoomDatabase() {
    abstract fun getUsersDao(): UsersDao
}