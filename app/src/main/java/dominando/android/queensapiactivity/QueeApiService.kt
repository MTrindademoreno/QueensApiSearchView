package dominando.android.queensapiactivity

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object QueeApiService {
    val queenApi = getQueenApi().create(InterfaceQueenApi::class.java)

    private fun getQueenApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://www.nokeynoshade.party/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}