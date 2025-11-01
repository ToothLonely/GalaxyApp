package dev.toothlonely.workmategalaxyapp.data.di

import dev.toothlonely.workmategalaxyapp.data.PlanetsRepository
import dev.toothlonely.workmategalaxyapp.data.paging.PlanetsPagingSource
import dev.toothlonely.workmategalaxyapp.presentation.main.MainScreenViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::PlanetsRepository)
    viewModelOf(::MainScreenViewModel)
    singleOf(::PlanetsPagingSource)
}