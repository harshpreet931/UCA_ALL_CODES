public class reverse_a_ll
{
    static class ll
    {
        int val;
        ll next;

        ll(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    public static ll reverse(ll head)
    {
        ll prev = null, curr = head;
        while(curr != null)
        {
            ll temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static ll reverse_recursive(ll head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }

        ll temp = reverse_recursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void print(ll head)
    {
        ll temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ll head = new ll(1);
        head.next = new ll(2);
        head.next.next = new ll(3);

        print(head);
        head = reverse(head);
        print(head);
        head = reverse_recursive(head);
        print(head);

    }
}