package m.kingpes.cleanarchitecture.data.local.entity
import androidx.room.Entity

@Entity(tableName = "photos")
data class PhotoEntity (
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)