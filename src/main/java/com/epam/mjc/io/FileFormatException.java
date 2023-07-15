package com.epam.mjc.io;

public class FileFormatException extends IllegalArgumentException {
    public FileFormatException(String message, Throwable e){
        super(message, e);
    }
}
