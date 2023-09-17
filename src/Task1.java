import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

    private File file;

    public Task1(String file) {
        this.file = new File(file);
    }

    public void phoneNumbersFilter() {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("\\d{3}[-]\\d{3}[-]\\d{4}");
        arrayList.add("\\(\\d{3}\\)\\s\\d{3}[-]\\d{4}");

        fileInputReader(arrayList);
    }

    private void fileInputReader(ArrayList arrayList) {
        try (FileReader fileReader = new FileReader(file);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Pattern ptrn;
                Matcher match;
                for (Object regex : arrayList) {
                    ptrn = Pattern.compile((String) regex);
                    match = ptrn.matcher(line);
                    if (match.find() && match.group().equals(line)) {
                        System.out.println(line);
                        fileOutputWriter(line);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void fileOutputWriter(String line) {
        try (FileWriter fileWriter = new FileWriter("file_Task_1_Output.txt", true)) {
            fileWriter.write(line + "\n");
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
