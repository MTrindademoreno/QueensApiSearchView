package dominando.android.queensapiactivity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "queens")
@Parcelize
data class QueenItem(
    @PrimaryKey
   val id: Int,
@ColumnInfo(name="url da imagem")
@SerializedName("image_url")
    val imageUrl: String,

   // val missCongeniality: Boolean,
@ColumnInfo(name="nome da rainha")
    val name: String
    //val quote: String,
   // val winner: Boolean
):Parcelable