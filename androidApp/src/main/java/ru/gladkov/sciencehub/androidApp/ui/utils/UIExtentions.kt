package ru.gladkov.sciencehub.androidApp.ui.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(message: String, duration: Int = LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

fun AppCompatActivity.replaceFragment(
    fragment: Fragment, @IdRes frameId: Int,
    addToback: Boolean = false,
    tag: String? = null,
    onLoadFunc: () -> Unit? = {}
) {
    val tg = tag ?: fragment.javaClass.canonicalName
    supportFragmentManager.transact {
        replace(frameId, fragment, tg)
        if (addToback) {
            addToBackStack(tag)
        }
    }
    onLoadFunc()
}

inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply { action() }.commit()
}
