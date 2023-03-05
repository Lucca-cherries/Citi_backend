package com.citi.stock.util;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import org.python.util.PythonInterpreter;

//@SpringBootTest
public class UtilTests {
    public static void main(String[] args) {
        Process process;
        try {
            process = Runtime.getRuntime().exec(
                    "python D:\\Javaaa\\stock\\src\\main\\java\\com\\citi\\stock\\util\\Runtime.py hello");
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            process.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
