package com.utm.ipp.lab4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NYTimesAnalyzer extends ArticleAnalyzer {

    @Override
    public String extractText(String html) throws Exception {
        Document doc = Jsoup.parse(html);

        Elements articleBody = doc.select("div.articleBody");

        StringBuilder article = new StringBuilder();
        for (Element bodyPart : articleBody) {
            Elements paragraphs = bodyPart.getElementsByAttributeValue("itemprop", "articleBody");
            for (Element paragraph : paragraphs) {
                article.append(paragraph.text() + "\n");
            }
        }

        return article.toString();
    }
}
