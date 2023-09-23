package com.vmware.bookseat.domain.mapper

import com.vmware.bookseat.data.repository.model.StatusDataModel
import com.vmware.bookseat.data.repository.model.StatusDataModel.AVAILABLE
import com.vmware.bookseat.data.repository.model.StatusDataModel.BOOKED
import com.vmware.bookseat.domain.model.SeatStatus
import com.vmware.bookseat.domain.model.SeatStatus.Available
import com.vmware.bookseat.domain.model.SeatStatus.Booked
import com.vmware.core.mapper.DataToDomainMapper
import javax.inject.Inject

class StatusDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<StatusDataModel, SeatStatus>() {
    override fun map(input: StatusDataModel) = when (input) {
        AVAILABLE -> Available
        BOOKED -> Booked
    }
}
