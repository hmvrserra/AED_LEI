public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF (int N) {
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i]=i;
        }
    }

    public int root(int p){
        while(p!=id[p]){
            p=id[p];
        }
        return p;
    }

    public boolean connected(int p, int q){          //are p and q connected?
        return root(p)==root(q);
    }

    public void union(int p, int q){                 //connect p and q
        int rp = root(p);
        int rq = root(q);
        id[rp]=rq;
    }
}
