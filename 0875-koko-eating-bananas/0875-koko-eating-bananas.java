/** Binary Search 
* Find the left and right boundary in the binary search
* left means the min eating speed = 1; right means the max eating speed = max pile in the piles
* Find the min speed such that Koko eat all bananas exactly in h hours
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //Initial boundries 
        int l = 1;
        int r = 1;
        for (int pile : piles) r = Math.max(r, pile);
        
        //Binary search
        while (l < r) {
            int mid = l + (r - l) / 2;
            int t = 0;
            for (int pile : piles) t += Math.ceil(pile * 1.0 / mid); // total time needed in speed of mid
    
            if (t > h) 
                l = mid + 1;
            else 
                r = mid;
        }
        return l;
    }
}

//Time: O(n*logn); Space: O(1);