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
            String[] data = sb.toString().replaceAll("[ :\n\t\r]", "").split("Name|Age|Email|Phone");

            String name = data[1];
            int age = Integer.parseInt(data[2]);
            String email = data[3];
            Long phone = Long.parseLong(data[4]);

            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
