package com.alifidn.practiceapi.data

import com.google.gson.annotations.SerializedName

data class Main(

	@field:SerializedName("MainResponse")
	val mainResponse: List<MainItem?>? = null
)