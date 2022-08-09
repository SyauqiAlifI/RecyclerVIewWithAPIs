package com.alifidn.practiceapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alifidn.practiceapi.data.MainItem
import com.alifidn.practiceapi.databinding.ActivityMainBinding
import com.alifidn.practiceapi.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private val mainAdapter = AdapterMain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Function get API
        getDataApi()
    }

    fun setRv(data : ArrayList<MainItem>) {
        binding.rvUsers.apply {
            adapter = mainAdapter
            mainAdapter.setUser(data)
        }
    }

    fun getDataApi() {
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<ArrayList<MainItem>> {
            override fun onResponse(
                call: Call<ArrayList<MainItem>>,
                response: Response<ArrayList<MainItem>>
            ) {
                response.body()?.let {
                    setRv(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<MainItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }
}