package com.example.tasksanj.mvp.model

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.tasksanj.db.DBHandler
import com.example.tasksanj.db.model.TaskEntity
import com.example.tasksanj.mvp.ext.OnBindData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ModelMainActivity(private val activity: AppCompatActivity) {

    private val db = DBHandler.getDatabase(activity)

    fun setData(taskEntity: TaskEntity){
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO){
                db.taskDao().insertTask(taskEntity)
            }
        }
    }

    fun editData(taskEntity: TaskEntity){
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO){
                db.taskDao().updateTask(taskEntity)
            }
        }
    }

    fun deleteTask(taskEntity: TaskEntity){
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO){
                db.taskDao().deleteTask(taskEntity)
            }
        }
    }

    fun getData(onBindData: OnBindData, state: Boolean) {

        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO){
                val task = db.taskDao().getTaskByColumn(state)
                withContext(Dispatchers.Main){
                    task.collect{

                        onBindData.getData(it)

                    }
                }
            }
        }

    }

    fun closeDatabase(){
        db.close()
    }

}