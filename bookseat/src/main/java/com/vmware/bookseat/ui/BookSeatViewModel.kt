package com.vmware.bookseat.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vmware.bookseat.domain.GetSeatAvailabilityUseCase
import com.vmware.bookseat.ui.mapper.SeatAvailabilityResponseDomainToUiMapper
import com.vmware.bookseat.ui.state.SeatAvailabilityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    suspend fun getSeatAvailability() = seatAvailabilityResponseDomainToUiMapper.toUi(
        getSeatAvailabilityUseCase.get(),
    )
}

//    suspend fun getSeatAvailability() = liveData {
//        emit(UiState.Loading)
//        try {
//            emit(
//                UiState.Success(
//                    seatAvailabilityResponseDomainToUiMapper.toUi(
//                        getSeatAvailabilityUseCase.get(),
//                    ),
//                ),
//            )
//        } catch (exception: Exception) {
//            emit(UiState.Error(ApiError.resolveError(exception)))
//        }
//    }
