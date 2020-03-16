package com.benjaminnwarner.retrofitdemo.ui.photorecords

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benjaminnwarner.retrofitdemo.R
import kotlinx.android.synthetic.main.fragment_photo_records.view.*

class PhotoRecordsFragment : Fragment() {
    private lateinit var viewModel: PhotoRecordsViewModel
    private var photoRecordAdapter = PhotoRecordAdapter(listOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val root = inflater.inflate(R.layout.fragment_photo_records, container, false)
        viewModel = ViewModelProvider(this).get(PhotoRecordsViewModel::class.java)

        root.fragment_photo_records_recycler.apply {
            val columnCount = 2
            val gridSpacing = 64
            layoutManager = GridLayoutManager(context, columnCount)
            adapter = photoRecordAdapter
            addItemDecoration(PhotoRecordGridDecoration(columnCount, gridSpacing))
        }

        viewModel.photoRecords.observe(viewLifecycleOwner, Observer {
            photoRecordAdapter = PhotoRecordAdapter(it)
            root.fragment_photo_records_recycler.swapAdapter(photoRecordAdapter, false)
            if(it.size != viewModel.pagination.value?.total) {
                watchScrollView()
            }
        })

        return root
    }

    private fun watchScrollView() {
        view?.fragment_photo_records_recycler?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            val SCROLL_DOWN = 1
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if(!recyclerView.canScrollVertically(SCROLL_DOWN)){
                    view?.fragment_photo_records_recycler?.removeOnScrollListener(this)
                    viewModel.getNextPage()
                }
            }
        })
    }

    companion object {
        fun newInstance() = PhotoRecordsFragment()
    }
}
