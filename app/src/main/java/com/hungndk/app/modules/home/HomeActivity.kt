package com.hungndk.app.modules.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hungndk.app.R
import com.hungndk.stdiohue.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_home

    override fun provideViewModel(): HomeViewModel =
            super.provideViewModel(HomeViewModel::class.java)

    private val homeAdapter = HomeAdapter{
        // item click callback
        // open detail page
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(recycler){
            layoutManager = LinearLayoutManager(context)
            adapter = homeAdapter
        }

        val viewModel = provideViewModel()

        viewModel.stateObser.observe(this, Observer {
            when(it){
                is HomeViewModel.State.Display -> {
                    homeAdapter.items = it.items
                }
                is HomeViewModel.State.Error -> {
                    // show error
                }
            }
        })

        viewModel.loadAllPost()
    }
}