package ArrayString;

public class StringRotation {
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();

        if (len == s2.length() && len != 0) {
            /* Concatenate the s1 with s1. */
            String s1s1 = s1 + s1;
            return isSusbstring(s1s1, s2);
        }

        return false;
    }

    public boolean isSusbstring(String s1, String s2) {
        return s2.contains(s1);
    }
    
    public static void main(String[] args) {
        String s = "abcde";
        String d = "abc";
        String e ="abd";

        System.out.println(s.contains(d));
        System.out.println(s.contains(e));
    }
}