package serie01;

public class Queue<T>
{
    private final static int MAX_SIZE = 1000;
    
    @SuppressWarnings("unchecked")
    private T[] data = (T[]) new Object[MAX_SIZE];
    private int size = 0;
    
    public void Enqueue(T element)
    {
        assert size != MAX_SIZE;
        data[size++] = element;
    }
    
    public T Dequeue()
    {
        assert !IsEmpty();
        var value = data[0];
        System.arraycopy(data, 1, data, 0, --size);
        return value;
    }
    
    public boolean IsEmpty()
    {
        return size == 0;
    }
}