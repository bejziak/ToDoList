package pl.kamil.to_dolist.adapter

import android.content.Context
import androidx.fragment.app.FragmentManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import pl.kamil.to_dolist.R
import pl.kamil.to_dolist.fragments.TaskListFragment

class TabsPagerAdapter(context: Context, fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    private val _ctx: Context = context;

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Music Fragment
                val bundle = Bundle()
                bundle.putString("toDoTaskList", _ctx.getString(R.string.toDoListText))
                val toDoFragment = TaskListFragment()
                toDoFragment.arguments = bundle
                return toDoFragment
            }
            1 -> {
                // # Movies Fragment
                val bundle = Bundle()
                bundle.putString("doneTaskList", _ctx.getString(R.string.doneTaskListText))
                val doneFragment = TaskListFragment()
                doneFragment.arguments = bundle
                return doneFragment
            }
            else -> return TaskListFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}