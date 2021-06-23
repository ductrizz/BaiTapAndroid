package com.trild.baitapapi.SetData

import android.util.Log
import com.trild.baitapapi.API.FollowerModel
import com.trild.baitapapi.API.FollowingModel
import com.trild.baitapapi.API.UserModel
import com.trild.baitapapi.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GithubDataRepository : GitHubRepository{
    private var gitHubService : GitHubService? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        gitHubService = retrofit.create(GitHubService::class.java)
    }

    private fun getOkHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =  HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        val OkHttpClient = builder.build()
        return OkHttpClient
    }


    override suspend fun getUserDetailfroAPI(userName: String): UserModel? {
        return gitHubService?.getUserDetail(userName = userName)
    }

    override suspend fun getListFollowerfroAPI(userName: String): FollowerModel? {
        return gitHubService?.getListFollower(userName = userName)
    }

    override suspend fun getListFollowingfroAPI(userName: String): FollowingModel? {
        return gitHubService?.getListFollowing(userName = userName)
    }
}