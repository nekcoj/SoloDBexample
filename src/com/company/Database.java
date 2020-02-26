package com.company;

import com.company.pojo.Artist;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    private String dbName;
    private static final Database INSTANCE = new Database();

    public static Database getInstance() {
        return Database.INSTANCE;
    }

    public void createDb(String dbFileName) {
        this.dbName = dbFileName;
        Path checkPath = Paths.get(dbName);
        if (!Files.exists(checkPath)) {
            try {
                createDbDir(dbName);
                getDbFiles();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void createDbDir(String dbName) {
        new File(dbName).mkdir();
        System.out.println("Database location created.");
    }

    public final void writeToFile(Artist artist) {
        try {
            Path path = Paths.get(dbName);
            Path filePath = path.resolve(String.valueOf(artist.getArtistID()));
            if(!Files.exists(filePath, LinkOption.NOFOLLOW_LINKS)) {
                Files.createFile(filePath);
            }
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(filePath));
            oos.writeObject(artist); // Serializes
            System.out.println("Database file: " + filePath.getFileName() + " created.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getDbFiles() {
//        Path path = Paths.get(dbName + "/");
        List<String> result = new ArrayList<>();

        try (Stream<Path> walk = Files.walk(Paths.get(dbName))) {
            result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public final Object readDbFile(String filePath) {
        Path path = Paths.get(filePath);
        Object object = null; // De-serializes
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path.toAbsolutePath()))) {
            object = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
