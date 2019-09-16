public class FlattenNestedList {
    //Given a nested list of integers, implement an iterator to flatten it.
    //
    //Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    //
    //Example 1:
    //
    //Input: [[1,1],2,[1,1]]
    //Output: [1,1,2,1,1]
    //Explanation: By calling next repeatedly until hasNext returns false,
    //             the order of elements returned by next should be: [1,1,2,1,1].
    //Example 2:
    //
    //Input: [1,[4,[6]]]
    //Output: [1,4,6]
    //Explanation: By calling next repeatedly until hasNext returns false,
    //             the order of elements returned by next should be: [1,4,6].

    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                NestedInteger curr = stack.peek();
                if(curr.isInteger()) {
                    return true;
                }
                stack.pop();
                for(int i = curr.getList().size() - 1; i >= 0; i--) {
                    stack.push(curr.getList().get(i));
                }
            }
            return false;
        }
    }


}
