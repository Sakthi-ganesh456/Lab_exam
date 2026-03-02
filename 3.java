ARRAY AND LINKED LIST:
import java.util.*;
 
public class ListImplementation {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
 
        System.out.println("ArrayList Elements:");
        for(String item : arrayList) {
            System.out.println(item);
        }
 
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Fox");
 
        // Display LinkedList
        System.out.println("\nLinkedList Elements:");
        for(String item : linkedList) {
            System.out.println(item);
        }
    }
}
B) BOOKLIST:
import java.util.*;
public class BookListUsingArrayList {
    public static void main(String[] args) {
        ArrayList<String> books = new ArrayList<>();
        books.add("The Alchemist");
        books.add("Harry Potter");
        books.add("The Hobbit");
        books.add("Rich Dad Poor Dad");
        System.out.println("Books in the list:");
        Iterator<String> itr = books.iterator();
        
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
