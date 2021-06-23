package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.databinding.ActivityMainBinding
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.contract.MainContract
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.viewmodel.MainViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val mainViewModel: MainContract.ViewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }


    private fun init() {
        initView()
        initListeners()
    }


    private fun initView() {

    }

    private fun initListeners() {
        binding.addBtn.setOnClickListener {
            val intent = Intent(this, AddEventActivity::class.java)
            startActivity(intent)
        }

        binding.showBtn.setOnClickListener {
            val intent = Intent(this, ShowActivitiesActivity::class.java)
            startActivity(intent)
        }

    }


}