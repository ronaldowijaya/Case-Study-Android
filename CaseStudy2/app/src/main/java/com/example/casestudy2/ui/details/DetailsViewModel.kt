/*
package com.example.casestudy2.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.casestudy2.domain.GetPromosUseCase
import com.example.casestudy2.domain.item.PromoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getPromosUseCase: GetPromosUseCase) : ViewModel() {
    private val _promos = MutableStateFlow(emptyList<PromoItem>())
    val promos: StateFlow<List<PromoItem>> get() = _promos

    init {
        getPromos()
    }

    private fun getPromos() {
        viewModelScope.launch {
            try {
                val promos = getPromosUseCase()
                _promos.value = promos
            } catch (_: Exception) {}
        }
    }
    fun getGameById(id: Int) {
        viewModelScope.launch {
            try {
                val promos = getPromosByIdUseCase(id)
                _promos.value = promos
            } catch (_: Exception) {}
        }
    }
}*/
