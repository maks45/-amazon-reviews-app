package com.maks.durov.amazonreviewapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.maks.durov.amazonreviewapp.exception.DataProcessingException;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileServiceTest {
    private FileService fileService;

    @BeforeAll
    public void init() {
        fileService = new FileService();
    }

    @Test
    void readFile_ok() {
        String filePath = "src/test/resources/test.txt";
        assertTrue(new File(filePath).exists());
        List<String> expected = List.of("some content");
        List<String> actual = fileService.readFile(filePath);
        assertEquals(expected, actual);
    }

    @Test
    void readFile_exception() {
        String fakePath = "";
        assertThrows(DataProcessingException.class, () -> fileService.readFile(fakePath));
    }
}
