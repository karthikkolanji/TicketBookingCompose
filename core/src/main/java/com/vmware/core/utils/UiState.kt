package com.vmware.core.utils

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Success<T>(var data: T) : UiState<T>()
    data class Error(var exception: Throwable) : UiState<Nothing>()
}
