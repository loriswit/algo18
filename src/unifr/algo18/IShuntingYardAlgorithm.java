package unifr.algo18;

public interface IShuntingYardAlgorithm
{
    Queue<Token> ConvertToRPN(Queue<Token> input);
}
