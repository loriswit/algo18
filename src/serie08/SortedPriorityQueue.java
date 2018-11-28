package serie08;

import java.util.ArrayList;

public class SortedPriorityQueue<T extends Comparable<T>>
{
    private ArrayList<T> array = new ArrayList<>();
    
    public void insert(T elem)
    {
        int index;
        for(index = 0; index < array.size(); ++index)
            if(elem.compareTo(array.get(index)) > 0)
                break;
        
        array.add(index, elem);
    }
    
    public T remove()
    {
        return array.remove(0);
    }
    
    public boolean isEmpty()
    {
        return array.isEmpty();
    }
}
