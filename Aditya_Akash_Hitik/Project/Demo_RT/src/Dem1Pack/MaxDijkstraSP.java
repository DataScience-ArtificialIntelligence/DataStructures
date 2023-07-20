package Dem1Pack;

import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class MaxDijkstraSP {
    public static void main(String[] args) throws IOException {
        BufferedReader read;
        BufferedReader read1;
        read1 = new BufferedReader(new FileReader("GraphList.txt"));
        String line1 = read1.readLine();
        In in1 = new In(line1);
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(in1);
        double[][] pArray = new double[G1.V()][G1.V()];

        read = new BufferedReader(new FileReader("GraphList.txt"));
        String line = read.readLine();

        while (line != null) {
            In in = new In(line);
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

            for (int s = 0; s < G.V(); s++)
            {
                // compute shortest paths
                DijkstraSP sp = new DijkstraSP(G, s);
                for (int t = 0; t < G.V(); t++) {
                    if (sp.hasPathTo(t)) {
                        if (pArray[s][t] < sp.distTo(t)) {
                            pArray[s][t] = sp.distTo(t);
                        }

                    }
                }
            }

            line = read.readLine();
        }

        read.close();

        System.out.println("Max-SP calculated for Dijkstra's Algorithm ----");
        for (int i = 0; i < G1.V(); i++) {
            for (int j = 0; j < G1.V(); j++) {
                if (pArray[i][j] == 0 && i != j){
                    StdOut.printf("%d to %d Max-SP ----   No Path", i, j);
                    System.out.println();
                }
                else {
                    StdOut.printf("%d to %d Max-SP ----   %.2f", i, j, pArray[i][j]);
                    System.out.println();
                }
            }

        }
    }
}
