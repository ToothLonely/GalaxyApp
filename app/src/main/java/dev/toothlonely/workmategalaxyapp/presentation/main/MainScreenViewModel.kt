package dev.toothlonely.workmategalaxyapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dev.toothlonely.workmategalaxyapp.data.paging.PlanetsPagingSource
import dev.toothlonely.workmategalaxyapp.data.PlanetsRepository

class MainScreenViewModel(
    private val repo: PlanetsRepository,
) : ViewModel() {
    val planetsFLow = Pager(
        config = PagingConfig(
            pageSize = 10
        ),
        pagingSourceFactory = {
            PlanetsPagingSource(repo)
        }
    ).flow.cachedIn(viewModelScope)
}