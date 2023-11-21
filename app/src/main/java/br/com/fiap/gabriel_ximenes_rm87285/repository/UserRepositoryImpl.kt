package br.com.fiap.gabriel_ximenes_rm87285.repository

import br.com.fiap.gabriel_ximenes_rm87285.db.Users
import br.com.fiap.gabriel_ximenes_rm87285.db.UsersDao
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val usersDao: UsersDao
) : UserRepository {
    override suspend fun getAll(): List<Users> {
        return usersDao.getAll()
    }

    override suspend fun getById(id: Int): Users {
        return usersDao.getById(id)
    }

    override suspend fun getByEmailAndPassword(email: String, password: String): Users? {
        return usersDao.getByEmailAndPassword(email, password)
    }

    override suspend fun deleteById(id: Int) {
        return usersDao.deleteById(id)
    }

    override suspend fun insert(user: Users) {
        return usersDao.insert(user)
    }
}