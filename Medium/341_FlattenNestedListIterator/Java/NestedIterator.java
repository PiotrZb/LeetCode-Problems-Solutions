// import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    LinkedList<Integer> likedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.likedList = new LinkedList<>();
        this.convertToLinkedList(nestedList);
    }

    @Override
    public Integer next() { return this.likedList.poll(); }

    @Override
    public boolean hasNext() { return !this.likedList.isEmpty(); }

    private void convertToLinkedList(List<NestedInteger> nestedList) {
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) this.likedList.add(element.getInteger());
            else convertToLinkedList(element.getList());
        }
    }

    // List<Integer> list;
    // int index, size;

    // public NestedIterator(List<NestedInteger> nestedList) {
    //     this.list = new ArrayList<>();
    //     this.index = 0;
    //     this.convertToList(nestedList);
    //     this.size = this.list.size();
    // }

    // @Override
    // public Integer next() { return this.list.get(this.index++); }

    // @Override
    // public boolean hasNext() { return this.index < this.size; }

    // private void convertToList(List<NestedInteger> nestedList) {
    //     for (int i = 0; i < nestedList.size(); i++) {
    //         NestedInteger element = nestedList.get(i);
    //         if (element.isInteger()) this.list.add(element.getInteger());
    //         else this.convertToList(element.getList());
    //     }
    // }
}