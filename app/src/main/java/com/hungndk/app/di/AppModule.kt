package com.hungndk.app.di

import dagger.Module

@Module(includes = [
    BuilderModule::class,
    ViewModelModule::class
])
class AppModule