package com.trild.baitapapi

import android.app.Activity
import android.os.Bundle

class TestActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_recy)


    /*    val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listUserFollower = githubDataRepository.getListFollowerfroAPI("ToanMobile")
            withContext(Dispatchers.Main) {
                findViewById<RecyclerView>(R.id.recycleViewMain).adapter =
                    UserAdapter(this@TestActivity, listUserFollower ?: FollowerModel())
            }
        }*/

/*        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listUserFollower = githubDataRepository.getListFollowerfroAPI("ToanMobile")
            withContext(Dispatchers.Main) {
                findViewById<RecyclerView>(R.id.recycleFollower).adapter =
                    AdapterFollower(this@TestActivity, listUserFollower ?: FollowerModel())
            }
        }*/

    }
}