package pl.kamil.to_dolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import pl.kamil.to_dolist.R
import pl.kamil.to_dolist.model.ToDoTask
import pl.kamil.to_dolist.viewmodel.ToDoTaskViewModel

class TaskListAdapter(context: Context, mToDoTaskViewModel: ToDoTaskViewModel): RecyclerView.Adapter<TaskListAdapter.MyViewHolder>() {
    private var taskList = emptyList<ToDoTask>()
    private val _ctx = context

    private val _mToDoTaskViewModel = mToDoTaskViewModel

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.itemView.tvImie.text = currentItem.name.toString()
        holder.itemView.tvNazwisko.text = currentItem.surname.toString()
        holder.itemView.tvPrzezwisko.text = currentItem.nickname.toString()
        holder.itemView.tvPesel.text = currentItem.pesel.toString()
        holder.itemView.tvPozycja.text = currentItem.positionName.toString()

        holder.itemView.swipeUserRow.showMode = SwipeLayout.ShowMode.PullOut
        holder.itemView.swipeUserRow.addDrag(SwipeLayout.DragEdge.Left, holder.itemView.findViewById(R.id.bottom_wrapper))
        holder.itemView.swipeUserRow.isSwipeEnabled = true

        holder.itemView.ivDeleteUser.setOnClickListener {
            _mUserViewModel.deleteUser(currentItem)
            Toast.makeText(_ctx, "DELETED", Toast.LENGTH_LONG).show()
        }

        holder.itemView.ivEditUser.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
            Toast.makeText(_ctx, "EditButton", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>)
    {
        this.userList = user
        notifyDataSetChanged()
    }
}