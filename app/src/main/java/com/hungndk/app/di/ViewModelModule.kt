package com.hungndk.app.di

import androidx.lifecycle.ViewModel
import com.hungndk.app.modules.home.HomeViewModel
import com.hungndk.stdiohue.helpers.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}