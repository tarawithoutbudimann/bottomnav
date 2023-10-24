package com.example.bottomnavbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate (layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomnav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_nav -> replaceFragment(HomeFragment())
                R.id.profile_nav -> replaceFragment(ProfileFragment())
                R.id.notif_nav -> replaceFragment(NotificationFragment())
                else ->{}
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()
    }
}