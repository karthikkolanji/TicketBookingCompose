package com.vmware.bookseat.ui.state

import com.vmware.bookseat.ui.model.SeatAvailabilityResponseUiModel
import com.vmware.core.utils.ApiError

sealed class SeatAvailabilityState {
    data class StateSuccess(val data: SeatAvailabilityResponseUiModel) : SeatAvailabilityState()
    data class StateError(val error: String) : SeatAvailabilityState()
    data object StateLoading : SeatAvailabilityState()
}
