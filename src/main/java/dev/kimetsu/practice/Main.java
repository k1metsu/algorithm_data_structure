package dev.kimetsu.practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // ГЕНЕРАЦИЯ НОМЕРОВ МАШИН
        List<String> coolNumbers = new ArrayList<>();
        List<String> coolNumbersWithOutRegion = new ArrayList<>();

        String numberplate = "";
        String numberplateWithoutRegion = "";

        char x, y, z;

        List<Character> allowedLetters = new ArrayList<>();
        allowedLetters.add('C');
        allowedLetters.add('M');
        allowedLetters.add('T');
        allowedLetters.add('B');
        allowedLetters.add('A');
        allowedLetters.add('P');
        allowedLetters.add('O');
        allowedLetters.add('H');
        allowedLetters.add('E');
        allowedLetters.add('Y');

        for (Character firstLetter : allowedLetters) {
            x = firstLetter;
            for (int i = 0; i < 10; i++) {
                for (Character secondLetter : allowedLetters) {
                    y = secondLetter;
                    for (Character thirdLetter : allowedLetters) {
                        z = thirdLetter;
                        numberplateWithoutRegion = String.format("%c%d%d%d%c%c", x, i, i, i, y, z);
                        coolNumbersWithOutRegion.add(numberplateWithoutRegion);
                    }
                }
            }
        }

        for (String numberWithoutRegion : coolNumbersWithOutRegion) {
            for (int j = 0; j <= 197; j++) {
                if(j < 10) {
                    numberplate = String.format("%s0%d", numberWithoutRegion, j);
                    coolNumbers.add(numberplate);
                } else {
                    numberplate = String.format("%s%d", numberWithoutRegion, j);
                    coolNumbers.add(numberplate);
                }
            }
        }

    }
}
