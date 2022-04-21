package cbass.apptareasroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import cbass.apptareasroom.R
import cbass.apptareasroom.databinding.FragmentAgregarTareaBinding
import cbass.apptareasroom.viewmodel.TareaVM

class AgregarTarea : Fragment() {

    lateinit var binding: FragmentAgregarTareaBinding
    private val viewModel by activityViewModels<TareaVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAgregarTareaBinding.inflate(layoutInflater)

        with(binding)
        {
            btnAdd.setOnClickListener {
                val nombre = etNomTarea.text.toString()

                viewModel.agregar(nombre)

                Navigation.findNavController(requireView()).navigate(R.id.action_agregarTarea_to_listaTareas2)
            }
        }
        return binding.root
    }


}