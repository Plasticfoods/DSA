class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return dfs(src, dst, flights, 0, k);
    }

    private int dfs(int curr, int dst, int[][] flights, int totalCost, int k) {
        if(curr == dst) return totalCost;

        // if the destination flight is present at neighbour return price or return -1
        if(k == 0) {
            for(int i=0 ; i<flights.length ; i++) {
                if(flights[i][0]==curr && flights[i][1]==dst) return totalCost + flights[i][2];
            }
            return -1;
        }

        // traverse all routes
        int minCost = -1;
        for(int i=0 ; i<flights.length ; i++) {
            if(flights[i][0] == curr) {
                int next = flights[i][1];
                int price = flights[i][2];

                int currCost = dfs(next, dst, flights, totalCost+price, k-1);
                
                if(minCost == -1) minCost = currCost;
                else if(currCost != -1) minCost = Math.min(currCost, minCost);
            }
        }

        return minCost;
    }
}