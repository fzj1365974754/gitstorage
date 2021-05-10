package com.servlet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path);
        Document document = Jsoup.parse(new File(path),"utf-8");
        Elements name = document.select("name");
        System.out.println(name);
        System.out.println("");
    }
}
