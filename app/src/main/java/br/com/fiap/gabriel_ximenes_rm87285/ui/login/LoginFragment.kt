package br.com.fiap.gabriel_ximenes_rm87285.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.fiap.gabriel_ximenes_rm87285.R
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentLoginBinding
import br.com.fiap.gabriel_ximenes_rm87285.ui.ListUser.UsersListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fun login(email: String, password: String) {
            loginViewModel.verifyUser(email, password)
            loginViewModel.loginResult.observe(viewLifecycleOwner) { result ->
                if (result == true) {
                    findNavController().navigate(R.id.to_usersListFragment)
                } else {
                    binding.passwordEditTextLogin.error = "Email ou senha incorretos"
                }
            }

        }
        binding.tvLoginGoRegister.setOnClickListener {
            findNavController().navigate(R.id.to_registerFragment)
        }

        binding.buttonLogin.setOnClickListener {
            login(
                binding.emailEditTextLogin.editText?.text.toString(),
                binding.passwordEditTextLogin.editText?.text.toString()
            )
        }
    }

}