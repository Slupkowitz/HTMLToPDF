package com.cgm;

import java.util.Scanner;

/** Main method for created pdf from website
 * input String url for extract html
 * input String target directory for pdf
 * output created pdf
 * */

public class Main {
    public static void main(String[] args) {
        // Reading from System.in
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a source url: ");
        String url = reader.nextLine();
        System.out.println("Enter target directory: ");
        String targetDirectory = reader.nextLine();
        reader.close();

        if (url.isEmpty()) {
            System.out.println("Source url is empty");
        } else {
            // get html from the website
            String xhtml = WebToHtml.getHTML(url);

            if (xhtml != null) {
                // transform xml to pdf
                XmlToPdf.xhtmlToPdf(xhtml, targetDirectory);

                System.out.println("Done");
            }
        }
    }
}
