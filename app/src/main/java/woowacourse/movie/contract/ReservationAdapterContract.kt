package woowacourse.movie.contract

import woowacourse.movie.data.ReservationsViewData
import woowacourse.movie.domain.Reservation

interface ReservationAdapterContract {
    interface View {
        val presenter: Presenter
        fun setAdapterData(reservations: ReservationsViewData)
    }

    interface Presenter {
        val view: View
        fun requestReservationData(): List<Reservation>
        fun setReservation()
    }
}
