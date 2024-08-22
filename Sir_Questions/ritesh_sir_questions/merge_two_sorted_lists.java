public class merge_two_sorted_lists 
{
    static class Node 
    {
        int val;
        Node next;

        Node(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    public static Node mergeTwoLists(Node list1, Node list2) 
    {
        Node temp1 = list1, temp2 = list2;
        Node res = new Node(0);
        Node newHead = res;
        
        while(temp1 != null || temp2 != null)
        {
            if(temp1 != null && temp2 != null) 
            {
                if(temp1.val <= temp2.val)
                {
                    res.next = new Node(temp1.val);
                    temp1 = temp1.next;
                    res = res.next;
                }
                else
                {
                    res.next = new Node(temp2.val);
                    temp2 = temp2.next;
                    res = res.next;
                }
            }

            else if(temp1 != null)
            {
                res.next = new Node(temp1.val);
                temp1 = temp1.next;
                res = res.next;
            }

            else
            {
                res.next = new Node(temp2.val);
                temp2 = temp2.next;
                res = res.next;
            }
        }

        return newHead.next;
    }

    public static void print(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(4);

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(4);

        print(head1);
        print(head2);

        Node res = mergeTwoLists(head1, head2);
        print(res);
    }
}
