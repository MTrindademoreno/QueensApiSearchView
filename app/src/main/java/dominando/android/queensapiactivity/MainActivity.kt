package dominando.android.queensapiactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dominando.android.queensapiactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var queenViewModel: QueenViewModel


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queenViewModel = ViewModelProvider(this).get(QueenViewModel::class.java)

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container,FragmentListApi())
        ft.commit()



}}