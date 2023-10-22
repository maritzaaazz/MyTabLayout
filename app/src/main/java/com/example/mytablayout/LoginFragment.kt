package com.example.mytablayout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.mytablayout.databinding.ActivityMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Menginflasi layout fragment_login.xml ke dalam tampilan yang akan digunakan oleh fragment ini.
        val fragmenrInflater = inflater.inflate(R.layout.fragment_login, container, false)

        // Mencari tombol dengan ID "login_btn" dalam tampilan fragment.
        val loginBtn = fragmenrInflater.findViewById<Button>(R.id.login_btn)

        // Mencari elemen EditText dengan ID "tvUsername" dalam tampilan fragment.
        val etUsername = fragmenrInflater.findViewById<EditText>(R.id.tvUsername)

        // Menambahkan penanganan klik ke tombol "login_btn".
        loginBtn.setOnClickListener(){
            // Mengambil teks yang ada di dalam EditText "tvUsername".
            val username = etUsername.text.toString()

            // Membuat objek Intent untuk berpindah ke MainActivity2.
            val intent = Intent(activity, MainActivity2::class.java)

            // Menambahkan data "EXTUSERNAME" ke intent, dengan nilai username sebagai nilai yang akan dikirimkan.
            intent.putExtra("EXTUSERNAME", username)

            // Memulai aktivitas MainActivity2 dengan membawa data yang dikirimkan dalam intent.
            startActivity(intent)
        }
        // Mengembalikan tampilan fragment yang telah disiapkan.
        return fragmenrInflater
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}