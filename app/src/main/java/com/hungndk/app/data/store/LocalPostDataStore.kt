package com.hungndk.app.data.store

import com.hungndk.app.data.pojo.Post
import io.reactivex.Observable
import javax.inject.Inject

class LocalPostDataStore @Inject constructor() : PostDataStore() {

    override fun getAllPost(): Observable<List<Post>> {
        return Observable.empty()
    }


}