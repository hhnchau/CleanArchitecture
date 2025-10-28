package m.kingpes.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import m.kingpes.cleanarchitecture.presentation.navigation.MainScaffold
import m.kingpes.cleanarchitecture.presentation.screen.MainScreen
import m.kingpes.cleanarchitecture.presentation.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val viewModel: MainViewModel = hiltViewModel()
            MainScreen(viewModel)

            //MainScaffold()
        }
    }
}