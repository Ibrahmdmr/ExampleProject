package com.example.jsonplaceholderworking.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholderworking.data.User
import com.example.jsonplaceholderworking.data.repo.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val state = MutableLiveData<List<User>>()
    val mState: LiveData<List<User>> get() = state

    init {
        getAllUserList()
    }

    fun getAllUserList() {
        viewModelScope.launch {

            val response = try {
                userRepository.getUserData()
            } catch (e: java.lang.Exception) {
                return@launch
            }

            if (response.isSuccessful) {
                state.value = response.body()
                Log.e("TAG", response.body().toString())
            }
        }

    }


}
