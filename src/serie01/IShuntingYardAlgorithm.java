package serie01;

public interface IShuntingYardAlgorithm
{
    Queue<Token> ConvertToRPN(Queue<Token> input);
}
