package cbass.apptareasroom.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarea_table")
class Tarea(
    @ColumnInfo(name = "name")
    var nombre:String
) {

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}