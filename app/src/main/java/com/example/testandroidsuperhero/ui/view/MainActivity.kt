package com.example.testandroidsuperhero.ui.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.testandroidsuperhero.databinding.ActivityMainBinding
import com.example.testandroidsuperhero.ui.viewmodel.SuperHeroViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private val superHeroViewModel: SuperHeroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}