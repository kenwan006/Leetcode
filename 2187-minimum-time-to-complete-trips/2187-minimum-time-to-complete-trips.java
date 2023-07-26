class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        //find the max t in time
        int maxTime = 0;
        for (int ti : time) maxTime = Math.max(maxTime, ti);
        long lo = 1, hi = (long) maxTime * totalTrips; //use long type
        
        //binary search
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (validate(time, mid, totalTrips)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    //given time t, check if the total completed trips >= totalTrips
    private boolean validate(int[] time, long t, int totalTrips) {
        long trips = 0;
        for (int ti : time) trips += Math.floor(t / ti);
        return trips >= totalTrips;
    }
}
//Time: O(n * log(m * n)) - n is the length of time, m is the maxTime 
//Space: O(1)