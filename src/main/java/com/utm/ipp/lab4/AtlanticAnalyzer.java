package com.utm.ipp.lab4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AtlanticAnalyzer extends ArticleAnalyzer {

    public String extractText(String html) throws Exception {
        Document doc = Jsoup.parse(html);

        Element articleBody = doc.select("div.article-content").first();

        Elements paragraphs = articleBody.getElementsByTag("p");

        StringBuffer article = new StringBuffer();

        for (Element paragraph : paragraphs) {
            article.append(paragraph.text() + "\n");
        }

        return article.toString();
    }
}
