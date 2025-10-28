package m.kingpes.cleanarchitecture.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val username: String,
    val email: String,
    @Embedded(prefix = "address_") val address: AddressEntity,
    val phone: String,
    val website: String,
    @Embedded(prefix = "company_") val company: CompanyEntity
    //@Embedded Cho phép Room lưu object con trong cùng bảng cha (User) mà không cần tạo bảng riêng
    //prefix = "address_" Giúp tránh trùng tên cột (ví dụ city và company_city)
)

data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    @Embedded(prefix = "geo_")val geo: GeoEntity
)

data class GeoEntity(
    val lat: String,
    val lng: String
)

data class CompanyEntity(
    val name: String,
    val catchPhrase: String,
    val bs: String
)