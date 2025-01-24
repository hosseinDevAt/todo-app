package com.example.tasksanj.adapter

import androidx.recyclerview.widget.DiffUtil

class RecyclerDiffUtils
    (
    private val oldList:ArrayList<*>,
    private val newList:ArrayList<*>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]


}