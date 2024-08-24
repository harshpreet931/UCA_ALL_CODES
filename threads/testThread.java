public class testThread
{
    // shared list -- owner is main / parent thread
    // 3 threads -- shared list

    // shared_list l; 5 -> 6 -> 7 -> 1,     5 -> 6 -> 7 -> 2 ,     5 -> 6 -> 7 -> 3 ...
    // t = fork(list_insert(l, 1))
    // t2 = fork(list_insert(l, 3))
    // list_insert(l, 2)
    // wait(t) / join, fork and...
    // wait(t2)
    // print(list) // [1, 2, 3], [3, 2, 1], [2, 3, 1] they can get cpu in any order

    // execution context

    // list_insert(shared_list l, int i)
    //   ptr* index = free_index(l)
    //   index.next = i; 
    //   i -> next = null



}