package org.mamedov;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void compress() {
        String bigString = "AAAAANNNMMMMYYYYuuuuUUUUaaaarWWLLLLJ888DDDDDDDDD";
        String compressString = compress(bigString);

    }

    @org.junit.jupiter.api.Test
    void deCompress() {


    }
}
