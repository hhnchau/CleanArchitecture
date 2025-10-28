package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.CommentDao
import m.kingpes.cleanarchitecture.data.local.entity.CommentEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CommentRepository @Inject constructor(
    private val api: ApiService,
    private val dao: CommentDao
) {
    fun getLocalComments(): Flow<List<CommentEntity>> = dao.getAllComments()
}