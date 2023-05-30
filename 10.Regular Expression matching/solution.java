public class Solution {
    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int s1, int s2) {
        if (s1 == s.length() && s2 == p.length()) {
            return true;
        }
        if (s2 == p.length()) {
            return false;
        }
        if (s2 == p.length() - 1 || p.charAt(s2 + 1) != '*') {
            // normal check
            if (s1 < s.length() && (p.charAt(s2) == '.' || s.charAt(s1) == p.charAt(s2))) {
                return match(s, p, s1 + 1, s2 + 1);
            } else {
                return false;
            }
        } else {
            // * as zero
            if (match(s, p, s1, s2 + 2)) {
                return true;
            }
            // * as not zero
            if (s1 < s.length() && ((p.charAt(s2) == '.' || s.charAt(s1) == p.charAt(s2)) && match(s, p, s1 + 1, s2))) {
                return true;
            }
        }
        return false;
    }
}