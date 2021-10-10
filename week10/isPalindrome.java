class Solution {
    private boolean isPalindrome(String s, int f, int e) {
        while(f<e) {
            if(s.charAt(f++)!=s.charAt(e--)) 
                return false;;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int len = s.length()-1,count=0;
        for(int i=0;i<len/2;i++) {
            if(s.charAt(i)!=s.charAt(len-i))
            {
                return (isPalindrome(s,i+1,len-i) || isPalindrome(s,i,len-i-1));
            }
        }
        return true;
    }
}