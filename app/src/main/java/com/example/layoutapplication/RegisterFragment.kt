package com.example.layoutapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class RegisterFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    //dipanggil ketika fragment ini dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mengambil argumen yang mungkin diteruskan saat membuat instance fragment
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    //dipanggil saat fragment perlu menginisialisasi tampilan antarmuka pengguna
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // menghubungkan tata letak xml dengan fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    //metode statis yang digunakan untuk membuat instance baru dari RegisterFragment
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    //menyimpan parameter 1
                    putString(ARG_PARAM1, param1)
                    //menyimpan parameter 2
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}