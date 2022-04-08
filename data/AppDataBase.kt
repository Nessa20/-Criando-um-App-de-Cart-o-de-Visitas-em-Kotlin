package br.com.dio.bussinescard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [BusinessCarDao::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun businessDao() : BusinessCarDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(lock = this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                     "businesscard_db"
                ).build()
                INSTANCE = instance
                instance
            }

        }
    }
}