package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.databinding.ActivityAddEventBinding
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.databinding.ActivityShowActivitiesBinding
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.contract.MainContract
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.adapter.EventAdapter
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.recycler.diff.EventDiffCallback
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.states.EventState
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.viewmodel.MainViewModel

class ShowActivitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowActivitiesBinding

    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()

    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowActivitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        initListeners()
        initRecycler()
        initObserver()
    }

    private fun initObserver() {
        mainViewModel.savedEventState.observe(this, Observer {
            renderState(it)
        })
        mainViewModel.getSavedEvents()
    }

    private fun initListeners() {

    }

    private fun initRecycler() {
        binding.eventsRv.layoutManager = LinearLayoutManager(this)
        eventAdapter = EventAdapter(EventDiffCallback()) {
            mainViewModel.deleteEvent(it)
        }
        binding.eventsRv.adapter = eventAdapter
    }

    private fun renderState(state: EventState?) {
        when (state) {
            is EventState.Success -> {
                eventAdapter.submitList(state.events)
            }
            is EventState.Error -> {
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
            }
            is EventState.DataFetched -> {
            }
            is EventState.Loading -> {
            }
        }
    }
}