package parsers;

import information.CatalogInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChipDipParser implements Runnable{

    private List<CatalogInfo> list;

    public List<CatalogInfo> getList() {
        return list;
    }

    private List<CatalogInfo> getCatalogFirst() throws IOException {
        Document document = Jsoup.connect("https://www.ru-chipdip.by/catalog").get();
        List<CatalogInfo> information = new ArrayList<>();
        Elements aElements = document.getElementsByAttributeValue("class","clear content_main"); //catalog__g2_row
        Elements aElem = document.select("h3");

        aElements.forEach(aElement -> {
            for (Element element:aElem) {
                String url = element.select("a").attr("href");
                String title = element.text();
                information.add(new CatalogInfo(url, title));
            }
        });
        return information;
    }

    public List<CatalogInfo> getCatalog(String urls, String htmlClass) throws IOException {
        List<CatalogInfo> information = new ArrayList<>();
        Document document = Jsoup.connect("https://www.ru-chipdip.by/"+urls).get();
        Elements aElements = document.getElementsByAttributeValue("class",htmlClass);

        aElements.forEach(aElement -> {
            Element aElem;
                if (urls.contains("catalog/ic-chip")) {
                     aElem = aElement.child(0);
                } else aElem = aElement.child(1);
                String url = aElem.select("a").attr("href");
                String title = aElem.text();
                information.add(new CatalogInfo(url, title));
        });
        return information;
    }

    public List<CatalogInfo> getSubsectionCatalog(String urls) throws IOException {
        List<CatalogInfo> information = new ArrayList<>();
        try {
        Document document = Jsoup.connect("https://www.ru-chipdip.by/"+urls).get();
        Elements aElements = document.getElementsByAttributeValue("class","name");

        aElements.forEach(aElement -> {
            Element aElem;
            aElem = aElement.child(0);
            String url = aElem.select("a").attr("href");
            String title = aElem.text();
            information.add(new CatalogInfo(url, title));
        });

        if (information.isEmpty()) {
            aElements = document.getElementsByAttributeValue("class","item__content");
            aElements.forEach(aElement -> {
                Element aElem;
                aElem = aElement.child(1);
                String url = aElem.select("a").attr("href");
                String title = aElem.select("a.link").text();
                information.add(new CatalogInfo(url, title));
            });
        }
        } catch (IOException e) {
            return information;
        }
        return information;
    }

    public String getProduct(String url) throws IOException {
        Document document = Jsoup.connect("https://www.ru-chipdip.by/"+url).get();
        final Elements hElement = document.getElementsByTag("h1");
        String hElemResult= hElement.outerHtml().replace("h1","h4");

        final Elements aElements = document.getElementsByAttributeValue("class","product__about_inner");
        aElements.select("td.ordering-control.ordering__quantity").remove();
        aElements.select("a").removeAttr("href");
        aElements.select("div.ordering-tocart-w").remove();
        aElements.select("table").addClass("table");

        String result = hElemResult + aElements.outerHtml().replace("h3","h4");
        return result;
    }

    @Override
    public void run() {
        try {
            list = getCatalogFirst();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
