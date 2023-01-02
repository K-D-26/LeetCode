class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2)
            return true;
        
        boolean c1 = Character.isUpperCase(word.charAt(0));
        boolean c2 = Character.isUpperCase(word.charAt(1));
        
        if(c1 == true && c2 == true) {
            for(int i=2; i<word.length(); i++) {
                if(!Character.isUpperCase(word.charAt(i)))
                    return false;
            }
            return true;
        }
        
        else if(c1 == true && c2 == false) {
            for(int i=2; i<word.length(); i++) {
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
            }
            return true;
        }
        
        else if(c1 == false && c2 == false) {
            for(int i=2; i<word.length(); i++) {
                if(Character.isUpperCase(word.charAt(i)))
                    return false;
            }
            return true;
        }
        
        return false;
    }
}
