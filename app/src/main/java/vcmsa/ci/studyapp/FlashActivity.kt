package vcmsa.ci.studyapp
/*
https://www.thenarratologist.com/best-sneaker-trivia-questions-and-answers/
*/
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class FlashActivity : AppCompatActivity() {

    // Declaration of the UI Elements
    private lateinit var quiz: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var answerStatus: TextView
    private lateinit var next: Button
    private lateinit var exit: Button

    //Static Data: Questions And answers
    companion object {
        val questions = arrayOf(
            "Adidas is the first brand to create the first sneaker with an air-cushioned sole? ",
            "Kim Kardashian is the pop icon that has a signature sneaker with Puma?",
            "Virgil Abloh collaborated with Nike for the 'Off-White' sneaker collection?",
            "Nike became the emblem of skate culture in the 80's and 90's?",
            "Kanye West is the rapper that partnered with Nike for the 'Air Yeezy' line?"
        )
        val answers = booleanArrayOf( false, false, true, false, true)
    }
    // Keeps Track of which question is currently shown
    private var currentQuestionIndex = 0
    // Keeps track of how many answers the user got correct
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flash)

        // Initialisation of the UI Elements
        quiz = findViewById(R.id.tvQuestion)
        trueButton = findViewById(R.id.btnTrue)
        falseButton = findViewById(R.id.btnFalse)
        answerStatus = findViewById(R.id.tvAnswerStatus)
        next = findViewById(R.id.btnNext)
        exit = findViewById(R.id.btnExit)

        //Displays the first question of the quiz
        handleQuizQuestions()

        //Set onClickListener
        //Lets user Pick/Answer True
        trueButton.setOnClickListener {
            handleAnswerStatus(true)
        }
        // Lets the user pick/answer false
        falseButton.setOnClickListener {
            handleAnswerStatus(false)
        }
        next.setOnClickListener {
            handleNext()
        }
        exit.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }
    }
    // sets the text of the quiz view to the current question using the index
    private fun handleQuizQuestions() {
        quiz.text = questions[currentQuestionIndex]
    }
    // Called when the user presses true or false
    private fun handleAnswerStatus(userAnswer: Boolean) {

        // Gets the correct answer for the current question index
        val correctAnswer = answers[currentQuestionIndex]

        // Answer Checking
        if (userAnswer == correctAnswer) {
            answerStatus.text = "Correct"
            answerStatus.setTextColor(Color.GREEN)
            score++
        } else {
            answerStatus.text = "Incorrect"
            answerStatus.setTextColor(Color.RED)
        }
        // Disables the answer button & enables next button to proceed with the quiz
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        next.isEnabled = true
        }

    private fun handleNext(){
        // Moves to the next question when next is pressed
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size){
            handleQuizQuestions()
            answerStatus.text = ""
            trueButton.isEnabled = true
            falseButton.isEnabled = true
        }
        else {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
            finish()
        }
    }
}