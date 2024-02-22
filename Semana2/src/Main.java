public class Main {
    public static void main(String[] args) {
        System.out.println("N\tT(N)\tRatio\tlg(Ratio)");

        int START = 5;

        double start = System.currentTimeMillis();
        QuickFindUF.doNUnionOperations(START);
        double end = System.currentTimeMillis();
        double previousElapsedTime = end - start;

        for (int N=START; N<=1000000; N*=2){
            start = System.currentTimeMillis();
            QuickFindUF.doNUnionOperations(N);
            end = System.currentTimeMillis();

            double elapsedTime = (end-start)/1000.0;

            double ratio = elapsedTime / previousElapsedTime;
            double lgRatio = Math.log(ratio) / Math.log(2);

            System.out.println(N + "\t" + elapsedTime + "\t" + ratio + "\t" + lgRatio);

            previousElapsedTime = elapsedTime;
        }
    }
}