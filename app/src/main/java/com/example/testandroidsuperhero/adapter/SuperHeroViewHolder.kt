package com.example.testandroidsuperhero.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testandroidsuperhero.data.model.SuperHero
import com.example.testandroidsuperhero.databinding.ItemSuperheroBinding

class SuperHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHero, onClickListener:(SuperHero) -> Unit) {
        binding.tvSuperHeroName.text = superHeroModel.superHero
        Glide.with(binding.imvSuperHero.context).load(superHeroModel.photo)
            .into(binding.imvSuperHero);

        itemView.setOnClickListener {
            onClickListener(superHeroModel)
        }
    }
}