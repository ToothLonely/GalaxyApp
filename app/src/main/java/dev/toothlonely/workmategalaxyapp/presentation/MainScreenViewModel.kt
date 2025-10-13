package dev.toothlonely.workmategalaxyapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dev.toothlonely.workmategalaxyapp.data.PlanetsPagingSource
import dev.toothlonely.workmategalaxyapp.data.PlanetsRepository

class MainScreenViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val repo: PlanetsRepository = PlanetsRepository(application)

    val planetsFLow = Pager(
        config = PagingConfig(
            pageSize = 10
        ),
        pagingSourceFactory = {
            PlanetsPagingSource(repo)
        }
    ).flow.cachedIn(viewModelScope)
}