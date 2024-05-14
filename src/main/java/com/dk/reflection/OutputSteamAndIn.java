package com.dk.reflection;


import java.io.*;
import java.nio.file.Files;


public class OutputSteamAndIn {
    People p = new People("Dongke",19,"男","12312");
    OutputStream outputSteam = Files.newOutputStream(new File("D:\\360").toPath());
    ObjectOutputStream ob = new ObjectOutputStream(outputSteam);


    public OutputSteamAndIn() throws IOException {
    }
}
