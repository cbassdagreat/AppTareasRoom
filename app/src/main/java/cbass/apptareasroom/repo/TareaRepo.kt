package cbass.apptareasroom.repo

import android.content.Context
import cbass.apptareasroom.model.Tarea
import cbass.apptareasroom.room.ProjectDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TareaRepo(val context: Context) {

    private val db = ProjectDB.getInstancia(context)

    fun agregar(tarea:Tarea)
    {
        CoroutineScope(Dispatchers.IO).launch {
            db.tareaDao().agregar(tarea)
        }
    }

    fun listar() : List<Tarea>
    {
        return db.tareaDao().listar()
    }
}