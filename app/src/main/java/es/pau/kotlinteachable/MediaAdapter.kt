package es.pau.kotlinteachable

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Project: KotlinTeachable
 * Created on 03/08/2017.
 */

class MediaAdapter(val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_media_item)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MediaAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = find<TextView>(R.id.media_title)
        val image = find<ImageView>(R.id.media_thumb)
        val icon = find<ImageView>(R.id.media_video_indicator)

        fun bind(item: MediaItem) {
            title.text = item.title
            image.loadUrl(item.thumbUrl)
            
            when (item.type) {
                MediaItem.Type.PHOTO -> icon.visibility = View.GONE
                MediaItem.Type.VIDEO -> icon.visibility = View.VISIBLE
            }
        }
    }
}