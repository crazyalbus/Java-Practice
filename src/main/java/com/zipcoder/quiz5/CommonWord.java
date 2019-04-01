package com.zipcoder.quiz5;

import java.util.*;

public class CommonWord {

    /**
     * Read the text and count each word in the text. Return the word and its
     * count in descending order to see what's the common word used in the text.
     * Store the word and its count in an Entry object.
     * @param text
     * @return a list of word and its count in descending order stored in the object entry
     */
    public List<Entry> getCommonWord(String text) {

        //convert text to array
        String[] words = text.split(" ");

    //hashmap to count
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if(wordMap.putIfAbsent(word.toLowerCase(), 1) != null) {
                Integer count = wordMap.get(word.toLowerCase()) + 1;
                wordMap.replace(word.toLowerCase(), count);
            }
        }

    //convert map to entry objects and add to list
        List<Entry> wordCounts = new ArrayList<>();
        Set<Map.Entry<String, Integer>> results = wordMap.entrySet();
        for (Map.Entry<String, Integer> entry: results) {
            wordCounts.add(new Entry(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordCounts, Collections.reverseOrder());
        return wordCounts;
    }

//
//    public static Comparator<Entry> sortByNumber = new Comparator<Entry>() {
//        public int compare(Entry word1, Entry word2) {
//            return Integer.compare(word1.getCount(), word2.getCount());
//        }
//    };

}
