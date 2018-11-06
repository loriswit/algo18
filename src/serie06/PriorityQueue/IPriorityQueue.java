package serie06.PriorityQueue;

public interface IPriorityQueue<T extends Comparable<T>>
{
    void insert(T elem);
    
    T remove();
    
    boolean isEmpty();
}
