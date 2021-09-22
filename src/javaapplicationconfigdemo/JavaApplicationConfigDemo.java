package javaapplicationconfigdemo;

//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author 30039802 Caspian Maclean
 *
 * Task:
 * Demonstrate how to use configuration file(s) and configuration parameters to
 * modify deployment variables. Provide your demonstration in an MS-word or
 * image screenshots.
 *
 * I don't submit the program, just screenshots.
 *
 * I'll make this a simple maths test program, configuration will be for the
 * user's name, and where to log the results.
 *
 */
public class JavaApplicationConfigDemo {

    public static void quiz(String question, int correctAnswer, Scanner scanner, FileWriter log) {
        System.out.print(question + " ");
        boolean isCorrect = false;
        try {
            int answer = scanner.nextInt();
            isCorrect = (answer == correctAnswer);
            if (isCorrect) {
                System.out.println("That's right");
                log.write("Correct: " + question + " " + answer + "\r\n");
            } else {
                System.out.println("No, the answer is " + correctAnswer + ", not " + answer);
                log.write("Wrong: " + question + " " + answer +
                        " (should be " + correctAnswer + ")\r\n");

            }
        } catch (InputMismatchException e) {
            // Could also catch 
            isCorrect = false;
            System.out.println("No, the answer is " + correctAnswer + ", your answer didn't even look like a number");
        } catch (IOException exIO) {
            System.out.println("Couldn't log results");
        }
        if (isCorrect) {
            //
        } else {
            //
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConfigurationLoader cfLoad = new ConfigurationLoader();
        try {
            Properties properties = cfLoad.loadProperties();
            String name = properties.getProperty("name", "Default User");
            String logFileName = properties.getProperty("log", "log.txt");

            System.out.println("Welcome, " + name);
            System.out.println("Logging scores to: '" + logFileName + "'");

            FileWriter logWriter = new FileWriter(logFileName);
            //log
            quiz("What is 3 times 4?", 3 * 4, scanner, logWriter);
            quiz("What is 7 plus 8?", 7 + 8, scanner, logWriter);
            logWriter.close();

        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }

    }

}
