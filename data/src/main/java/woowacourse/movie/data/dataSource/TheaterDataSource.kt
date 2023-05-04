package woowacourse.movie.data.dataSource

import woowacourse.movie.domain.Movie
import woowacourse.movie.domain.MovieSchedule
import woowacourse.movie.domain.Theater
import java.time.LocalTime

class TheaterDataSource(movies: List<Movie>) : DataSource<Theater> {
    override val value: List<Theater> = listOf(
        Theater(
            "선릉 극장",
            listOf(
                MovieSchedule(
                    movies[0],
                    listOf(
                        LocalTime.of(10, 0),
                        LocalTime.of(12, 0),
                        LocalTime.of(14, 0),
                    )
                ),
                MovieSchedule(
                    movies[1],
                    listOf(
                        LocalTime.of(12, 0),
                        LocalTime.of(14, 0),
                        LocalTime.of(16, 0),
                    )
                )
            )
        ),
        Theater(
            "잠실 극장",
            listOf(
                MovieSchedule(
                    movies[0],
                    listOf(
                        LocalTime.of(8, 0),
                        LocalTime.of(10, 0),
                        LocalTime.of(12, 0),
                    )
                ),
                MovieSchedule(
                    movies[1],
                    listOf(
                        LocalTime.of(14, 0),
                        LocalTime.of(16, 0),
                        LocalTime.of(18, 0),
                    )
                ),
                MovieSchedule(
                    movies[2],
                    listOf(
                        LocalTime.of(10, 0),
                        LocalTime.of(12, 0),
                        LocalTime.of(14, 0),
                    )
                )
            )
        )
    )

    override fun add(t: Theater) {
    }
}