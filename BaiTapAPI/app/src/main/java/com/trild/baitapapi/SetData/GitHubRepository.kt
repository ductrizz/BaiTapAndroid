package com.trild.baitapapi.SetData

import com.trild.baitapapi.API.*


interface GitHubRepository {
    //->User
    suspend fun getUserDetailfroAPI(userName : String) : UserModel? //-> get user detail thep {UserName} tu UserModel

    //->Follower
    suspend fun getListFollowerfroAPI(userName : String) : List<UserFollower>? //-> get list Follower theo {UserName} tu FollowerModel

    //->Following
    suspend fun getListFollowingfroAPI(userName : String) : List<UserFollowing>? //-> get list Following theo {UserName} tu FollowerModel
}