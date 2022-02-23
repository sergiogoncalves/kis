package com.kis.interview.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class TranslatorUtilsTest {

    @Test
    void shouldCheckCapitalLetter() throws  Exception{

        TranslatorUtils.setCapitalLetterPosition(0);
        Assert.isTrue(TranslatorUtils.capitalLetter("kis").equals("Kis"), "");


        Assert.isTrue(TranslatorUtils.capitalLetter("kiss").equals("kiss"), "");

        TranslatorUtils.setCapitalLetterPosition(0);
        Assert.isTrue(TranslatorUtils.capitalLetter("kis!").equals("Kis!"), "");

    }

    @Test
    void shouldCheckIfHasNoLetters() {

        Assert.isTrue(TranslatorUtils.checkIfHasNoLetters(""), "");
        Assert.isTrue(!TranslatorUtils.checkIfHasNoLetters("kis"), "");
    }

    @Test
    void shouldPontuationSignal() {

        Assert.isTrue(TranslatorUtils.pontuationSignal("kiss!").equals("! "), "");
    }

    @Test
    void shouldCheckVowel() {
        Assert.isTrue(TranslatorUtils.checkVowel('a'), "");
        Assert.isTrue(!TranslatorUtils.checkVowel('b'), "");
    }

    @Test
    void shouldBringTranslation() {

        Assert.isTrue(TranslatorUtils.bringTranslation("No").trim().equals("Onay"), "");

        TranslatorUtils.setCapitalLetterPosition(0);
        Assert.isTrue(TranslatorUtils.bringTranslation("No!").trim().equals("Onay!"), "");

        TranslatorUtils.setCapitalLetterPosition(0);
        Assert.isTrue(TranslatorUtils.bringTranslation("Stop").trim().equals("Opstay"), "");

    }

    @Test
    void shouldbringPhraseTranslation(){

        Assert.isTrue(TranslatorUtils.bringPhraseTransation("No littering").equals("Onay itteringlay"), "");

        Assert.isTrue(TranslatorUtils.bringPhraseTransation("No shirts, no shoes, no service").equals("Onay irtsshay, onay oesshay, onay ervicesay"), "");

        Assert.isTrue(TranslatorUtils.bringPhraseTransation("No persons under 14 admitted").equals("Onay ersonspay underay 14 admitteday"), "");

        Assert.isTrue(TranslatorUtils.bringPhraseTransation("Hey buddy, get away from my car!").equals("Eyhay uddybay, etgay awayay omfray ymay arcay!"), "");

        Assert.isTrue(TranslatorUtils.bringPhraseTransation("I").equals("Iyay"), "");

    }

    @Test
    void shouldCheckIsNumeric(){
        Assert.isTrue(TranslatorUtils.isNumeric("14"), "");
        Assert.isTrue(!TranslatorUtils.isNumeric("kis"), "");
    }
}