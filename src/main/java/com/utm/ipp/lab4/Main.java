package com.utm.ipp.lab4;


public class Main {
    public static void main(String[] args) throws Exception {
        String[] urls = new String[] {
                "http://www.theatlantic.com/magazine/archive/1945/07/as-we-may-think/303881/?single_page=true",
                "http://www.nytimes.com/2012/02/19/magazine/shopping-habits.html?ref=general&src=me&pagewanted=all",
                "http://www.newyorker.com/magazine/2012/08/06/marathon-man?currentPage=all"
        };

        for (String url : urls) {
            String msg = String.format("Article at: %s\nhas source: %s,\ncontains %d words",
                    url, ArticleAnalyzer.getURLSource(url), ArticleAnalyzer.getNumberOfWords(url));
            System.out.println(msg);
        }
    }
}