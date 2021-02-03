package dominando.android.queensapiactivity

import retrofit2.Response
import retrofit2.http.GET

interface InterfaceQueenApi {

    @GET("queens/")
    suspend fun all():Response<Queen>
}