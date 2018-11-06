package serie06.PriorityQueue;

import java.util.Random;

public class PriorityQueueTest
{
    
    @org.junit.Test
    public void test()
    {
        final int N = 1000;
        Integer[] array = new Integer[N];
        for(int i = 0; i < N; i++)
        {
            array[i] = i;
        }
        shuffleArray(array);
        
        IPriorityQueue<Integer> priorityQueue = new Heap<>();
        assert priorityQueue.isEmpty();
        
        for(int i = 0; i < N; i++)
        {
            priorityQueue.insert(array[i]);
        }
        
        for(int i = 0; i < N; i++)
        {
            assert !priorityQueue.isEmpty();
            Integer pop = priorityQueue.remove();
            assert pop == i;
        }
        assert priorityQueue.isEmpty();
        
    }
    
    // Implements Fisher–Yates shuffle
    static void shuffleArray(Integer[] array)
    {
        Random random = new Random();
        for(int i = array.length - 1; i > 0; i--)
        {
            int index = random.nextInt(i + 1);
            Integer a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
