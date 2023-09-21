package com.vmware.bookseat.data.repository.mapper

import com.plume.common.data.contract.mapper.ApiToDataMapper
import com.vmware.bookseat.data.datasource.remote.model.SeatApiModel
import com.vmware.bookseat.data.repository.model.SeatDataModel
import javax.inject.Inject

class SeatApiToDataMapper @Inject constructor(
    private val categoryApiToDataMapper: CategoryApiToDataMapper,
    private val statusApiToDataMapper: StatusApiToDataMapper,
) :
    ApiToDataMapper<SeatApiModel, SeatDataModel>() {
    override fun map(input: SeatApiModel) = SeatDataModel(
        hold = input.hold,
        price = input.price,
        seatCategory = categoryApiToDataMapper.toData(input.seatCategory),
        seatId = input.seatId,
        seatNumber = input.seatNumber,
        status = statusApiToDataMapper.toData(input.status),
    )
}
