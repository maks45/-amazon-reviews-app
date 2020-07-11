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
    void readFile_ok() {
        String filePath = "test.txt";
        assertNotNull(getClass().getClassLoader().getResource(filePath));
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
