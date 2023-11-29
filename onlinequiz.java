import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<QuizQuestion> questions;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }
}

class QuizApp {
    private Map<String, String> users;
    private List<Quiz> quizzes;

    public QuizApp() {
        users = new HashMap<>();
        quizzes = new ArrayList<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, password);
        System.out.println("User registered successfully!");
    }

    public boolean authenticateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
        System.out.println("Quiz added successfully!");
    }

    public void startQuiz(String username, Quiz quiz) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome, " + username + "! Let's start the quiz.");

        List<QuizQuestion> questions = quiz.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);

            System.out.println("\nQuestion " + (i + 1) + ": " + currentQuestion.getQuestion());
            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer (enter option number): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is option " + currentQuestion.getCorrectOption());
            }
        }

        System.out.println("\nQuiz completed! Your score: " + score + "/" + questions.size());
    }
}

public class onlinequiz {
    public static void main(String[] args) {
        QuizQuestion question1 = new QuizQuestion("What is the capital of France?",
                List.of("Berlin", "Paris", "Madrid", "Rome"), 2);

        QuizQuestion question2 = new QuizQuestion("Which programming language is known for its 'Write Once, Run Anywhere' philosophy?",
                List.of("Java", "Python", "C++", "JavaScript"), 1);

        Quiz quiz = new Quiz(List.of(question1, question2));

        QuizApp quizApp = new QuizApp();
        quizApp.registerUser("user1", "password123");
        quizApp.registerUser("user2", "password456");

        quizApp.addQuiz(quiz);

        Scanner scanner = new Scanner(System.in);

        // User authentication
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (quizApp.authenticateUser(username, password)) {
            // Start the quiz
            quizApp.startQuiz(username, quiz);
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }
}
