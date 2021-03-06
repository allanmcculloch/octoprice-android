package com.octoprice.android.network.model.product

data class ProductResponse(
    val available_from: String,
    val available_to: String?,
    val brand: String?,
    val code: String,
    val description: String?,
    val direction: String?,
    val display_name: String?,
    val full_name: String?,
    val is_business: Boolean,
    val is_green: Boolean,
    val is_prepay: Boolean,
    val is_restricted: Boolean,
    val is_tracker: Boolean,
    val is_variable: Boolean,
    val sample_consumption: SampleConsumption?,
    val tariffs_active_at: String?,
    val links: List<Link>?,
    val term: Int?
)