package cbass.apptareasroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cbass.apptareasroom.R
import cbass.apptareasroom.adapter.TareaAdapter
import cbass.apptareasroom.databinding.FragmentListaTareasBinding
import cbass.apptareasroom.viewmodel.TareaVM

class ListaTareas : Fragment() {

    lateinit var binding: FragmentListaTareasBinding
    private val viewModel by activityViewModels<TareaVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaTareasBinding.inflate(layoutInflater)
        viewModel.listar()

        val adapter = TareaAdapter()
        val manager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvListaTareas.adapter = adapter
            rvListaTareas.layoutManager = manager

            fbtnAdd.setOnClickListener            {
                Navigation.findNavController(requireView()).navigate(R.id.action_listaTareas2_to_agregarTarea)
            }

            viewModel.lista.observe(viewLifecycleOwner, Observer {
                adapter.actualizar(it)
            })

        }

        return binding.root
    }

}