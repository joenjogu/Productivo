package com.joenjogu.productivo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment(WorkFragment())

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.work_menu -> {
                    displayFragment(WorkFragment())
                    true
                }
                R.id.tasks_menu -> {
                    displayFragment(TaskFragment())
                    true
                }
                R.id.stats_menu -> {
                    displayFragment(StatsFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun displayFragment(fragment : Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}