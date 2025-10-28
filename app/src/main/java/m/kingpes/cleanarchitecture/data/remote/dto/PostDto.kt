package m.kingpes.cleanarchitecture.data.remote.dto

import m.kingpes.cleanarchitecture.data.local.entity.PostEntity

data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
){
    fun toEntity(): PostEntity{
        return PostEntity(
            id = id,
            userId = userId,
            title = title,
            body = body
        )
    }
}