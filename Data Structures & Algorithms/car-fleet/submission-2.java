class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by starting position ascending
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleet = 0;
        double curfleettime = 0;

        // Iterate from the car closest to the target to the furthest
        for (int i = n - 1; i >= 0; i--) {
            double time = (target - cars[i][0]) / cars[i][1];
            
            if (time > curfleettime) {
                fleet++;
                curfleettime = time; // This car is the new bottleneck for cars behind it
            }
        }
        return fleet;
    }
}