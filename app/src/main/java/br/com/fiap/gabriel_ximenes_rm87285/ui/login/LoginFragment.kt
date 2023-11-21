package br.com.fiap.gabriel_ximenes_rm87285.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.gabriel_ximenes_rm87285.R
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvLoginGoRegister.setOnClickListener {
            findNavController().navigate(R.id.to_registerFragment)
        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.to_usersListFragment)
        }
    }

}