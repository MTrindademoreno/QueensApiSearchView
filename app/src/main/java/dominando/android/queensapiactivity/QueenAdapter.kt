package dominando.android.queensapiactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList

class QueenAdapter( val list:ArrayList<QueenItem>


   ):RecyclerView.Adapter<QueenAdapter.ViewHolder>(),Filterable {



private var movieFilter = ArrayList<QueenItem>()

    init {
        movieFilter = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_queen,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieFilter[position])
    }

    override fun getItemCount(): Int {
       return movieFilter.size
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(queen: QueenItem)= with(itemView){
            findViewById<TextView>(R.id.nameQueen).text = queen.name
            Glide.with(itemView.context).load(queen.imageUrl).into(findViewById(R.id.imgQueen))

        }

    }
    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    movieFilter = list
                } else {
                    val resultList = ArrayList<QueenItem>()
                    for (movie in list) {
                        if (movie.name.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(movie)
                        }
                    }
                    movieFilter = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = movieFilter
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {




                   notifyDataSetChanged()


            }

        }
    }

}
