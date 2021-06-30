package com.trild.githubuser.API

import com.trild.githubfind.Model.FollowerModel
import com.trild.githubfind.Model.FollowingModel
import com.trild.githubfind.Model.UserModel


interface GithubRepository {

    suspend fun getModelDetailAPI(UserName : String): UserModel?

    suspend fun getFollwerDetailAPI(UserName: String): List<FollowerModel>?

    suspend fun getFollwingDetailAPI(UserName: String): List<FollowingModel>?
}