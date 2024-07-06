package com.example.test_solo_project_h

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test_solo_project_h.adapter.ProductAdapter
import com.example.test_solo_project_h.databinding.ActivityMainBinding
import com.example.test_solo_project_h.databinding.HomeFragmentBinding
import com.example.test_solo_project_h.network.NetworkConnect
import com.example.test_solo_project_h.retrofit.ProductApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var bindingIM: HomeFragmentBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        bindingIM = HomeFragmentBinding.inflate(layoutInflater)
//
//        adapter = ProductAdapter()
//        bindingIM.rcView.layoutManager = GridLayoutManager(this, 2)
//        bindingIM.rcView.adapter = adapter


        // Настройка навигации
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
            ?: NavHostFragment.create(R.navigation.nav_panel_fragment).also {
                supportFragmentManager.commit {
                    replace(R.id.fragmentContainerView, it)
                }
            }



        // Инициализация BottomNavigationView
        val btnNavView = findViewById<BottomNavigationView>(R.id.but_nav_view_act)
        btnNavView.setupWithNavController(navHostFragment.navController)

        // Инициализация адаптера для RecyclerView





        // Обработка сетевого подключения
        val inflateLayout = findViewById<View>(R.id.network_error)
        val networkConnection = NetworkConnect(application)
        networkConnection.observe(this) { isConnected ->
            if (isConnected) {
                Toast.makeText(this, "Соединение восстановлено", Toast.LENGTH_SHORT).show()
                inflateLayout.visibility = View.GONE
            } else {
                inflateLayout.visibility = View.VISIBLE
                Toast.makeText(this, "Соединение потеряно", Toast.LENGTH_SHORT).show()
            }
        }

        // Инициализация Retrofit и загрузка данных
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://gallery.prod1.webant.ru")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

//        val productApi = retrofit.create(ProductApi::class.java)
//        CoroutineScope(Dispatchers.IO).launch {
//            val list = productApi.getAllPhotos()
//            runOnUiThread {
//                adapter.submitList(list.photos)
//            }
//        }

    }


}