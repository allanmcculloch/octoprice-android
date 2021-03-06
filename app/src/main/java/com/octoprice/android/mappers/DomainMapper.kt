package com.octoprice.android.mappers

interface DomainMapper <T, DomainModel>{
    fun toDomain(model: T): DomainModel
}