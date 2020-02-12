package com.example.nutritionsearchmvvm.data.entities

import kotlin.collections.List

data class List(
    val q: String?,
    val sr: String?,
    val ds: String?,

    val start: String?,

    val end: String?,

    val total: String?,
    val group: String?,
    val sort: String?,

    val item: List<Item>? = listOf()


)
