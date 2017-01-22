//package pgdp;

import java.util.Iterator;

/**
 * Created by fga on 17/01/2017.
 */
public class Set<T> implements Iterable<T> {

    final List<T> list;
    
    public static void main(String[] args) {
    
    }

    public Set() {
        this.list = new List<>();
    }

    public Set(List list) {
        this.list = list;
    }

    public Set<T> add(T e) throws NullPointerException {

        if (e == null) {
            throw new NullPointerException("Can't add 'null' to a set");
        }

        if (!contains(e)) {
            return new Set<>(list.add(e));
        } else { return this; }
    }

    public Set<T> remove(T e) throws NullPointerException {

        if (e == null) {
            throw new NullPointerException("Can't remove 'null' from a set");
        }

        if (contains(e)) {
            int index = 0;
            List.Entry searcher = list.head;
            while (searcher != null) {
                if (searcher.elem.equals(e)) {
                    return new Set<>(list.remove(index));
                }
                searcher = searcher.next;
                index++;
            }
        }
        return this;
    }

    public boolean contains(T e) {
        return list.contains(e);
    }

    public int size() {
        return list.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Set) {
            List.Entry[] in = ((Set)obj).list.toArray();
            List.Entry[] cmp = list.toArray();

            if (in.length != cmp.length) { return false; }

            // create an array that keeps track of the already compared indexes
            int[] used = new int[in.length]; int usedCounter = 0;
            for (int i = 0; i < used.length; i++) {
                used[i] = -1;
            }

            // for every entry in the inList, check of there is another one in the cmp list
            for (int i = 0; i < in.length; i++) {
                boolean foundOne = false;

                // loop the compare
                for (int j = 0; j < cmp.length; j++) {

                    // yay, found an entry that matches
                    if (in[i].equals(cmp[j])) {
                        foundOne = true;

                        // check if we already had that
                        for (int k = 0; k < used.length; k++) {
                            if (used[k] == j) {
                                foundOne = false;
                                break;
                            }
                        }

                        // block this index for future compares
                        used[usedCounter] = j; usedCounter++;
                        break;
                    }
                }

                // couldn't find an entry like this :(
                if (!foundOne) { return false; }
            }
            return true;

        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "{";
        List.Entry current = list.head;
        while (current != null) {
            if (!s.equals("{")) { s += ", "; }
            s += current.elem.toString();
            current = current.next;
        }
        s += "}";
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator<>(this);
    }

    private class SetIterator<T> implements Iterator<T> {

        public Set<T> set;
        public int cursor;

        public SetIterator(Set<T> set) throws NullPointerException {

            if (set == null) {
                throw new NullPointerException("You can't iterate over an empty set.");
            }

            this.set = set;
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < set.size();
        }

        @Override
        public T next() {
            List.Entry search = list.head;
            int counter = 0;
            while (counter < cursor) {
                search = search.next;
                counter++;
            }
            cursor++;

            if (search == null) {
                return null;
            } else {
                return (T) search.elem;
            }
        }
    }
}
