package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.EventEntity

interface EventRepository {

    fun saveEvent(event: EventEntity): Completable
    fun getSavedEvents(): Observable<List<Event>>
    fun deleteEvent(event: Event): Completable
}