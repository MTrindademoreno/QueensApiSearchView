package dominando.android.queensapiactivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class QueenViewModel:ViewModel() {

    val queenLiveData:MutableLiveData<Queen> = MutableLiveData()


    val mQueenBusinness = QueenBusinness()

    fun getQueen(){

        viewModelScope.launch {
            val response= mQueenBusinness.getQueen()

            when(response){
                is ResponseApi.Success->
                {queenLiveData.postValue(
                    response.data as? Queen
                )}
            }
        }


    }

}