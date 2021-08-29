package winexy.salo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LocationQueryActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_location_query)

		val queryInput = findViewById<EditText>(R.id.queryInput)

		queryInput.doAfterTextChanged {
			// TODO: Debounce API Call
			val query = it.toString()
			val sort = "name"
			val activeOnly = "true"
			val locale = "ru-RU"
			val limit = 10

			val retrofit = Retrofit.Builder()
				.baseUrl("https://tequila-api.kiwi.com/")
				.addConverterFactory(GsonConverterFactory.create())
				.build()

			val kiwi = retrofit.create(Kiwi::class.java)

			kiwi.findLocation(query).enqueue(object : Callback<LocationsQueryResponse> {
				override fun onResponse(
					call: Call<LocationsQueryResponse>,
					response: Response<LocationsQueryResponse>
				) {
					val body = response.body()
					Log.d("QUERY", "I feel so good ${body?.locations}")
				}

				override fun onFailure(call: Call<LocationsQueryResponse>, t: Throwable) {
					Log.d("QUERY", "i don't feel so good")
					t.printStackTrace()
				}
			})
		}
	}
}