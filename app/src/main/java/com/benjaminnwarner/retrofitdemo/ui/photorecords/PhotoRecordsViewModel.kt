package com.benjaminnwarner.retrofitdemo.ui.photorecords

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benjaminnwarner.retrofitdemo.mappers.PaginationMapper
import com.benjaminnwarner.retrofitdemo.mappers.PhotoMapper
import com.benjaminnwarner.retrofitdemo.models.PhotoRecord
import com.benjaminnwarner.retrofitdemo.models.Pagination
import com.benjaminnwarner.retrofitdemo.repository.photorecord.PhotoRecordApi
import kotlinx.coroutines.launch

class PhotoRecordsViewModel : ViewModel() {

    private val _photoRecords: MutableLiveData<List<PhotoRecord>> = MutableLiveData()
    val photoRecords: LiveData<List<PhotoRecord>> get() = _photoRecords

    private val _pagination: MutableLiveData<Pagination> = MutableLiveData()
    val pagination:LiveData<Pagination> get() = _pagination
    private val itemsPerPage = 16

    private val photoRepository = PhotoRecordApi.create()

    init {
        viewModelScope.launch {
            val response = photoRepository.getPhotoRecords(0, itemsPerPage)
            val records = PhotoMapper.mapList(response.photo_records)
            _photoRecords.postValue(records)
            val pagination = PaginationMapper.map(response.pagination)
            _pagination.postValue(pagination)
        }
    }

    fun getNextPage(){
        viewModelScope.launch {
            val offset = _pagination.value!!.offset + itemsPerPage
            val response = photoRepository.getPhotoRecords(offset, itemsPerPage)
            val records = PhotoMapper.mapList(response.photo_records)
            _photoRecords.postValue(_photoRecords.value!! + records)
            val pagination = PaginationMapper.map(response.pagination)
            _pagination.postValue(pagination)
        }
    }
}
