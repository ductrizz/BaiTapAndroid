package com.trild.githubfind.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.trild.githubfind.Model.FollowerModel
import com.trild.githubfind.Model.FollowingModel
import com.trild.githubfind.Model.UserModel
import com.trild.githubuser.API.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ViewModel : ViewModel() {
    var githubService : GithubService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        githubService = retrofit.create(GithubService::class.java)
    }

    private fun getOkHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =  HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        val OkHttpClient = builder.build()
        return OkHttpClient
    }

    fun getModelDetailAPI(UserName: String, returnUser : (UserModel?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO){
            val userModel = githubService.getUserDetail(userName = UserName)
            Logger.e("getUserDetail="+userModel)
            withContext(Dispatchers.Main){
                returnUser(userModel)
            }
        }
    }


    fun getFollowerDetailAPI(UserName: String, returnUser : (List<FollowerModel>?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO){
            val listFollower = githubService.getListFollower(userName = UserName)
            Logger.e("getFollower="+listFollower)
            withContext(Dispatchers.Main){
                returnUser(listFollower)
            }
        }
    }

    fun getFollowingDetailAPI(UserName: String, returnUser : (List<FollowingModel>?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO){
            val listFollowing = githubService.getListFollowing(userName = UserName)
            Logger.e("getFollwing="+listFollowing)
            withContext(Dispatchers.Main){
                returnUser(listFollowing)
            }
        }
    }

}