package StringManipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringUtil {
    // Counting vowel letters
    public static int countVowels(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray())  // in case user input capital letters
            if (vowels.indexOf(ch) != -1)
                count++;

        return count;
    }

    // A string
    public static String reverse(String str) {
        if (str == null)
            return "";

        //Using String builder class
        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /* Rotations detect like
    ABCD -> DABC
    CDAB -> BCDA
            ABCD
    * */
    public static boolean areRotations(
            String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() &&
                (str1 + str1).contains(str2));
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }
        }

        return output.toString();
    }

    //get most repeated character
    public static char getMaxOccuringChar(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++)
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }

        return result;
    }

    //Sentence capitalize
    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");

        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase()
                    + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }


    //Anagrams that means they have same characters but different orders ABCD = BCDA
    // O(n log n)
    public static boolean areAnagrams(
            String first, String second
    ) {
        if (first == null || second == null)
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    //using histogram
    // O(n)
    public static boolean areAnagram2(
            String first, String second
    ) {
        if (first == null || second == null)
            return false;

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        first = first.toLowerCase(); // if user insert upper case will have diffenet value need convert to lower first
        for (var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++; //a =97 => a -a =0 , b-97 =1

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }

        return true;
    }

    //Palindrome word can be read from both sides like ABBA , MADAM
    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;

        int left = 0; //left pointer
        int right = word.length() - 1; // right point
//compare first with last and every time move left to right and compare if the result always the same its palindrome
        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }


}
