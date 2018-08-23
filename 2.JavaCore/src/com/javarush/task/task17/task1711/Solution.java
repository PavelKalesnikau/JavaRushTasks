package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

// Тестовые данные
// -c Сидоров м 15/04/1990 Лялина ж 11/02/1994 Юдина ж 21/06/1992
// -u 0 Сидоров м 15/04/1990 1 Лялина ж 11/02/1994
// -d 2
// -i 2

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if (args.length == 0) return;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    addPersons(args);
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    updatePersons(args);
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    deletePersons(args);
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    infoPersons(args);
                    break;
                }
        }
    }

    private static void infoPersons(String[] args) {
        Person person = null;
        for (int k = 1; k < args.length; k++) {
            try {
                person = allPeople.get(Integer.parseInt(args[k]));
                String name = person.getName();
                String sex = person.getSex() == Sex.MALE ? "м" : "ж";
                String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
                System.out.println(name + " " + sex + " " + bd);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    private static void deletePersons(String[] args) {
        Person person = null;
        for (int k = 1; k < args.length; k++) {
            person = allPeople.get(Integer.parseInt(args[k]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
        return;
    }

    private static void updatePersons(String[] args) {
        Person person = null;
        int i = 1, j = 0;
        while (i < args.length) {
            j = i;
            i += 4;
            try {
                person = allPeople.get(Integer.parseInt(args[j]));
                person.setName(args[j + 1]);
                switch (args[j + 2]) {
                    case "м":
                        person.setSex(Sex.MALE);
                        break;
                    case "ж":
                        person.setSex(Sex.FEMALE);
                        break;
                }
                person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy").parse(args[j + 3]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addPersons(String[] args) {
        Person person = null;
        int i = 1, j = 0;
        while (i < args.length) {
            j = i;
            i += 3;
            try {
                if ("м".equals(args[j + 1]))
                    person = Person.createMale(args[j], new SimpleDateFormat("dd/MM/yyyy").parse(args[j + 2]));
                else
                    person = Person.createFemale(args[j], new SimpleDateFormat("dd/MM/yyyy").parse(args[j + 2]));
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));
                person = null;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
