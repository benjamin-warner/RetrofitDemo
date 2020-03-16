package com.benjaminnwarner.retrofitdemo.ui.photorecords

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.benjaminnwarner.retrofitdemo.R
import com.benjaminnwarner.retrofitdemo.helpers.ResourceHelpers
import com.benjaminnwarner.retrofitdemo.models.PhotoRecord
import com.squareup.picasso.Picasso

class PhotoRecordViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_photo_record, parent, false)) {
    private var image: ImageView? = null
    private var photoType: TextView? = null
    private var comment: TextView? = null

    init {
        image = itemView.findViewById(R.id.photo_record_image)
        photoType = itemView.findViewById(R.id.photo_record_type)
        comment = itemView.findViewById(R.id.photo_record_comment)
    }

    fun bind(photoRecord: PhotoRecord) {
        Picasso
            .get()
            .load(photoRecord.imageUrl)
            .into(image)

        val photoTypeRId = ResourceHelpers.photoTypeStringId(photoRecord.photoType)
        photoType?.text = itemView.context.resources.getString(photoTypeRId)

        val photoTypeColorRId = ResourceHelpers.photoTagColor(photoRecord.photoType);
        DrawableCompat.setTint(
            DrawableCompat.wrap(photoType?.background!!),
            ContextCompat.getColor(itemView.context, photoTypeColorRId)
        )

        comment?.text = photoRecord.comment
    }
}
