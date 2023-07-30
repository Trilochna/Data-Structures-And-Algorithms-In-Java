class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // we will be using the monotonic stack : https://www.youtube.com/watch?v=Dq_ObZwTY_Q
        // here we will be using it in decreasing order/
        // i.e. stack can either store the same value or the smaller value not the greater value
        // greater values will get some elements in the stcak poped according to the condition

        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int currDay = 0; currDay < temperatures.length; currDay++){

            // This line starts a while-loop that runs as long as the stack is not empty, and the temperature of the current day ("temperatures[currDay]") is greater than the temperature of the day represented by the top element of the stack ("temperatures[stack.peek()]").

            while(!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]){

                // Inside the while-loop, this line pops (removes and returns) the top element from the stack and assigns it to the variable "prevDay." The top element represents the index of the day with a temperature lower than the current day's temperature.

                int prevDay = stack.pop();

                // This line calculates the number of days between the current day ("currDay") and the day with a lower temperature ("prevDay"). It then stores this difference in the "ans" array at the index represented by "prevDay." This difference represents the number of days the previous day must wait until a warmer day.

                answer[prevDay] = currDay - prevDay;
            }
            stack.add(currDay);
        }

        return answer;

    }
}
