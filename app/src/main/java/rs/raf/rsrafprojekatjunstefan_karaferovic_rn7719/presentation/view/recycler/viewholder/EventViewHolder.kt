package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.viewholder

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models.Event
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.databinding.EventItemBinding
import kotlin.math.round

class EventViewHolder(
    private val itemBinding: EventItemBinding,
    onDelete: (Int) -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {

    init {
        itemBinding.deleteBtn.setOnClickListener { onDelete(adapterPosition) }
    }

    fun bind(event: Event) {
        itemBinding.nameTv.text = event.name
        itemBinding.descTv.text = event.desc
        itemBinding.dateTv.text = event.date
        itemBinding.timeTv.text = event.time
        itemBinding.urlTv.text = event.url
        if (event.type.equals("Low")) {
            itemBinding.root.setBackgroundColor(Color.parseColor("#f8f8f8"))
        } else if (event.type.equals("Medium")) {
            itemBinding.root.setBackgroundColor(Color.parseColor("#00ed00"))
        }
    }
}