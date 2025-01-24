package com.example.tasksanj.mvp.ext

import com.example.tasksanj.db.model.TaskEntity

interface OnBindData {

    fun saveData(taskEntity: TaskEntity) {}

    fun editData(taskEntity: TaskEntity) {}

    fun getData(taskEntity: List<TaskEntity>) {}

    fun deleteData(taskEntity: TaskEntity) {}

    fun request(state: Boolean) {}

}