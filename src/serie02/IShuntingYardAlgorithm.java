package serie02;

public interface IShuntingYardAlgorithm
{
    Queue<Token> ConvertToRPN(Queue<Token> input);
}
