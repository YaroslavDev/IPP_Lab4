package com.utm.ipp.lab4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewYorkerAnalyzer extends ArticleAnalyzer {

    @Override
    public String extractText(String html) throws Exception {
        Document doc = Jsoup.parse(html);

        Element articleBody = doc.select("div.articleBody").first();

        Elements paragraphs = articleBody.getElementsByTag("p");

        StringBuilder article = new StringBuilder();

        for (Element paragraph : paragraphs) {
            article.append(paragraph.text() + "\n");
        }

        return article.toString();
    }
}
