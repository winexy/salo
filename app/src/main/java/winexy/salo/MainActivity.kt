package winexy.salo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val originButton = findViewById<Button>(R.id.originButton)

		originButton.setOnClickListener {
			startActivity(Intent(this, LocationQueryActivity::class.java))
		}
	}
}