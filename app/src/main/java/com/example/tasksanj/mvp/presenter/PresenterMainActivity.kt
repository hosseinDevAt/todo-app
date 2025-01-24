package com.example.tasksanj.mvp.presenter

import com.example.tasksanj.db.model.TaskEntity
import com.example.tasksanj.mvp.ext.BaseLifeCycle
import com.example.tasksanj.mvp.ext.OnBindData
import com.example.tasksanj.mvp.model.ModelMainActivity
import com.example.tasksanj.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
): BaseLifeCycle {

    override fun onCreate() {

        setNewTask()
        setDataInitRecycler()
        dataHandler()

    }

    override fun onDestroy() {

        model.closeDatabase()

    }

    private fun setNewTask() {

        view.showDialog(
            object : OnBindData{
                override fun saveData(taskEntity: TaskEntity) {
                    model.setData(taskEntity)
                }
            }
        )

    }

    private fun dataHandler() {

        view.setData(
            object : OnBindData {
                override fun request(state: Boolean) {
                    model.getData(
                        state = state,
                        onBindData = object : OnBindData {
                            override fun getData(taskEntity: List<TaskEntity>) {
                                view.showTask(taskEntity)
                            }
                        }
                    )
                }
            }
        )

    }

    private fun setDataInitRecycler() {

        view.initRecycler(
            arrayListOf(),
            object : OnBindData{

                override fun editData(taskEntity: TaskEntity) {

                    model.editData(taskEntity)

                }

                override fun deleteData(taskEntity: TaskEntity) {
                    model.deleteTask(taskEntity)
                }

            }
        )

    }




}