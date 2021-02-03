package dominando.android.queensapiactivity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: QueenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val position = intent.getIntExtra("position",-1)
        detailViewModel = ViewModelProvider(this).get(QueenViewModel::class.java)
        detailViewModel.getQueen()
        detailViewModel.queenLiveData.observe(this, androidx.lifecycle.Observer {

            findViewById<TextView>(R.id.nameQueend).text = it[position].name
            Glide.with(applicationContext).load(it[position].imageUrl)
                .into(findViewById<ImageView>(R.id.imgQueend))
        })


    }
}