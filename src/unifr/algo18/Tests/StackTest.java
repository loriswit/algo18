package unifr.algo18.Tests;

import org.junit.Test;
import unifr.algo18.Stack;

public class StackTest
{
    @Test
    public void dequeue()
    {
        var integerStack = new Stack<Integer>();
        integerStack.Push(1);
        integerStack.Push(2);
        integerStack.Push(3);

        assert integerStack.Peek() == 3;
        assert integerStack.Pop() == 3;
        assert integerStack.Peek() == 2;
        assert integerStack.Pop() == 2;
        assert integerStack.Peek() == 1;
        assert integerStack.Pop() == 1;
        assert integerStack.IsEmpty();
    
        var stringStack = new Stack<String>();
        stringStack.Push("lorem");
        stringStack.Push("ipsum");
        stringStack.Push("dolor");
        stringStack.Push("sit amet");

        assert stringStack.Peek().equals("sit amet");
        assert stringStack.Pop().equals("sit amet");
        assert stringStack.Peek().equals("dolor");
        assert stringStack.Pop().equals("dolor");
        assert stringStack.Peek().equals("ipsum");
        assert stringStack.Pop().equals("ipsum");
        assert stringStack.Peek().equals("lorem");
        assert stringStack.Pop().equals("lorem");
        assert stringStack.IsEmpty();
    }
}