class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 1;

        while(l<=r){
            int mid = (l+r)/2;
            if(calculateHours(piles, mid, h)){
                res = mid;
                r = mid-1;
            }
            else
                l = mid+1;
        }
        return res;
    }

    public boolean calculateHours(int[] piles, int ban, int h){
        int hrs = 0;
        for(int pile : piles){
            hrs += Math.ceil((double)pile/(double)ban);
        }
        return hrs<=h;
    }
}
