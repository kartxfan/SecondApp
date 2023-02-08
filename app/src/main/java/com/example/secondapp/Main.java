package com.example.secondapp;

public class Main {

    // задание полей
    static double TelescopePrice = 14_000; // стоимость телескопа
    static double account = 1000; // счЄт пользовател€
    static double stipend = 2500; // стипенди€
    static double percentBank = 5; // годова€ процентна€ ставка на счету
    static double procentMonth = 5.0 / 12.0; // мес€чна€ процентна€ ставка на счету

    static double countMonth = 0;

    static String result = "";


    public static void main(String[] args) {
        System.out.println("ѕотребовалось " + countMonth() + " мес€цев ");
        System.out.println("ќсталось " + (account - TelescopePrice) + " монет ");
        System.out.println(result);
    }


    /**
     * ћетод расчета количества мес€цев
     * @return количество мес€цев
     */
    static double countMonth() {

        while (TelescopePrice > account) {
            countMonth = countMonth + 1; // countMonth++;

            account = account + (account * procentMonth) / 100 + stipend;

            result = result + account + " монет ";
        }

        return countMonth;
    }

}