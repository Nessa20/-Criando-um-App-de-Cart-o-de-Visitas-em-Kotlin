package br.com.dio.bussinescard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val  dao: BusinessCarDao) {
    fun insert(businessCarDao: BusinessCarDao) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(businessCarDao)
        }
    }
    fun getAll() = dao.getAll()
}