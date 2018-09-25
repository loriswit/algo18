package unifr.algo18.Tests;

import org.junit.Test;
import unifr.algo18.Queue;
import unifr.algo18.RpnEvaluationAlgorithm;
import unifr.algo18.Token;

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