class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (final int a : asteroids)
            if (a > 0) {
                stack.push(a);
            } else { // a < 0
                // Destroy previous positive one(s).
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a)
                    stack.pop();
                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(a);
                else if (stack.peek() == -a)
                    stack.pop();
                else
                    ;
            }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
