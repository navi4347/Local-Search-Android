package app.ntech.localsearch.roomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "local")
data class UserEntity(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id :Int = 0,
    @ColumnInfo(name = "Username")var Username : String? = null,
    @ColumnInfo(name = "Categories")var Categories : String? = null,
    @ColumnInfo(name = "SubCategories")var SubCategories : String? = null,
    @ColumnInfo(name = "Timings")var Timings : String? = null,
    @ColumnInfo(name = "Address")var Address : String? = null,
    @ColumnInfo(name = "Website")var Website : String? = null,
    @ColumnInfo(name = "Email")var Email : String? = null,
    @ColumnInfo(name = "Phone")var Phone : String? = null,
    @ColumnInfo(name = "ImageUrl")var ImageUrl : String? = null,
    @ColumnInfo(name = "GoogleMaps")var GoogleMaps : String? = null,

    )