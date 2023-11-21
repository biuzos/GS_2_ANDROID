package br.com.fiap.gabriel_ximenes_rm87285.ui.ListUser

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.gabriel_ximenes_rm87285.databinding.ItemUsersBinding
import br.com.fiap.gabriel_ximenes_rm87285.db.Users
import kotlin.math.log

class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.UsersViewHolder>() {

    private var usersList = listOf<Users>()

    fun setList(usersList: List<Users>) {
        Log.d("UsersListAdapter", "setList: $usersList")
        this.usersList = usersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersListAdapter.UsersViewHolder {
        val binding: ItemUsersBinding = ItemUsersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersListAdapter.UsersViewHolder, position: Int) {
        val item = usersList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = usersList.size

    inner class UsersViewHolder(private val binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Users) {
            binding.tvUsersName.text = item.name
            binding.tvUsersEmail.text = item.email
            binding.tvUsersId.text = item.id.toString()
        }
    }


}