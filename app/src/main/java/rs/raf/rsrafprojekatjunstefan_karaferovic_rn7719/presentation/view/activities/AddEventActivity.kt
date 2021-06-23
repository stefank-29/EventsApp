package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.activities

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.R
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.databinding.ActivityAddEventBinding
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.contract.MainContract
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.viewmodel.MainViewModel
import java.text.SimpleDateFormat
import java.util.*


class AddEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddEventBinding
    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init() {
        initView()
        initListeners()
        initSpinner()
    }


    private fun initView() {

        val cities = resources.getStringArray(R.array.cities)

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, cities)

        binding.autoComplete.setAdapter(adapter)

        // date picker
        val cal = Calendar.getInstance()

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd.MM.yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                binding.setDate.text = sdf.format(cal.time)

            }

        val timeSetListener =
            TimePickerDialog.OnTimeSetListener { timePicker,
                                                 hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                val sdf = SimpleDateFormat("HH:mm").format(cal.time)
                binding.setTime.text = sdf.format(cal.time)
            }


        binding.setDate.setOnClickListener {
            DatePickerDialog(
                this@AddEventActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        binding.setTime.setOnClickListener {
            TimePickerDialog(
                this@AddEventActivity, timeSetListener,
                cal.get(Calendar.HOUR),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }
    }


    private fun initSpinner() {
        val dataAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.priorities,
            android.R.layout.simple_spinner_item
        )
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.priority.setAdapter(dataAdapter)
    }

    private fun initListeners() {
        binding.saveBtn.setOnClickListener {
            val type = binding.priority.selectedItem.toString()
            val name = binding.nameEt.text.toString()
            val desc = binding.descEt.text.toString()
            val date = binding.setDate.text.toString()
            val time = binding.setTime.text.toString()
            val url = binding.urlEt.text.toString()

            mainViewModel.saveEvent(name, desc, date, time, type, url)

            finish()

            Toast.makeText(
                this,
                "Event saved",
                Toast.LENGTH_LONG
            ).show()

        }

    }
}