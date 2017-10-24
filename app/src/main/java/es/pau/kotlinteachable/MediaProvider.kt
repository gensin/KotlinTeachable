package es.pau.kotlinteachable

import android.support.annotation.UiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created on 18/08/2017.
 */

object MediaProvider {
    private val thumbBase = "http://lorempixel.com/400/400/cats/"

    private var data: List<MediaItem> = emptyList<MediaItem>()

    fun dataAsync(callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                Thread.sleep(2000)
                data = (1..10).map { MediaItem("Title $it", "$thumbBase$it", selectType(it)) }
            }

            uiThread {
                callback(data)
            }
        }
    }

    fun selectType(position: Int): MediaItem.Type {
        if (position % 3 == 0){
            return MediaItem.Type.VIDEO
        }

        return MediaItem.Type.PHOTO
    }
}
