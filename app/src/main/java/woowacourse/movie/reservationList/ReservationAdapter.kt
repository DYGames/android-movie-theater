package woowacourse.movie.reservationList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import woowacourse.movie.R
import woowacourse.movie.common.database.MovieDao
import woowacourse.movie.common.model.ReservationViewData
import woowacourse.movie.common.model.ReservationsViewData

class ReservationAdapter(
    movieDao: MovieDao,
    private val onClickItem: (ReservationViewData) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(), ReservationAdapterContract.View {
    private var reservationsViewData: ReservationsViewData = ReservationsViewData(emptyList())
    override val presenter: ReservationAdapterContract.Presenter = ReservationAdapterPresenter(this, movieDao)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReservationViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_reservation, parent, false
            )
        ) { onClickItem(reservationsViewData.value[it]) }
    }

    override fun getItemCount(): Int = reservationsViewData.value.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ReservationViewHolder).bind(reservationsViewData.value[position])
    }

    override fun setAdapterData(reservations: ReservationsViewData) {
        reservationsViewData = reservations
        notifyDataSetChanged()
    }
}