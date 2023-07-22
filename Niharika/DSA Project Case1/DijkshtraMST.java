import java.util.*;

class DijkshtraMST {
    private int V;
    private List<List<Edge>> adj;

    class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    DijkshtraMST(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge(dest, weight);
        adj.get(src).add(edge);
    }

    void dijkstra(int src, int k) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited,k);
            visited[u] = true;

            for (Edge edge : adj.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    
                }
            }
        }

        printSolution(dist,k);
    }

    int minDistance(int[] dist, boolean[] visited, int k) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void printSolution(int[] dist, int k) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int t=1;
        while(t>0){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1 for Graph 1 MST\n"+"Enter 2 for Graph 2 MST\n"+"Enter 3 for Graph 3 MST\n"+"Enter 4 for mean(average), median, maximum and minimum values of the MSTs\n"+"Enter any other number to exit the loop\n");
        int k=sc.nextInt();
        int V = 6;
        DijkshtraMST graph = new DijkshtraMST(V);
        if(k==1){
        //List for Graph G1
        graph.addEdge(4, 5, 2);
        graph.addEdge(5, 0, 2);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 0, 4);
        graph.addEdge(2, 1, 5);
        graph.addEdge(3, 1, 2);
        graph.addEdge(5, 4, 2);
        graph.addEdge(0, 5, 2);
        graph.addEdge(3, 2, 2);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 2);
        graph.dijkstra(0,k);
        }
        
        else if(k==2){
        //List for Graph G2
        graph.addEdge(0, 0, 1);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 2);
        graph.addEdge(0, 0, 1);
        graph.addEdge(1, 0, 2);
        graph.addEdge(3, 0, 6);
        graph.addEdge(2, 1, 2);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 2, 2);
        graph.addEdge(4, 3, 2);
        graph.addEdge(5, 4, 2);
        graph.dijkstra(0,k);
        }

        else if(k==3){
        //List for Graph G3
        graph.addEdge(0, 0, 1);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 2);
        graph.addEdge(0, 0, 1);
        graph.addEdge(1, 0, 2);
        graph.addEdge(3, 0, 6);
        graph.addEdge(2, 1, 2);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 2, 2);
        graph.addEdge(4, 3, 2);
        graph.addEdge(5, 4, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(4, 2, 5);
        graph.dijkstra(0,k);
        }
        else if(k==4){
            Calculations cal = new Calculations();
            Calculations.valuesCalculation(null);
        }
        else{
            System.out.println("Invalid input, exiting the loop");
            break;
        }
        t++;
    }
}

}


