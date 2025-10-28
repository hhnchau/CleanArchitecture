package m.kingpes.cleanarchitecture.data.repository

import kotlinx.coroutines.flow.Flow
import m.kingpes.cleanarchitecture.data.local.dao.AlbumDao
import m.kingpes.cleanarchitecture.data.local.entity.AlbumEntity
import m.kingpes.cleanarchitecture.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(
    private val api: ApiService,
    private val dao: AlbumDao
){
    fun getLocalAlbums(): Flow<List<AlbumEntity>> = dao.getAllAlbums()
}