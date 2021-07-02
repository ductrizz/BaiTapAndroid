package com.trild.githubfind.ui


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.trild.githubfind.API.GithubDao
import com.trild.githubfind.Model.FollowerModel
import com.trild.githubfind.Model.FollowingModel
import com.trild.githubfind.Model.UserModel
import com.trild.githubfind.data.UserDatabase
import com.trild.githubuser.API.GithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception


class ViewModel : ViewModel() {
    lateinit var githubService: GithubService

    //RoomInitVar
    lateinit var githubDao: GithubDao

    init {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            githubService = retrofit.create(GithubService::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //Function Init Database
    fun initDatabase(context: Context) {
        githubDao = UserDatabase(context).githubDao()
    }

    private fun getOkHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        val OkHttpClient = builder.build()
        return OkHttpClient
    }

    fun getModelDetailAPI(UserName: String, returnUser: (UserModel?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val userDB = githubDao.getUserModel(userName = UserName)
            val user = if (userDB != null) {
                userDB
            } else {
                try{
                val userAPI = githubService.getUserDetail(userName = UserName)
                if(userAPI != null) {
                    githubDao.insertUserModel(userAPI)
                }
                userAPI
            }catch (e: Exception){
                e.printStackTrace()
                    null
                }
            }
            Logger.e("getUserDetail=" + user)
            withContext(Dispatchers.Main) {
                returnUser(user)
            }
        }
    }


    fun getFollowerDetailAPI(UserName: String, returnUser: (List<FollowerModel>?) -> Unit) {

        viewModelScope.launch(Dispatchers.IO) {
            val listFollowerDB = githubDao.getListUserFollower(userName = UserName)
            var listFollower = if (listFollowerDB?.size ?: 0 > 0) {
                listFollowerDB
            } else {
                try {
                    val listFollowerAPI = githubService.getListFollower(userName = UserName)
                    if(listFollowerAPI != null) {
                        githubDao.insertListUserFollower(listFollowerAPI)
                    }
                    listFollowerAPI
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
            Logger.e("getFollower=" + listFollower)
            withContext(Dispatchers.Main) {
                returnUser(listFollower)
            }
        }
    }

    fun getFollowingDetailAPI(UserName: String, returnUser: (List<FollowingModel>?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val listFollowingDB = githubDao.getListUserFollowing(userName = UserName)
            var listFollowing = if (listFollowingDB?.size ?: 0 > 0) {
                listFollowingDB
            } else {
                try {
                    val listFollowingAPI = githubService.getListFollowing(userName = UserName)
                    if(listFollowingAPI != null) {
                        githubDao.insertListUserFollowing(listFollowingAPI)
                    }
                    listFollowingAPI
                } catch (e: Exception) {
                    e.printStackTrace()
                    null
                }
            }
            Logger.e("getFollower=" + listFollowing)
            withContext(Dispatchers.Main) {
                returnUser(listFollowing)

            }
        }
    }

}
