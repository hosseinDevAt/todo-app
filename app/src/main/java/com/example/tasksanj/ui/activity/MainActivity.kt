package com.example.tasksanj.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tasksanj.mvp.model.ModelMainActivity
import com.example.tasksanj.mvp.presenter.PresenterMainActivity
import com.example.tasksanj.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewMainActivity(this)
        setContentView(view.binding.root)


        presenter = PresenterMainActivity(view, ModelMainActivity(this))
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}