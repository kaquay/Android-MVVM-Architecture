package com.hungndk.app.data.repository

import com.hungndk.app.data.store.CloudPostDataStore
import com.hungndk.app.data.store.LocalPostDataStore
import io.reactivex.Observable
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val localPostDataStore: LocalPostDataStore,
    private val cloudPostDataStore: CloudPostDataStore
) {
    fun getAllPosts() = Observable.concat(
        localPostDataStore.getAllPost(),
        cloudPostDataStore.getAllPost().doAfterNext {
            // save to local
            localPostDataStore.saveAllPost(it)
        }
    )
}