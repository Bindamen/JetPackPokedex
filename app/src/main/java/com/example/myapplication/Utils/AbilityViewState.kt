package com.example.myapplication.Utils

import com.example.myapplication.Model.AbilitiesItem


sealed class AbilityViewState {
    object Empty : AbilityViewState()
    object Loading : AbilityViewState()
    data class Success(val data: AbilitiesItem) : AbilityViewState()
    data class Error(val exception: Throwable) : AbilityViewState()
}