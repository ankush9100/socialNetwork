package com.ankush.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ankush.foodapp.fragments.*

import com.iammert.library.readablebottombar.ReadableBottomBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        context = this@MainActivity
        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val searchFra = SearchFragment()
        val postFragment = PostFragment()

        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        readable_tabs.setOnItemSelectListener( object : ReadableBottomBar.ItemSelectListener{

            override fun onItemSelected(index: Int) {
                when(index){
                    0->setCurrentFragment(homeFragment)
                    1->setCurrentFragment(notificationFragment)
                    2->setCurrentFragment(postFragment)
                    3->setCurrentFragment(searchFra)
                    4->setCurrentFragment(profileFragment)


                }

                readable_tabs.selectItem(index)
            }
        })
    }

    private fun setCurrentFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.menu_frag,fragment)
            commit()
        }
    }
}