package com.hungndk.app.data.services

import com.hungndk.app.data.pojo.Post
import io.reactivex.Observable

interface PostService {
    fun fetchAllPost(): Observable<Response<List<Post>>>
}