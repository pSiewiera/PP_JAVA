public class App {
    public static void main(String[] args) throws Exception {
        int numberOfItems = 30;
        long seed = 2351L;
        int lowerBound = 1;
        int upperBound = 10;

        Problem problem = new Problem(numberOfItems, seed, lowerBound, upperBound);
        System.out.println(problem);

        int capacity = 347;
        Result result = problem.solve(capacity);
        System.out.println(result);
    }
}
