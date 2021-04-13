package cn.az.code.year2021.apr;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @author ycpang
 * @since 2021-04-13 16:11
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private final Stack<ListIterator<NestedInteger>> lists;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return lists.peek().next().getInteger();
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()) {
                    return lists.peek().previous() == x;
                }
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
