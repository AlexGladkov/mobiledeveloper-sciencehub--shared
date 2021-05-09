package ru.gladkov.sciencehub.androidApp.ui.routing

import androidx.fragment.app.Fragment

interface Navigator {
    fun navigateTo(fragment: Fragment, addToBackStack: Boolean)
}