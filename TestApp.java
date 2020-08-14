import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args) {
        testList();
    }



    private static void testList(){
        MyLinkedList list = new MyLinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        MyLinkedList.Iterator iterator = list.getIterator();
        System.out.println("getNext:");
        while (iterator.hasNext()){
            System.out.println(iterator.getNext());
        }
        System.out.println("\ngetPrev:");
        while (iterator.hasPrev()){
            System.out.println(iterator.getPrev());
        }

        System.out.println("\nSet:");
        list.set(4, "Five (Updated using Set)");
        while (iterator.hasNext()){
            System.out.println(iterator.getNext());
        }

        System.out.println("\nCount:" + list.getCount());

        System.out.println("\nget index 3:" + list.get(3));

        list.insert(0,"inserted 0");
        list.insert(3,"inserted 3");
        list.insert(list.getCount(),"inserted last");

        System.out.println("\n");
        iterator.reset();
        while (iterator.hasNext()){
            System.out.println(iterator.getNext());
        }

        System.out.println("\nCount:" + list.getCount());

    }
}
