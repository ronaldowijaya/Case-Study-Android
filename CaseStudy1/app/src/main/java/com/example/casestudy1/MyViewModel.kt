package com.example.casestudy1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.casestudy1.model.TransHistory

class MyViewModel : ViewModel() {
    private val _trans = mutableStateOf(TransHistory("","","",0))
    val trans: State<TransHistory> = _trans

    fun setTransHistory(newTrans: TransHistory) {
        _trans.value = newTrans
    }
}