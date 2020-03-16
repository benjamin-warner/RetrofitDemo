package com.benjaminnwarner.retrofitdemo.ui.photorecords

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class PhotoRecordGridDecoration(private val columnCount: Int, private val spacing: Int) : ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % columnCount
        outRect.left = spacing - column * spacing / columnCount
        outRect.right = (column + 1) * spacing / columnCount

        if (position < columnCount) {
            outRect.top = spacing
        }
        outRect.bottom = spacing
    }
}
