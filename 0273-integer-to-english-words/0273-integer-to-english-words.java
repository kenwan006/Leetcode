class Solution {
    private final String[] BELOW_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }
    
    private String helper(int num) {
        String res = "";
        if (num < 20) {
            res = BELOW_TWENTY[num];
        } else if (num < 100) {
            res = TENS[num / 10] + " " + BELOW_TWENTY[num % 10];
        } else if (num < 1000) {
            res = BELOW_TWENTY[num / 100] + " Hundred " + helper(num % 100);
        } else if (num < 1000000) {
            res = helper(num / 1000) + " Thousand " + helper(num % 1000);
        } else if (num < 1000000000) {
            res = helper(num / 1000000) + " Million " + helper(num % 1000000);
        } else {
            res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        }
        return res.trim();
    }
}