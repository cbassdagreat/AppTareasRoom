package cbass.apptareasroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cbass.apptareasroom.dao.TareaDao
import cbass.apptareasroom.model.Tarea
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Tarea::class], version = 1)
abstract class ProjectDB:RoomDatabase() {

    abstract fun tareaDao(): TareaDao

    companion object{
        @Volatile
        private var instancia:ProjectDB? = null

        fun getInstancia(context: Context) :ProjectDB
        {
            if (instancia == null)
            {
                kotlin.synchronized(this)
                {
                    instancia = Room.databaseBuilder(context, ProjectDB::class.java,"project_db").build()

                }
            }
            return instancia!!
        }
    }
}