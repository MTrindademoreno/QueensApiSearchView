package dominando.android.queensapiactivity

class QueenBusinness {
    private  val repository: QueenRepository by lazy {
        QueenRepository()
    }
    private lateinit var list:MutableList<QueenItem>

    suspend fun getQueen():ResponseApi{
      return repository.getQueen()


    }
}