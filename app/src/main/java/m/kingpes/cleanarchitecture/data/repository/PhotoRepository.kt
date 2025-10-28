package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.PhotoDao
import m.kingpes.cleanarchitecture.data.local.entity.PhotoEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(
    private val api: ApiService,
    private val dao: PhotoDao
) {
    fun getLocalPhotos(): Flow<List<PhotoEntity>> = dao.getAllPhotos()
}