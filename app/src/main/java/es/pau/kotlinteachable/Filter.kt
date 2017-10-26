package es.pau.kotlinteachable

/**
 * Created on 27/10/17.
 */
sealed class Filter {
    object None : Filter()
    class ByType(val type: MediaItem.Type): Filter()
}