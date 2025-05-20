package vcmsa.ci.studyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    // Declaration of the UI Elements
    private lateinit var startButton: Button
    private lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initialize UI Elements
        startButton = findViewById(R.id.btnStart)
        exitButton = findViewById(R.id.btnExit)

        //set OnClickListener for the start Button
        startButton.setOnClickListener {
            //Button that takes you to the main activity
            val intent = Intent(this, FlashActivity::class.java)
            startActivity(intent)
        }
        //set onClickListener for the exit button
        exitButton.setOnClickListener {
            //terminates and closes the app
            finishAffinity()
            exitProcess(1)
        }
    }
}

