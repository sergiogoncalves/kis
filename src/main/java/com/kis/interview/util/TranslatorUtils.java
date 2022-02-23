package com.kis.interview.util;

import lombok.Setter;

public class TranslatorUtils {

    @Setter
    public static int capitalLetterPosition = 0;

    /***
     * Put the first letter as capital
     * @param word
     * @return
     */
    public static String capitalLetter(String word) {

        if(capitalLetterPosition == 0) {

            capitalLetterPosition++;

            return word.substring(0,1).toUpperCase()+ word.substring(1);
        }

        return word;
    }

    /***
     * Check if the word is empty
     * @param word
     * @return
     */
    public static boolean checkIfHasNoLetters(String word) {

        if(word.equals(""))
            return  true;

        return false;
    }

    /***
     * Find the pontuation
     * @param word
     * @return
     */
    public static String pontuationSignal(String word) {

        char[] str = word.toCharArray();

        for(int i = 0; i < str.length; i++){
            if(str[i] == '!' || str[i] == ',' || str[i] == ';' || str[i] == '.' || str[i] == '?' ||
                    str[i] == '-' || str[i] == '\'' || str[i] == '\"' || str[i] == ':') {
                return (str[i] + " ");
            }
        }

        return " ";
    }

    /***
     * Check if the letter is vowel
     * @param word
     * @return
     */
    public static boolean checkVowel(char word) {

       return "aeiouyAEIOUY".contains(String.valueOf(word));
    }

    /***
     * Does the translation
     * @param word
     * @return
     */
     public static String bringTranslation(String word) {

        if(checkIfHasNoLetters(word)) {
            return "";
        }

        if(isNumeric(word)) return word + " ";

        String firstPart = "";
        String secondPart = "";

        char [] strArr = word.replaceAll("[^a-zA-Z ]", "").toCharArray();
        int firstPosition = 0;

        for (int i = 0; i < strArr.length; i++) {

            if (checkVowel(strArr[i])) {
                firstPosition = i;
                break;
            }
        }

        firstPart =  word.replaceAll("[^a-zA-Z ]", "").substring(0, firstPosition);
        secondPart = capitalLetter(word.replaceAll("[^a-zA-Z ]", "").substring(firstPosition).toString()) ;

        String returningWord = secondPart + firstPart.toLowerCase();
        String pontuation =  pontuationSignal(word);

        return returningWord + (checkIfThereIsConsonants(returningWord) ?  "ay" : "yay"  ) +  pontuation;
    }


    public static String bringPhraseTransation(String words) {

        capitalLetterPosition = 0;

        String[] phrase =  words.split(" ");

        StringBuilder finalTranstation = new StringBuilder();

        for (String internalWord:  phrase) {
            finalTranstation.append(bringTranslation( internalWord));
        }

        return finalTranstation.toString().trim();
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }


    public static boolean checkIfThereIsConsonants(String word) {

        word = word.toLowerCase();

        for (int i = 0; i < word.length(); ++i) {

            char ch = word.charAt(i);

           if("bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".contains(String.valueOf(ch))){
               return true;
           }
        }
         return false;
    }
}
