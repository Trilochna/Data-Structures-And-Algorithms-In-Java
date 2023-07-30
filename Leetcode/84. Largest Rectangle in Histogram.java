class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // if the current heights of the rectangle are not in increasing order;
        // then they will be popped

        int area = 0; 
        int n = heights.length;
        int start;

        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int currHeight = heights[i];
            start = i;

            while(!stack.isEmpty() && stack.peek().getValue() > currHeight){

                Pair<Integer, Integer> pair = stack.pop();

                int index = pair.getKey();
                int hgt = pair.getValue();

                area = Math.max(area, hgt * (i - index));
                start = index; 
            }
            stack.push(new Pair(start, currHeight));
        }

        while(!stack.isEmpty()){
            Pair<Integer, Integer> pair = stack.pop();

            int index = pair.getKey();
            int hgt = pair.getValue();

            area = Math.max(area, hgt * (n - index));
        }

        return area;
    }
}


// 2ND APPROACH : 

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int maxarea=Integer.MIN_VALUE;
//         int nsl[]=new int[heights.length];
//         int nsr[]=new int[heights.length];
//         Stack<Integer> s=new Stack<>();
//         //nsr
//         for(int i=heights.length-1;i>=0;i--){
//             while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nsr[i]= heights.length;
//             }
//             else{
//                 nsr[i]= s.peek();
//             }
//             s.push(i);
//         }
//         //next smaller left
//         s=new Stack<>();
//         for(int i=0;i<heights.length;i++){
//             while(!s.isEmpty()&& heights[s.peek()]>=heights[i]){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nsl[i]= -1;
//             }
//             else{
//                 nsl[i]= s.peek();
//             }
//             s.push(i);

//         }
//         for(int i=0;i<heights.length;i++){
//             int heigth=heights[i];
//             int width=nsr[i]-nsl[i]-1;
//             int currarea=heigth*width;
//             maxarea=Math.max(currarea,maxarea);
//         }
//         return maxarea;
//     }
// }
