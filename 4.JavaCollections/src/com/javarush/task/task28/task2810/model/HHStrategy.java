package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Этот класс будет реализовывать конкретную стратегию работы
 *  с сайтом ХэдХантер (http://hh.ua/ и http://hh.ru/).
 *
 */
public class HHStrategy implements Strategy {
    //private static final String URL_FORMAT = "https://hh.ru/search/vacancy?area=115&clusters=true&enable_snippets=true&no_magic=true&text=Java+%s&page=%d";
     private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d"; // for validator

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        int page = 0;
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        Elements elements = null;
        while (true){
            Document doc = getDocument(searchString, page);
            elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements.isEmpty()) break;
            for (Element element : elements ) {
                Vacancy vacancy = new Vacancy();
                vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                vacancy.setSiteName(URL_FORMAT);
                vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                vacancies.add(vacancy);
            }
            page++;
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page){
        Document document = null;
        try {
            document = Jsoup
                    .connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                    .referrer("")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }
}
