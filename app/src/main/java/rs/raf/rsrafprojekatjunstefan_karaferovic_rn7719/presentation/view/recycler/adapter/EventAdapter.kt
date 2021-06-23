package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.databinding.EventItemBinding
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.diff.EventDiffCallback
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.viewholder.EventViewHolder

class EventAdapter(
    private val recipeDiffCallback: EventDiffCallback,
    private val onDelete: (Event) -> Unit
) : ListAdapter<Event, EventViewHolder>(recipeDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemBinding =
            EventItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(itemBinding) {
            onDelete(getItem(it))
        }
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}