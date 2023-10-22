package com.example.mytablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.mytablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan 'binding' untuk mengatur tampilan dalam aktivitas menggunakan View Binding.
        with(binding){
            // Mengatur adapter untuk viewPager dengan menggunakan TabAdapter yang telah dibuat sebelumnya.
            viewPager.adapter = TabAdapter(this@MainActivity)
            // Menghubungkan TabLayout dengan viewPager menggunakan TabLayoutMediator.
            TabLayoutMediator(tabLayout,viewPager) { tab, position ->
                // Menentukan teks yang akan ditampilkan pada setiap tab berdasarkan posisi.
                tab.text = when (position) {
                    0 -> "Register"    // Tab pertama dengan teks "Register".
                    1 -> "Login"       // Tab kedua dengan teks "Login".
                    else -> ""         // Jika posisi lainnya, tidak menampilkan teks.
                }
            }.attach() // Melampirkan mediator TabLayout ke viewPager.

        }
    }


    // Override metode onCreateOptionsMenu untuk menambahkan menu ke aktivitas.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Menginflasi menu_options.xml ke dalam menu aktivitas.
        menuInflater.inflate(R.menu.menu_options, menu)
        return true     // Mengembalikan true untuk menunjukkan bahwa menu telah dibuat.

    }

}