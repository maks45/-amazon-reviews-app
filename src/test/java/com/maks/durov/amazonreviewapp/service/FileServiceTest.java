package com.maks.durov.amazonreviewapp.service;

import java.io.File;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import com.maks.durov.amazonreviewapp.exception.DataProcessingException;
import java.util.List;

class FileServiceTest {
    private final FileService fileService = new FileService();

    @Test
    void readFileOk() {
        String filePath = "src/test/resources/test.txt";
        assertTrue(new File(filePath).exists());
        List<String> expected = List.of("some content");
        List<String> actual = fileService.readFile(filePath);
        assertEquals(expected, actual);
    }

    @Test
    void readFileException() {
        String fakePath = "";
        assertThrows(DataProcessingException.class, () -> fileService.readFile(fakePath));
    }
}