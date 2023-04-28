package woowacourse.movie.view.widget

import android.os.Bundle
import woowacourse.movie.domain.movieTimePolicy.MovieTime
import woowacourse.movie.domain.movieTimePolicy.WeekdayMovieTimePolicy
import woowacourse.movie.domain.movieTimePolicy.WeekendMovieTimePolicy
import woowacourse.movie.view.data.LocalFormattedTime
import java.time.LocalDate

class TimeSpinner(val spinner: SaveStateSpinner) {
    fun make(savedInstanceState: Bundle?, date: LocalDate) {
        val times = MovieTime(
            listOf(WeekdayMovieTimePolicy, WeekendMovieTimePolicy)
        ).determine(date).map { LocalFormattedTime(it) }
        spinner.initSpinner(times)
        spinner.load(savedInstanceState)
    }

    fun save(savedInstanceState: Bundle) {
        spinner.save(savedInstanceState)
    }
}
