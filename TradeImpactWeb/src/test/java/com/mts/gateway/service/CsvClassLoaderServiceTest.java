package com.mts.gateway.service;

import com.mts.gateway.config.SDPConfigProperties;
import com.mts.gateway.dto.ClassInfo;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CsvClassLoaderServiceTest {

    @Test
    public void testLoadFromCsv() throws Exception {
        // Create temporary CSV file
        Path tmp = Files.createTempFile("classes", ".csv");
        String content = "com.example.MyClass,1001,SERVICE_X,Test class" + System.lineSeparator()
                + "com.example.Other,1002,SERVICE_Y,Other class" + System.lineSeparator();
        Files.writeString(tmp, content);

        SDPConfigProperties cfg = new SDPConfigProperties();
        cfg.setClassesCsv(tmp.toAbsolutePath().toString());

        CsvClassLoaderService svc = new CsvClassLoaderService(cfg);
        svc.loadFromCsv(cfg.getClassesCsv());

        List<ClassInfo> classes = svc.getAllClasses();
        assertEquals(2, classes.size());

        ClassInfo c1 = svc.getClassById(1001L);
        assertNotNull(c1);
        assertEquals("com.example.MyClass", c1.getClassName());

        ClassInfo byName = svc.getClassByName("MyClass");
        assertNotNull(byName);
        assertEquals(1001L, byName.getClassId());
    }
}
