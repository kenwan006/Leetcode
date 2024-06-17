class Solution {
    public int totalFruit(int[] fruits) {
        //sliding window
        int i = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(); //map fruit type -> freq
        for (int j = 0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            
            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if (map.get(fruits[i]) == 0) map.remove(fruits[i]);
                i++;
            }
            
            //we maintain a sliding window [i..j] containing at most 2 types of fruits
            res = Math.max(res, (j - i + 1));
        }
        return res;
    }
}
