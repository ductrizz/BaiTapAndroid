package com.trild.baitapapi.SetData

import com.trild.baitapapi.API.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitHubService {

    //SetInterFace-User
    @GET("/users/{userName}")
    suspend fun getUserDetail(@Path("userName") userName : String?): UserModel?

    //setInterfacce-Follower
     @GET("/users/{userName}/followers")
     suspend fun getListFollower(
        @Path("userName") userName : String?,
        @Query("per_page") perpage : Int,
        @Query("page") page : Int
        ): List<UserFollower>?

     //setInterfacce-Following
    @GET("/users/{userName}/following")
    suspend fun getListFollowing(
         @Path("userName") userName : String?,
         @Query("per_page") perpage : Int,
         @Query("page") page : Int
     ): List<UserFollowing>?
}