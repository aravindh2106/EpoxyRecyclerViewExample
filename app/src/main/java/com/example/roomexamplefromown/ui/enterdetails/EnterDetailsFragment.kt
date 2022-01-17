package com.example.roomexamplefromown.ui.enterdetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomexamplefromown.databinding.FragmentEnterDetailsBinding
import com.example.roomexamplefromown.db.UserDatabase
import com.example.roomexamplefromown.epoxy.UserController
import com.example.roomexamplefromown.model.User
import com.example.roomexamplefromown.repo.Userepository
import com.example.roomexamplefromown.ui.enterdetails.factory.UserFactory


class EnterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentEnterDetailsBinding
    private lateinit var viewModel: EnterDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dao = UserDatabase.getDatabase(requireContext()).userDao()
        val repo = Userepository(dao)
        val factory = UserFactory(repo)
        viewModel =
            ViewModelProvider(this, factory).get(EnterDetailViewModel::class.java)
        binding = FragmentEnterDetailsBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        viewModel.readAllData.observe(viewLifecycleOwner, Observer {
            val controller = UserController(it,{selectedUser:User->listItemClick(selectedUser)})
            binding.recyclerview.setController(controller = controller)
            binding.recyclerview.requestModelBuild()
        })
    }

    private fun listItemClick(user: User) {
        Toast.makeText(requireContext(), "done is ${user.name}", Toast.LENGTH_SHORT).show()
        viewModel.initUpdateAndDelete(user)
    }
}


