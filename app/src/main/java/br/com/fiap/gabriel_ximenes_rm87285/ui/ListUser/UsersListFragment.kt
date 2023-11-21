package br.com.fiap.gabriel_ximenes_rm87285.ui.ListUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.fiap.gabriel_ximenes_rm87285.databinding.FragmentUsersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersListFragment : Fragment() {

    private lateinit var binding: FragmentUsersListBinding

    private val usersListViewModel: UsersListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UsersListAdapter()
        binding.recyclerUsers.adapter = adapter

        usersListViewModel.getUsers()

        usersListViewModel.users.observe(viewLifecycleOwner) { userList ->
            adapter.setList(usersList = userList)
        }
    }
}