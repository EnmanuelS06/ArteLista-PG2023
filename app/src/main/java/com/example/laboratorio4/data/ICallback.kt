package com.example.laboratorio4.data

interface ICallback<T> {
        fun onSuccess(result: T?)
        fun onFailed(exception: Exception)

}
