package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String,
    val date: String,
    val time: String,
    val type: String,
    val url: String
)