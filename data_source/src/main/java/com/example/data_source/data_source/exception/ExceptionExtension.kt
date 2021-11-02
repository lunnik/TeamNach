package com.example.data_source.data_source.exception

/* */
val Exception.tag: String get() = javaClass.simpleName

/**
 *
 */
fun Exception.message(): String = message ?: tag
