package app.ntech.localsearch.roomDb

import androidx.room.*


@Dao
interface UserDao{

    @Query("SELECT * FROM local ORDER BY id DESC")
    fun getAllUserInfo() : List<UserEntity>?

    @Insert
    fun insertUser(user : UserEntity?)

    @Update
    fun updateUser(user : UserEntity?)

    @Delete
    fun deleteUser(user : UserEntity?)

    @Query("DELETE FROM local")
    fun delete()

    @Query("SELECT * FROM local WHERE SubCategories = (:category)")
    fun filtersubcategory(category : String): List<UserEntity>?

    @Query("SELECT * FROM local WHERE Categories = (:category)")
    fun filtercategory(category : String): List<UserEntity>?

/*
    @Query("SELECT * FROM donordetails WHERE bloodgroup = (:strBlood) AND state = (:states) AND district = (:strDist)")
    fun filterdb(strBlood : String,states : String,strDist : String): List<UserEntity>?

    @Query("SELECT * FROM donordetails WHERE bloodgroup = (:strBlood) AND state = (:states) AND district = (:strDist) AND city = (:strCity)")
    fun filternewdb(strBlood : String,states : String,strDist : String,strCity : String): List<UserEntity>?

    @Query("SELECT COUNT() FROM donordetails WHERE mobilenumber = (:mobileNumber)")
    fun numberexistsornot(mobileNumber : String) : Int
*/

}