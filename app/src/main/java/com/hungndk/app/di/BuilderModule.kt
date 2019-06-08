package com.hungndk.app.di

import com.hungndk.app.modules.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity
}