package com.javarush.task.task34.task3412;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;


/* 
Добавление логирования в класс
*/

public class Solution1 {
    private static final Logger logger = LoggerFactory.getLogger(Solution1.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution1(int value1, String value2, Date value3) {
//        logger.trace("Create Solution");
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug(String.format("constructor (value1 = %d, value2 = %s, value3 = %tT)", value1, value2, value3));
        }

        public static void main (String[]args) throws IOException {
            BasicConfigurator.configure();
            Solution1 solution = new Solution1(1, "string", new Date());
            solution.calculateAndSetValue3(23);
            solution.printString();
            solution.divide(3,0);

        }

        public void calculateAndSetValue3 ( long value){
            logger.trace("Calculate of value3");
            value -= 133;
            if (value > Integer.MAX_VALUE) {
                value1 = (int) (value / Integer.MAX_VALUE);
                logger.debug(String.format("calculate value 1 = %d", value1));
            } else {
                value1 = (int) value;
                logger.debug(String.format("calculate value 1 = %d", value1));
            }
        }

        public void printString () {
            logger.trace("method printString");
            if (value2 != null) {
                System.out.println(value2.length());
            }
        }

        public void printDateAsLong () {
            logger.trace("method printDateAsLong");
            if (value3 != null) {
                System.out.println(value3.getTime());
            }
        }

        public void divide ( int number1, int number2){
            logger.trace("method divide");
            try {
                System.out.println(number1 / number2);
            } catch (ArithmeticException e) {
                logger.error(String.format("Arithmetic error of %d/%d", number1, number2), e);
            }
        }

        public void setValue1 ( int value1){
            this.value1 = value1;
            logger.debug(String.format("Set value1 = %d", value1));
        }

        public void setValue2 (String value2){
            this.value2 = value2;
            logger.debug(String.format("Set value2 = %d", value2));
        }

        public void setValue3 (Date value3){
            this.value3 = value3;
            logger.debug(String.format("Set value3 = %d", value3));
        }
    }
