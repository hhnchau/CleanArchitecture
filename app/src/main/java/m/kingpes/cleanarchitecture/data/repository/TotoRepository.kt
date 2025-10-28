package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.TodoDao
import m.kingpes.cleanarchitecture.data.local.entity.TodoEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TotoRepository @Inject constructor(
    private val api: ApiService,
    private val dao: TodoDao
) {
    fun getLocalTodos(): Flow<List<TodoEntity>> = dao.getAllTodos()
}