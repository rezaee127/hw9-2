package com.example.hw9_2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hw9_2.databinding.Fragment2Binding


class Fragment2 : Fragment() {
    private val args: Fragment2Args by navArgs()

    lateinit var  binding : Fragment2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = Fragment2Binding.inflate (inflater, container, false)

        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

        val fullName=args.fullName
        val userName=args.userName
        val email=args.email
        val password=args.password
        val gender=args.gender

        binding.textViewFullName.text=fullName
        binding.textViewUserName.text=userName
        binding.textViewEmail.text=email
        binding.textViewPassword.text=password
        binding.textViewGender.text=gender

        binding.buttonSave.setOnClickListener {
            val pref = activity?.getSharedPreferences("share", Context.MODE_PRIVATE)
            val edit = pref?.edit()
            edit?.putString("FullName", fullName)
            edit?.putString("UserName", userName)
            edit?.putString("Email", email)
            edit?.putString("Password", password)
            edit?.putString("Gender", gender)
            edit?.apply()
            Toast.makeText(activity, "ذخیره اطلاعات انجام شد", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }

    }

}