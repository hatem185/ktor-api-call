package com.example.ktorapicall.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorapicall.model.Post
import com.example.ktorapicall.model.PostApi
import com.example.ktorapicall.model.PostsApiImpl
import com.example.ktorapicall.util.Provider
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {

    private var postsApi: PostApi = PostsApiImpl(Provider.client)
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadPostsFromApi()
    }

    private fun loadPostsFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getPosts()
        }
    }
}