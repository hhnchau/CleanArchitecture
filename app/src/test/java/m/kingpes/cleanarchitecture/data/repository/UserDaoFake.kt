package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.UserDao
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity

class UserDaoFake: UserDao {
    private var userList = mutableListOf<UserEntity>()

    override fun getAllUsers(): Flow<List<UserEntity>> {
        // Dùng flow builder để phát dữ liệu từ list hiện tại
        return kotlinx.coroutines.flow.flow {
            emit(userList.toList()) // emit snapshot hiện tại
        }
    }

    override suspend fun insertUsers(users: List<UserEntity>) {
        userList.addAll(users)
    }

    override suspend fun clearAll() {
        userList.clear()
    }

}