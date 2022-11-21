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

public class Database {
    private ArrayList<User> users;
    private static Database database;
    private final String FILE_PATH = String.valueOf(Paths.get("src\\main\\java\\com\\example\\loginsystem\\database\\Users.json"));
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Database() throws IOException {
        /*Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        users = gson.fromJson(reader, listType);*/
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

    public void saveChanges() throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_PATH);
        gson.toJson(users, fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}
