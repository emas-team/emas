package emas.core.utils;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultWriterTest {
    private ResultWriter resultWriter;

    @Before
    public void setUp() {
        resultWriter = new ResultWriter();
    }

    @Test
    public void testSaveResults() throws Exception {
        List<Double> generations = new LinkedList<>();
        generations.add(0.6);
        generations.add(0.5);

        Field f = resultWriter.getClass().getDeclaredField("generations");
        f.setAccessible(true);
        f.set(resultWriter, generations);

        resultWriter.saveResults();

        List<Double> actual = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("results.csv"))) {
            String line = br.readLine();

            while (line != null) {
                actual.add(Double.parseDouble(line));
                line = br.readLine();
            }
        }
        assertEquals(generations.get(0), actual.get(0));
        assertEquals(generations.get(1), actual.get(1));
    }
}