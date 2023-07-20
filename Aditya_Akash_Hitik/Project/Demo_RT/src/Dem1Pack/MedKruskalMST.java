package Dem1Pack;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import edu.princeton.cs.algs4.*;
import java.util.ArrayList;
import java.util.Comparator;

public class MedKruskalMST {

    public static void main(String[] args) throws IOException {
        ArrayList<Double> Weights = new ArrayList<Double>();
        BufferedReader read;
        int count=0;
        int temp_index;
        double median;




            read = new BufferedReader(new FileReader("GraphList.txt"));
            String line = read.readLine();

            while (line != null) {
                count++;
                In in = new In(line);
                EdgeWeightedGraph G = new EdgeWeightedGraph(in);
                KruskalMST mst = new KruskalMST(G);

                Weights.add(mst.weight());
                line = read.readLine();
            }

            read.close();

        Weights.sort(Comparator.naturalOrder());

        if(count % 2 == 0){
            temp_index = (((count/2) + ((count/2)+1))/2)-1;
            median = Weights.get(temp_index);
        }
        else{
            temp_index = ((count+1)/2)-1;
            median = Weights.get(temp_index);
        }

        System.out.println("The Median-MST calculated for Kruskal's Algorithm is " + median);

    }

}

