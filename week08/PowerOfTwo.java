class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.toBinaryString(n).replace("0","").equals("1");
    }
}