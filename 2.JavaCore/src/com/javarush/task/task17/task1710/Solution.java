package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

// Тестовые данные
// -c Сидоров м 15/04/1990
// -u 2
// -d 2
// -i 2
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args.length == 0) return;

        Person person = null;

        if ("-c".equals(args[0])) {
            try {
                if ("м".equals(args[2]))
                    person = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                else person = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if ("-u".equals(args[0])) {
            try {
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                switch (args[3]) {
                    case "м":
                        person.setSex(Sex.MALE);
                        break;
                    case "ж":
                        person.setSex(Sex.FEMALE);
                        break;
                }
                person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[4]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if ("-d".equals(args[0])) {
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        } else if ("-i".equals(args[0])) {
            try {
                person = allPeople.get(Integer.parseInt(args[1]));
                String name = person.getName();
                String sex = person.getSex() == Sex.MALE ? "м" : "ж";
                String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
                System.out.println(name + " " + sex + " " + bd);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}








