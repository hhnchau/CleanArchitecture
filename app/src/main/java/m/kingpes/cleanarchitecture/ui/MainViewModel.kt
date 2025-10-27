package m.kingpes.cleanarchitecture.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import m.kingpes.cleanarchitecture.data.UserRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: UserRepository
): ViewModel() {
    val users =
        repo.getLocalUsers().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    fun refresh(){
        viewModelScope.launch { repo.refreshUsers() }
    }
}