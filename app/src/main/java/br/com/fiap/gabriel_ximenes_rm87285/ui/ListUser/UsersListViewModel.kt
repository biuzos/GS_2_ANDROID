package br.com.fiap.gabriel_ximenes_rm87285.ui.ListUser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.gabriel_ximenes_rm87285.db.Users
import br.com.fiap.gabriel_ximenes_rm87285.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class UsersListViewModel (
    private val repository: UserRepository
) : ViewModel() {


    private val _users = MutableLiveData<List<Users>>()
    val users: LiveData<List<Users>> get() = _users


    fun getUsers() {
        _users.value = listOf(
            Users(1, "Gabriel", "gabriel@gmail.com", "123456"),
            Users(2, "Fernando", "gabriel@gmail.com", "123456"),
            Users(3, "Jose", "gabriel@gmail.com", "123456")
        )
    }
}