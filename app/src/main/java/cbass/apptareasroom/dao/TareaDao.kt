package cbass.apptareasroom.dao

import androidx.room.*
import cbass.apptareasroom.model.Tarea

@Dao
interface TareaDao {

    @Insert
    fun agregar(tarea:Tarea)

    @Delete
    fun eliminar(tarea:Tarea)

    @Query("delete from tarea_table where id = :id")
    fun eliminarById(id:Int)

    @Update
    fun actualizar(tarea:Tarea)

    @Query("select id, name from tarea_table")
    fun listar(): List<Tarea>

    @Query("select id, name from tarea_table where id = :id")
    fun buscar(id:Int) : Tarea

    @Query("select count(id) from tarea_table")
    fun contar(): Int

}
