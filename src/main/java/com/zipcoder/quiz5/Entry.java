package com.zipcoder.quiz5;

import java.util.Objects;

/**
 * A class that store the word and its getCommonWord.
 * Modify the class as you see fit.
 */
public class Entry implements Comparable<Entry>{
    private String word;
    private Integer count = 0;

    public Entry(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count += count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(word, entry.word) &&
                Objects.equals(count, entry.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "word='" + word + '\'' +
                ", getCommonWord=" + count +
                '}';
    }

    @Override
    public int compareTo(Entry entry) {
        return (Integer.compare(this.getCount(), entry.getCount()));
    }
}
