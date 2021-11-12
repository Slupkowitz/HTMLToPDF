package com.cgm;

import org.htmlcleaner.*;

/** Clear html from inappropriate characters */

public class HtmlClean {
    public static String cleanHtml(String xhtml) {
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode root = htmlCleaner.clean(xhtml);
        CleanerProperties cleanerProperties = htmlCleaner.getProperties();

        XmlSerializer xmlSerializer = new PrettyXmlSerializer(cleanerProperties);
        return xmlSerializer.getAsString(root);
    }
}

