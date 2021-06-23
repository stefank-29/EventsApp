package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.EventEntity

@Dao
abstract class EventDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun saveEvent(event: EventEntity): Completable

    @Query("SELECT * FROM events")
    abstract fun getEvents(): Observable<List<EventEntity>>

    @Query("DELETE FROM events WHERE id = :eventId")
    abstract fun deleteEventById(eventId: Int): Completable

}