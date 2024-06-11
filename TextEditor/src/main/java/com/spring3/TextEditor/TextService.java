package com.spring3.TextEditor;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class TextService {

    public String extractTextFromHtml(String htmlContent) {
        return Jsoup.parse(htmlContent).text();
    }

    public void saveTextToFile(String text, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public String readTextFromFile(String filepath) {
		try {
		return new String(Files.readAllBytes(Paths.get(filepath)));
		}
		catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
