package pl.kamil.to_dolist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pl.kamil.to_dolist.R

class TaskListFragment : Fragment()
{
    private lateinit var rvList: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_with_recycler, container, false)

        rvList = view.findViewById(R.id.rvList)

        return view
    }
    // Here "layout_login" is a name of layout file
    // created for LoginFragment
}