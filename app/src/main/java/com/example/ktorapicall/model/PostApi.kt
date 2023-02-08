package com.example.ktorapicall.model

interface PostApi {
    suspend fun getPosts(): List<Post>
}