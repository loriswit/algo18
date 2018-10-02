package serie02;

public class ShuntingYardAlgorithm implements IShuntingYardAlgorithm
{
    private Stack<Token> operators = new Stack<>();
    
    @Override
    public Queue<Token> ConvertToRPN(Queue<Token> input)
    {
        var output = new Queue<Token>();
        
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
                        while((isFunction(operators.Peek()) || higherPrecedence(operators.Peek(), token)) &&
                            !isOpenBracket(operators.Peek()))
                            output.Enqueue(operators.Pop());
                    
                    operators.Push(token);
                    break;
                
                case Bracket:
                    if(isOpenBracket(token))
                        operators.Push(token);
                    else
                    {
                        while(!isOpenBracket(operators.Peek()))
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
    
    private boolean isFunction(Token token)
    {
        return token.type == Token.TokenType.Function;
    }
    
    private boolean higherPrecedence(Token a, Token b)
    {
        return a.type == Token.TokenType.Operator &&
            a.GetOperatorPrecedence() >= b.GetOperatorPrecedence();
    }
    
    private boolean isOpenBracket(Token token)
    {
        return token.type == Token.TokenType.Bracket &&
            token.asBracket == Token.Bracket.Open;
    }
}
