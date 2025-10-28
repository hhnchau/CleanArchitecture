package m.kingpes.cleanarchitecture.data.remote.dto

import m.kingpes.cleanarchitecture.data.local.entity.AddressEntity
import m.kingpes.cleanarchitecture.data.local.entity.CompanyEntity
import m.kingpes.cleanarchitecture.data.local.entity.GeoEntity
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity
import kotlin.math.ln

data class UserDto (
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressDto,
    val phone: String,
    val website: String,
    val company: CompanyDto
){
    fun toEntity(): UserEntity{
        return UserEntity(
            id = id,
            name = name,
            username = username,
            email = email,
            address = address.toEntity(),
            phone = phone,
            website = website,
            company = company.toEntity()
        )
    }
}

data class AddressDto(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoDto
){
    fun toEntity(): AddressEntity{
        return AddressEntity(
            street = street,
            suite = suite,
            city = city,
            zipcode = zipcode,
            geo = geo.toEntity()
        )
    }
}

data class GeoDto(
    val lat: String,
    val lng: String
){
    fun toEntity(): GeoEntity{
        return GeoEntity(
            lat = lat, lng = lng
        )
    }
}

data class CompanyDto(
    val name: String,
    val catchPhrase: String,
    val bs: String
){
    fun toEntity(): CompanyEntity{
        return CompanyEntity(
            name = name,
            catchPhrase = catchPhrase,
            bs = bs
        )
    }
}