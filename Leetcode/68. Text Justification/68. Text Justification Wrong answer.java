class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int currLineLength = 0;
        int i = 0;

        while(i < words.length){
            // case : When line is complete i.e fully justification 

            // how will we know that the current line if complete
            if(currLineLength + currLine.size() + words[i].length() > maxWidth){ // currLine.size() is space to be added
            // distribute the extra space evenly
                // how will we get the extra space
                int extraSpace = maxWidth - currLineLength;
                // now calculate the number of spaces that will go in between each word
                int putSpace = extraSpace / Math.max(1, currLine.size() - 1); // to remove denominator errors
                int greedySpaces = extraSpace % Math.max(1, currLine.size() - 1);

                // now add all these calculated spaces
                for(int j = 0; j < Math.max(1, currLine.size() - 1); j++){ // -1 because we will not add spaces between the words not after i.e left as well fully justificatioon handled
                        for (int k = 0; k < putSpace; k++) {
                            currLine.set(j, currLine.get(j) + " ");
                        }
                    if(greedySpaces != 0){
                        // append them to the end of the word
                        for (int k = 0; k < putSpace; k++) {
                            currLine.set(j, currLine.get(j) + " ");
                        }
                        greedySpaces--;
                    }

                }

                result.add(String.join("", currLine));
                // reset
                currLine = new ArrayList<>();
                currLineLength = 0;

// here we are having the word + one space for each word+ current word and if all this is greater than the max width then go to next line to add more words
            }


            // case : of when line if not complete 
            // we are going to be updating the line
            currLine.add(words[i]);
            // update the length of the current line as well
            currLineLength += words[i].length();
            i++; // to get to the next word

        }
        // Handling last line
        StringBuilder lastLine = new StringBuilder(String.join(" ", currLine));
        int trailSpace = maxWidth - lastLine.length();
        for (int k = 0; k < trailSpace; k++) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;

    }
}
