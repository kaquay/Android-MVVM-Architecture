package com.hungndk.app.data.store

import com.hungndk.app.data.pojo.Post
import io.reactivex.Observable
import javax.inject.Inject

class CloudPostDataStore @Inject constructor(
//    private val service: PostService
) : PostDataStore() {
    override fun getAllPost(): Observable<List<Post>> {
//        return service.fetchAllPost()
//            .map { it.data }
        return Observable.empty()
    }

}