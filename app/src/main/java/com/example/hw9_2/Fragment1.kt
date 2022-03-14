package com.example.hw9_2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.hw9_2.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    var gender = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment1Binding.inflate(inflater, container, false)

        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initView()


    }


    private fun initView() {
        binding.register.setOnClickListener {

            if (binding.editTextFullName.text.isBlank())
                binding.editTextFullName.error = "نام را وارد کنید"
            else if (binding.editTextUserName.text.isBlank())
                binding.editTextUserName.error = "نام کاربری را وارد کنید"
            else if (binding.editTextEmailAddress.text.isBlank())
                binding.editTextEmailAddress.error = "ایمیل را وارد کنید"
            else if (binding.editTextPassword.text.isBlank())
                binding.editTextPassword.error = "پسورد را وارد کنید"
            else if (binding.editTextPassword.text.toString() != binding.editTextReTypePassword.text.toString()) {
                binding.editTextReTypePassword.error = "پسوردهای وارد شده یکی نیستند"
            } else if (!binding.Female.isChecked && !binding.Male.isChecked) {
                binding.Male.error = "یک گزینه را انتخاب کنید"
            } else {
                if (binding.Female.isChecked) {
                    gender = "Female"
                } else if (binding.Male.isChecked) {
                    gender = "Male"
                }

                goToFragment2()
            }
        }
    }

    private fun goToFragment2() {
        val fullName = binding.editTextFullName.text.toString()
        val userName = binding.editTextUserName.text.toString()
        val email = binding.editTextEmailAddress.text.toString()
        val password = binding.editTextPassword.text.toString()

        val action = Fragment1Directions.actionFragment1ToFragment2(fullName, userName, email, password, gender)
        findNavController().navigate(action)


      /*  val bundle = bundleOf(
            "fullName" to fullName, "userName" to userName,
            "email" to email, "password" to password, "gender" to gender)
        findNavController().navigate(R.id.action_fragment1_to_fragment2, bundle)

       */

    }


}