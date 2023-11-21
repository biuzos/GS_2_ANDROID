package br.com.fiap.gabriel_ximenes_rm87285.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.gabriel_ximenes_rm87285.db.Users
import br.com.fiap.gabriel_ximenes_rm87285.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    fun insert(user: Users) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(user = user)
        }
    }
}