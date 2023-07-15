package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            StringBuilder sb = new StringBuilder();
            while((ch = fileInputStream.read()) != -1){
                sb.append((char)ch);
            }
            String[] data = sb.toString().split(": | |\n |\r\n |\r");

            String name = data[1];
            int age = Integer.parseInt(data[3]);
            String email = data[5];
            Long phone = Long.parseLong(data[7]);

            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
