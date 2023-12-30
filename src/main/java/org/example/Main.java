package org.example;

import java.util.HashMap;

public class Main {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> alpha = new HashMap<>();
        alpha.put(pattern.charAt(0), words[0]);

        int i = 1;
        int j = 1;
        Character ch;
        while (i < pattern.length()) {
            ch = pattern.charAt(i);
            if (!alpha.containsKey(ch) && !alpha.containsValue(words[j])) {
                alpha.put(ch, words[j]);
            } else if (alpha.containsKey(ch) && !alpha.get(ch).equals(words[j])) {
                return false;
            } else if (!alpha.containsKey(ch) && alpha.containsValue(words[j])){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}