package rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.datasources.local.EventDataBase
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.repositories.EventRepository
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.data.repositories.EventRepositoryImpl
import rs.raf.rsrafprojekatjunstefan_karaferovic_rn7719.presentation.viewmodel.MainViewModel

val eventModule = module {

    viewModel { MainViewModel(eventRepository = get()) }

    single<EventRepository> {
        EventRepositoryImpl(
            localDataSource = get()
        )
    }

    // Dao
    single { get<EventDataBase>().getEventDao() }

    // Service

}