import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Task2 {
    private File txtFile;
    private ArrayList<User> userData = new ArrayList<>();
    public Task2(String file) {
        this.txtFile = new File(file);
    }

    public void jsonFormatter() {
        txtFileReader();
        String[] jsonUserArray = getJsonStrings();
        jsonUserSerialization(jsonUserArray);
    }

    public void txtFileReader() {
        try (FileReader fileReader = new FileReader(txtFile);
             Scanner scanner = new Scanner(fileReader)) {
            userDataFormatter(scanner);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void userDataFormatter(Scanner scanner) {
        int counter = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(" ");
            for (int i = 0; i < 1; i++) {
                if (counter == 1) {
                    userData.add(new User(lineArray[0], Integer.valueOf(lineArray[1])));
                } else {
                    counter++;
                    break;
                }
            }
        }
    }
    private String[] getJsonStrings() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String[] jsonUsersArray = new String[userData.size()];
        for (int i = 0; i < userData.size(); i++) {
            String json = gson.toJson(userData.get(i));
            jsonUsersArray[i] = json;
            System.out.println(json);
        }

        return jsonUsersArray;
    }

    private static void jsonUserSerialization(String[] jsonUsersArray) {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("user.json"))) {
            ois.writeObject(jsonUsersArray);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static class User {
        private String name;
        private Integer age;
        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}
