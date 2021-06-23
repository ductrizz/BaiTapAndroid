package com.trild.baitapapi

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.trild.baitapapi.API.FollowerModel
import com.trild.baitapapi.SetData.GithubDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TestActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_recy)


        val githubDataRepository = GithubDataRepository()
        CoroutineScope(Dispatchers.IO).launch {
            val listUserFollower = githubDataRepository.getListFollowerfroAPI("ToanMobile")
            withContext(Dispatchers.Main) {
                findViewById<RecyclerView>(R.id.recycleViewMain).adapter =
                    UserAdapter(this@TestActivity, listUserFollower ?: FollowerModel())
            }
        }


    }
}