package dominando.android.queensapiactivity

class QueenRepository {


    suspend fun getQueen():ResponseApi{
        return try {
            val response = QueeApiService.queenApi.all()
            return if(response.isSuccessful){
                ResponseApi.Success(response.body())
            }else{ResponseApi.Error("Erro Ao carregar Dados!")}



        }catch (exception:Exception){
            return ResponseApi.Error("Erro ao carregar dados !!")
        }

    }
}