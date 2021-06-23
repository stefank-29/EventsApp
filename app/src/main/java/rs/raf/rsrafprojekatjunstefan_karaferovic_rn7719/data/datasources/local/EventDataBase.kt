package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.datasources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.datasources.local.converters.DateConverter
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.datasources.local.converters.StringListConverter
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.EventEntity


@Database(
    entities = [EventEntity::class],
    version = 1 ,
    exportSchema = false
)
@TypeConverters(StringListConverter::class, DateConverter::class)
abstract class EventDataBase : RoomDatabase() {
    abstract fun getEventDao(): EventDao
}