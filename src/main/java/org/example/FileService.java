package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

 class FileService {
     String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

     void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content);
    }
}
