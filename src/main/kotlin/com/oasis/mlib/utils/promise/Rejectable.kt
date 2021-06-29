package com.oasis.mlib.utils.promise

interface Rejectable {
    fun reject(reason: Throwable)
}