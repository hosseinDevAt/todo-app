package com.example.tasksanj.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tasksanj.databinding.RecyclerItemBinding
import com.example.tasksanj.db.model.TaskEntity
import com.example.tasksanj.mvp.ext.OnBindData

class RecyclerTaskAdapter(
    private val tasks: ArrayList<TaskEntity>,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<RecyclerTaskAdapter.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.setData(tasks[position])
    }


    inner class TaskViewHolder(
        private val view: RecyclerItemBinding
    ) : ViewHolder(view.root) {

        fun setData(data: TaskEntity) {

            view.txtTitle.text = data.title
            view.checkBox.isChecked = data.state

            view.checkBox.setOnClickListener {

                if (data.state)
                    onBindData.editData(TaskEntity(data.id, data.title, false))
                else
                    onBindData.editData(TaskEntity(data.id, data.title, true))

            }

            view.imgDelete.setOnClickListener {

                onBindData.deleteData(data)

            }

        }
    }

    fun dataUpdate(newList: ArrayList<TaskEntity>) {
        val diffCallback = RecyclerDiffUtils(tasks, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        tasks.clear()
        tasks.addAll(newList)

        diffResult.dispatchUpdatesTo(this)
    }
}