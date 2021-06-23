package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.contract

import android.util.EventLog
import androidx.lifecycle.LiveData
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.states.EventState
import java.util.*

interface MainContract {

    interface ViewModel {

        val savedEventState: LiveData<EventState>

        fun saveEvent(
            name: String,
            desc: String,
            date: String,
            time: String,
            type: String,
            url: String
        )

        fun getSavedEvents()

        fun deleteEvent(event: Event)

    }
}