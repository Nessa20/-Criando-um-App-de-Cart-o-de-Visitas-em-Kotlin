package br.com.dio.bussinescard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinessCarDao {
    @Query(value = "SELECT * FROM BusinessCard")
    fun getAll(): LiveData<List<BusinessCarDao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCarDao: BusinessCarDao)
}