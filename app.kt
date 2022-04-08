package br.com.dio.bussinescard

import android.app.Application
import br.com.dio.bussinescard.data.AppDataBase
import br.com.dio.bussinescard.data.BusinessCardRepository

class app : Application() {
    val database by lazy { AppDataBase.getDataBase( this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}