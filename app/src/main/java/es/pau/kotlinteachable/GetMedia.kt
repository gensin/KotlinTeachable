package es.pau.kotlinteachable

/**
 * Created on 18/08/2017.
 */
private val thumbBase = "http://lorempixel.com/400/400/cats/"

fun getMedia() = (1..10).map{ MediaItem("Title $it", "$thumbBase$it", selectType(it)) }

fun selectType(position: Int): MediaItem.Type {
    if (position % 3 == 0){
        return MediaItem.Type.VIDEO
    }

    return MediaItem.Type.PHOTO
}