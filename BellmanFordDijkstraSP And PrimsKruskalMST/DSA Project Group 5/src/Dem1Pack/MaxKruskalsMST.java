package Dem1Pack;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import edu.princeton.cs.algs4.*;

public class MaxKruskalsMST {

    public static void main(String[] args) throws IOException {
        BufferedReader read;
        float count=0;
        double new_weight= Double.NEGATIVE_INFINITY;

            read = new BufferedReader(new FileReader("GraphList.txt"));
            String line = read.readLine();

            while (line != null) {
                count++;
                In in = new In(line);
                EdgeWeightedGraph G = new EdgeWeightedGraph(in);
                KruskalMST mst = new KruskalMST(G);
                if(mst.weight()>new_weight){
                    new_weight = mst.weight();
                }
                line = read.readLine();
            }

            read.close();

        System.out.println("The Max-MST calculated for Kruskal's Algorithm is " + new_weight);

    }

}
