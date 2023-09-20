package com.vmware.core.utils

sealed class State<out T> {
    object LoadingState : State<Nothing>()
    data class Success<T>(var data: T) : State<T>()
    data class ErrorState(var exception: Throwable) : State<Nothing>()
}
