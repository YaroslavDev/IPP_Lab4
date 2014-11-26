package com.utm.ipp.lab4;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Future;

public abstract class ArticleAnalyzer {

    public static HashMap<String, Class> mapper = new HashMap<String, Class>();

    static {
        mapper.put("www.theatlantic.com", AtlanticAnalyzer.class);
        mapper.put("www.nytimes.com", NYTimesAnalyzer.class);
        mapper.put("www.newyorker.com", NewYorkerAnalyzer.class);
    }

    public static String getURLSource(String stringURL) throws Exception {
        URL url = new URL(stringURL);
        return url.getHost();
    }

    public static int getNumberOfWords(String stringURL) throws Exception {
        String source = getURLSource(stringURL);

        ArticleAnalyzer analyzer = (ArticleAnalyzer) mapper.get(source).newInstance();

        String text = analyzer.fetchURLText(stringURL);

        return text.split("[ ]").length;
    }

    public String fetchURLText(String url) throws Exception {
        String html = getAsyncHTML(url);

        return extractText(html);
    }

    public String getAsyncHTML(String stringURL) throws Exception {
        AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
                .setFollowRedirects(true)
                .setMaximumNumberOfRedirects(10)
                .setMaxRequestRetry(3)
                .build();
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient(config);
        Future<Response> f = asyncHttpClient.prepareGet(stringURL).execute();
        Response r = f.get();
        asyncHttpClient.close();
        return r.getResponseBody();
    }

    public abstract String extractText(String html) throws Exception;
}
