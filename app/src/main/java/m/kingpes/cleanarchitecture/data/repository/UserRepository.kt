package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.UserDao
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val api: ApiService,
    private val dao: UserDao
) {
    private var currentPage = 1;
    fun getLocalUsers(): Flow<List<UserEntity>> = dao.getAllUsers()

    suspend fun refreshUsers(){
        currentPage = 1
        val users = api.getUsers()
        //val users = api.getUsers(page = currentPage)
        dao.clearAll()

        dao.insertUsers(users.map { it.toEntity() })
//        users.forEach { user ->
//            dao.insert(UserEntity(user.id, user.name, user.email))
//        }
    }

    suspend fun loadMoreUsers(){
        currentPage++
        val users = api.getUsers()
        //val users = api.getUsers(page = currentPage)

        dao.insertUsers(users.map { it.toEntity() })

//        users.forEach { user->
//            dao.insert(UserEntity(user.id, user.name, user.email))
//        }
    }

    suspend fun clearAll(){
        dao.clearAll()
        currentPage = 1
    }
}