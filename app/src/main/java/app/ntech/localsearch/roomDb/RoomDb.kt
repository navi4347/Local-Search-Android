package app.ntech.localsearch.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class],version = 3)
abstract class RoomDb : RoomDatabase(){

    abstract fun userDao() : UserDao?

    companion object{

        private var INSTANCE : RoomDb?=null

        fun getAppDatabase(context: Context):RoomDb?{

            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder<RoomDb>(
                    context.applicationContext,RoomDb::class.java,"Lca")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }
    }



}