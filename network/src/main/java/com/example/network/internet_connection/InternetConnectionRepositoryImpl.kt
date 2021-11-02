package com.example.network.internet_connection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject


/**
 *
 */
class InternetConnectionRepositoryImpl() : InternetConnectionRepository, KoinComponent {

    /* */
    private val context: Context by inject()

    /* */
    private var _isOnline: Boolean = false
    override val isOnline: Boolean get() = _isOnline

    /* */
    private var _isOnlineLiveData = MutableLiveData<Boolean>()
    override val isOnlineLiveData: LiveData<Boolean> get() = _isOnlineLiveData

    /**
     *
     */
    override suspend fun fetch() {
        _isOnline = try {
            haveNetworkConnection()
        } catch (exception: Exception) {
            false
        }
        _isOnlineLiveData.postValue(_isOnline)
    }

    /** */
    private fun haveNetworkConnection(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }

}
