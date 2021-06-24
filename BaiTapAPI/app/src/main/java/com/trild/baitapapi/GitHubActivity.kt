package com.trild.baitapapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GitHubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

/*        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val userModel = githubDataRepository.getUserDetailfroAPI( "ToanMobile")
            Logger.e("USER MODEL :",userModel.toString())
            withContext(Dispatchers.Main){
                findViewById<TextView>(R.id.txtUserName).text = userModel?.name ?: ""
            }
        }*/

        /*//Follower
                        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listUserFollower = githubDataRepository.getListFollowerfroAPI("ToanMobile")
            withContext(Dispatchers.Main) {
                findViewById<RecyclerView>(R.id.recycleFollower).adapter =
                    AdapterFollower(this@TestActivity, listUserFollower ?: FollowerModel())
            }
        }
                }
            }*/

    }

}