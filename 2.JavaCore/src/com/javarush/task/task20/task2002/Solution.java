package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            user1.setFirstName("John");
            user1.setLastName("Memory");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            user1.setBirthDate(sdf.parse("12.01.1978"));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user2 = new User();
            user2.setFirstName("Lara");
            user2.setLastName("Frei");
            user2.setBirthDate(sdf.parse("17.03.1983"));
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            printWriter.flush();

            for (User user : users) {
                user.save(outputStream);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            int size = Integer.parseInt(reader.readLine());
            if (size != 0) users = new ArrayList<User>(size);
            for (int i = 0; i < size; i++) {
                User user = new User();
                user.load(reader);
                users.add(user);
            }
            reader.close();
            isReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
