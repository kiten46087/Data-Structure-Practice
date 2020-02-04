package ArrayString;

public class OneEdit {
    /**
     * My method using substring not optimized.
     */
    public boolean oneEdit(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 == len2) return compareSameLen(s1, s2);

        if (Math.abs(len1 - len2) != 1) return false;

        if (len1 < len2) {
            for (int i = 0; i < s2.length(); i++) {
                String temp = "";
                temp = s2.substring(0, i) + s2.substring(i + 1, s2.length());
                if (temp.equals(s1)) return true;
            }
        } else {
            for (int i = 0; i < s1.length(); i++) {
                String temp = "";
                temp = s1.substring(0, i) + s1.substring(i + 1, s1.length());
                if (temp.equals(s2)) return true;
            }
        }
        return false;
    }

    /**
     * Helper method which compares two strings
     */
    public boolean compareSameLen(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) 
                diff += 1;
        }             

        return diff == 1;
    }


    /**
     * Optimized solution no need to do loop check for two situtation.
     */
    public boolean oneEditConcise(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        if (ns > nt) return oneEditConcise(t, s);

        if (nt - ns > 1) return false;

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != s.charAt(i)) {
                if (ns == nt) 
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else 
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return (ns + 1 == nt);
    }


    /**
     * Optimized solution, more compact two pointer and inside one loop.
     */
    public boolean oneEditCompact(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) return false;

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;

                if (s1.length() == s2.length())
                    index1 += 1;
            } else {
                index1 += 1;
            }
            index2 += 1;
        }

        return true;
    }

    public static void main(String[] args) {
        OneEdit test = new OneEdit();
        System.out.println(test.oneEdit("pale", "bale"));
        System.out.println(test.oneEdit("pale", "ale"));
        System.out.println(test.oneEdit("ale", "pale"));
        System.out.println(test.oneEdit("bxale", "pale"));
    }
}