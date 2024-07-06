package com.example.test_solo_project_h

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test_solo_project_h.adapter.ProductAdapter
import com.example.test_solo_project_h.databinding.HomeFragmentBinding
import com.example.test_solo_project_h.retrofit.Photos
import com.example.test_solo_project_h.retrofit.Product
import com.example.test_solo_project_h.retrofit.ProductApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//binding = HomeFragmentBinding.inflate(layoutInflater)
//adapter = ProductAdapter()
//binding.rcView.layoutManager = GridLayoutManager(requireContext(), 2)
//binding.rcView.adapter = adapter
//return binding.root


class HomeFragment : Fragment() {
    private lateinit var adapter: ProductAdapter
    private lateinit var binding: HomeFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProductAdapter()
        binding.rcView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rcView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://gallery.prod1.webant.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val productApi = retrofit.create(ProductApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val list = productApi.getAllPhotos()
            activity?.runOnUiThread {
                adapter.submitList(list.photos)
            }
        }

    }

}