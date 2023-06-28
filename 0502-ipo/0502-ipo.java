class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        class Project {
            int profit;
            int capital;
            public Project(int profit, int capital) {
                this.profit = profit;
                this.capital = capital;
            }
        }
        
        Comparator<Project> comparator = new Comparator<>() {
            @Override
            public int compare(Project p1, Project p2) {
                return p1.capital - p2.capital;
            }
        };
        
        //create n projects and sort by the capital in ascending order
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects, comparator);
        
        //Find the project with capital <= w, add their profit to a max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int i = 0; // iterate over the project array
        for (int j = 0; j < k; j++) {
            while (i < n && projects[i].capital <= w) heap.offer(projects[i++].profit);
            if (!heap.isEmpty()) w += heap.poll();
        }
        return w;
    }
}
//Time: O(n * log(n)); Space: O(n)
