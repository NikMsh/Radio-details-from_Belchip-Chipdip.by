package parsers;

import information.CatalogInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BelChipParser {

    public Integer getNumOfPages(String url) throws IOException {
        Document document = Jsoup.connect("http://belchip.by/"+url).get();
        String num;
        try {
            num = document.select(".numpages a").last().text();
        } catch (Exception ex) {
            return null;
        }
        return Integer.valueOf(num);
    }

    public List<CatalogInfo> getCatalog(String urls, String htmlClass) throws IOException {
        Document document = Jsoup.connect("http://belchip.by/"+urls).get();
        List<CatalogInfo> information = new ArrayList<>();
        Elements aElements = document.getElementsByAttributeValue("class",htmlClass);
        information = getInfo(information, aElements);
        if (information.isEmpty() && htmlClass.equals("cat-item")) {
            aElements = document.getElementsByAttributeValue("class", "cat-item");
            information = getInfo(information, aElements);
        }
        else if (information.isEmpty()) {
            aElements = document.getElementsByAttributeValue("class", "list-item");
            information = getInfo(information, aElements);
        }
        return information;
    }

    private List<CatalogInfo> getInfo(List<CatalogInfo> information, Elements aElements) {
        aElements.forEach(aElement -> {
            Element aElem = aElement.child(1);
            String url = aElem.attr("href");
            if (url.isEmpty()) {
                Elements urlH3 = aElem.getElementsByAttribute("href");
                url = urlH3.attr("href");
            }
            String title = aElem.text();

            information.add(new CatalogInfo(url,title));
        });
        return information;
    }

    public String getProduct(String url) throws IOException {
        Document document = Jsoup.connect("http://belchip.by/"+url).get();

        final Elements hElement = document.getElementsByTag("h1");
        String hElemResult= hElement.outerHtml().replace("h1","h4");

        final Elements tableElement = document.getElementsByAttributeValue("class","full-description");
        tableElement.select("td.left-full").remove();
        tableElement.select("div.butt-add1").remove();
        tableElement.select("div.tech").remove();
        /*final Elements aElements = document.getElementsByAttributeValue("class","marg");
        aElements.select("div.butt-add1").remove();
        String str = aElements.outerHtml();*/
        String result = hElemResult + tableElement.outerHtml();
        return result;
    }
}


