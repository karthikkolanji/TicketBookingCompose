package com.vmware.core.mapper

class ApiMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

class DataMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

class DomainMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

class UiMapperException(message: String, throwable: Throwable?) : Exception(message, throwable)


abstract class ApiToDataMapper<INPUT : Any, OUTPUT : Any> {
    fun toData(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName} to Data", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DataToDomainMapper<INPUT : Any, OUTPUT : Any> {
    fun toDomain(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DomainMapperException("Could not map ${input::class.simpleName} to Domain", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DomainToUiMapper<INPUT : Any, OUTPUT : Any> {
    fun toUi(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw UiMapperException(
            "Could not map ${input::class.simpleName}",
            throwable
        )
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

