class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while(columnNumber > 0){
            // get the remainder
            int offset = (columnNumber - 1) % 26;
            result.append((char)('A' + offset));
            columnNumber = (columnNumber - 1) / 26;
        }
        // because we'll be getting the result in opposite order'
        result.reverse();
        return result.toString();
    }
}

/*

//     return columnNumber == 0 ? "" : convertToTitle((columnNumber - 1) / 26) + (char) ('A' + ((columnNumber - 1) % 26));


Converting base 100 system to base 26 system where 26 + 1 = 27 which will be the 
continuation of the 26 alphabetical system 
like, A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
AZ -> 52
BA -> 53
...


Here : at each step the columns alphabets are incrementing by one
the one's column is following A to Z incrementation
whereas in the ten's column is following A - 26 times then increment to B 26 times and so on until Z 26 times....


1 based indexing as a does not map to 0 === it maps to 1
-- we can have 26 characters in each position in a column

here if we'll A + column number to be mapped = B
but, it'll lead to wrong answer

so we will do A + (n - 1) 

*/
