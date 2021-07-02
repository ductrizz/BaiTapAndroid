package com.trild.githubfind.API

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trild.githubfind.Model.FollowerModel
import com.trild.githubfind.Model.FollowingModel
import com.trild.githubfind.Model.UserModel


@Dao
interface GithubDao {

    @Insert
    suspend fun insertUserModel(user : UserModel)

    @Insert
    suspend fun insertListUserFollower(list : List<FollowerModel>)

    @Insert
    suspend fun insertListUserFollowing(list : List<FollowingModel>)

    @Query("SELECT * FROM UserModel WHERE login = :userName")
    suspend fun getUserModel(userName: String) : UserModel?

    @Query("SELECT * FROM FollowerDetail WHERE login = :userName")
    suspend fun getListUserFollower(userName: String) : List<FollowerModel>?

    @Query("SELECT * FROM FollowingDetail WHERE login = :userName")
    suspend fun getListUserFollowing(userName: String) : List<FollowingModel>?

/*  //ERROR NotNull() ???
    @Query("SELECT * FROM FollowerDetail")
    suspend fun getListUserFollower(userName: String) : List<FollowerModel>?

    @Query("SELECT * FROM FollowingDetail")
    suspend fun getListUserFollowing(userName: String) : List<FollowingModel>?*/
}