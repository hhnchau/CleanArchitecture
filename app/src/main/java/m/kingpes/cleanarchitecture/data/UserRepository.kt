package m.kingpes.cleanarchitecture.data

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.UserDao
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: ApiService,
    private val dao: UserDao
) {
    fun getLocalUsers(): Flow<List<UserEntity>> = dao.getAll()

    suspend fun refreshUsers(){
        val users = api.getUsers()
        users.forEach { user ->
            dao.insert(UserEntity(user.id, user.name, user.email))
        }
    }
}