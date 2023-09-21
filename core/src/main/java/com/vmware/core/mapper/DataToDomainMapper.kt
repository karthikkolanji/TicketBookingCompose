package com.plume.common.data.contract.mapper

@Deprecated("Use mapper.toDomain(dataModel)", ReplaceWith("mapper.toDomain(this)"))
fun <INPUT : Any, OUTPUT : Any> INPUT.toDomain(mapper: DataToDomainMapper<INPUT, OUTPUT>) =
    mapper.toDomain(this)

@Deprecated("Use Collection.map(::toDomain)", ReplaceWith("Collection.map(::toDomain)"))
fun <INPUT : Any, OUTPUT : Any> Collection<INPUT>.toDomain(mapper: DataToDomainMapper<INPUT, OUTPUT>) =
    map { it.toDomain(mapper) }
