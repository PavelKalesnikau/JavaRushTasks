package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    Controller controller;

    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Киев");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies)  {
        Document xmlDoc = null;
        try {

            xmlDoc = getDocument();

            Elements template = xmlDoc.getElementsByClass("template");
            Elements templateCopy = template.clone();
            // build template
            templateCopy.removeAttr("style");
            templateCopy.removeClass("template");

            // delete unnecessary elements with class "vacancy", leave only with class 'template'
            Elements vcElements = xmlDoc.getElementsByClass("vacancy");
            for (Element vcElement : vcElements) {
                if (!vcElement.hasClass("template")) vcElement.remove();
            }

            // fill xml file with vacancies
            Elements newNodes = new Elements();
            for (Vacancy vacancy : vacancies) {
                Elements newNode = templateCopy.clone();
                for (Element element : newNode.first().children()) {
                    if (element.hasClass("city")) element.text(vacancy.getCity());
                    if (element.hasClass("companyName")) element.text(vacancy.getCompanyName());
                    if (element.hasClass("salary")) element.text(vacancy.getSalary());

                    if (element.hasClass("title")) {
                        Elements tags = element.getElementsByTag("a");
                        Element href = tags.get(0).text(vacancy.getTitle());
                        href.attr("href", vacancy.getUrl());
                    }
                }
                newNodes.addAll(newNode);
            }
//            xmlDoc.getElementsByClass("template").before(newNodes.outerHtml()); // Тоже работает
            template.before(newNodes.outerHtml());

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return xmlDoc.html();
    }

    private void updateFile(String fileContent) throws IOException {

        if (fileContent.isEmpty()) return; // testing
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        writer.write(fileContent);
        writer.close();
    }

    protected Document getDocument() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        StringBuffer buffer = new StringBuffer();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            buffer.append(line);
        }
        reader.close();
        String html = buffer.toString();

        Document xmlDoc = Jsoup.parse(html);

        return xmlDoc;
    }
}
