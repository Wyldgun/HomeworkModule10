import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task3 {
    private File file;
    private ArrayList<Object> dataArray = new ArrayList<>();


    public Task3(String file) {
        this.file = new File(file);
    }

    public void wordFrequencyCount() {
        try (FileReader fileReader = new FileReader(file);
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineArray = line.split(" ");
                dataArrayFill(lineArray);
            }
            wordFrequencySort();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void wordFrequencySort() {
        TreeMap<Integer,String> sortedData = new TreeMap<>();
        for (int i = 0; i < dataArray.size(); i=i+2) {
            sortedData.put((Integer)dataArray.get(i+1),dataArray.get(i).toString());
        }
        System.out.println("sortedData = " + sortedData.descendingMap());
    }

    private void dataArrayFill(String[] lineArray) {
        boolean isScanned = false;
        int frequency = 1;
        for (int i = 0; i < lineArray.length; i++) {
            for (int j = i + 1; j < lineArray.length; j++) {
                if (lineArray[i].equals(lineArray[j]) && !dataArray.contains(lineArray[i])) {
                    frequency++;
                }
            }
            if (!dataArray.contains(lineArray[i])) {
                dataArray.add(lineArray[i]);
                dataArray.add(frequency);
                isScanned = true;
            } else if (!isScanned) {
                dataArray.add(dataArray.indexOf(lineArray[i]) + 1, (Integer) dataArray.get(dataArray.indexOf(lineArray[i]) + 1) + frequency);
                dataArray.remove(dataArray.indexOf(lineArray[i]) + 2);
            }
            frequency = 1;
        }
    }
}
