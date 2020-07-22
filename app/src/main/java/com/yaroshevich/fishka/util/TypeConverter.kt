package com.yaroshevich.fishka.util

interface TypeConverter<S, D> {

    fun convert(source: S): D
    fun reverse(source: D): S

}


abstract class ListTypeConverter<S,D>: TypeConverter<S,D> {


    fun convert(source: List<S>): List<D>{
        val destinationList = mutableListOf<D>()
        source.forEach {
            val destination = convert(it)
            destinationList.add(destination)
        }

        return destinationList
    }

    fun reverse(source: List<D>): List<S>{
        val destinationList = mutableListOf<S>()
        source.forEach {
            val destination = reverse(it)
            destinationList.add(destination)
        }

        return destinationList
    }
}