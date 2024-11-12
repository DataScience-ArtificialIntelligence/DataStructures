package Dem2Pack;

import edu.princeton.cs.algs4.*;

public class BellmanFordDegConn {

    public static void main(String[] args) {

        In in = new In("musae_facebook_edges_2.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        double[][] arr= new double[G.V()][1];
        double temp =0;
        int cat1=0;
        int cat2=0;
        int cat3=0;
        int numzero=0;

        for(int s=0; s< G.V(); s++) {
            temp = 0;
            BellmanFordSP sp = new BellmanFordSP(G, s);
            for (int t = 0; t < G.V(); t++) {
                if (sp.hasPathTo(t)) {
                    if (1 <= sp.distTo(t) && sp.distTo(t) <= 3) {
                        cat1++;
                    } else if (sp.distTo(t) > 3 && sp.distTo(t) < 6) {
                        cat2++;
                    } else {
                        cat3++;
                    }
                }
                else{
                    numzero++;
                }
            }

        }

        System.out.println("First to Third Degree Connections: " + cat1);
        System.out.println("Fourth and Fifth Degree Connections: " + cat2);
        System.out.println("Higher than fifth degree connections: " + cat3);


    }

}
