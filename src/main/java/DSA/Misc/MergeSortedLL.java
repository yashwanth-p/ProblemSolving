package DSA.Misc;

public class MergeSortedLL {
    public static void main(String[] args)
    {
        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        // Node head1 = new Node(5);
        llist1.addToTheLast(new LLNode(15, "Fathima"));
        llist1.addToTheLast(new LLNode(10, "Don"));
        llist1.addToTheLast(new LLNode(5, "Sonia"));
        llist1.addToTheLast(new LLNode(2, "Romeal"));
        llist1.addToTheLast(new LLNode(1, "Sonia"));

        // LLNode head2 = new LLNode(2);
        llist2.addToTheLast(new LLNode(20, "Kilian"));
        llist2.addToTheLast(new LLNode(3, "James"));
        llist2.addToTheLast(new LLNode(2, "Daniel"));
        llist2.addToTheLast(new LLNode(1, "Biswa"));


        llist1.head = new Helper().sortedMerge(llist1.head,
                llist2.head);
        llist1.printList();

    }
}

class LLNode
{
    int data;
    LLNode next;
    String name;
    LLNode(int d, String name) {
        data = d;
        next = null;
        this.name = name;
    }
}

class MergeLists
{
    LLNode head;

    /* Method to insert a node at
    the end of the linked list */
    public void addToTheLast(LLNode node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            LLNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Method to print linked list */
    void printList()
    {
        LLNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.name + " : " +temp.data + "\n");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Helper
{
    /* Takes two lists sorted in
    increasing order, and splices
    their nodes together to make
    one big sorted list which is
    returned. */
    LLNode sortedMerge(LLNode list1, LLNode list2)
    {

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // 15 10 5
        // 20 3 2

        LLNode head = new LLNode(0, "");
        LLNode temp = head;
        while(list1!=null && list2!=null) {

            if(list1.data > list2.data || (list1.data == list2.data && isAlphabeticallyFirst(list1.name, list2.name)) ) {
                LLNode curLLNode = list1;
                list1 = list1.next;
                curLLNode.next = null;
                head.next = curLLNode;
                head = head.next;

            } else {
                LLNode curLLNode = list2;
                list2 = list2.next;
                curLLNode.next = null;
                head.next = curLLNode;
                head = head.next;
            }

            if(list1 == null) {
                head.next = list2;
            }

            if(list2 == null) {
                head.next = list1;
            }
        }

        return temp.next;
    }

    private boolean isAlphabeticallyFirst(String name1, String name2) {
        return name2.compareTo(name1) > 0;
    }
}

// This code is contributed
// by Shubhaw Kumar
