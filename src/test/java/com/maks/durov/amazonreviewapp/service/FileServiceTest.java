package com.maks.durov.amazonreviewapp.service;

import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import com.maks.durov.amazonreviewapp.exception.DataProcessingException;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileServiceTest {
    private FileService fileService;

    @BeforeAll
    public void init(){
        fileService = new FileService();
    }

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