package com.example.android_task.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android_task.model.Data
import com.example.android_task.repository.UserRepository
import retrofit2.HttpException

class UserListPaginationSource(
    private val repository: UserRepository,
) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getUsersList(currentPage)
            val data = response.data //list of users
            val responseDataMutableList = mutableListOf<Data>()
            responseDataMutableList.addAll(data)
            //add data in list
            LoadResult.Page(
                data = responseDataMutableList,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            //internet filer exception
            LoadResult.Error(e)
        }catch (e :HttpException){
            //server exception
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return null
    }



}