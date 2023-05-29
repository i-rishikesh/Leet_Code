class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int o = x; // original num
        int r = 0; // reversed num

        while (o >= 10) {
            r *= 10;
            r += o % 10;
            o /= 10;
        }

        return r == x / 10;
    }
}