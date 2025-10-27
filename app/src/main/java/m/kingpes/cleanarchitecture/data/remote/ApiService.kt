package m.kingpes.cleanarchitecture.data.remote
import retrofit2.http.GET

data class UserResponse(val id: Int, val name: String, val email: String)

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}