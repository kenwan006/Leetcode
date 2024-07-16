class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>(); // row -> seats occupied
        for (int[] seat : reservedSeats) {
            int row = seat[0], col = seat[1];
            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }
        
        //check the availability for each row to assign a group of four people
        //remember if certain row is not occupied, then this row won't be in the map
        int m = n - map.size(); //rows without any reservation
        int res = m * 2;
        for (int row : map.keySet()) {
            Set<Integer> set = map.get(row);
            boolean left = false, right = false; //left - 2,3,4,5, right - 6,7,8,9
            if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
                res++;
                left = true;
            }
            if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
                res++;
                right = true;
            }
            if (!left && !right && !set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) res++;
        }
        return res;
    }
}

//Time: O(n); Space: O(n)