package com.example.data_source.data_source.delegate

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


/**
 *
 *
 */
fun SharedPreferences.string(
    defaultValue: String,
    key: String
): ReadWriteProperty<Any, String> = object : ReadWriteProperty<Any, String> {

    /**
     *
     */
    override fun getValue(thisRef: Any, property: KProperty<*>): String =
        getString(key, defaultValue).toString()

    /**
     *
     *
     */
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) =
        edit().putString(key, value).apply()


}
