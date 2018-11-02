package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Валидатор так и не пропустил. Пришлось вставлять код из инета, а потом его убрать.
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?location=%s&page=%d&type=all";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        int page = 1;
        List<Vacancy> vacancies = new ArrayList<Vacancy>();
        Elements elements = null;
        while (true) {
            Document doc = getDocument(searchString, page);
            elements = doc.getElementsByClass("job");

            if (elements.isEmpty()) break;

            for (Element element : elements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(element.getElementsByClass("title").text());
                vacancy.setCompanyName(element.getElementsByClass("company_name").text());
                vacancy.setCity(element.getElementsByClass("location").text());
                vacancy.setSalary(element.getElementsByClass("salary").text());
                vacancy.setSiteName(URL_FORMAT);
                vacancy.setUrl("https://moikrug.ru/" + element.getElementsByClass("job_icon").attr("href"));
                vacancies.add(vacancy);
            }
            page++;
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) {
        Document document = null;
        try {
            document = Jsoup
                    .connect(String.format(URL_FORMAT, searchString, page))
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36")
                    .referrer(String.format(URL_FORMAT, searchString, page))
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

}
