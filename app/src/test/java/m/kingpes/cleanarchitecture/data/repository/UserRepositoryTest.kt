package m.kingpes.cleanarchitecture.data.repository

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import m.kingpes.cleanarchitecture.data.remote.ApiService
import m.kingpes.cleanarchitecture.data.remote.dto.AddressDto
import m.kingpes.cleanarchitecture.data.remote.dto.CompanyDto
import m.kingpes.cleanarchitecture.data.remote.dto.GeoDto
import m.kingpes.cleanarchitecture.data.remote.dto.UserDto
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserRepositoryTest {
    private lateinit var api: ApiService
    private lateinit var dao: UserDaoFake
    private lateinit var repo: UserRepository

    @Before
    fun setup(){
        api = mockk()
        dao = UserDaoFake()
        repo = UserRepository(api, dao)
    }

    @After
    fun tearDown(){

    }

    @Test
    fun `fetchUsers should insert users into DB when API success`() = runTest{
        ///Give
        val fakeUsers = listOf(
            UserDto(1, "John", "join", "john@gmail.com",
                AddressDto("Street", "Suite", "City", "Zip",
                    GeoDto("1", "1")
                ), "123456", "site.com",
                CompanyDto("Comp", "catch", "bs")
            )
        )

        coEvery{api.getUsers()} returns fakeUsers

        ///When
        repo.refreshUsers()

        ///Then
        val result = dao.getAllUsers().first()
        assertThat(result).isNotEmpty()
        assertThat(result[0].name).isEqualTo("Johns")
        coVerify{api.getUsers()}
    }

    @Test
    fun `refreshUsers should not insert when API throws error`() = runTest{
        coEvery {api.getUsers()} throws Exception("Network error")

        try {
            repo.refreshUsers()
        }catch (_: Exception){}

        val result = dao.getAllUsers().first()
        assertThat(result).isEmpty()
    }
}