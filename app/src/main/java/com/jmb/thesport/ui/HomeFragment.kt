package com.jmb.thesport.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jmb.thesport.R
import com.jmb.thesport.data.model.response.Team
import com.jmb.thesport.databinding.FragmentHomeBinding
import com.jmb.thesport.ui.viewmodels.HomeViewModel
import com.jmb.thesport.util.Resource


class HomeFragment : Fragment(), HomeAdapter.OnTeamClickListener {
    private val viewModel: HomeViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(
            this,
            HomeViewModel.Factory(activity.application)
        ).get(HomeViewModel::class.java)

    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        viewModel.fetchLigaList.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                    binding.progress.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progress.visibility = View.GONE

                    binding.rv.adapter = HomeAdapter(requireContext(), it.data.teams, this)
                }
                is Resource.Failure -> {
                    binding.progress.visibility = View.GONE
                    Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT)
                        .show()
                    Log.e(tag, it.exception.toString())
                }
            }
        })
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.topAppBar)
        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_liga,binding.topAppBar.menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
             R.id.ligaSpanish->{
                viewModel.setLiga("Spanish La Liga")
                true
            }
            R.id.colombiaCategoriaA ->{
                viewModel.setLiga("Colombia Categoría Primera A")
                true
            }
            else -> {
                viewModel.setLiga("Copa Libertadores")
                true
            }
        }
    }


    override fun onTeamClick(team: Team) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(team))
    }




}