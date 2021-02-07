package pl.kamil.to_dolist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import pl.kamil.to_dolist.model.ToDoTask.Companion.TABLE_NAME
import java.util.*

@Parcelize
@Entity(tableName = TABLE_NAME)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var category: String,
    var description: String,
    var date: Date,
    var phone: String,
    var email: String,
    var photos: List<String>,
    var isDone: Boolean
): Parcelable
{
    companion object
    {
        public const val TABLE_NAME = "toDo_tasks_table"
    }
}
