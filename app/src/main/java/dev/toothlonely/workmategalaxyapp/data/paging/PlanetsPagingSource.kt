package dev.toothlonely.workmategalaxyapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.toothlonely.workmategalaxyapp.data.PlanetsRepository
import dev.toothlonely.workmategalaxyapp.domain.Planet

class PlanetsPagingSource(
    private val repo: PlanetsRepository
) : PagingSource<Int, Planet>() {
    override fun getRefreshKey(state: PagingState<Int, Planet>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Planet> {
        return try {
            val page = params.key ?: 1
            val planetsDataSet = repo.getPlanets(page)

            LoadResult.Page(
                data = planetsDataSet,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (planetsDataSet.isEmpty()) null else page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}