package Iterators;

import java.util.*;

//o(1) | o(d) => depth of each level
public class FlattenNestedListIterator {
    class NestedIterator implements Iterator<Integer> {

        private Stack<List<NestedInteger>> listStack = new Stack<>();
        private Stack<Integer> indexStack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            listStack.add(nestedList);
            indexStack.add(0);
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            int currentPosition = indexStack.pop();
            indexStack.add(currentPosition + 1);
            return listStack.peek().get(currentPosition).getInteger();
        }


        @Override
        public boolean hasNext() {
            makeStackTopAnInteger();
            return !indexStack.isEmpty();
        }


        private void makeStackTopAnInteger() {

            while (!indexStack.isEmpty()) {

                // If the top list is used up, pop it and its index.
                if (indexStack.peek() >= listStack.peek().size()) {
                    indexStack.pop();
                    listStack.pop();
                    continue;
                }

                // Otherwise, if it's already an integer, we don't need to do anything.
                if (listStack.peek().get(indexStack.peek()).isInteger()) {
                    break;
                }

                // Otherwise, it must be a list. We need to update the previous index
                // and then add the new list with an index of 0.
                listStack.add(listStack.peek().get(indexStack.peek()).getList());
                indexStack.add(indexStack.pop() + 1);
                indexStack.add(0);
            }
        }
    }
}
