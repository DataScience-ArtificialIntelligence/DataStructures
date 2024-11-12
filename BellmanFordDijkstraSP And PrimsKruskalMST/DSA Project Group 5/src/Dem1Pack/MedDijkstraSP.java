package Dem1Pack;

import edu.princeton.cs.algs4.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class MedDijkstraSP {
    public static void main(String[] args) throws IOException {
        BufferedReader read;
        BufferedReader read1;
        BufferedReader read2;
        int numGraphs = 0;
        int numVertices = 0;


        read2 = new BufferedReader(new FileReader("GraphList.txt"));
        String line2 = read2.readLine();

        while (line2 != null) {
            numGraphs++;
            line2 = read2.readLine();
        }

        read2.close();

        ArrayList<Double> indArr = new ArrayList<Double>();

        read1 = new BufferedReader(new FileReader("GraphList.txt"));
        String line1 = read1.readLine();
        In in1 = new In(line1);
        EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(in1);
        numVertices = G1.V();
        double[][][] medArray = new double[numGraphs][numVertices][numVertices];

        read1.close();

        read = new BufferedReader(new FileReader("GraphList.txt"));
        String line = read.readLine();


        int count = 0;

            while(line != null) {
                In in = new In(line);
                EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

                for (int s = 0; s < G.V(); s++) {
                    // compute shortest paths
                    DijkstraSP sp = new DijkstraSP(G, s);
                    for (int t = 0; t < G.V(); t++) {
                        if (sp.hasPathTo(t)) {
                            medArray[count][s][t] = sp.distTo(t);

                        } else {
                            medArray[count][s][t] = 0;
                        }
                    }

                }
                count++;
                line = read.readLine();
            }

            read.close();


        System.out.println("Median-SP calculated for Dijkstra's Algorithm ----");
        int temp_index;
            double medianGen;
            for (int i = 0; i < numVertices; i++) {
                indArr.clear();
                for (int j = 0; j < numVertices; j++) {
                    indArr.clear();
                    for (int k = 0; k < numGraphs; k++) {
                        indArr.add(medArray[k][i][j]);
                    }
                    indArr.sort(Comparator.naturalOrder());

                    if (numVertices % 2 == 0) {
                        temp_index = (((numVertices / 2) + ((numVertices / 2) + 1)) / 2) - 1;
                        medianGen = indArr.get(temp_index);
                    } else {
                        temp_index = ((numVertices + 1) / 2) - 1;
                        medianGen = indArr.get(temp_index);
                    }

                    if(medianGen!=0) {
                        System.out.println(i + " to " + j + " Median-SP ----   " + medianGen);
                    }
                    else{
                        System.out.println(i + " to " + j + " Median-SP ----   No Path" );
                    }
                }
            }


        }
    }




