package m.kingpes.cleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import m.kingpes.cleanarchitecture.data.local.dao.UserDao
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}