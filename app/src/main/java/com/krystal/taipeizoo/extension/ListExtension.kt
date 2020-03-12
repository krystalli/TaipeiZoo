package com.krystal.taipeizoo.extension

fun <T> List<T>.plusIfValid(item: T, isValid: Boolean?): List<T> {
    if (isValid == true) {
        return this.plus(item)
    }

    return this
}

fun <T> List<T>.plusIfValid(items: List<T>, isValid: Boolean?): List<T> {
    if (isValid == true) {
        return this.plus(items)
    }

    return this
}