package Dem2Pack;


import edu.princeton.cs.algs4.*;


public class DijkstraZ_factor {

    public static void main(String[] args) {
        In in = new In("musae_facebook_edges.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        long   count=0,count_1=0,ans_1=0,mean=0,counter=0,sus_ans;
        long Standard_z_factor=0,total_nodes=22470;

        for (int s=0;s<G.V();s++) {
            DijkstraSP sp = new DijkstraSP(G, s);
             for (int t=0;t<G.V();t++) {
                 if (sp.hasPathTo(t)) {
                 long d= (long) sp.distTo(t);
                 count += (s*d);//just checking if path is there,if it is we know it is one only..
                 count_1 += (s * s * d);

             }else continue;
             }
        }
       // System.out.println("Above =" + count);
        //System.out.println("Above =" + count_1);


        long ans = (long)count_1/total_nodes;
        mean = count/total_nodes;
        ans_1=(mean)*(mean);

        long f_ans=(long) ans_1-ans;//variance
        //System.out.println("Variance =" + f_ans);
        long sd = (long) Math.sqrt(f_ans);//Standard Deviation




        //System.out.println("Standard Deviation =" + sd);
        //System.out.println("Average =" + mean);

        for (int s=0;s<G.V();s++) {
            if ((s-mean)/sd>=Standard_z_factor) {
                counter++;
            }
        }
        sus_ans=total_nodes-counter;
        System.out.println("Number of Webpages which have a good reach =" + counter);
        System.out.println("Number of Webpages which don't have a good reach =" + sus_ans);
    }


}
