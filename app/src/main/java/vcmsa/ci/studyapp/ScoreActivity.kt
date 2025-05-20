package vcmsa.ci.studyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        //Initialise the UI Elements
        val scoreDisplay = findViewById<TextView>(R.id.tvScore)
        val feedbackDisplay = findViewById<TextView>(R.id.tvFeedBack)
        val reviewButton = findViewById<Button>(R.id.btnReview)
        val exitButton = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("score", 0 )
        //Display the score as calculated with each correct answer
        scoreDisplay.text = "Your score:\n $score/5"

        //Display the feedback according to the score acquired
        val feedback = if (score >= 3){
            "Great job!"
        }else {
            "Keep Practicing"
        }
        feedbackDisplay.text = feedback

        //set the exit button on onClick
        reviewButton.setOnClickListener {
            // Start/Open the Review screen and display the questions as well as the answers from the Flash screen
            val intent = Intent (this,ReviewActivity::class.java)
            intent.putExtra("questions", FlashActivity.questions)
            intent.putExtra("answers", FlashActivity.answers)
            startActivity(intent)
        }
        //set the exit button on onClick
        exitButton.setOnClickListener {
            //Close and terminate the App
            finishAffinity()
            exitProcess(0)
        }
    }
}