package pl.kamil.to_dolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.kamil.to_dolist.model.ToDoTask


@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase()
{
    abstract fun toDoTaskDao(): ToDoTaskDAO

    companion object
    {
        @Volatile
        private var INSTANCE: ToDoDatabase? = null
        const val DATABASE_NAME = "toDoTask_database"

        fun getDatabase(context: Context): ToDoDatabase
        {
            val tempInstance = INSTANCE
            if(tempInstance != null)
                return tempInstance

            synchronized(this)
            {
                val instance = Room.databaseBuilder(context.applicationContext, ToDoDatabase::class.java, DATABASE_NAME).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}