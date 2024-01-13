package com.islamzada.firebaseregister.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.islamzada.firebaseregister.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater)

        val currentUser = FirebaseAuth.getInstance().currentUser

        binding.textViewAccount.text = currentUser?.email.toString()

        binding.buttonEXT.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            val action = MainFragmentDirections.mainToLogin()
            findNavController().navigate(action)

        }


        return binding.root
    }

}