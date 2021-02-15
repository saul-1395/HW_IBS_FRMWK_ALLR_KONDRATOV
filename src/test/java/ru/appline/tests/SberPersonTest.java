package ru.appline.tests;

import org.junit.jupiter.api.Test;
import ru.appline.baseTests.BaseTests;

import static java.lang.Thread.sleep;
import static ru.appline.framework.utils.OffOn.OFF;
import static ru.appline.framework.utils.OffOn.ON;


public class SberPersonTest extends BaseTests {
    @Test
    public void test() {

        app.getStartPage().selectServiceTopMenuClick("Ипотека")
                .checkVisibleDropDownMenu()
                .selectServiceDropDownMenuClick("Ипотека на готовое жильё")
                .scrollToHeader("Кредитный калькулятор")
                .goToFraim()
                .inputValueToListForFieldName("Стоимость недвижимости", "5180000")
                .inputValueToListForFieldName("Первоначальный взнос", "3058000")
                .inputValueToListForFieldName("Срок кредита", "30")
                .scrollToHeader("Дополнительные услуги, снижающие ставку по кредиту")
                .clickToggleButton("Скидка 0,3% при покупке квартиры на ДомКлик", OFF)
                .clickToggleButton("Страхование жизни и здоровья", OFF)
                .clickToggleButton("Молодая семья", ON)
                .clickToggleButton("Электронная регистрация сделки", OFF)
                .scrollToHeader("Есть зарплатная карта СберБанка")
                .checkCalculateList("Ежемесячный платеж", "29 346")
                .checkCalculateList("Сумма кредита", "3 680 000")
                .checkCalculateList("Необходимый доход", "37 777")
                .checkCalculateList("Процентная ставка", "11%")
        ;
    }
}
