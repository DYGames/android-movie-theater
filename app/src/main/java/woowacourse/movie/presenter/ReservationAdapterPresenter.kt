package woowacourse.movie.presenter

import woowacourse.movie.contract.ReservationAdapterContract
import woowacourse.movie.data.ReservationsViewData
import woowacourse.movie.data.repository.ReservationRepository
import woowacourse.movie.domain.Reservation
import woowacourse.movie.mapper.ReservationMapper.toView

class ReservationAdapterPresenter(
    override val view: ReservationAdapterContract.View,
    private val reservationRepository: ReservationRepository = ReservationRepository()
) : ReservationAdapterContract.Presenter {
    override fun setReservation() {
        val reservations = makeReservationListViewData(
            requestReservationData()
        )
        view.setAdapterData(reservations)
    }

    private fun requestReservationData(): List<Reservation> =
        reservationRepository.requestReservation()

    private fun makeReservationListViewData(reservations: List<Reservation>): ReservationsViewData {
        val reservations = reservations.map { it.toView() }
        return ReservationsViewData(reservations)
    }
}
