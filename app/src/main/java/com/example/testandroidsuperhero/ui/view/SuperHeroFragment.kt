package com.example.testandroidsuperhero.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroidsuperhero.adapter.SuperHeroAdapter
import com.example.testandroidsuperhero.databinding.FragmentSuperHeroBinding
import com.example.testandroidsuperhero.data.model.SuperHero
import com.example.testandroidsuperhero.ui.viewmodel.SuperHeroViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class SuperHeroFragment : Fragment() {
    //ViewBinding
    private var _binding: FragmentSuperHeroBinding?= null
    private val binding get() = _binding!!

    //VieModel Fragment
    private val superHeroViewModel: SuperHeroViewModel by viewModels()

    //List && Adapter
    private var superHeroMutableList = mutableListOf<SuperHero>()
    private lateinit var adapter: SuperHeroAdapter

    //private val manager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSuperHeroBinding.inflate(inflater, container, false)
        initRecyclerView()
        observeData()
        message()
        isLoadingData()


        return binding.root
    }

    // References to the instance are deleted
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isLoadingData(){
        superHeroViewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
    }

    private fun initRecyclerView() {
        adapter = SuperHeroAdapter(
            superHeroList = superHeroMutableList,
            onClickListener = { superHero -> onItemSelected(superHero) }
        )
        //Asignamos el adapter al nuevo adapter del recyclerView
        binding.recyclerSuperHero.layoutManager = LinearLayoutManager(context)
        binding.recyclerSuperHero.adapter = adapter
    }

    private fun observeData(){
        superHeroViewModel.fetchSuperHeroData().observe(viewLifecycleOwner) {
            adapter.setListData(it)
            adapter.notifyItemChanged(it.size)
        }
    }

    //Accedemos al item seleccionado
    private fun onItemSelected(superHero: SuperHero) {
        findNavController().navigate(SuperHeroFragmentDirections.actionSuperHeroFragmentToSuperHeroInfoFragment(superHero.id))
    }

    private fun message() {
        superHeroViewModel.message.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        })
    }

}