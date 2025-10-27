package m.kingpes.cleanarchitecture.data.remote
import retrofit2.http.GET
import retrofit2.http.Query

data class UserResponse(val id: Int, val name: String, val email: String)

interface ApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("_page") page: Int,
        @Query("_limit")limit: Int = 10
    ): List<UserResponse>
}