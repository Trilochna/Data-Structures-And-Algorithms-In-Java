class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + line.size() + word.length() <= maxWidth) {
                line.add(word);
                lineLength += word.length();
            } else {
                result.add(line);
                line = new ArrayList<>();
                line.add(word);
                lineLength = word.length();
            }
        }

        result.add(line);

        List<String> justifiedLines = new ArrayList<>();
        for (int i = 0; i < result.size() - 1; i++) {
            line = result.get(i);
            int numWords = line.size();
            int numSpaces = maxWidth - line.stream().mapToInt(String::length).sum();

            int spaceGaps = Math.max(numWords - 1, 1);
            int spacesPerGap = numSpaces / spaceGaps;
            int extraSpaces = numSpaces % spaceGaps;

            StringBuilder justifiedLine = new StringBuilder();
            for (String word : line) {
                justifiedLine.append(word);

                if (spaceGaps > 0) {
                    int spacesToAdd = spacesPerGap + (extraSpaces > 0 ? 1 : 0);
                    justifiedLine.append(" ".repeat(spacesToAdd));
                    extraSpaces -= 1;
                    spaceGaps -= 1;
                }
            }

            justifiedLines.add(justifiedLine.toString());
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", result.get(result.size() - 1)));
        lastLine.append(" ".repeat(maxWidth - lastLine.length()));
        justifiedLines.add(lastLine.toString());

        return justifiedLines;        
    }
}
