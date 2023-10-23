package com.example.layoutapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    //parameter 1
    private var param1: String? = null
    //parameter 2
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //untuk mengambil nilai dari parameter 1
            param1 = it.getString(ARG_PARAM1)
            //untuk mengambil nilai dari parameter 2
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // menghubungkan tata letak xml dengan fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    companion object {
        const val EXTRA_NAME = "com.example.layoutapplication.EXTRA_NAME"
        fun newInstance () = LoginFragment()
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    //menyimpan parameter 1
                    putString(ARG_PARAM1, param1)
                    //menyimpan parameter 2
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //kelas TabAdapter (adalah sub-class dari FrafmentPagerAdapter)
    class TabAdapter(fm: FragmentManager) : FragmentPagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
        override fun getCount(): Int {
            //mengembalikan jumlah halaman /tab
            return 2
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                //membuat instance dari LoginFragment
                0 -> LoginFragment.newInstance()
                //membuat instance daari RegisterFragment
                1 -> RegisterFragment.newInstance("", "")
                else -> throw IllegalArgumentException("Invalid coy")
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Login" //judul untuk halaman awal (0)
                1 -> "Register"//judul untuk halaman tab (1)
                else -> null
            }
        }
    }

    //kelas LoginFragment (adalah subkelas dari Fragment)
    class LoginFragment : Fragment() {
        private lateinit var inputusername: EditText
        private lateinit var inputpassword: EditText
        private lateinit var tombolLogin: Button

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            //menghubungkan tata letak xml dengan fragment
            val view = inflater.inflate(R.layout.fragment_login, container, false)
            //mendapatkan referensi EditText
            inputusername = view.findViewById(R.id.usernamelogin)
            //mendapatkan referensi EditText
            inputpassword = view.findViewById(R.id.passwordlogin)
            //mendapatkan referensi button
            tombolLogin = view.findViewById(R.id.login)

            tombolLogin.setOnClickListener {
                //mengambil teks dari EditText inputusername
                val unname = inputusername.text.toString()
                //mengambil teks dari EditText inputpassword
                val ppasword = inputpassword.text.toString()

                if (unname == "istrihanbin" && ppasword == "siapjadimantu") {
                    //menampilkan pesan sukses
                    Toast.makeText(context, "yak tul", Toast.LENGTH_SHORT).show()
                    //membuat intent untuk berpindah ke DashboardActivity
                    val intent = Intent(context, DashboardActivity::class.java)
                    //memulai aktivitas baru
                    startActivity(intent)
                } else {
                    //menampilkan pesan gagal
                    Toast.makeText(context, "yak nt bang", Toast.LENGTH_SHORT).show()
                }
            }
            return view
        }
        companion object {
            @JvmStatic
            //membuat instance dari LoginFragment
            fun newInstance () = LoginFragment()
        }
    }
}

