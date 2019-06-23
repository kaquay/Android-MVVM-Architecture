package com.hungndk.app.modules.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.hungndk.app.R
import com.hungndk.stdiohue.base.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_home

    override fun provideViewModel(): HomeViewModel =
            super.provideViewModel(HomeViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val viewModel = provideViewModel()

        viewModel.stateObser.observe(this, Observer {
            when(it){
                is HomeViewModel.State.Display -> {
                    // nothing now
                }
                is HomeViewModel.State.Error -> {
                    // show error
                }
            }
        })

        viewModel.loadAllPost()
    }
}