package Sandbox;

import java.util.Iterator;
public class SetTest {
    public static void main(String[] args) {
        java.util.Set set = new java.util.TreeSet();
        set.add("2");
        set.add(3); // Error here, change to String or change all to numbers
        set.add("1");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
