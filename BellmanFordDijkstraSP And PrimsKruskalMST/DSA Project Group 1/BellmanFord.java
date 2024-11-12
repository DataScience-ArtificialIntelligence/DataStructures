import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

    class BellmanFord {
    class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge edge[];

    BellmanFord(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    void ShortestDistance(int src) {
        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edge[j].src;
                int v = edge[j].dest;
                int weight = edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Check for negative-weight cycles
        for (int j = 0; j < E; ++j) {
            int u = edge[j].src;
            int v = edge[j].dest;
            int weight = edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative-weight cycle");
                return;
            }
        }

        printSolution(dist);
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }



    public static void main(String[] args) {
        int V,E;
        int source=0;
        int t=1;
        Scanner sc = new Scanner(System.in);
        while(t>0){
        System.out.println("Enter 1 for Shortest path of Graph 1\n"+"Enter 2 for Shortest path of Graph 2\n"+"Enter 3 for Shortest path of Graph 3\n"+"Enter 4 for mean(average), median, maximum and minimum values of the MSTs\n"+"Enter any other number to exit the loop\n");
        int k= sc.nextInt();
        switch (k){

        case 1:
        V = 6; // Number of vertices in graph
        E = 12; // Number of edges in graph
        BellmanFord graph1 = new BellmanFord(V, E);
        // Add edge 0-5
        graph1.edge[0].src = 0;
        graph1.edge[0].dest = 5;
        graph1.edge[0].weight = 2;

        // Add edge 0-3
        graph1.edge[1].src = 0;
        graph1.edge[1].dest = 3;
        graph1.edge[1].weight = 4;

        // Add edge 3-2
        graph1.edge[2].src = 3;
        graph1.edge[2].dest = 2;
        graph1.edge[2].weight = 2;

        // Add edge 3-1
        graph1.edge[3].src = 3;
        graph1.edge[3].dest = 1;
        graph1.edge[3].weight = 2;

        // Add edge 2-1
        graph1.edge[4].src = 2;
        graph1.edge[4].dest = 1;
        graph1.edge[4].weight = 5;

        // Add edge 5-4
        graph1.edge[5].src = 5;
        graph1.edge[5].dest = 4;
        graph1.edge[5].weight = 2;

        // Add edge 5-0
        graph1.edge[6].src = 5;
        graph1.edge[6].dest = 0;
        graph1.edge[6].weight = 2;

        // Add edge 3-0
        graph1.edge[7].src = 3;
        graph1.edge[7].dest = 0;
        graph1.edge[7].weight = 4;

        // Add edge 2-3
        graph1.edge[8].src = 2;
        graph1.edge[8].dest = 3;
        graph1.edge[8].weight = 2;

        // Add edge 1-3
        graph1.edge[9].src = 1;
        graph1.edge[9].dest = 3;
        graph1.edge[9].weight = 2;

        // Add edge 1-2
        graph1.edge[10].src = 1;
        graph1.edge[10].dest = 2;
        graph1.edge[10].weight = 5;

        // Add edge 4-5
        graph1.edge[11].src = 4;
        graph1.edge[11].dest = 5;
        graph1.edge[11].weight = 2;

        graph1.ShortestDistance(source);
        break;

        case 2:
        //data for G2
        V = 6; // Number of vertices in graph
        E = 15; // Number of edges in graph
        BellmanFord graph2 = new BellmanFord(V, E);
        // Add edge 0-0
        graph2.edge[0].src = 0;
        graph2.edge[0].dest = 0;
        graph2.edge[0].weight = 1;

        // Add edge 0-1
        graph2.edge[1].src = 0;
        graph2.edge[1].dest = 1;
        graph2.edge[1].weight = 2;

        // Add edge 0-3
        graph2.edge[2].src = 0;
        graph2.edge[2].dest = 3;
        graph2.edge[2].weight = 6;

        // Add edge 1-2
        graph2.edge[3].src = 1;
        graph2.edge[3].dest = 2;
        graph2.edge[3].weight = 2;

        // Add edge 1-3
        graph2.edge[4].src = 1;
        graph2.edge[4].dest = 3;
        graph2.edge[4].weight = 4;

        // Add edge 2-3
        graph2.edge[5].src = 2;
        graph2.edge[5].dest = 3;
        graph2.edge[5].weight = 2;

        // Add edge 3-4
        graph2.edge[6].src = 3;
        graph2.edge[6].dest = 4;
        graph2.edge[6].weight = 2;

        // Add edge 4-5
        graph2.edge[7].src = 4;
        graph2.edge[7].dest = 5;
        graph2.edge[7].weight = 5;

        // Add edge 1-0
        graph2.edge[8].src = 1;
        graph2.edge[8].dest = 0;
        graph2.edge[8].weight = 2;

        // Add edge 3-0
        graph2.edge[9].src = 3;
        graph2.edge[9].dest = 0;
        graph2.edge[9].weight = 6;

        // Add edge 2-1
        graph2.edge[10].src = 2;
        graph2.edge[10].dest = 1;
        graph2.edge[10].weight = 2;

        // Add edge 3-1
        graph2.edge[11].src = 3;
        graph2.edge[11].dest = 1;
        graph2.edge[11].weight = 4;

        // Add edge 3-2
        graph2.edge[12].src = 3;
        graph2.edge[12].dest = 2;
        graph2.edge[12].weight = 2;

        // Add edge 4-3
        graph2.edge[13].src = 4;
        graph2.edge[13].dest = 3;
        graph2.edge[13].weight = 2;

        // Add edge 5-4
        graph2.edge[14].src = 5;
        graph2.edge[14].dest = 4;
        graph2.edge[14].weight = 5;

        graph2.ShortestDistance(source);
        break;
        
        case 3:
        //data for G3
        V = 6; // Number of vertices in graph
        E = 17; // Number of edges in graph
        BellmanFord graph3 = new BellmanFord(V, E);
        // Add edge 0-0
        graph3.edge[0].src = 0;
        graph3.edge[0].dest = 0;
        graph3.edge[0].weight = 1;

        // Add edge 0-1
        graph3.edge[1].src = 0;
        graph3.edge[1].dest = 1;
        graph3.edge[1].weight = 2;

        // Add edge 0-3
        graph3.edge[2].src = 0;
        graph3.edge[2].dest = 3;
        graph3.edge[2].weight = 6;

        // Add edge 1-2
        graph3.edge[3].src = 1;
        graph3.edge[3].dest = 2;
        graph3.edge[3].weight = 2;

        // Add edge 1-3
        graph3.edge[4].src = 1;
        graph3.edge[4].dest = 3;
        graph3.edge[4].weight = 4;

        // Add edge 2-3
        graph3.edge[5].src = 2;
        graph3.edge[5].dest = 3;
        graph3.edge[5].weight = 2;

        // Add edge 2-4
        graph3.edge[6].src = 2;
        graph3.edge[6].dest = 4;
        graph3.edge[6].weight = 4;

        // Add edge 3-4
        graph3.edge[7].src = 3;
        graph3.edge[7].dest = 4;
        graph3.edge[7].weight = 2;


        // Add edge 4-5
        graph3.edge[8].src = 4;
        graph3.edge[8].dest = 5;
        graph3.edge[8].weight = 5;

        // Add edge 1-0
        graph3.edge[9].src = 1;
        graph3.edge[9].dest = 0;
        graph3.edge[9].weight = 2;

        // Add edge 3-0
        graph3.edge[10].src = 3;
        graph3.edge[10].dest = 0;
        graph3.edge[10].weight = 6;

        // Add edge 2-1
        graph3.edge[11].src = 2;
        graph3.edge[11].dest = 1;
        graph3.edge[11].weight = 2;

        // Add edge 3-1
        graph3.edge[12].src = 3;
        graph3.edge[12].dest = 1;
        graph3.edge[12].weight = 4;

        // Add edge 3-2
        graph3.edge[13].src = 3;
        graph3.edge[13].dest = 2;
        graph3.edge[13].weight = 2;

         // Add edge 4-2
        graph3.edge[14].src = 4;
        graph3.edge[14].dest = 2;
        graph3.edge[14].weight = 4;

        // Add edge 4-3
        graph3.edge[15].src = 4;
        graph3.edge[15].dest = 3;
        graph3.edge[15].weight = 2;

        // Add edge 5-4
        graph3.edge[16].src = 5;
        graph3.edge[16].dest = 4;
        graph3.edge[16].weight = 5;

        graph3.ShortestDistance(source);
        break;

        case 4:
        Calculations cal = new Calculations();
        Calculations.valuesCalculation(null);
        break;

        default:
        System.out.println("Exiting the loop");
        System.exit(0);
        break;
        }
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



    

