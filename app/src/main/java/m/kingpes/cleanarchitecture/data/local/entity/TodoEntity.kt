package m.kingpes.cleanarchitecture.data.local.entity

import androidx.room.Entity

@Entity(tableName = "todos")
data class TodoEntity (
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)