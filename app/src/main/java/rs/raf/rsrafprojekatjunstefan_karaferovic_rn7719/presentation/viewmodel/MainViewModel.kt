package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.EventEntity
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.repositories.EventRepository
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.contract.MainContract
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.states.EventState
import timber.log.Timber

class MainViewModel(
    private val eventRepository: EventRepository
) : ViewModel(), MainContract.ViewModel {

    private val subscriptions = CompositeDisposable()

    override val savedEventState: MutableLiveData<EventState> = MutableLiveData()

    override fun saveEvent(
        name: String,
        desc: String,
        date: String,
        time: String,
        type: String,
        url: String
    ) {
        val subscription = eventRepository
            .saveEvent(
                EventEntity(
                    id = 0,
                    name = name,
                    description = desc,
                    date = date,
                    time = time,
                    type = type,
                    url = url
                )
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("Event saved")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun getSavedEvents() {
        val subscription = eventRepository
            .getSavedEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.e("$it")
                    savedEventState.value = EventState.Success(it)
                },
                {
                    savedEventState.value =
                        EventState.Error("Error while fetching data")
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }

    override fun deleteEvent(event: Event) {
        val subscription = eventRepository
            .deleteEvent(event)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("Event saved")
                },
                {
                    Timber.e(it)
                }
            )
        subscriptions.add(subscription)
    }


    override fun onCleared() {
        super.onCleared()
        subscriptions.dispose()
    }
}