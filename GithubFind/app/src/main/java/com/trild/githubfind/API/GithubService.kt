package com.trild.githubuser.API


import com.trild.githubfind.Model.FollowerModel
import com.trild.githubfind.Model.FollowingModel
import com.trild.githubfind.Model.UserModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    //SetInterFace-User
    @GET("/users/{userName}")
    suspend fun getUserDetail(@Path("userName") userName : String?): UserModel?

    //setInterfacce-Follower
    @GET("/users/{userName}/followers")
    suspend fun getListFollower(@Path("userName") userName : String?): List<FollowerModel>?

    //setInterfacce-Following
    @GET("/users/{userName}/following")
    suspend fun getListFollowing(@Path("userName") userName : String?): List<FollowingModel>?
}