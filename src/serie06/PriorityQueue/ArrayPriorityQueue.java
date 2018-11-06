package serie06.PriorityQueue;

import java.util.ArrayList;

public class ArrayPriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T>
{
    private ArrayList<T> array = new ArrayList<>();
    
    // O(1)
    @Override
    public void insert(T elem)
    {
        array.add(elem);
    }
    
    // O(n)
    @Override
    public T remove()
    {
        int min = 0;
        for(int i = 1; i < array.size(); ++i)
            if(array.get(i).compareTo(array.get(min)) < 0)
                min = i;
        
        return array.remove(min);
    }
    
    @Override
    public boolean isEmpty()
    {
        return array.isEmpty();
    }
}
