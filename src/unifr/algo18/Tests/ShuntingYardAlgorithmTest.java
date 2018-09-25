package unifr.algo18.Tests;

import org.junit.Test;
import unifr.algo18.Queue;
import unifr.algo18.ShuntingYardAlgorithm;
import unifr.algo18.Token;

import static org.junit.Assert.*;

public class ShuntingYardAlgorithmTest {

    @Test
    public void convertToRPN() {
        Queue<Token> inQ = new Queue<>();
        Token three = new Token(3), plus = new Token(Token.OperatorType.Plus), four = new Token(4);

        inQ.Enqueue(three);
        inQ.Enqueue(plus);
        inQ.Enqueue(four);

        Queue<Token> outQ = new ShuntingYardAlgorithm().ConvertToRPN(inQ);

        assert outQ.Dequeue() == three;
        assert outQ.Dequeue() == four;
        assert outQ.Dequeue() == plus;
    }
}