package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.states

import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event

sealed class EventState {
    object Loading : EventState()
    object DataFetched : EventState()
    data class Success(val events: List<Event>) : EventState()
    data class Error(val message: String) : EventState()
}
