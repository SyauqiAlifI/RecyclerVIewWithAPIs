package com.alifidn.practiceapi.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alifidn.practiceapi.databinding.ActivityUserBinding
import com.alifidn.practiceapi.practice.data.PracticeUserResponseItem
import com.alifidn.practiceapi.practice.network.PracticeApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private var _binding : ActivityUserBinding? = null
    private val binding get() = _binding as ActivityUserBinding

    private val userAdapter = AdapterUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Get Data Api
        practiceGetDataApi()
    }

    fun setData(item : ArrayList<PracticeUserResponseItem>) {
        binding.rvUserPractice.apply {
            adapter = userAdapter
            userAdapter.setPracticeUser(item)
        }
    }

    fun practiceGetDataApi() {
        PracticeApiConfig.getApiService().getListPracticeUser().enqueue(object : Callback<ArrayList<PracticeUserResponseItem>> {
            override fun onResponse(
                call: Call<ArrayList<PracticeUserResponseItem>>,
                response: Response<ArrayList<PracticeUserResponseItem>>
            ) {
                response.body()?.let {
                    setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<PracticeUserResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }
}