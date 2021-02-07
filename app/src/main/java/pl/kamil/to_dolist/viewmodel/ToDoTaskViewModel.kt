package pl.kamil.to_dolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.kamil.to_dolist.data.ToDoDatabase
import pl.kamil.to_dolist.model.ToDoTask
import pl.kamil.to_dolist.repository.ToDoTaskRepository

class ToDoTaskViewModel(application: Application): AndroidViewModel(application)
{
    val readAllData: LiveData<List<ToDoTask>>
    private val repository: ToDoTaskRepository

    init
    {
        val toDoTaskDao = ToDoDatabase.getDatabase(application).toDoTaskDao()
        repository = ToDoTaskRepository(toDoTaskDao)
        readAllData = repository.readAllData
    }

    fun addTask(toDoTask: ToDoTask)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTask(toDoTask)
        }
    }

    fun updateTask(toDoTask: ToDoTask)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTask(toDoTask)
        }
    }

    fun deleteTask(toDoTask: ToDoTask)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(toDoTask)
        }
    }
}