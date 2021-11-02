package com.example.data_source.data_source.extension

/* */
val String.Companion.empty: String get() = ""

/* */
val String.valueOrNullIfBlank: String?
    get() = if (this.isBlank()) null else this
