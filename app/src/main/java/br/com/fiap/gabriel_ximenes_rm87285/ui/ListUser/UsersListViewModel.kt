package br.com.fiap.gabriel_ximenes_rm87285.ui.ListUser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.gabriel_ximenes_rm87285.db.Users
import br.com.fiap.gabriel_ximenes_rm87285.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {


    private val _users = MutableLiveData<List<Users>>()
    val users: LiveData<List<Users>> get() = _users


    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _users.postValue(repository.getAll())
        }
    }
}