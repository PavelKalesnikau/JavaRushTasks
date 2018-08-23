package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {
        /*IncomeDataUkraine idUkr = new IncomeDataUkraine();
        Customer customer = new IncomeDataAdapter(idUkr);
        Contact contact = new IncomeDataAdapter(idUkr);
        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());
        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());*/
    }


/*
    public static class IncomeDataUkraine implements IncomeData{
        @Override
        public String getCountryCode() {
            return "UA";
        }

        @Override
        public String getCompany() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getContactFirstName() {
            return "Ivan";
        }

        @Override
        public String getContactLastName() {
            return "Ivanov";
        }

        @Override
        public int getCountryPhoneCode() {
            return 38;
        }

        @Override
        public int getPhoneNumber() {
            return 501234567;
        }
    }
*/

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
         /* Мое решение. Не принял валидатор. Хотя результат, как требуется в задании.

         StringBuilder phoneNumber = new StringBuilder(String.valueOf(data.getPhoneNumber()));
            // дополним нули до 10 цифр
            for (int i = 0; i < 10-phoneNumber.length(); i++) {
              phoneNumber.insert(0, "0");
            }
            String index = phoneNumber.substring(0,3);
            String phone = phoneNumber.substring(3,6)+"-"+phoneNumber.substring(6,8)+"-"+phoneNumber.substring(8,10);
            return "+"+data.getCountryPhoneCode()+ "(" + index +")"+phone;*/

         // Решение из интернета
         String phone = String.valueOf(data.getPhoneNumber());
            StringBuilder allNumber = new StringBuilder(data.getCountryPhoneCode());
            if (phone.length()< 10){
                for (int i = 0; i < 10 - phone.length(); i++) {
                    allNumber.insert(0,'0');
                }
            }
            allNumber.append(phone);
            return  String.format( "+" + data.getCountryPhoneCode() + "("+ allNumber.substring(0,3) + ")"
                    + allNumber.substring(3,6) + "-" + allNumber.substring(6,8) + "-" + allNumber.substring(8,10));
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567;
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}