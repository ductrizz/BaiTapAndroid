package com.trild.baitapapi

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.orhanobut.logger.Logger
import com.trild.baitapapi.API.FollowerModel
import com.trild.baitapapi.API.UserModel
import com.trild.baitapapi.SetData.GithubDataRepository
import kotlinx.coroutines.*

class GitHubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_user)

        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val userModel = githubDataRepository.getUserDetailfroAPI( "ToanMobile")
            Logger.e("USER MODEL :",userModel.toString())
            withContext(Dispatchers.Main){
                findViewById<TextView>(R.id.txtUserName).text = userModel?.name ?: ""
            }
        }

        /*//Follower
                    val githubDataRepository = GithubDataRepository()
            CoroutineScope(Dispatchers.IO).launch {
                val listUserFollower = githubDataRepository.getListFollowerfroAPI("ToanMobile")
                withContext(Dispatchers.Main){
                    Logger.e("USER MODEL :", "xxx")
                    findViewById<RecyclerView>(R.id.recycleViewMain).adapter = AdapterFollower(this@GitHubActivity, listUserFollower?: FollowerModel())
                }
            }*/

    }

}