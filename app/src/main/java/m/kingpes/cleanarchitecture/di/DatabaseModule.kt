package m.kingpes.cleanarchitecture.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import m.kingpes.cleanarchitecture.data.local.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ): AppDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "app_db"
    )
        .fallbackToDestructiveMigration(dropAllTables = true)
        .build()

    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()

    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()
}