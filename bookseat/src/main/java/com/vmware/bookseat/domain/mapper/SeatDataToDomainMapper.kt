package com.vmware.bookseat.domain.mapper

import com.plume.common.data.contract.mapper.DataToDomainMapper
import com.vmware.bookseat.data.repository.model.SeatDataModel
import com.vmware.bookseat.domain.model.SeatDomainModel
import javax.inject.Inject

class SeatDataToDomainMapper @Inject constructor(
    private val categoryDataToDomainMapper: CategoryDataToDomainMapper,
    private val statusDataToDomainMapper: StatusDataToDomainMapper,
) :
    DataToDomainMapper<SeatDataModel, SeatDomainModel>() {
    override fun map(input: SeatDataModel) = SeatDomainModel(
        hold = input.hold,
        price = input.price,
        seatCategory = categoryDataToDomainMapper.toDomain(input.seatCategory),
        seatId = input.seatId,
        seatNumber = input.seatNumber,
        status = statusDataToDomainMapper.toDomain(input.status),
    )
}
