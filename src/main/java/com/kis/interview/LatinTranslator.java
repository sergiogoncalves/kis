package com.kis.interview;

import com.kis.interview.util.TranslatorUtils;

import static com.kis.interview.util.TranslatorUtils.checkIfHasNoLetters;
import static com.kis.interview.util.TranslatorUtils.capitalLetter;
import static com.kis.interview.util.TranslatorUtils.checkVowel;
import static com.kis.interview.util.TranslatorUtils.pontuationSignal;

public class LatinTranslator {


    public static void main(String[] args) {
        System.out.println(TranslatorUtils.bringPhraseTransation("Hey buddy, get away from my car!"));

        System.out.println(TranslatorUtils.bringPhraseTransation("No persons under 14 admitted"));
    }


}
