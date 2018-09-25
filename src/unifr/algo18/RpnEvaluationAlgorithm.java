package unifr.algo18;

public class RpnEvaluationAlgorithm implements IRpnEvaluationAlgorithm
{
    @Override
    public double EvaluateExpression(Queue<Token> inputQueue)
    {
        var stack = new Stack<Double>();
        
        while(!inputQueue.IsEmpty())
        {
            var token = inputQueue.Dequeue();
            switch(token.type)
            {
                case Numeric:
                    stack.Push(token.asNumber);
                    break;
                    
                case Operator:
                    var right = stack.Pop();
                    var left = stack.Pop();
                    switch(token.asOperator)
                    {
                        case Plus:
                            stack.Push(left + right);
                            break;
    
                        case Minus:
                            stack.Push(left - right);
                            break;
    
                        case Multiply:
                            stack.Push(left * right);
                            break;
    
                        case Divide:
                            stack.Push(left / right);
                            break;
    
                        case Power:
                            stack.Push(Math.pow(left, right));
                            break;
                    }
                    break;
                    
                case Function:
                    var value = stack.Pop();
                    switch(token.asFunction)
                    {
                        case Sin:
                            stack.Push(Math.sin(value));
                            break;
                            
                        case Cos:
                            stack.Push(Math.cos(value));
                            break;
                            
                        case Exp:
                            stack.Push(Math.exp(value));
                            break;
                    }
            }
        }
        
        return stack.Pop();
    }
}
