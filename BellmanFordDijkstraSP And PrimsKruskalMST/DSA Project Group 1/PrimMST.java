import java.util.Arrays;
import java.util.Scanner;
public class PrimMST {
    
    private static final int V = 6; // Number of vertices in the graph;
    private int minKey(int key[], Boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printMST(int parent[], int graph[][]) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " -> " + i + "\t" + graph[i][parent[i]]);
        }
        int sum=0;
        for(int i=1;i<V;i++){
            sum+=graph[i][parent[i]];
        }
        System.out.println("Minimum Edge Weight:"+" "+sum);
        
    }

    private void primMST(int graph[][]) {
        int[] parent = new int[V];
        int[] key = new int[V];
        Boolean[] mstSet = new Boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        int t=1;
        while(t>0){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1 for Graph 1 MST\n"+"Enter 2 for Graph 2 MST\n"+"Enter 3 for Graph 3 MST\n"+"Enter 4 for the mean, median, maximum and minimum of the three MSTs\n");
        int k=sc.nextInt();
        if(k==1){
        int[][] graph = {
        
            //Graph 1 Adjacency list
            {0, 0, 0, 4, 0, 2},
            {0, 0, 5, 2, 0, 0},
            {0, 5, 0, 2, 0, 0},
            {4, 2, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 2, 0}
        };
        PrimMST prim = new PrimMST();
        prim.primMST(graph);
    }
        else if(k==2){
        int[][] graph = {

            //Graph 2 Adjacency list
            {1, 2, 0, 6, 0, 0},
            {2, 0, 2, 4, 0, 0},
            {0, 2, 0, 2, 0, 0},
            {6, 4, 2, 0, 2, 0},
            {0, 0, 0, 2, 0, 2},
            {0, 0, 0, 0, 2, 0}
        };
        PrimMST prim = new PrimMST();
        prim.primMST(graph);
    }
        else if(k==3){
        int[][] graph = {
            //Graph 3 Adjacency list
            {1, 2, 0, 6, 0, 0},
            {2, 0, 2, 4, 0, 0},
            {0, 2, 0, 2, 5, 0},
            {6, 4, 2, 0, 2, 0},
            {0, 0, 5, 2, 0, 2},
            {0, 0, 0, 0, 2, 0}
        };
        PrimMST prim = new PrimMST();
        prim.primMST(graph);
    }
        
        else if(k==4){
            Calculations cal = new Calculations();
            Calculations.printCalculations();
        }
        else{
            System.out.println("Invalid input->exiting from the loop");
            break;
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