class Calculations{
    public static void valuesCalculation(String[] args){
    //calculates the mean of every graph G1, G2, G3
    int [] shortestDistG1 = {0,6,6,4,4,2};
    int [] shortestDistG2 = {0,2,4,6,8,10};
    int [] shortestDistG3 = {0,2,4,6,8,10};
    int meanG1;
    int meanG2;
    int meanG3;
    int sumG1=0;
    int sumG2=0;
    int sumG3=0;
    for(int j=0;j<6;j++){
        sumG1+= shortestDistG1[j];
        sumG2+= shortestDistG2[j];
        sumG3+= shortestDistG3[j];
    }
    meanG1 = sumG1/6;
    meanG2 = sumG2/6;
    meanG3 = sumG3/6;

    Calculations.meanOfMSTs(meanG1, meanG2, meanG3);
    
    //calculates the median of every graph G1, G2, G3
    Arrays.sort(shortestDistG1);
    Arrays.sort(shortestDistG2);
    Arrays.sort(shortestDistG3);
    int medianG1 = shortestDistG1.length / 2;
    if(sumG1 % 2==0){
        int medianG1Value1 = shortestDistG1[medianG1-1];
        int medianG1Value2 = shortestDistG1[medianG1-1];
        medianG1 = (medianG1Value1 + medianG1Value2) / 2;
    }
    int medianG2 = shortestDistG2.length / 2;
    if(sumG2 % 2==0){
        int medianG2Value1 = shortestDistG2[medianG2-1];
        int medianG2Value2 = shortestDistG2[medianG2-1];
        medianG1 = (medianG2Value1 + medianG2Value2) / 2;
    }
    int medianG3 = shortestDistG3.length / 2;
    if(sumG3 % 2==0){
        int medianG3Value1 = shortestDistG3[medianG3-1];
        int medianG3Value2 = shortestDistG3[medianG3-1];
        medianG1 = (medianG3Value1 + medianG3Value2) / 2;
    }
    Calculations.medianOfMSTs(medianG1,medianG2,medianG3);

    //calculates the maximum and minimum of every graph G1, G2, G3
    Arrays.sort(shortestDistG1);
    int temp1;
    for(int i=0;i<shortestDistG1.length;i++){
        for(int j=i+1;j<shortestDistG1.length;j++){
            if(shortestDistG1[i]>shortestDistG1[j]){
                temp1=shortestDistG1[i];
                shortestDistG1[i]=shortestDistG1[j];
                shortestDistG1[j]= temp1;
            }
        }
    }
    int maxG1 = shortestDistG1[shortestDistG1.length - 1];
    int minG1 = shortestDistG1[0];
    Arrays.sort(shortestDistG2);
    int temp2;
    for(int i=0;i<shortestDistG2.length;i++){
        for(int j=i+1;j<shortestDistG2.length;j++){
            if(shortestDistG2[i]>shortestDistG2[j]){
                temp2=shortestDistG2[i];
                shortestDistG2[i]=shortestDistG2[j];
                shortestDistG2[j]= temp2;
            }
        }
    }
    int maxG2 = shortestDistG2[shortestDistG2.length - 1];
    int minG2 = shortestDistG2[0];
    Arrays.sort(shortestDistG3);
    int temp3;
    for(int i=0;i<shortestDistG3.length;i++){
        for(int j=i+1;j<shortestDistG3.length;j++){
            if(shortestDistG3[i]>shortestDistG3[j]){
                temp3=shortestDistG3[i];
                shortestDistG3[i]=shortestDistG3[j];
                shortestDistG3[j]= temp3;
            }
        }
    }
    int maxG3 = shortestDistG3[shortestDistG3.length - 1];
    int minG3 = shortestDistG3[0];
    Calculations.maximumOfMSTs(maxG1,maxG2,maxG3);
    Calculations.minimumOfMSTs(minG1,minG2,minG3);
}

    //calculates mean of the three mst
    public static void meanOfMSTs(int meanG1, int meanG2, int meanG3) {
        int totalWeight = meanG1 + meanG2 + meanG3 ;
        System.out.println("The Mean of three MSTs:"+" "+ totalWeight / 3);
    }
    //calculates the median of the three mst
    public static void medianOfMSTs(int medianG1, int medianG2, int medianG3) {
        int[] medians = {medianG1, medianG2, medianG3};
        Arrays.sort(medians);
        int medianFinal = medians.length / 2;

        if (medians.length % 2 == 0) {
            // Even number of elements, take the average of the two middle values
            double medianValue1 = medians[medianFinal - 1];
            double medianValue2 = medians[medianFinal];
            System.out.println("The Median of three MSTs:"+" "+ (medianValue1 + medianValue2) / 2);
        } else {
            // Odd number of elements, return the middle value
            System.out.println("The Median of three MSTs:"+" "+  medians[medianFinal]);
        }
    }
    //calculates the maximum of the three mst
    public static void maximumOfMSTs(int maxG1, int maxG2, int maxG3) {
        int maxMST = Math.max(maxG1, Math.max(maxG2, maxG3));
        System.out.println("The Maximum of three MSTs:"+" "+ maxMST);
    }
    //calculates the minimum of the three mst
    public static void minimumOfMSTs(int minG1, int minG2, int minG3) {
        int minMST = Math.min(minG1, Math.min(minG2, minG3));
        System.out.println("The Minimum of three MSTs:"+" "+ minMST);
    }
}