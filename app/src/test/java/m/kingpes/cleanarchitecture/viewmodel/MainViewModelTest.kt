package m.kingpes.cleanarchitecture.viewmodel

import com.google.common.truth.Truth.assertThat
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import m.kingpes.cleanarchitecture.data.local.entity.AddressEntity
import m.kingpes.cleanarchitecture.data.local.entity.CompanyEntity
import m.kingpes.cleanarchitecture.data.local.entity.GeoEntity
import m.kingpes.cleanarchitecture.data.local.entity.UserEntity
import m.kingpes.cleanarchitecture.data.repository.UserRepository
import m.kingpes.cleanarchitecture.presentation.viewmodel.MainViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {
    private lateinit var repo: UserRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup(){
        repo = mockk()
        viewModel = MainViewModel(repo)
    }

    @After
    fun tearDown(){}

    @Test
    fun `loadUsers should update state when repository returns data`() = runTest {
        //Give
        val fakeUsers = listOf(
            UserEntity(1, "John", "join", "john@gmail.com",
                AddressEntity("Street", "Suite", "City", "Zip",
                    GeoEntity("1", "1")
                ), "123456", "site.com",
                CompanyEntity("Comp", "catch", "bs")
            )
        )

        coEvery { repo.getLocalUsers() }returns flowOf(fakeUsers)

        //When
        viewModel.loadMore()
        advanceUntilIdle() // simulate coroutine completion

        //Then
        val result = viewModel.users.first()
        assertThat(result).isEqualTo(fakeUsers)
        verify { repo.getLocalUsers() }
    }

    @Test
    fun `refreshUsers should not insert when API throws error`() = runTest {
        //coEvery { repo.getLocalUsers() } just coRuns

        viewModel.refresh()
        advanceUntilIdle()

        coVerify { repo.getLocalUsers() }

    }
}