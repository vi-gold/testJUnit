package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @BeforeAll
    public static void BeforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void BeforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("AfterAll");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("AfterEach");
    }


    @ParameterizedTest(name = "#{index} - сложение {0} и {1}, ожидаем {2}")
    @DisplayName("Проверка суммирования")
    @CsvSource({"0, 0, 0", "5, 2, 7", "77, 62, 139"})
    @Tag("plus")
    void summ(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.summ(a, b);
        Assertions.assertEquals(expectedResult , result, "Не тот ответ");
    }

    @ParameterizedTest(name = "#{index} - вычитание {0} и {1}, ожидаем {2}")
    @DisplayName("Проверка вычитания")
    @CsvSource({"0, 0, 0", "5, 2, 3", "77, 62, 15"})
    @Tag("minus")
    void subtract(int a, int b, int expectedResult) {
        Calc calc = new Calc();
        int result = calc.subtract(a, b);
        Assertions.assertEquals(expectedResult , result, "Не тот ответ");
    }
}