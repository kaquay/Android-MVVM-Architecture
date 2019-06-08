package com.hungndk.app.di

import com.hungndk.app.MyApplication
import com.hungndk.stdiohue.di.BaseModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    BaseModule::class,
    AppModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class
]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}