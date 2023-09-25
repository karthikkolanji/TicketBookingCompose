package com.vmware.bookseat.domain.mapper

import com.google.common.truth.Truth
import com.vmware.bookseat.data.repository.model.StatusDataModel
import com.vmware.bookseat.domain.model.SeatStatus
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class StatusDataToDomainMapperTest(
    private val input: StatusDataModel,
    private val expectedResult: SeatStatus,
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} When toLocalDataSource Then returns {1}")
        fun getParameters() =
            listOf(
                arrayOf(
                    StatusDataModel.AVAILABLE,
                    SeatStatus.Available,
                ),
                arrayOf(
                    StatusDataModel.BOOKED,
                    SeatStatus.Booked,
                ),
            )
    }

    private lateinit var classUnderTest: StatusDataToDomainMapper

    @Before
    fun setup() {
        classUnderTest = StatusDataToDomainMapper()
    }

    @Test
    fun `Given TransactionRequestDataModel When toLocalDataSource Then returns MyAccount`() {
        // When
        val actualResult = classUnderTest.toDomain(input)

        // Then
        Truth.assertThat(expectedResult).isEqualTo(actualResult)
    }
}
