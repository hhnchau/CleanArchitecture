package m.kingpes.cleanarchitecture.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import m.kingpes.cleanarchitecture.data.local.AppDatabase
import m.kingpes.cleanarchitecture.data.remote.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ): AppDatabase = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "app_db"
    ).build()

    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()
}