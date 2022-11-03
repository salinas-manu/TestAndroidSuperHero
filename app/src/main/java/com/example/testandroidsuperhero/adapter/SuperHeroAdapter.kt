package com.example.testandroidsuperhero.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidsuperhero.R
import com.example.testandroidsuperhero.data.model.SuperHero

class SuperHeroAdapter(private var superHeroList:MutableList<SuperHero>, private val onClickListener:(SuperHero) -> Unit) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun setListData(data:MutableList<SuperHero>){
        superHeroList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superHeroList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return superHeroList.size
    }

}