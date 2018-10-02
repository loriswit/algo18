package serie01.Tests;

import org.junit.Test;
import serie01.Queue;

public class QueueTest
{
    @Test
    public void dequeue()
    {
        var integerQueue = new Queue<Integer>();
        integerQueue.Enqueue(1);
        integerQueue.Enqueue(2);
        integerQueue.Enqueue(3);
        
        assert integerQueue.Dequeue() == 1;
        assert integerQueue.Dequeue() == 2;
        assert integerQueue.Dequeue() == 3;
        assert integerQueue.IsEmpty();
        
        var stringQueue = new Queue<String>();
        stringQueue.Enqueue("lorem");
        stringQueue.Enqueue("ipsum");
        stringQueue.Enqueue("dolor");
        stringQueue.Enqueue("sit amet");
        
        assert stringQueue.Dequeue().equals("lorem");
        assert stringQueue.Dequeue().equals("ipsum");
        assert stringQueue.Dequeue().equals("dolor");
        assert stringQueue.Dequeue().equals("sit amet");
        assert stringQueue.IsEmpty();
    }
}