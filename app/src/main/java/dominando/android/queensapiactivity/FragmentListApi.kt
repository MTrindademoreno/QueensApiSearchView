package dominando.android.queensapiactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FragmentListApi : Fragment() {
private lateinit var queenAdapter: QueenAdapter

    private lateinit var queenViewModel: QueenViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_list_api, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        queenViewModel = ViewModelProvider(requireActivity()).get(QueenViewModel::class.java)
        queenViewModel.getQueen()


            queenViewModel.queenLiveData.observe(viewLifecycleOwner, Observer { queen ->
                activity?.findViewById<RecyclerView>(R.id.rvQueen)?.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    queenAdapter= QueenAdapter(queen)
                    adapter=queenAdapter

                }
            })

        activity?.findViewById<SearchView>(R.id.search)?.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                this@FragmentListApi.queenAdapter.filter.filter(newText)
                return false
            }

        })

    }


}