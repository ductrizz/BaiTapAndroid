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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserModel(user : UserModel?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListUserFollower(list : List<FollowerModel>?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListUserFollowing(list : List<FollowingModel>?)

    @Query("SELECT * FROM UserModel WHERE login = :userName")
    suspend fun getUserModel(userName: String) : UserModel?

    @Query("SELECT * FROM FollowerDetail WHERE login = :userName")
    suspend fun getListUserFollower(userName: String) : List<FollowerModel>?

    @Query("SELECT * FROM FollowingDetail WHERE login = :userName")
    suspend fun getListUserFollowing(userName: String) : List<FollowingModel>?
}