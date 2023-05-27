package com.example.jsonplaceholderworking

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.toSpannable
import androidx.core.view.indices
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsonplaceholderworking.data.User
import com.example.jsonplaceholderworking.databinding.FragmentDetailListeBinding
import com.example.jsonplaceholderworking.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.grpc.NameResolver.Args

@AndroidEntryPoint
class DetailListFragment : Fragment() {
    private lateinit var dataBinding: FragmentDetailListeBinding
    private val args: DetailListFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dataBinding = FragmentDetailListeBinding.inflate(inflater,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.args = args
    }

}