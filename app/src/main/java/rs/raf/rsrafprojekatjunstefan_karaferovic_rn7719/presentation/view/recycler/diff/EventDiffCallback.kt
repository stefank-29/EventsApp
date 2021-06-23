package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event

class EventDiffCallback : DiffUtil.ItemCallback<Event>() {

    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.name == newItem.name
                && oldItem.desc == newItem.desc
                && oldItem.date == newItem.date
                && oldItem.time == newItem.time
                && oldItem.type == newItem.type
                && oldItem.url == newItem.url
    }
}