package winexy.salo

import com.google.gson.annotations.SerializedName

data class Location(
	@SerializedName("id")
	val id: String,
	@SerializedName("name")
	val name: String,
	@SerializedName("code")
	val code: String,
	@SerializedName("type")
	val type: String
)
