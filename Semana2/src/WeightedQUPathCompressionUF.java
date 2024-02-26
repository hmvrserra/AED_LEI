public class WeightedQUPathCompressionUF {

    private int[] id;
    private int[] sz;

    public WeightedQUPathCompressionUF(int N){      //constructor (N is the number of points)

        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i]=1;
        }
    }

    public int root(int p){     //root of p
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){     //are p and q connected?
        return root(p)==root(q);
    }

    public void union(int p, int q){        //connect p and q
        int rp = root(p);
        int rq = root(q);
        if (rp==rq)
            return;
        if (sz[rp]<sz[rq]){
            id[rp]=rq;
            sz[rq]+=sz[rp];
        } else {
            id[rq]=rp;
            sz[rp]+=sz[rq];
        }
    }
}
