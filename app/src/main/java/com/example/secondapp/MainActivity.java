package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // задание полей
    float TelescopePrice = 14_000; // стоимость телескопа
    int account = 1000; // счёт пользователя
    float stipend = 2500; // заработная плата в месяц
    int percentFree = 100; // доля заработной платы на любые траты
    float percentBank = 5; // годовая процентная ставка
    float[] monthlyPayments = new float[120]; // создание массива ежемесячных платежей на 10 лет

    // метод подсчёта стоимости телескопа с учётом первоначального взноса
    private float apartmentPriceWithContribution() {
        return TelescopePrice - account; // возврат подсчитанного значения
    }

    // метод подсчёта ежемесячных трат на телескоп (стипендия, процент своб.трат)
    public float monthSavings(float amount, int percent) {
        return (amount*percent)/100;
    }

    // метод подсчёта времени выплаты ипотеки (сумма долга, сумма платежа, годовой процент)
    // и заполнение массива monthlyPayments[] ежемесячными платежами
    public int countMonth(float total, float monthSavings, float percentBankYear) {

        float percentBankMonth = percentBankYear / 12; // подсчёт ежемесячного процента банка
        int count = 0; // счётчик месяцев накопления

        // алгоритм расчёта накопления
        while (total>0) {
            count++; // добавление нового месяца платежа
            // заполнение массива ежемесячными платежами по накоплению
            // если сумма больше то
            // иначе
            // в массив добавляется платёж равный остатку накопления
            monthlyPayments[count - 1] = Math.min(total, monthSavings); // в массив добавляется целый платёж

            total = (total + (total*percentBankMonth)/100) - monthSavings; // вычисление
        }

        return count;
    }

    // вывод на экран полученных значений
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        // создание дополнительных полей для вывода на экран полученных значений
        // поле вывода количества месяцев выплаты накоплений
        TextView countOut = findViewById(R.id.countOut); // вывод информации количества месяцев выплаты
        // поле выписки по ежемесячным платежам
        TextView manyMonthOut = findViewById(R.id.manyMonthOut); // вывод информации выписки по ежемесячным платежам

        // запонение экрана
        // 1) вывод количества месяцев выплаты
        countOut.setText("Потребуется " + countMonth(apartmentPriceWithContribution(), monthSavings(stipend, percentFree),percentBank) + " месяцев");
        // 2) подготовка выписки
        String monthlyPaymentsList = "";
        for(float list : monthlyPayments) {
            if (list > 0) {
                monthlyPaymentsList = monthlyPaymentsList + list + " монет ";
            } else {
                break;
            }
        }
        // 3) вывод выписки ежемесячных выплат
        manyMonthOut.setText("Первоначальный взнос " + account + " монет, ежемесячные выплаты: " + monthlyPaymentsList);
    }
}