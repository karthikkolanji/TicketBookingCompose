package com.plume.common.data.contract.mapper

fun <INPUT : Any, OUTPUT : Any> INPUT.toApi(mapper: DataToApiMapper<INPUT, OUTPUT>) =
    mapper.toApi(this)

fun <INPUT : Any, OUTPUT : Any> Collection<INPUT>.toApi(mapper: DataToApiMapper<INPUT, OUTPUT>) =
    map { it.toApi(mapper) }
