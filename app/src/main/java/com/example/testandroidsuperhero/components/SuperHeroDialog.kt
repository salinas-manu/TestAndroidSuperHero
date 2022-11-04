package com.example.testandroidsuperhero.components
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.testandroidsuperhero.databinding.DialogSuperheroBinding

class SuperHeroDialog(
    private val nameSuperHero: String,
    private val statsSuperHero: String,
    private val biographySuperHero: String,
    private val lookSuperHero: String,
    private val worksSuperHero: String,
    private val connectionsSuperHero: String
) : DialogFragment() {

    private lateinit var binding: DialogSuperheroBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogSuperheroBinding.inflate(layoutInflater)

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.tvNameSuperhero.text = nameSuperHero
        binding.tvStatsSuperHero.text = "Stats: $statsSuperHero"
        binding.tvBiographySuperHero.text = "Biography: $biographySuperHero"
        binding.tvLookSuperHero.text = "Appearance: $lookSuperHero"
        binding.tvWorkSuperHero.text = "Works: $worksSuperHero"
        binding.tvConnectionsSuperHero.text = "Connections: $connectionsSuperHero"
        binding.btnAccept.text = "ACEPTAR"
        binding.btnAccept.setOnClickListener {
            dismiss()
        }

        val dialog = builder.create()
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

}