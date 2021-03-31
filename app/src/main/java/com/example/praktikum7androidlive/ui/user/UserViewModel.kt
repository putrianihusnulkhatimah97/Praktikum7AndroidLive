package com.example.praktikum7androidlive.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum7androidlive.model.User
import com.example.praktikum7androidlive.network.Api
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val _response = MutableLiveData<User>()

    val response: LiveData<User>
        get() = _response

    init {
        setResponse()
    }

    private fun setResponse() {
        viewModelScope.launch {
            try {
                val listResult = Api.retrofitService.getUsers()
                _response.value = listResult
            } catch (e: Exception) {
                _response.value = null
            }
        }
    }
}