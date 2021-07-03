package com.jmb.thesport.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jmb.thesport.databinding.FragmentDetailBinding
import com.jmb.thesport.ui.viewmodels.HomeViewModel
import com.jmb.thesport.util.Resource


class DetailFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(
            this,
            HomeViewModel.Factory(activity.application)
        ).get(HomeViewModel::class.java)

    }
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val navController = findNavController()
        val appbarconfi = AppBarConfiguration(navGraph = navController.graph)
        binding.mainToolbar.setupWithNavController(navController, appbarconfi)
        binding.mainToolbar.title = args.data.strTeam
        Glide.with(this).load(args.data.strStadiumThumb).into(binding.mainBackdrop)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.tvDescription.text =  if(args.data.strDescriptionES.isNullOrEmpty()) args.data.strDescriptionEN else args.data.strDescriptionES
        binding.foundation.text = getEmojiByUnicode(0x1F4C6) + args.data.intFormedYear
        Glide.with(this).load(args.data.strTeamBadge).into(binding.escudoEquipo)
        Glide.with(this).load(args.data.strTeamJersey).into(binding.camisa)
        viewModel.getEventos(args.data.strTeam).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    binding.rvEventos.adapter = EventsAdapter(requireContext(), it.data.event)
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), it.exception.toString(), Toast.LENGTH_SHORT)
                        .show()
                }

            }
        })

        setupBotones()
    }


    private fun setupBotones() {
        if (args.data.strWebsite.isEmpty()) binding.btnWeb.visibility = View.GONE
        if (args.data.strFacebook.isEmpty()) binding.btnFacebook.visibility = View.GONE
        if (args.data.strTwitter.isEmpty()) binding.btntw.visibility = View.GONE
        if (args.data.strInstagram.isEmpty()) binding.btnIg.visibility = View.GONE
        if (args.data.strYoutube.isEmpty()) binding.btnYT.visibility = View.GONE
        vincularBotones()
    }

    private fun vincularBotones() {
        var viewIntent: Intent? = null
        binding.btnWeb.setOnClickListener {
            viewIntent = Intent(
                "android.intent.action.VIEW",
                Uri.parse("http://${args.data.strWebsite}")
            )
            startActivity(viewIntent)
        }
        binding.btnFacebook.setOnClickListener {
            viewIntent = Intent(
                "android.intent.action.VIEW",
                Uri.parse("http://${args.data.strFacebook}")
            )
            startActivity(viewIntent)
        }
        binding.btntw.setOnClickListener {
            viewIntent = Intent(
                "android.intent.action.VIEW",
                Uri.parse("http://${args.data.strTwitter}")
            )
            startActivity(viewIntent)
        }
        binding.btnIg.setOnClickListener {
            viewIntent = Intent(
                "android.intent.action.VIEW",
                Uri.parse("http://${args.data.strInstagram}")
            )
            startActivity(viewIntent)
        }
        binding.btnYT.setOnClickListener {
            viewIntent = Intent(
                "android.intent.action.VIEW",
                Uri.parse("http://${args.data.strYoutube}")
            )
            startActivity(viewIntent)
        }
    }

    private fun setupRecyclerView() {
        _binding!!.rvEventos.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    fun getEmojiByUnicode(unicode: Int): String {
        return String(Character.toChars(unicode))
    }


}