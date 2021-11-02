package com.example.data_source.data_source.delegate

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 *
 */
fun SharedPreferences.boolean(
    defaultValue: Boolean,
    key: String
): ReadWriteProperty<Any, Boolean> = object : ReadWriteProperty<Any, Boolean> {

    /**
     *
     * @param thisRef
     * @param property
     */
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean =
        getBoolean(key, defaultValue)

    /**
     *
     * @param thisRef
     * @param property
     * @param value
     */
    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) =
        edit().putBoolean(key, value).apply()

}