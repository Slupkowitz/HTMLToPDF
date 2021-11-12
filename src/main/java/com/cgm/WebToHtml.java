package com.cgm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/** Connect to defined url and get html
 * Transform html to xhtml
 * */

public class WebToHtml {
    /** Return xhtml from url
     * @param url website domain address
     * @return xhtml
     */
    public static String getHTML(String url) {
        try {
            if (!url.startsWith("https://") || !url.startsWith("http://")) {
                url = ("https://").concat(url);
            }

            String html = Jsoup.connect(url).get().html();

            String cleanHtml = HtmlClean.cleanHtml(html);

            return htmlToXhtml(cleanHtml);
        } catch (Exception e) {
            System.out.println("Can't connect to " + url + " url: " + e.getMessage());
        }
        return null;
    }

    // not necessary but can fix some errors (missing end tags,...)
    /** transform html to xhtml */
    private static String htmlToXhtml(String html) {
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }

}
