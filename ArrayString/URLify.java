package ArrayString;

public class URLify {
    /**
     * Method that go thourgh from the end to the begining
     * in a char array.
     */
    public static String toUrl(char[] s, int len) {
        int numberOfSpaces = countOfChar(s, 0, len, ' ');
        int newIndex = len - 1 + numberOfSpaces * 2;

        if (newIndex + 1 < s.length) s[newIndex + 1] = '\0';

        for (int oldIndex = len - 1; oldIndex >= 0; oldIndex -= 1) {
            if (s[oldIndex] == ' ') {
                s[newIndex] = '0';
                s[newIndex - 1] = '2';
                s[newIndex - 2] = '%';
                newIndex -= 3;
            } else {
                s[newIndex] = s[oldIndex];
                newIndex -= 1;
            }
        } 

        return new String(s);
    }


    /**
     * 
     */
    private static int countOfChar(char[] array, int start, int end, char target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (array[i] == target) count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        
    }
}