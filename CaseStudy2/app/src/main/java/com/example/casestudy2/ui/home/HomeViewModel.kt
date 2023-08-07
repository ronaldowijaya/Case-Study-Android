package com.example.casestudy2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.casestudy2.domain.GetPromosByIdUseCase
import com.example.casestudy2.domain.GetPromosUseCase
import com.example.casestudy2.domain.item.DetailsItem
import com.example.casestudy2.domain.item.PromoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPromosUseCase: GetPromosUseCase, private val getPromosByIdUseCase: GetPromosByIdUseCase) : ViewModel() {
    private val _promos = MutableLiveData<List<PromoItem>>()
    val promos: LiveData<List<PromoItem>> get() = _promos

    private val _promo = MutableLiveData<DetailsItem>()
    val promo: LiveData<DetailsItem> get() = _promo

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

    fun getPromoById(id: Int) {
        viewModelScope.launch {
            try {
                val promo = getPromosByIdUseCase(id)
                _promo.value = promo
            } catch (_: Exception) {}
        }
    }
}