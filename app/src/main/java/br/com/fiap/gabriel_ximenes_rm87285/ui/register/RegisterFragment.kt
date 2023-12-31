package br.com.fiap.gabriel_ximenes_rm87285.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentLoginBinding
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentRegisterBinding
import br.com.fiap.gabriel_ximenes_rm87285.db.Users
import br.com.fiap.gabriel_ximenes_rm87285.ui.ListUser.UsersListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    private val registerViewModel: RegisterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun clearText() {
            binding.nameEditTextRegister.editText?.text?.clear()
            binding.emailEditTextRegister.editText?.text?.clear()
            binding.passwordEditTextRegister.editText?.text?.clear()
        }


        fun registerUser() {
            val name = binding.nameEditTextRegister.editText?.text.toString()
            val email = binding.emailEditTextRegister.editText?.text.toString()
            val password = binding.passwordEditTextRegister.editText?.text.toString()

            if (name.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(requireContext(), "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT)
                    .show()
                return
            }

            lifecycleScope.launch {
                val isEmailRegistered = registerViewModel.getUserByEmail(email)
                if (isEmailRegistered) {
                    binding.emailEditTextRegister.error = "Email já cadastrado!"
                    Toast.makeText(requireContext(), "Email já cadastrado!", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val user = Users(
                        name = name,
                        email = email,
                        password = password
                    )
                    registerViewModel.insert(user)
                    Toast.makeText(requireContext(), "User registered", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.buttonSubRegister.setOnClickListener {
            registerUser()
        }

        binding.buttonCancelRegister.setOnClickListener {
            clearText()
        }
    }
}