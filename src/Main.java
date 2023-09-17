import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Task1 task1 = new Task1("file_Task_1_Input.txt");
        task1.phoneNumbersFilter();

        System.out.println("----------------------------");

        Task2 task2 = new Task2("file_Task_2_Input.txt");
        task2.jsonFormatter();

        System.out.println("----------------------------");

        Task3 task3 = new Task3("file_Task_3_Input.txt");
        task3.wordFrequencyCount();

    }
}
