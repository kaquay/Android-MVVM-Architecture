package com.hungndk.app.data.store

import com.hungndk.app.data.pojo.Post
import io.reactivex.Observable
import javax.inject.Inject

class LocalPostDataStore @Inject constructor() : PostDataStore() {

    override fun getAllPost(): Observable<List<Post>> {
        return Observable.just(
            listOf(
                Post(1, "Post Local 1", ""),
                Post(2, "Post Local 1", ""),
                Post(3, "Post Local 1", ""),
                Post(4, "Post Local 1", "")
            )
        )
    }

    fun saveAllPost(items: List<Post>) {
        // do save
    }


}