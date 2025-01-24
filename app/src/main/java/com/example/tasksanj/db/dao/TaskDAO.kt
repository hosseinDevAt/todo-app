package com.example.tasksanj.db.dao

import androidx.room.*
import com.example.tasksanj.db.DBHandler
import com.example.tasksanj.db.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {

    @Insert
    fun insertTask(vararg task: TaskEntity)

    @get:Query("SELECT * FROM ${DBHandler.TASK_TABLE}")
    val getTasks: Flow<List<TaskEntity>>

    @Query("SELECT * FROM ${DBHandler.TASK_TABLE} WHERE state = :type")
    fun getTaskByColumn(type: Boolean): Flow<List<TaskEntity>>

    @Update
    fun updateTask(vararg task: TaskEntity): Int

    @Delete
    fun deleteTask(vararg task: TaskEntity): Int

}