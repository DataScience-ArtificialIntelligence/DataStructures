import java.util.*;
import java.util.Scanner;
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        i = 0;

        while (e < V - 1) {
            Edge nextEdge = edges[i++];

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }

        System.out.println("Minimum Spanning Tree:");
        int minimumWeight = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " + result[i].dest + " : " + result[i].weight);
            minimumWeight += result[i].weight;
        }
        System.out.println("Total minimum edge weight: " + minimumWeight);
    }
}

public class KrushkalMST {
    public static void main(String[] args) {
        int t=1;
        while(t>0){
        int V,E;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for Graph 1 MST\n"+"Enter 2 for Graph 2 MST\n" +"Enter 3 for Graph 3 MST\n"+"Enter 4 for the mean(average),median,maximum and minimum of the three MSTs\n");
        int m = sc.nextInt();
        switch(m){
        case 1:
        System.out.println("Enter the number of vertices in Graph 1:");
        V=sc.nextInt();
        System.out.println("Enter the number of edges in Graph 1:");
        E=sc.nextInt();
        Graph graph1 = new Graph(V, E);
        //For Graph G1
        graph1.edges[0].src = 4;
        graph1.edges[0].dest = 5;
        graph1.edges[0].weight = 2;

        graph1.edges[1].src = 5;
        graph1.edges[1].dest = 0;
        graph1.edges[1].weight = 2;

        graph1.edges[2].src = 2;
        graph1.edges[2].dest = 3;
        graph1.edges[2].weight = 2;

        graph1.edges[3].src = 3;
        graph1.edges[3].dest = 0;
        graph1.edges[3].weight = 4;

        graph1.edges[4].src = 2;
        graph1.edges[4].dest = 1;
        graph1.edges[4].weight = 5;

        graph1.edges[5].src = 3;
        graph1.edges[5].dest = 1;
        graph1.edges[5].weight = 2;
        
        graph1.kruskalMST();
        break;
    

        case 2:
        System.out.println("Enter the number of vertices in Graph 2:");
        V=sc.nextInt();
        System.out.println("Enter the number of edges in Graph 2:");
        E=sc.nextInt();
        Graph graph2 = new Graph(V, E);

        //For Graph G2
        graph2.edges[0].src = 0;
        graph2.edges[0].dest = 0;
        graph2.edges[0].weight = 1;

        graph2.edges[1].src = 0;
        graph2.edges[1].dest = 1;
        graph2.edges[1].weight = 2;

        graph2.edges[2].src = 0;
        graph2.edges[2].dest = 3;
        graph2.edges[2].weight = 6;

        graph2.edges[3].src = 1;
        graph2.edges[3].dest = 2;
        graph2.edges[3].weight = 2;

        graph2.edges[4].src = 1;
        graph2.edges[4].dest = 3;
        graph2.edges[4].weight = 4;

        graph2.edges[5].src = 2;
        graph2.edges[5].dest = 3;
        graph2.edges[5].weight = 2;

        graph2.edges[6].src = 3;
        graph2.edges[6].dest = 4;
        graph2.edges[6].weight = 2;

        graph2.edges[7].src = 4;
        graph2.edges[7].dest = 5;
        graph2.edges[7].weight = 2;
    
        graph2.kruskalMST();
        break;

        case 3:
        System.out.println("Enter the number of vertices in Graph 3:");
        V=sc.nextInt();
        System.out.println("Enter the number of edges in Graph 3:");
        E=sc.nextInt();
        Graph graph3 = new Graph(V, E);
        //For Graph G3
        graph3.edges[0].src = 0;
        graph3.edges[0].dest = 0;
        graph3.edges[0].weight = 1;

        graph3.edges[1].src = 0;
        graph3.edges[1].dest = 1;
        graph3.edges[1].weight = 2;

        graph3.edges[2].src = 0;
        graph3.edges[2].dest = 3;
        graph3.edges[2].weight = 6;

        graph3.edges[3].src = 1;
        graph3.edges[3].dest = 2;
        graph3.edges[3].weight = 2;

        graph3.edges[4].src = 1;
        graph3.edges[4].dest = 3;
        graph3.edges[4].weight = 4;

        graph3.edges[5].src = 2;
        graph3.edges[5].dest = 3;
        graph3.edges[5].weight = 2;

        graph3.edges[6].src = 3;
        graph3.edges[6].dest = 4;
        graph3.edges[6].weight = 2;

        graph3.edges[7].src = 4;
        graph3.edges[7].dest = 5;
        graph3.edges[7].weight = 2;

        graph3.edges[8].src = 4;
        graph3.edges[8].dest = 2;
        graph3.edges[8].weight = 5;

        graph3.kruskalMST();
        break;

        case 4:
        Calculations cal = new Calculations();
            Calculations.printCalculations();
            break;

        default :
        System.exit(0);
        }
        }
        t++;
}
}

class Calculations{
    static int mstG1Weight = 12;
    static int mstG2Weight = 10;
    static int mstG3Weight = 10;
    //calculates mean of the three mst
    public static double MeanofMST(int mstG1Weight, int mstG2Weight, int mstG3Weight) {
        int totalWeight = mstG1Weight + mstG2Weight + mstG3Weight;
        return (double) totalWeight / 3;
    }
    //calculates the median of the three mst
    public static double MedianofMST(int mstG1Weight, int mstG2Weight, int mstG3Weight) {
        int[] mstWeights = {mstG1Weight, mstG2Weight, mstG3Weight};
        Arrays.sort(mstWeights);
        int middleIndex = mstWeights.length / 2;

        if (mstWeights.length % 2 == 0) {
            // Even number of elements, take the average of the two middle values
            double middleValue1 = mstWeights[middleIndex - 1];
            double middleValue2 = mstWeights[middleIndex];
            return (middleValue1 + middleValue2) / 2;
        } else {
            // Odd number of elements, return the middle value
            return mstWeights[middleIndex];
        }
    }
    //calculates the maximum of the three mst
    public static int MaximumofMST(int mstG1Weight, int mstG2Weight, int mstG3Weight) {
        int maxMST = Math.max(mstG1Weight, Math.max(mstG2Weight, mstG3Weight));
        return maxMST;
    }
    //calculates the minimum of the three mst
    public static int MinimumofMST(int mstG1Weight, int mstG2Weight, int mstG3Weight) {
        int minMST = Math.min(mstG1Weight, Math.min(mstG2Weight, mstG3Weight));
        return minMST;
    }
    

    public static void printCalculations(){
        Calculations cal = new Calculations();
        System.out.println("The Mean of three MSTs:"+" "+ cal.MeanofMST(mstG1Weight, mstG2Weight, mstG3Weight));
        System.out.println("The Median of three MSTs:"+" "+ cal.MedianofMST(mstG1Weight, mstG2Weight, mstG3Weight));
        System.out.println("The Maximum of three MSTs:"+" "+ cal.MaximumofMST(mstG1Weight, mstG2Weight, mstG3Weight));
        System.out.println("The Minimum of three MSTs:"+" "+ cal.MinimumofMST(mstG1Weight, mstG2Weight, mstG3Weight));
    }

}

    

