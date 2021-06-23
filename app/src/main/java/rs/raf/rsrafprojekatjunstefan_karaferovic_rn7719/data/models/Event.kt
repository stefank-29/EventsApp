package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.models

import java.io.Serializable

data class Event(
    val id: Int,
    val name: String,
    val desc: String,
    val date: String,
    val time: String,
    val type: String,
    val url: String
) : Serializable

