package com.example.data_source.data_source.delegate

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.Serializable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 */
inline fun <reified T: Serializable> SharedPreferences.serializable(
    defaultValue: T? = null,
    key: String
): ReadWriteProperty<Any, T?> = object : ReadWriteProperty<Any, T?> {

    /* */
    private val adapter =
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(T::class.java)

    /**
     *
     */
    override fun getValue(thisRef: Any, property: KProperty<*>): T? {
        val savedValue = getString(key, null)
        return if(savedValue == null)
            defaultValue
        else adapter.fromJson(savedValue)
    }

    /**
     *
     */
    override fun setValue(thisRef: Any, property: KProperty<*>, value: T?) {
        val valueToSave: String? = if(value == null) null else adapter.toJson(value)
        edit().putString(key, valueToSave).apply()
    }

}
