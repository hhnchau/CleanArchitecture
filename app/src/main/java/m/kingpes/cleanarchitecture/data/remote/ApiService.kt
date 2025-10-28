package m.kingpes.cleanarchitecture.data.remote
import m.kingpes.cleanarchitecture.data.remote.dto.AlbumDto
import m.kingpes.cleanarchitecture.data.remote.dto.CommentDto
import m.kingpes.cleanarchitecture.data.remote.dto.PhotoDto
import m.kingpes.cleanarchitecture.data.remote.dto.PostDto
import m.kingpes.cleanarchitecture.data.remote.dto.TotoDto
import m.kingpes.cleanarchitecture.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Query

data class UserResponse(val id: Int, val name: String, val email: String)

interface ApiService {

    @GET("posts")
    suspend fun getPosts():List<PostDto>

    @GET("comments")
    suspend fun getComments():List<CommentDto>

    @GET("albums")
    suspend fun getAlbums():List<AlbumDto>

    @GET("photos")
    suspend fun getPhotos():List<PhotoDto>

    @GET("todos")
    suspend fun getTodos():List<TotoDto>

    @GET("users")
    suspend fun getUsers():List<UserDto>

    @GET("users")
    suspend fun getUserss(
        @Query("_page") page: Int,
        @Query("_limit")limit: Int = 10
    ): List<UserResponse>
}