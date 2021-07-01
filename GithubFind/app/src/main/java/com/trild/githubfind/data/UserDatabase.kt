package com.trild.githubfind.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trild.githubfind.API.GithubDao
import com.trild.githubfind.Model.FollowerModel
import com.trild.githubfind.Model.FollowingModel
import com.trild.githubfind.Model.UserModel

@Database(entities = [UserModel::class, FollowerModel::class, FollowingModel::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun githubDao(): GithubDao


    companion object {

        private var instance: UserDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            UserDatabase::class.java,
            "GithubFind"
        ).build()
    }
}