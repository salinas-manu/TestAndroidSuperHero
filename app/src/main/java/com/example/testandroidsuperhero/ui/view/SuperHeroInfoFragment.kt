package com.example.testandroidsuperhero.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.testandroidsuperhero.R
import com.example.testandroidsuperhero.databinding.FragmentSuperHeroInfoBinding
import com.example.testandroidsuperhero.ui.viewmodel.SuperHeroInfoViewModel

class SuperHeroInfoFragment : Fragment() {
    private val args: SuperHeroInfoFragmentArgs by navArgs()
    private var _binding: FragmentSuperHeroInfoBinding?= null
    private val superHeroInfoViewModel: SuperHeroInfoViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperHeroInfoBinding.inflate(inflater, container, false)

        observeSuperHeroInfo()
        message()
        // Inflate the layout for this fragment
        return binding.root
    }

    // References to the instance are deleted
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeSuperHeroInfo(){
        superHeroInfoViewModel.fetchSuperHeroById(args.idSuperHero).observe(viewLifecycleOwner){
            if (it.comics.isNotEmpty()) binding.cardViewComics.visibility = View.VISIBLE
            if (it.series.isNotEmpty()) binding.cardViewSeries.visibility = View.VISIBLE
            if (it.stories.isNotEmpty()) binding.cardViewStories.visibility = View.VISIBLE
            if (it.events.isNotEmpty()) binding.cardViewEvents.visibility = View.VISIBLE
            if (it.urls.isNotEmpty()) binding.cardViewUrls.visibility = View.VISIBLE
            binding.tvName.text = it.name
            binding.tvComics.text = getString(R.string.super_hero_info, "\n${it.comics}")
            binding.tvSeries.text = getString(R.string.super_hero_info, "\n${it.series}")
            binding.tvStories.text = getString(R.string.super_hero_info, "\n${it.stories}")
            binding.tvEvents.text = getString(R.string.super_hero_info, "\n${it.events}")
            binding.tvUrls.text = getString(R.string.super_hero_info, "\n${it.urls}")
        }
    }

    private fun message(){
        superHeroInfoViewModel.message.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            }
        }
    }
}