package com.vmware.bookseat.data.repository.mapper

import com.vmware.core.mapper.ApiToDataMapper
import com.vmware.bookseat.data.datasource.remote.model.StatusApiModel
import com.vmware.bookseat.data.datasource.remote.model.StatusApiModel.AVAILABLE
import com.vmware.bookseat.data.datasource.remote.model.StatusApiModel.BOOKED
import com.vmware.bookseat.data.repository.model.StatusDataModel
import javax.inject.Inject

class StatusApiToDataMapper @Inject constructor() :
    ApiToDataMapper<StatusApiModel, StatusDataModel>() {
    override fun map(input: StatusApiModel) = when (input) {
        AVAILABLE -> StatusDataModel.AVAILABLE
        BOOKED -> StatusDataModel.BOOKED
    }
}
