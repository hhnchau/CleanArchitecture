package m.kingpes.cleanarchitecture.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<UserEntity>>

    @Insert
    suspend fun insert(user: UserEntity)
}