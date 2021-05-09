package ru.gladkov.sciencehub.androidApp.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.gladkov.sciencehub.androidApp.R
import ru.gladkov.sciencehub.androidApp.ui.news.NewsFragment
import ru.gladkov.sciencehub.androidApp.ui.routing.Navigator
import ru.gladkov.sciencehub.androidApp.ui.utils.replaceFragment

class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val fragment = supportFragmentManager.findFragmentByTag(
                NewsFragment::class.java.canonicalName
            ) ?: NewsFragment.newInstance()
            replaceFragment(
                fragment,
                R.id.flContainer,
                false,
                NewsFragment::class.java.canonicalName
            )
        }
    }

    override fun navigateTo(fragment: Fragment, addToBackStack: Boolean) {
        replaceFragment(
            fragment,
            R.id.flContainer,
            addToBackStack,
            fragment::class.java.canonicalName
        )
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
