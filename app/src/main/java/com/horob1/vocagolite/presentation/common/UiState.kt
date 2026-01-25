package com.horob1.vocagolite.presentation.common

sealed class UiState<out T> {
    data object Idle : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : UiState<Nothing>()

    val isLoading: Boolean get() = this is Loading
    val isSuccess: Boolean get() = this is Success
    val isError: Boolean get() = this is Error
    val isIdle: Boolean get() = this is Idle

    fun getOrNull(): T? = (this as? Success)?.data

    fun getOrDefault(default: @UnsafeVariance T): T = getOrNull() ?: default

    inline fun onSuccess(action: (T) -> Unit): UiState<T> {
        if (this is Success) action(data)
        return this
    }

    inline fun onError(action: (String, Throwable?) -> Unit): UiState<T> {
        if (this is Error) action(message, throwable)
        return this
    }

    inline fun onLoading(action: () -> Unit): UiState<T> {
        if (this is Loading) action()
        return this
    }

    inline fun <R> map(transform: (T) -> R): UiState<R> {
        return when (this) {
            is Idle -> Idle
            is Loading -> Loading
            is Success -> Success(transform(data))
            is Error -> Error(message, throwable)
        }
    }
}
