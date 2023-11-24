package br.com.fiap.gabriel_ximenes_rm87285.ui.doencas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentDoencasBinding
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentLoginBinding
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoencasFragment : Fragment() {

    private lateinit var binding: FragmentDoencasBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoencasBinding.inflate(inflater, container, false)
        return binding.root
    }


}