package org.mamedov;

public class Compressor {

    public static void main(String[] args) {
        String bigString = "AAAAANNNMMMMYYYYuuuuUUUUaaaarWWLLLLJ888DDDDDDDDD";
//        String bigString = "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" +
//                "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" +
//                "rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr" +
//                "AAAAANNNMMMMYYYYuuuuUUUUaaaarWWLLLLJ888DDDDDDDDD";
//        String bigString = "bnm";
        System.out.println(bigString);

        String compressString = compress(bigString);
        System.out.println(compressString);

        String normalString = deCompress(compressString);
        System.out.println(normalString);

    }

    /** Compress the input string to the more short length.
     * Effective only for the string which have repeating characters like AAAAANNNMMMMYYYYuuuuUUUU
     * Algorithm convert the repeating characters to 2 values XY , where X - Character, Y - how much it repeats
     * For saving the counts of repeats used the character value it gets possibility to use counter to 65535 (Character.MAX_VALUE)
     * @param input Normal string
     * @return compressed string
     */
    public static String compress(String input) {

        char[] charArr = input.toCharArray();
        StringBuilder builderResult = new StringBuilder();

        int counter = 0;
        Character currentChar = null;
        for (char el : charArr) {
            // we can save in one char counter not more than Character.MAX_VALUE
            if (currentChar != null && currentChar.equals(el) && counter < Character.MAX_VALUE) {
                // we still in the block
                counter++;
            } else if (counter > 0) {

                // save the previous block of characters
                builderResult.append(currentChar);
                // transfer counter to ascii code it will add possibility to save to 256 value in a counter
                builderResult.append((char) counter);
                //  update the counters
                counter = 1;
                currentChar = el;
            } else {
                //  update the counters
                counter = 1;
                currentChar = el;
            }
        }
        if (charArr.length > 0) {
            // save the previous block of characters
            builderResult.append(currentChar);
            builderResult.append((char) counter);
        }

        return builderResult.toString();
    }

    /** Decompress String to the normal view
     * @param input compressed string
     * @return normal string
     */
    public static String deCompress(String input) {

        char[] charArr = input.toCharArray();
        StringBuilder builderResult = new StringBuilder();

        char counterChar;
        char currentChar;
        int counterInt;
        for (int i = 0; (i < charArr.length / 2); i++) {
            currentChar = charArr[(i * 2)];
            counterChar = charArr[(i * 2) + 1];
            counterInt = (int) counterChar; // convert the character to integer
            for (int j = 0; j < counterInt; j++) {
                builderResult.append(currentChar);
            }
        }

        return builderResult.toString();
    }

}
