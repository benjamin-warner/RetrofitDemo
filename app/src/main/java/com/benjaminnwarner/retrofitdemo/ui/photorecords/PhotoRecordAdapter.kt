package com.benjaminnwarner.retrofitdemo.ui.photorecords

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benjaminnwarner.retrofitdemo.models.PhotoRecord

class PhotoRecordAdapter(private val list: List<PhotoRecord>): RecyclerView.Adapter<PhotoRecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoRecordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PhotoRecordViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PhotoRecordViewHolder, position: Int) {
        val photoRecord: PhotoRecord = list[position]
        holder.bind(photoRecord)
    }

    override fun getItemCount(): Int = list.size
}
