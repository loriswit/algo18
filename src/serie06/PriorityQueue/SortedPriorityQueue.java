package serie06.PriorityQueue;

import java.util.ArrayList;

public class SortedPriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T>
{
    private ArrayList<T> array = new ArrayList<>();
    
    // O(n)
    @Override
    public void insert(T elem)
    {
        int index;
        for(index = 0; index < array.size(); ++index)
            if(elem.compareTo(array.get(index)) < 0)
                break;
        
        array.add(index, elem);
    }
    
    // O(1)
    @Override
    public T remove()
    {
        return array.remove(0);
    }
    
    @Override
    public boolean isEmpty()
    {
        return array.isEmpty();
    }
}
