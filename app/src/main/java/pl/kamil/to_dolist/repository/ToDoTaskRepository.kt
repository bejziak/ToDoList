package pl.kamil.to_dolist.repository

import androidx.lifecycle.LiveData
import pl.kamil.to_dolist.data.ToDoTaskDAO
import pl.kamil.to_dolist.model.ToDoTask

class ToDoTaskRepository(private val toDoTaskDAO: ToDoTaskDAO)
{
    val readAllData: LiveData<List<ToDoTask>> = toDoTaskDAO.readAllData()

    suspend fun addTask(toDoTask: ToDoTask)
    {
        toDoTaskDAO.addTask(toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask)
    {
        toDoTaskDAO.updateTask(toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask)
    {
        toDoTaskDAO.deleteTask(toDoTask)
    }
}