package m.kingpes.cleanarchitecture.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class AlbumEntity (
    @PrimaryKey val id: Int,
    val userId: Int,
    val title: String
)