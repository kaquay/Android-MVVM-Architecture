package com.hungndk.app.usecases

import com.hungndk.app.data.repository.PostRepository
import javax.inject.Inject

class GetAllPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) : BaseUsecase() {
    fun execute() = postRepository.getAllPosts()
}