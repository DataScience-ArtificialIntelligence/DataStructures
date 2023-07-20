package Dem2Pack;

import edu.princeton.cs.algs4.*;

public class BellmanFordAvg {

    public static void main(String[] args) {

        In in = new In("musae_facebook_edges.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        double[][] arr= new double[G.V()][1];
        double temp =0;
        int count=0;

        for(int s=0; s< G.V(); s++){
            temp=0;
            BellmanFordSP sp = new BellmanFordSP(G, s);
            for (int t = 0; t < G.V(); t++) {
                if (sp.hasPathTo(t)) {
                    temp += sp.distTo(t);
                } else {
                    temp+=0;
                    count++;
                }
            }
            arr[s][0] = temp;
        }

        double total=0;
        int num = ((G.V() * G.V()) - count);
        double avg;

        for(int i=0; i<G.V(); i++){
            total+=arr[i][0];
        }

        avg = total/(num);
        System.out.println(avg);


    }

}
