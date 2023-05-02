package woowacourse.movie.presenter

import android.os.Bundle
import woowacourse.movie.contract.MovieReservationContract
import woowacourse.movie.data.MovieViewData
import woowacourse.movie.domain.Count
import woowacourse.movie.domain.ReservationDetail
import woowacourse.movie.mapper.ReservationDetailMapper.toView
import java.time.LocalDateTime

class MovieReservationPresenter(override val view: MovieReservationContract.View) :
    MovieReservationContract.Presenter {
    var peopleCount: Count = Count(PEOPLE_DEFAULT_COUNT)

    override fun addPeopleCount(count: Int) {
        peopleCount += count
        view.setCounterText(peopleCount.value)
    }

    override fun minusPeopleCount(count: Int) {
        peopleCount -= count
        view.setCounterText(peopleCount.value)
    }

    override fun reserveMovie(date: LocalDateTime, movie: MovieViewData) {
        val reservationDetail = ReservationDetail(
            date, peopleCount.value
        ).toView()
        view.startReservationResultActivity(reservationDetail, movie)
    }

    override fun save(outState: Bundle) {
        outState.putInt(PEOPLE_COUNT_SAVE_KEY, peopleCount.value)
    }

    override fun load(savedInstanceState: Bundle?) {
        peopleCount = if (savedInstanceState == null) peopleCount
        else Count(savedInstanceState.getInt(PEOPLE_COUNT_SAVE_KEY))
        view.setCounterText(peopleCount.value)
    }

    companion object {
        private const val PEOPLE_COUNT_SAVE_KEY = "peopleCount"
        private const val PEOPLE_DEFAULT_COUNT = 1
    }
}