package com.ivanov.stepan.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomUtils {

    private final static List<String> SURNAME_LIST = new ArrayList(Arrays.asList("Иванов", "Петров", "Сидоров", "Емельяненько"));
    private final static List<String> NAME_LIST = new ArrayList(Arrays.asList("Петр", "Иван", "Егор", "Кирилл", "Стас", "Олег"));
    private final static List<String> PATRONYMIC_LIST = new ArrayList(Arrays.asList("Петрович", "Игоревич", "Егорович", "Степанович", "Олегович"));

    private final static int STRING_LENGTH = 10;

    public static String getString() {
        return RandomStringUtils.randomAlphabetic(STRING_LENGTH);
    }

    public static String getString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static int getInt(int maxValue) {
        if (maxValue == 0)
            return 0;
        else
            return org.apache.commons.lang3.RandomUtils.nextInt(0, maxValue);
    }

    public static String getRandomFullName() {
        String surName = getRandomListValue(SURNAME_LIST).toString();
        String name = getRandomListValue(NAME_LIST).toString();
        String patronymic = getRandomListValue(PATRONYMIC_LIST).toString();
        return surName + " " + name + " " + patronymic;
    }

    public static Object getRandomListValue(List list) {
        return list.get(RandomUtils.getInt(list.size()));
    }

}
