package m.kingpes.cleanarchitecture.data.remote.dto

data class CommentDto (
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)