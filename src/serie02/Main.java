package serie02;

public class Main
{
    public static void main(String[] args)
    {
        new Calculator(
            new RpnEvaluationAlgorithm(),
            new ShuntingYardAlgorithm());
    }
}
