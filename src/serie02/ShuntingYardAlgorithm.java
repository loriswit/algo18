package serie02;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm
{
    @Override
    public Queue<Token> ConvertToRPN(Queue<Token> input)
    {
        var output = new Queue<Token>();
        var operators = new Stack<Token>();
        
        while(!input.IsEmpty())
        {
            var token = input.Dequeue();
            switch(token.type)
            {
                case Numeric:
                    output.Enqueue(token);
                    break;
                
                case Function:
                    operators.Push(token);
                    break;
                
                case Operator:
                    if(!operators.IsEmpty())
                        while((operators.Peek().type == Token.TokenType.Function ||
                            (operators.Peek().type == Token.TokenType.Operator &&
                                operators.Peek().GetOperatorPrecedence() >= token.GetOperatorPrecedence())) &&
                            !(operators.Peek().type == Token.TokenType.Bracket &&
                                operators.Peek().asBracket == Token.Bracket.Open))
                            output.Enqueue(operators.Pop());
                    
                    operators.Push(token);
                    break;
                
                case Bracket:
                    if(token.asBracket == Token.Bracket.Open)
                        operators.Push(token);
                    else
                    {
                        while(!(operators.Peek().type == Token.TokenType.Bracket &&
                            operators.Peek().asBracket == Token.Bracket.Open))
                            output.Enqueue(operators.Pop());
                        
                        operators.Pop();
                    }
                    break;
            }
        }
        
        while(!operators.IsEmpty())
            output.Enqueue(operators.Pop());
        
        return output;
    }
}
