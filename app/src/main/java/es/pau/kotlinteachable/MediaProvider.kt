package es.pau.kotlinteachable

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created on 18/08/2017.
 */

object MediaProvider {
    private val thumbBase = "http://lorempixel.com/400/400/"

    private var data: List<MediaItem> = emptyList<MediaItem>()

    fun dataAsync(dataType: String, callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                data = dataSync(dataType)
            }

            uiThread {
                callback(data)
            }
        }
    }

    public fun dataSync(dataType: String): List<MediaItem> {
            Thread.sleep(2000)
            data = (1..10).map { MediaItem(it, "Title $it", "$thumbBase/dataType/$it", selectType(it)) }
            return data
    }

    fun selectType(position: Int): MediaItem.Type {
        if (position % 3 == 0){
            return MediaItem.Type.VIDEO
        }

        return MediaItem.Type.PHOTO
    }
}
