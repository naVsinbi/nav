package com.navillera.nav;

import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

public class HtmlUnitWebScrapingLiveTest {

    private WebClient webClient;

    @Test
    public void givenBaeldungArchive_whenRetrievingArticle_thenHasH1() throws Exception {
        webClient = new WebClient();
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        final String url = "http://www.baeldung.com/full_archive";
        final HtmlPage page = webClient.getPage(url);
        final String xpath = "(//ul[@class='bca-archive__monthlisting']/li)[1]/a";
        final HtmlAnchor latestPostLink = (HtmlAnchor) page.getByXPath(xpath).get(0);
        final HtmlPage postPage = latestPostLink.click();

        final List<Object> h1 = postPage.getByXPath("//h1");

        System.out.println(page.getTextContent());
        System.out.println(page.toString());
        System.out.println(page.getBody().asNormalizedText());
        System.out.println(h1.size() > 0);

        webClient.close();
    }
}
