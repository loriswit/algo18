package serie02;

public class Queue<T>
{
    private Node<T> head = null;
    
    public void Enqueue(T element)
    {
        head = new Node<>(element, head);
    }
    
    public T Dequeue()
    {
        assert head != null;
        
        // if head is the only item, set it to null
        if(head.next == null)
        {
            var value = head.value;
            head = null;
            return value;
        }
        
        var node = head;
        var next = head.next;
        
        while(next.next != null)
        {
            node = next;
            next = node.next;
        }
        
        node.next = null;
        return next.value;
    }
    
    public boolean IsEmpty()
    {
        return head == null;
    }
}
