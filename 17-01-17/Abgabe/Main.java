package pgdp;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new Set<>();
        set = set.add(1);
        System.out.println("Length: " + set.size() + ", contents: " + set.toString());
        set = set.add(2);
        System.out.println("Length: " + set.size() + ", contents: " + set.toString());
        set = set.add(3);
        System.out.println("Length: " + set.size() + ", contents: " + set.toString());
        set = set.add(4);
        System.out.println("Length: " + set.size() + ", contents: " + set.toString());
        set = set.add(5);
        System.out.println("Length: " + set.size() + ", contents: " + set.toString());


        for (Integer e : set) {
            System.out.println("Entry: " + e);
        }
    }
}
