package vcmsa.ci.studyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.system.exitProcess

class ReviewActivity : AppCompatActivity() {

    // Declaration of the UI Elements
    private lateinit var tvReview: TextView
    private lateinit var restart: Button
    private lateinit var exit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        //Initialise the UI Elements
        tvReview = findViewById(R.id.tvContentDisplay)
        restart = findViewById(R.id.btnRestart)
        exit = findViewById(R.id.btnExit)

        //set the restart button on onClick
        restart.setOnClickListener {
            //call the private function handleRestart
            handleRestart()
        }
        //set the exit button on onClick
        exit.setOnClickListener {
            //call the private function handleExit
            handleExit()
        }

        // Pulling data from the FlashActivity to be displayed
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        // Building a summary of the data to display at a later stage
        val reviewText = StringBuilder()
        // Validation Check (checks if both arrays are not null and have the same length,  ensuring data integrity)
        if (questions != null && answers != null && questions.size == answers.size){
            for (i in questions.indices){
                // Loop to format the results
                // appends each question and its corresponding answer to the text view
                reviewText.append("${i + 1}. ${questions[i]}\n")
                reviewText.append(" Answer: ${if (answers[i]) "True" else "False"} \n\n")
            }
            //Displays Results
            tvReview.text = reviewText.toString()
        } else {
            // If Data is invalid or null - error handling
            tvReview.text = "Alien!"
        }
    }
    //Restarts the quiz by launching MainActivity
    private fun handleRestart(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    //Closes and Completely terminates the app
    private fun handleExit(){
        finishAffinity()
        exitProcess(0)
    }

}