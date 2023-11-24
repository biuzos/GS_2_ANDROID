package br.com.fiap.gabriel_ximenes_rm87285.ui.doencas

import androidx.lifecycle.ViewModel
import br.com.fiap.gabriel_ximenes_rm87285.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoencasViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {


}