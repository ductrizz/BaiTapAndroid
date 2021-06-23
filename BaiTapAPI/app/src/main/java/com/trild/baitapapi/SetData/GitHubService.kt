package com.trild.baitapapi.SetData

import com.trild.baitapapi.API.FollowerModel
import com.trild.baitapapi.API.FollowingModel
import com.trild.baitapapi.API.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubService {

    //SetInterFace-User
    @GET("/users/{userName}")
    suspend fun getUserDetail(@Path("userName") userName : String?): UserModel?

    //setInterfacce-Follower
     @GET("/users/{userName}/followers")
     suspend fun getListFollower(@Path("userName") userName : String?): FollowerModel?

     //setInterfacce-Following
    @GET("/users/{userName}/following")
    suspend fun getListFollowing(@Path("userName") userName : String?): FollowingModel?
}