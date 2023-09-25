package com.vmware.bookseat.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vmware.bookseat.domain.GetSeatAvailabilityUseCase
import com.vmware.bookseat.ui.mapper.SeatAvailabilityResponseDomainToUiMapper
import com.vmware.bookseat.ui.model.CategoriesSeatsUiModel
import com.vmware.bookseat.ui.model.SeatStatusUiModel
import com.vmware.bookseat.ui.model.SeatUiModel
import com.vmware.bookseat.ui.state.SeatAvailabilityState
import com.vmware.core.di.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookSeatViewModel @Inject constructor(
    private val getSeatAvailabilityUseCase: GetSeatAvailabilityUseCase,
    private val seatAvailabilityResponseDomainToUiMapper: SeatAvailabilityResponseDomainToUiMapper,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    init {
        fetchSeatAvailability()
    }

    private val _seatAvailabilityState = MutableLiveData<SeatAvailabilityState>(
        SeatAvailabilityState.StateLoading,
    )
    val seatAvailabilityState = _seatAvailabilityState

    private fun fetchSeatAvailability() {
        viewModelScope.launch(dispatcherProvider.main()) {
            SeatAvailabilityState.StateLoading
            try {
                val seatAvailabilityData = getSeatAvailability()
                _seatAvailabilityState.postValue(
                    SeatAvailabilityState.StateSuccess(
                        seatAvailabilityData,
                    ),
                )
            } catch (exception: Exception) {
                _seatAvailabilityState.postValue(
                    exception.localizedMessage?.let { SeatAvailabilityState.StateError(it) },
                )
            }
        }
    }

    private suspend fun getSeatAvailability() = seatAvailabilityResponseDomainToUiMapper.toUi(
        getSeatAvailabilityUseCase.get(),
    )

    fun updateSelectedSeats(seat: SeatUiModel) {
        val currentSeatAvailabilityData =
            seatAvailabilityState.value as SeatAvailabilityState.StateSuccess
        currentSeatAvailabilityData.let { successState ->
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
            _seatAvailabilityState.value = successState.copy(
                data = updatedData.copy(
                    selectedSeats = getTotalSelectedSeats(updatedData.categoriesSeats),
                ),
            )
        }
    }

    private fun getTotalSelectedSeats(categoriesSeats: List<CategoriesSeatsUiModel>): List<SeatUiModel> {
        return categoriesSeats
            .flatMap { it.seats.values.flatten() } // Flatten the seat lists
            .filter { it.status is SeatStatusUiModel.Available.Selected }
    }
}
