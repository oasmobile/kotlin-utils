@file:Suppress("unused")

package com.oasis.mlib.utils.exceptions

class InvalidDataTypeException(message: String = "") : Throwable(message) {
    var fieldName = ""
}