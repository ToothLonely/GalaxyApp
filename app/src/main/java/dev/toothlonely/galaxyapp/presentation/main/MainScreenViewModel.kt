package dev.toothlonely.galaxyapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dev.toothlonely.galaxyapp.data.paging.PlanetsPagingSource
import dev.toothlonely.galaxyapp.data.PlanetsRepository

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