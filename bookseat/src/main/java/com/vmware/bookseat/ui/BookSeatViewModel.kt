package com.vmware.bookseat.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vmware.bookseat.domain.GetSeatAvailabilityUseCase
import com.vmware.bookseat.ui.mapper.SeatAvailabilityResponseDomainToUiMapper
import com.vmware.bookseat.ui.model.SeatUiModel
import com.vmware.bookseat.ui.state.SeatAvailabilityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BookSeatViewModel @Inject constructor(
    private val getSeatAvailabilityUseCase: GetSeatAvailabilityUseCase,
    private val seatAvailabilityResponseDomainToUiMapper: SeatAvailabilityResponseDomainToUiMapper,
) : ViewModel() {

    private val _seatAvailabilityState = MutableLiveData<SeatAvailabilityState>(
        SeatAvailabilityState.StateLoading,
    )
    val seatAvailabilityState = _seatAvailabilityState

    fun fetchSeatAvailability() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val seatAvailabilityData = getSeatAvailability()
                _seatAvailabilityState.postValue(
                    SeatAvailabilityState.StateSuccess(
                        seatAvailabilityData,
                    ),
                )
            } catch (exception: Exception) {
                _seatAvailabilityState.postValue(
                    SeatAvailabilityState.StateError(exception.localizedMessage),
                )
            }
        }
    }

    private suspend fun getSeatAvailability() = seatAvailabilityResponseDomainToUiMapper.toUi(
        getSeatAvailabilityUseCase.get(),
    )

    fun updateSelectedSeats(seat: SeatUiModel) {
        val currentSeatAvailabilityData =
            seatAvailabilityState.value as? SeatAvailabilityState.StateSuccess
        currentSeatAvailabilityData?.let { successState ->
            val updatedCategoriesSeats = successState.data.categoriesSeats.map { categorySeats ->
                val updatedSeats = categorySeats.seats.map { seatMapEntry ->
                    val seatList = seatMapEntry.value.toMutableList()
                    val indexOfSeat = seatList.indexOfFirst { it.seatId == seat.seatId }
                    if (indexOfSeat != -1) {
                        seatList[indexOfSeat] = seat
                    }
                    seatMapEntry.key to seatList
                }.toMap()
                categorySeats.copy(seats = updatedSeats.toMutableMap())
            }
            val updatedData = successState.data.copy(categoriesSeats = updatedCategoriesSeats)
            Timber.d("updateSelectedSeats called")

            Timber.d("toggleable *** $updatedData")
            _seatAvailabilityState.value = successState.copy(data = updatedData)
        }
    }

//    fun updateSelectedSeats(seat: SeatUiModel) {
//        val currentSeatAvailabilityData =
//            seatAvailabilityState.value as SeatAvailabilityState.StateSuccess
//
//        currentSeatAvailabilityData.let { successState ->
//            val updatedCategoriesSeats = successState.data.categoriesSeats.map { categorySeats ->
//
//                for ((row, list) in categorySeats.seats) {
//                    val updatedSeat = list.find { it.seatId == seat.seatId }
//                    categorySeats.copy(seat=)
//                }
//            }
//            val updatedData = successState.data.copy(categoriesSeats = updatedCategoriesSeats)
//
//            Timber.d("toggleable *** $updatedData")
//            _seatAvailabilityState.value = successState.copy(data = updatedData)
//        }
//    }
}
