package winexy.salo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface Kiwi {
	@GET("locations/query")
	@Headers("apikey: ${BuildConfig.KIWI_API_KEY}")
	fun findLocation(
		@Query("term") term: String,
		@Query("limit") limit: Int = 1
	): Call<LocationsQueryResponse>
}

