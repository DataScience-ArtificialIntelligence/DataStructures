package Dem2Pack;

import edu.princeton.cs.algs4.*;
public class BellmanMostLiked {
    public static void main(String[] args) {

        In in = new In("musae_facebook_edges_2.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        double[][] arr= new double[G.V()][1];
        double val =0;


        for(int s=0; s< G.V(); s++){
            val=0;
            BellmanFordSP sp = new BellmanFordSP(G, s);
            for (int t = 0; t < G.V(); t++) {
                if (sp.hasPathTo(t)) {
                    if(sp.distTo(t)==1)
                        val += sp.distTo(t);
                }
            }
            arr[s][0] = val;

        }
        double count=-1;
        int id=0;
        for(int i=0; i<G.V(); i++){
            if(arr[i][0]>count){
                count = arr[i][0];
                id = i;
            }
        }

        System.out.println("The highest number of likes a page has is: " + count);
        System.out.println("The page id is: " + id);




    }
}
