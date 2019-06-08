package com.hungndk.stdiohue.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    open fun provideViewModel(clazz: Class<VM>): VM {
        return ViewModelProviders.of(this, viewModelFactory)
                .get(clazz)
    }

    abstract fun provideViewModel(): VM


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

}