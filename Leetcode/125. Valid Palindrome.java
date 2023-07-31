public boolean isPalindrome(String s) {
    // Initialize two pointers, 'i' and 'j', pointing to the start and end of the string.
    int i = 0;
    int j = s.length() - 1;

    // Loop until the two pointers meet or cross each other.
    while (i < j) {
        // Get the characters at the 'i' and 'j' positions in the string.
        Character start = s.charAt(i);
        Character end = s.charAt(j);

        // Check if the character at 'i' is not a letter or digit.
        if (!Character.isLetterOrDigit(start)) {
            // If so, move the 'i' pointer to the right.
            i++;
            // And skip the rest of the loop to check the next character.
            continue;
        }

        // Check if the character at 'j' is not a letter or digit.
        if (!Character.isLetterOrDigit(end)) {
            // If so, move the 'j' pointer to the left.
            j--;
            // And skip the rest of the loop to check the next character.
            continue;
        }

        // At this point, both 'start' and 'end' are letters or digits.
        // Check if they are equal, ignoring case (converting to lowercase).
        if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
            // If they are not equal, it means the string is not a palindrome.
            // So, we return 'false' immediately.
            return false;
        }

        // If 'start' and 'end' are equal, move the 'i' pointer to the right
        // and the 'j' pointer to the left to compare the next characters in the next iteration.
        i++;
        j--;
    }

    // If the loop completes without finding any mismatched characters,
    // it means the string is a palindrome. So, we return 'true'.
    return true;
}
