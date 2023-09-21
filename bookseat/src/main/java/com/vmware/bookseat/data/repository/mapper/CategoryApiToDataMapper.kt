package com.vmware.bookseat.data.repository.mapper

import com.plume.common.data.contract.mapper.ApiToDataMapper
import com.vmware.bookseat.data.datasource.remote.model.CategoryApiModel
import com.vmware.bookseat.data.datasource.remote.model.CategoryApiModel.EXECUTIVE
import com.vmware.bookseat.data.datasource.remote.model.CategoryApiModel.NORMAL
import com.vmware.bookseat.data.datasource.remote.model.CategoryApiModel.PREMIUM
import com.vmware.bookseat.data.repository.model.CategoryDataModel
import javax.inject.Inject

class CategoryApiToDataMapper @Inject constructor() :
    ApiToDataMapper<CategoryApiModel, CategoryDataModel>() {
    override fun map(input: CategoryApiModel) = when (input) {
        NORMAL -> CategoryDataModel.NORMAL
        EXECUTIVE -> CategoryDataModel.EXECUTIVE
        PREMIUM -> CategoryDataModel.PREMIUM
    }
}
