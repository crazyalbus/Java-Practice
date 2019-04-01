package com.zipcoder.quiz5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissingCharacter {

    /**
     * Given a text, return a list of all the characters that are missing from
     * the text. For example, if the text is `abc`, then the missing chars
     * are `defghijklmnopqrstuvwxyz`.
     * @param text
     * @return a list of all the missing characters from the text
     */
    String textToCheck;

    public List<Character> getMissingChars(String text) {
        textToCheck = text;
        Character[] alphaArray = toCharacterArray("abcdefghijklmnopqrstuvwxyz");
        Stream<Character> alphaStream = streamFromArray(alphaArray);
        List<Character> missing = alphaStream.collect(Collectors.toList());
        return missing;
    }

    public Character[] toCharacterArray(String text) {
        Character[] characterArray = new Character[text.length()];
        for(int i=0; i<text.length(); i++){
            characterArray[i] = Character.valueOf(text.charAt(i));
        }
        return characterArray;
    }


    public Stream<Character> streamFromArray(Character[] characterArray) {
        Stream<Character> characterStream = Arrays.stream(characterArray).filter(this::notInString);
        return characterStream;
    }


    public boolean notInString(char character){
        char[] textArray = textToCheck.toCharArray();
        for (char c: textArray) {
            if((character == Character.toLowerCase(c)) || !Character.isAlphabetic(character)) {
                return false;
            }
        }
        return true;
    }
}
