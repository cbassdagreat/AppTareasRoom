package cbass.apptareasroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbass.apptareasroom.model.Tarea
import cbass.apptareasroom.repo.TareaRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TareaVM(application: Application):AndroidViewModel(application){
    private val repo = TareaRepo(application.applicationContext)
    val lista = MutableLiveData<List<Tarea>>()

    fun listar()
    {
        CoroutineScope(Dispatchers.IO).launch {
            lista.postValue(repo.listar())
        }
    }

    fun agregar(nommbre:String)
    {
        val tarea = Tarea(nommbre)
        repo.agregar(tarea)
        listar()

    }
}