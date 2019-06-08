package com.hungndk.app.data.store

import com.hungndk.app.data.pojo.Post
import io.reactivex.Observable

abstract class PostDataStore {

    abstract fun getAllPost():
            Observable<List<Post>>
}