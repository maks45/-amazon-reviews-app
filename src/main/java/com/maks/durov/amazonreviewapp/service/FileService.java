package com.maks.durov.amazonreviewapp.service;

import com.maks.durov.amazonreviewapp.exception.DataProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FileService {
    public List<String> readFile(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new DataProcessingException("can't read file", e);
        }
    }
}
