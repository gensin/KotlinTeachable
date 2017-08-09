package es.pau.kotlinteachable

/**
 * Project: KotlinTeachable
 * Created on 03/08/2017.
 */
data class MediaItem(val title: String, val thumbUrl: String, val type: Type) {

    enum class Type { PHOTO, VIDEO }
}