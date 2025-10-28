package m.kingpes.cleanarchitecture.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import m.kingpes.cleanarchitecture.R

class HomeDetailScreen: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_detail_activity)
    }
}