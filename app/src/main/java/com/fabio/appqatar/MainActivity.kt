package com.fabio.appqatar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabio.appqatar.databinding.ActivityMainBinding
import com.fabio.appqatar.fragments.EquiposFragment
import com.fabio.appqatar.fragments.ExtraFragment
import com.fabio.appqatar.fragments.FixtureFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var equipoFragment: EquiposFragment
    lateinit var extraFragment: ExtraFragment
    lateinit var fixtureFragment: FixtureFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        equipoFragment = EquiposFragment()
        extraFragment = ExtraFragment()
        fixtureFragment = FixtureFragment()

        showFragment(equipoFragment)

        binding.bnvMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menuHome -> showFragment(equipoFragment)
                R.id.menuFix -> showFragment(fixtureFragment)
                R.id.menuExtra -> showFragment(extraFragment)
            }
            return@setOnItemSelectedListener true
        }

    }
    fun showFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameContent, frag).commit()
    }

}