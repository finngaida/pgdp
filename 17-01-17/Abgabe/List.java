//package pgdp;

import java.util.Arrays;

/**
 * Created by fga on 17/01/2017.
 */
public class List<T> {

    final Entry head;

    public List() { this.head = null; }

    /**
     * constructor empty HeadList
     */
    public List(Entry head) {
        this.head = head;
    }

    /**
     * Appends a new element with value info to the end of this list
     * @param info value of the new element
     */
    public List<T> add(T info) {

        // special case: no head
        if (head == null) {
            //System.out.println("Head is null, creating new entry\n" + Integer.toHexString(hashCode()));
            Entry newEntry = new Entry(null, info);
            return new List<>(newEntry);
        }

        // Sonst: neuen Eintrag erstellen
        Entry newEntry = new Entry(null, info);

        //System.out.println("Created new entry: " + newEntry);

        // Alle vorigen einträge einfädeln
        Entry[] entries = new Entry[length()];
        Entry searcher = head;
        for (int i = 0; i < entries.length; i++) {
            entries[entries.length-i-1] = searcher;
            searcher = searcher.next;
        }

        //System.out.println("Queued up all previous entries: " + Arrays.toString(entries));

        // uund neu aufschachteln
        Entry newNext = newEntry;
        for (int i = 0; i < entries.length; i++) {
            newNext = new Entry(newNext, entries[i].elem);
        }

        //System.out.println("Got a new head: " + newNext);

        // die neue Liste zurück
        return new List<>(newNext);
    }

    public boolean contains(T e) {
        Entry stepper = head;
        while (stepper != null) {
            if (stepper.elem.equals(e)) return true;
            stepper = stepper.next;
        }
        return false;
    }

    /**
     * Removes and returns the element at position index from this list.
     * @param index position of the element that is removed
     * @return value of the removed element
     */
    public List remove(int index) {

        // special case: wrong index or no head -> move not legal
        if (index < 0 || head == null) { return null; }

        // special case: remove head
        if (index == 0) {
            return new List(head.next);
        }

        // Alle vorigen einträge einfädeln
        Entry[] entries = new Entry[length()-1];
        Entry searcher = head;
        for (int i = 0; i < entries.length-1; i++) {
            entries[entries.length-i-(i>index ? 2 : 1)] = searcher;
            searcher = head.next;
        }

        // uund neu aufschachteln
        for (int i = 0; i < entries.length-1; i++) {
            searcher = new Entry(searcher, entries[i].elem);
        }

        // die neue Liste zurück
        return new List<>(searcher);
    }

    public int length() {
        int count = 0;
        Entry next = head;
        while (next != null) {
            count++;
            next = next.next;
        }
        return count;
    }

    public Entry[] toArray() {
        Entry[] ret = new Entry[length()];
        Entry stepper = head;
        int counter = 0;
        while (stepper != null) {
            ret[counter] = stepper;
            stepper = stepper.next;
            counter++;
        }
        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof List) {
            List carsten = (List)obj;
            int length = length();
            if (carsten.length() == length) {
                Entry search = head;
                Entry compare = carsten.head;
                for (int i = 0; i < length; i++) {
                    if (!search.equals(compare)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String out = "[";
        if (head != null) {
            out += head.elem;
            Entry tmp = head.next;
            while (tmp != null) {
                out = out + "," + tmp.elem;
                tmp = tmp.next;
            }
        }
        out += "]";
        return out;
    }

    class Entry<T> {

        final Entry next;
        final T elem;

        public Entry(Entry next, T elem) {
            this.next = next;
            this.elem = elem;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Entry) {
                Entry carsten = (Entry)obj;
                if (carsten.elem == null) {
                    return elem == null;
                } else {
                    return carsten.elem.equals(elem);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return elem.toString();
        }
    }

}
