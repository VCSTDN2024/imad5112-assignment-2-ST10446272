# Meal App
- Developer: Likhona Ngwenya
- Student Number: ST10446272
- Group: GR01
- Course: Higher Certificate in Mobile Application and Web Development (HMAW0501)
- Subject: IMAD5112

# Links
- GitHub Repository: https://github.com/VCSTDN2024/imad5112-assignment-2-ST10446272/tree/main
- YouTube Video: https://youtu.be/t0ZqomGlEtM


## Project Overview
The Study App is a mobile application developed as part of an assignment in the IMAD5112 subject. This application was created using Kotlin and Android Studio. The App's primary purpose is to help users study with flash cards. This app allows the users to answer flashcard questions in a basic True or False setup for history to text their knowledge on Sneaker Culture, the users responses will be scored and receive feedback on the questions answered and the app will provide a score based on the users answer, the user will have a review screen showing all the questions along with the correct answers. The app was developed to meet the requirements of the assignment,
which includes creating a functional mobile app and utilizing GitHub for version control and CI/CD automation using GitHub Actions.


## Purpose and Features

### FlashActivity.kt – Quiz 
- This is the starting screen of the quiz where questions are presented one by one, and users choose "True" or "False".

Key Features:

- Displays one question at a time.
- Accepts True/False input.
- Provides immediate feedback ("Correct" or "Incorrect").
- Increments the score for each question.
- Moves to the next question with a "Next" button.
- Ends the quiz and sends the score to the ScoreActivity.

 ### ScoreActivity.kt
- Shows the final score and feedback after the quiz ends.

Key Features:
- Displays the total score out of 5.
- Gives feedback:
--"Great job!" if score is 3 or higher
--"Keep Practicing" otherwise

Review button – to see all questions and answers
Exit button – to close the app

### ReviewActivity.kt – Question Summary
- Displays a list of all the questions and whether the user answered them correctly.

Key Features:
- Receives the questions and answers via Intent.
- Loops through each question and answer.
- Displays a formatted summary



---------------------------
## Screenshots

### App Screenshots:
Screenshot 1: MainActivity.kt
![Layout 1](https://github.com/user-attachments/assets/de3c1863-fcff-4c63-86b8-4fd7097ddcf6)

Screenshot 2: FlashActivity.kt
![Layout 2](https://github.com/user-attachments/assets/e03b3ac5-a2ee-4281-bb0e-975198328516)

Screenshot 3: FlashActivity.kt
![Layout 3](https://github.com/user-attachments/assets/ad6e0f3e-fe56-4b9e-80a2-2dfd8eaa63b8)

Screenshot 4: ScoreActivity.kt
![Layout  4](https://github.com/user-attachments/assets/441ba09f-50c9-4eaf-9386-718e72432f71)

Screenshot 5: ReviewActivity.kt
![Layout 5](https://github.com/user-attachments/assets/39b8076f-e66a-48f0-986f-d7237ee12e98)


Video Demo:
A video showcasing the app's functionality can be viewed here: https://youtu.be/t0ZqomGlEtM .


## RoadMap

### App Overview: 
- This is a true/false quiz application that allows a user to:

1. Answer questions.
2. Get feedback after each question.
3. View a final score.
4. Review the questions and their correct answers.
5. Exit or restart the quiz.

### App Flow: 

Open app MainActivity	→	 FlashActivity shows question 1.
Answer → Get feedback (correct/incorrect).
Press Next → Repeat until all 5 questions are done.
After last question → Automatically go to ScoreActivity.
View score and message → Option to:
Press Review to go over all questions and answers.
Press Exit to close the app.


## References

1. Reference 1: https://za.pinterest.com/pin/1095500678113315315/ 
2. Reference 2: https://www.thenarratologist.com/best-sneaker-trivia-questions-and-answers/




```

