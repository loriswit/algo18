package unifr.algo18;

public class Main
{
    public static void main(String[] args)
    {
        new Calculator(new RpnEvaluationAlgorithm(), new ShuntingYardAlgorithm());
    }
}
