package com.vmware.bookseat.domain.mapper

import com.plume.common.data.contract.mapper.DataToDomainMapper
import com.vmware.bookseat.data.repository.model.CategoryDataModel
import com.vmware.bookseat.data.repository.model.CategoryDataModel.EXECUTIVE
import com.vmware.bookseat.data.repository.model.CategoryDataModel.NORMAL
import com.vmware.bookseat.data.repository.model.CategoryDataModel.PREMIUM
import com.vmware.bookseat.domain.model.SeatCategory
import javax.inject.Inject

class CategoryDataToDomainMapper @Inject constructor() :
    DataToDomainMapper<CategoryDataModel, SeatCategory>() {
    override fun map(input: CategoryDataModel) = when (input) {
        NORMAL -> SeatCategory.Normal
        EXECUTIVE -> SeatCategory.Executive
        PREMIUM -> SeatCategory.Premium
    }
}
