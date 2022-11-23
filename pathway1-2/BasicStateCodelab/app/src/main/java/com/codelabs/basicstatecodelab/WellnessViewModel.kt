package com.codelabs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _list = getWellnessTasks().toMutableStateList()
    val list: List<WellnessTask>
        get() = _list

    fun remove(item: WellnessTask) {
        _list.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) = list.find {
        it.id == item.id
    }?.let { task ->
        task.checked = checked
    }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

}
