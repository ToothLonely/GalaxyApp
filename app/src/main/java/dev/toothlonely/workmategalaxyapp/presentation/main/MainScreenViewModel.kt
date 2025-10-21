package dev.toothlonely.workmategalaxyapp.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dev.toothlonely.workmategalaxyapp.data.paging.PlanetsPagingSource
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