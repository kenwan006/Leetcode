class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        int vowels = 0;
        int consonants = 0;
        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
            c = Character.toLowerCase(c);
            
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowels++;
            else if (Character.isLetter(c)) consonants++;
        }
        
        return vowels > 0 && consonants > 0;
    }
}