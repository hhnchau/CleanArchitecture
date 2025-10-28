package m.kingpes.cleanarchitecture.data.remote.dto

data class PhotoDto (
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)