package com.hungndk.app.modules.home

import androidx.lifecycle.MutableLiveData
import com.hungndk.app.data.pojo.Post
import com.hungndk.app.usecases.GetAllPostUseCase
import com.hungndk.app.utils.RxUtils
import com.hungndk.stdiohue.base.BaseViewModel
import com.hungndk.stdiohue.base.addTo
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPostsUseCase: GetAllPostUseCase
) : BaseViewModel() {

    sealed class State {
        class Display(val items: List<Post>?) : State()
        object Error : State()
    }

    val stateObser = MutableLiveData<State>()

    fun loadAllPost() {
        getPostsUseCase.execute()
            .compose(RxUtils.callApi())
            .subscribe({
                stateObser.postValue(State.Display(it))
            }, {
                stateObser.postValue(State.Error)
            })
            .addTo(this)

    }

}