package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.repositories

import io.reactivex.Completable
import io.reactivex.Observable
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.datasources.local.EventDao
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.EventEntity


class EventRepositoryImpl(
    private val localDataSource: EventDao // local
) : EventRepository {

    override fun saveEvent(event: EventEntity): Completable {
        return localDataSource.saveEvent(event)
    }

    override fun getSavedEvents(): Observable<List<Event>> {
        return localDataSource
            .getEvents()
            .map {
                it.map {
                    Event(
                        id = it.id,
                        name = it.name,
                        desc = it.description,
                        date = it.date,
                        time = it.time,
                        type = it.type,
                        url = it.url
                    )
                }
            }
    }

    override fun deleteEvent(event: Event): Completable {
        return localDataSource.deleteEventById(event.id)
    }

}