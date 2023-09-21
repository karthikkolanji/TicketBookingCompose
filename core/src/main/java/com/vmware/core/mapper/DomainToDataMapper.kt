package com.plume.common.data.contract.mapper

fun <INPUT : Any, OUTPUT : Any> INPUT.toData(mapper: DomainToDataMapper<INPUT, OUTPUT>) =
    mapper.toData(this)

fun <INPUT : Any, OUTPUT : Any> Collection<INPUT>.toData(mapper: DomainToDataMapper<INPUT, OUTPUT>) =
    map { it.toData(mapper) }
