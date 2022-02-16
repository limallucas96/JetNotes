package com.lls.jetnotes.entities

sealed class FlowWrapper<out T> {
    object None : FlowWrapper<Nothing>()
    object Loading : FlowWrapper<Nothing>()
    data class Success<out T>(val value: T) : FlowWrapper<T>()
    data class Error(val error: Throwable, val message: String? = null) : FlowWrapper<Nothing>()
}