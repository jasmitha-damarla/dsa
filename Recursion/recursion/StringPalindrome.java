package recursion;

public class StringPalindrome {

    private boolean isPalindrome(String str, int cur) {
        if (cur >= str.length() / 2) {
            return true;
        }
        if (str.charAt(cur) != str.charAt(str.length() - cur - 1)) {
            return false;
        }
        return isPalindrome(str, cur + 1);
    }

    public static void main(String[] args) {
        StringPalindrome stringPalindrome = new StringPalindrome();
        System.out.println(stringPalindrome.isPalindrome("morrie", 0) ? "Yes" : "No");
    }

}
