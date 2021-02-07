package pl.kamil.to_dolist.data

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.kamil.to_dolist.model.ToDoTask
import pl.kamil.to_dolist.model.ToDoTask.Companion.TABLE_NAME

interface ToDoTaskDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(user: ToDoTask)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(user: ToDoTask)

    @Delete
    suspend fun deleteTask(user: ToDoTask)

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id ASC")
    fun readAllData(): LiveData<List<ToDoTask>>
}