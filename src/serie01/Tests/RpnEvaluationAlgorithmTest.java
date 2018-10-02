package serie01.Tests;

import org.junit.Test;
import serie01.Queue;
import serie01.Token;
import serie01.RpnEvaluationAlgorithm;

public class RpnEvaluationAlgorithmTest
{
    @Test
    public void evaluateExpression()
    {
        var tokenQueue = new Queue<Token>();
    
        tokenQueue.Enqueue(new Token(5));
        tokenQueue.Enqueue(new Token(4));
        tokenQueue.Enqueue(new Token(Token.OperatorType.Plus));
    
        assert new RpnEvaluationAlgorithm().EvaluateExpression(tokenQueue) == 9;
    
        tokenQueue = Token.Tokenize("pi 3 7 + 5 / * cos");
        assert new RpnEvaluationAlgorithm().EvaluateExpression(tokenQueue) == 1;
    }
}