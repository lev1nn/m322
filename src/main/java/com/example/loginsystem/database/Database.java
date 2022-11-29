package com.example.loginsystem.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.nio.charset.StandardCharsets;
import com.google.common.hash.Hashing;

public class Database {
    private ArrayList<User> users;
    public ArrayList<User> activeUsers;
    private static Database database;
    private final String FILE_PATH = String.valueOf(Paths.get("src\\main\\java\\com\\example\\loginsystem\\database\\Users_New.json"));
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Database() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        users = gson.fromJson(reader, listType);
    }

    public static Database getInstance() throws IOException {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public void addUser(String username, String password, String emailAddress) {
        users.add(new User(username, password, emailAddress));
    }

    public boolean checkUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public User getUserFromEmail(String email) {
        for (User user : users) {
            if (user.getEmailAddress().equals(email)) {
                return user;
            }
        }

        return null;
    }

    public void saveChanges() throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        gson.toJson(users, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }

    public String generateHash(String password){
        return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
    }

    public void setActive(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                activeUsers = new ArrayList<>();
                activeUsers.add(0, user);
            }
        }
    }

    public void setInactive(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                activeUsers.remove(user);
            }
        }
    }

    public ArrayList<User> getActiveUsers() {
        return activeUsers;
    }
}
