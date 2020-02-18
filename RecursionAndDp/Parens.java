package RecursionAndDp;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Parens {
    /* Naive solution but not quite sufficient build case 2 based on case 1. */
    // For this solution we waste lots of time dealing with duplicate strings.
    public Set<String> generateParens(int remaining) {
        Set<String> set = new HashSet<>();
        if (remaining == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParens(remaining - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        set.add(s);
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    /* Private helper method for the above solution. */
    public String insertInside(String str, int leftIndex) {
        String left = str.substring(0, leftIndex + 1);
        String right = str.substring(leftIndex + 1, str.length());
        return left + "()" + right;
    }

    /*
     * Faster approach build the string from scratch.
     * accoding to the number of the left of right paren.
     */
    public LinkedList<String> generate(int count) {
        char[] str = new char[count * 2];
        LinkedList<String> list = new LinkedList<>();
        addParen(list, count, count, str, 0);
        return list;
    }

    /* Private helper method. */
    private void addParen(LinkedList<String> list, int leftRem, int rightRem, char[] str, int index) {
        // Invalid situation.
        if (leftRem < 0 || rightRem < leftRem) 
            return;
        
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')';
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        } 
    }

    public static void main(String[] args) {
        Parens test = new Parens();
        List<String> testList = test.generate(2);
        for (int i = 0; i < testList.size(); i++) {
            System.out.println(testList.get(i));
        }
    }
}