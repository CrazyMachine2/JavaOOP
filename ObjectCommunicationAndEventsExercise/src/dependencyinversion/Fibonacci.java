package dependencyinversion;

public class Fibonacci implements Operation {
   private static int timesCalled = 0;

    @Override
    public int execute(int first, int second) {
        return calc(first,second);
    }

    private int calc(int n, int limit){
        timesCalled++;

        if(timesCalled == limit){
            throw new IllegalArgumentException("Number too large!");
        }

        if(n < 2){
            return 1;
        }

        return calc(n - 1,limit) + calc(n - 2,limit);
    }
}
