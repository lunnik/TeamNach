package com.example.grueponach.presentation.common.extension

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

/** */
fun Fragment.showSnackbar(@StringRes messageRes: Int, duration: Int = Snackbar.LENGTH_LONG) {
	Snackbar.make(view ?: return, messageRes, duration).apply {
		val textView = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
		textView.isSingleLine = false
		show()
	}
}

/** */
fun Fragment.showSnackbar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
	Snackbar.make(view ?: return, message, duration).apply {
		val textView = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
		textView.isSingleLine = false
		show()
	}
}