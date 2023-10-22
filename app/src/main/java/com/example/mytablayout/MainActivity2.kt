package com.example.mytablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mytablayout.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan 'binding' untuk mengatur tampilan dalam aktivitas menggunakan View Binding.
        with(binding) {
            // Mendapatkan intent yang digunakan untuk memulai aktivitas saat ini.
            val intent = intent

            // Mengambil data string yang dikirimkan melalui intent dengan kunci "EXTUSERNAME" (username).
            val username = intent.getStringExtra("EXTUSERNAME")

            // Menampilkan data username di TextView "tvUsername" dalam tampilan.
            tvUsername.text = username
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options2, menu)
        return true
    }

    // Override metode onOptionsItemSelected untuk menangani tindakan saat pengguna memilih opsi menu.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                // Ketika pengguna memilih opsi "action_logout" dari menu...

                // Membuat objek Intent untuk berpindah ke MainActivity (aktivitas login).
                val intent = Intent(this@MainActivity2, MainActivity::class.java)

                // Memulai aktivitas baru (login) dengan intent yang telah dibuat.
                startActivity(intent)

                // Menutup aktivitas MainActivity2 (logout dan kembali ke halaman login).
                finish()

                true // Mengembalikan true untuk menunjukkan bahwa tindakan telah ditangani.
            }

            else -> super.onOptionsItemSelected(item)
            // Jika pengguna memilih opsi menu lainnya, panggil metode onOptionsItemSelected dari kelas induk.
        }
    }
}