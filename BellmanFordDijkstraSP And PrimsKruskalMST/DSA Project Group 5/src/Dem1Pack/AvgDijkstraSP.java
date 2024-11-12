package Dem1Pack;

import edu.princeton.cs.algs4.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class AvgDijkstraSP {
    public static void main(String[] args) throws IOException {
        BufferedReader read;
        BufferedReader read1;
        float count=0;
        read1 = new BufferedReader(new FileReader("GraphList.txt"));
        String line1 = read1.readLine();
        In in1 = new In(line1);
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(in1);
        double[][] pArray = new double[G1.V()][G1.V()];


            read = new BufferedReader(new FileReader("GraphList.txt"));
            String line = read.readLine();

            while (line != null) {
                count++;
                In in = new In(line);
                EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);


                for (int s = 0; s < G.V(); s++)
                {
                    // Compute Shortest Paths
                    DijkstraSP sp = new DijkstraSP(G, s);
                    for (int t = 0; t < G.V(); t++) {
                        if (sp.hasPathTo(t)) {
                            pArray[s][t] += sp.distTo(t);

                        } else {
                            pArray[s][t] += 0;
                        }
                    }
                }

                line = read.readLine();
            }

            read.close();
        System.out.println("Average-SP calculated for Dijkstra's Algorithm ----");
        for (int i = 0; i < G1.V(); i++) {
            for (int j = 0; j < G1.V(); j++) {
                if (pArray[i][j] / count == 0){
                    StdOut.printf("%d to %d Average-SP ----   No Path", i, j);
                    System.out.println();
                }
                else {
                    StdOut.printf("%d to %d Average-SP ----   %.2f", i, j, pArray[i][j] / count);
                    System.out.println();
                }
            }

        }
    }

}


