package com.example.jsonplaceholderworking

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonplaceholderworking.data.User
import com.example.jsonplaceholderworking.databinding.FragmentDetailBinding
import com.example.jsonplaceholderworking.databinding.UserLayoutBinding
import com.example.jsonplaceholderworking.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var adapter : UserAdapter
    private lateinit var dataBinding: FragmentDetailBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = FragmentDetailBinding.inflate(inflater,container,false)
        return dataBinding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.apply {
            usersListView.setHasFixedSize(true)
            usersListView.layoutManager = LinearLayoutManager(context)

            adapter = UserAdapter{ user, position ->
                val action = DetailFragmentDirections.listeGo(user)
                view.findNavController().navigate(action)
            }
            usersListView.adapter = adapter
        }

        subScribe()
    }

    private fun subScribe(){
        viewModel.mState.observe(this@DetailFragment, ::handleState)
    }

    private fun handleState(users: List<User>?) {
        adapter.submitList(users)
    }

}



