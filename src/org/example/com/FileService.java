package org.example.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileService {
     public  String read(String path) throws IOException {

        String message = Files.readString(Path.of(path));

        return message;
     }
     public void write(String typeCommand, String path, String cypherUncypherText) throws IOException {

         Files.writeString(Path.of(path + typeCommand), cypherUncypherText);

     }

}
