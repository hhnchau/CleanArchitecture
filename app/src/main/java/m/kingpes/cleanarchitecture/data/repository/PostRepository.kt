package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.PostDao
import m.kingpes.cleanarchitecture.data.local.entity.PostEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PostRepository @Inject constructor(
    private val api: ApiService,
    private val dao: PostDao
) {

    fun getLocalPosts(): Flow<List<PostEntity>> = dao.getAllPosts()

    suspend fun getRemotePosts(){
        val posts = api.getPosts()
        dao.clearPosts()
        //dao.insetPosts(posts)
    }

}