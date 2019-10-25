package collectionhierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[]data = scan.nextLine().split(" ");
        int n = Integer.parseInt(scan.nextLine());

        add(addCollection, data);
        add(addRemoveCollection,data);
        add(myList,data);

        remove(myList, n);
        remove(addRemoveCollection, n);


    }

    private static void remove(AddRemovable list, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(list.remove() + " ") ;
        }
        System.out.println();
    }


    private static void add(Addable list, String[] data) {
        for (String datum : data) {
            System.out.print(list.add(datum) + " ");
        }
        System.out.println();
    }
}
