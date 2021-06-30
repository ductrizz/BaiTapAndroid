package com.trild.githubfind

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.trild.githubfind.databinding.GithubActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: GithubActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GithubActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}