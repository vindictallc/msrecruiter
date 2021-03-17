package com.vindicta.msrecruiter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;


public class Main {

    public static void main(String[] args) throws IOException {
        // Start GUI
        ListViewer lv = new ListViewer();

	    // Get directory name
        String directoryName = "resource/";

        int score = 0;

        // Get search terms
        Keywords keyHash = new Keywords();
        SpouseList spouseList = new SpouseList();

        File dirPath = new File(directoryName);
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File f, String name) {
                return name.endsWith(".pdf");
            }
        };
        File allFiles[] = dirPath.listFiles(filter);
        for(File file : allFiles) {

            // Open PDF, get contents, close it
            String text = getContents(file);

            // analyze the PDF contents & record resumes with higher scores
            score = keyHash.calculateScore(text);
            if (score >= 10) {
                spouseList.addResume(file.getName(), score);
            }
        }
        spouseList.printResumes();


    }

    private static String getContents(File file) throws IOException {
        PDDocument document = null;
        document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();
        return text;
    }

}
