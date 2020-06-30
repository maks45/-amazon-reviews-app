package com.maks.durov.amazonreviewapp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FileService {
    public List<String> readFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            lines.remove(0);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException("can't read file " + path, e);
        }
    }
}
