package com.trild.baitapapi.SetData

import com.trild.baitapapi.API.FollowerModel
import com.trild.baitapapi.API.FollowingModel
import com.trild.baitapapi.API.UserModel


interface GitHubRepository {
    //->User
    suspend fun getUserDetailfroAPI(userName : String) : UserModel? //-> get user detail thep {UserName} tu UserModel

    //->Follower
    suspend fun getListFollowerfroAPI(userName : String) : FollowerModel? //-> get list Follower theo {UserName} tu FollowerModel

    //->Following
    suspend fun getListFollowingfroAPI(userName : String) : FollowingModel? //-> get list Following theo {UserName} tu FollowerModel
}