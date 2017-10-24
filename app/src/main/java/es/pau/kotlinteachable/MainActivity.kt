package es.pau.kotlinteachable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    val recyclerView by lazy { findViewById(R.id.recycler) as RecyclerView }

    var adapter = MediaAdapter() { (title) -> toast(title) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter
        MediaProvider.dataAsync { adapter.items = it }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         MediaProvider.dataAsync{ media ->
            adapter.items = when(item.itemId) {
                R.id.filter_all -> media
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }
        return true
    }
}
