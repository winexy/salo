package winexy.salo

import com.google.gson.annotations.SerializedName

data class LocationsQueryResponse(
	@SerializedName("locations")
	val locations: List<Location>
)