package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class GroupAnagram {
    /**
     * This question ask the user to group the anagrams together.
     * So we don't actually need to sort the array.
     */
    public void sort(String[] array) {
        HashMap<String, ArrayList<String>> mapList = new HashMap<>();

        for (String s : array) {
            String key = sortChars(s);
            mapList.get(key).add(s);
        }

        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index += 1;
            }
        }
    }

    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}

class AnagramComparator implements Comparator<String> {
    private String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}