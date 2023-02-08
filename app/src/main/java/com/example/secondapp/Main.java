package com.example.secondapp;

public class Main {

    // ������� �����
    static double TelescopePrice = 14_000; // ��������� ���������
    static double account = 1000; // ���� ������������
    static double stipend = 2500; // ���������
    static double percentBank = 5; // ������� ���������� ������ �� �����
    static double procentMonth = 5.0 / 12.0; // �������� ���������� ������ �� �����

    static double countMonth = 0;

    static String result = "";


    public static void main(String[] args) {
        System.out.println("������������� " + countMonth() + " ������� ");
        System.out.println("�������� " + (account - TelescopePrice) + " ����� ");
        System.out.println(result);
    }


    /**
     * ����� ������� ���������� �������
     * @return ���������� �������
     */
    static double countMonth() {

        while (TelescopePrice > account) {
            countMonth = countMonth + 1; // countMonth++;

            account = account + (account * procentMonth) / 100 + stipend;

            result = result + account + " ����� ";
        }

        return countMonth;
    }

}