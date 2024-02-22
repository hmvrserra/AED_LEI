public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N){                       //constructor (N is the number of points)
        id = new int[N];
        for(int i=0; i<N; i++)
            id[i]=i;
    }

    public boolean connected(int p, int q){          //are p and q connected?
        return id[p]==id[q];
    }

    public void union(int p, int q){                 //connect p and q
        int idP = id[p];
        int idQ = id[q];
        for(int i=0; i<id.length; i++){
            if(id[i]==idP)
                id[i] = idQ;
        }
    }
    public static void doNUnionOperations(int N){    //do multiple union ops
        QuickFindUF uf = new QuickFindUF(N);
        for (int i = 0; i < N; i++){
            int p = (int) (N * Math.random());
            int q = (int) (N * Math.random());
            uf.union(p, q);
        }
    }
}
