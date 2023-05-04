package woowacourse.movie.data

import java.io.Serializable

data class TheaterViewData(
    val name: String,
    val movieSchedules: List<MovieScheduleViewData>
) : Serializable {
    companion object {
        const val THEATER_EXTRA_NAME = "theater"
    }
}
