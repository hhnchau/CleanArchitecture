package m.kingpes.cleanarchitecture.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import m.kingpes.cleanarchitecture.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: UserRepository
): ViewModel() {
    val users =
        repo.getLocalUsers().stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun refresh(){
        viewModelScope.launch { repo.refreshUsers() }
    }

    fun loadMore(){
        viewModelScope.launch { repo.loadMoreUsers() }
    }

    fun clearAll(){
        viewModelScope.launch { repo.clearAll() }
    }
}