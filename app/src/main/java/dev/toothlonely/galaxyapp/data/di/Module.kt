package dev.toothlonely.galaxyapp.data.di

import dev.toothlonely.galaxyapp.data.PlanetsRepository
import dev.toothlonely.galaxyapp.data.paging.PlanetsPagingSource
import dev.toothlonely.galaxyapp.presentation.main.MainScreenViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::PlanetsRepository)
    viewModelOf(::MainScreenViewModel)
    singleOf(::PlanetsPagingSource)
}