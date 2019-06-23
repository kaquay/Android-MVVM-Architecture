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
        class Display(val items: List<PostItemModel>) : State()
        object Error : State()
    }

    val stateObser = MutableLiveData<State>()

    fun loadAllPost() {
        getPostsUseCase.execute()
                .compose(RxUtils.callApi())
                .concatMapIterable { it }
                .map { PostItemModel(it) }
                .toList()
                .subscribe({
                    stateObser.postValue(State.Display(it))
                }, {
                    stateObser.postValue(State.Error)
                })
                .addTo(this)

    }

}

class PostItemModel(private val post: Post) {
    fun getTitle() = "Dummy Post title"

    fun getDescription() = "Dummy Post Description"

    fun getThumbUrl() = "https://cafebiz.cafebizcdn.vn/thumb_w/600/2019/photo1550826876737-1550826876920-crop-1550826883367966172893.jpg"
}