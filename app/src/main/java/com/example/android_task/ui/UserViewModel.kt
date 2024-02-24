package com.example.android_task.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.android_task.pagination.UserListPaginationSource
import com.example.android_task.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val userList = Pager(PagingConfig(1)){
        UserListPaginationSource(repository)
    }.liveData.cachedIn(viewModelScope)


}



