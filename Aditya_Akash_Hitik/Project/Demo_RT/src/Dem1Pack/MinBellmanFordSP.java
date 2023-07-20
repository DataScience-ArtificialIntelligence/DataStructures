package Dem1Pack;

import edu.princeton.cs.algs4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MinBellmanFordSP {
    public static void main(String[] args) throws IOException {
        BufferedReader read;
        BufferedReader read1;
        read1 = new BufferedReader(new FileReader("GraphList.txt"));
        String line1 = read1.readLine();
        In in1 = new In(line1);
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(in1);
        double[][] pArray = new double[G1.V()][G1.V()];

        for (int a = 0; a < G1.V(); a++) {
            for (int b = 0; b < G1.V(); b++) {
                pArray[a][b] = Double.POSITIVE_INFINITY;
            }
        }

        read = new BufferedReader(new FileReader("GraphList.txt"));
        String line = read.readLine();

        while (line != null) {
            In in = new In(line);
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

            for (int s = 0; s < G.V(); s++)
            {
                // compute shortest paths
                BellmanFordSP sp = new BellmanFordSP(G, s);
                for (int t = 0; t < G.V(); t++) {
                    if (sp.hasPathTo(t)) {
                        if (pArray[s][t] > sp.distTo(t)) {
                            pArray[s][t] = sp.distTo(t);
                        }

                    }
                }
            }

            line = read.readLine();
        }

        read.close();

        System.out.println("Min-SP calculated for Bellman-Ford's Algorithm ----");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (pArray[i][j] == Double.POSITIVE_INFINITY){
                    StdOut.printf("%d to %d Min-SP ----   No Path", i, j);
                    System.out.println();
                }
                else {
                    StdOut.printf("%d to %d Min-SP ----   %.2f", i, j, pArray[i][j]);
                    System.out.println();
                }
            }

        }
    }
}
