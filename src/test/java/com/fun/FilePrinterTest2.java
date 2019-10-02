package com.fun;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilePrinterTest2 {

    @Nested
    class Encode {
        private FilePrinter2 printer = new FilePrinter2();

        private void check(final String input, final String expected) {
            final String encode = printer.encode(input);
            assertThat(encode).isEqualTo(expected);
        }

        @Test
        void should_encode_0_to_0() {
            String input = "0";
            String expected = "0";

            check(input, expected);
        }

        @Test
        void should_encode_1_to_1() {
            String input = "1";
            String expected = "1";

            check(input, expected);
        }

        @Test
        void should_encode_000_to_00() {
            check("000", "00");
        }

        @Test
        void should_encode_111_to_1() {
            check("111", "1");
        }

        @Test
        void should_encode_10_to_1() {
            check("10", "1");
        }

        @Test
        void should_encode_0001_to_001() {
            check("0001", "001");
        }

        @Test
        void should_encode_000111_to_001() {
            check("000111", "001");
        }

        @Test
        void should_encode_111000_to_1() {
            check("111000", "1");
        }

        @Test
        void should_encode_11100000_to_1() {
            check("11100000", "1");
        }

        @Test
        void should_encode_00111111_to_0011(){
            check("00111111", "0011");
        }
        @Test
        void should_encode_1111000011_to_1111(){
            check("1111000011", "1111");
        }
        @Test
        void should_encode_10100101000001101011011110111110101111101000000100100111000101011010100111101101101111010001001001011_to_01111111111111111111111111111111111111(){
            check("0100101000001101011011110111110101111101000000100100111000101011010100111101101101111010001001001011", "01111111111111111111111111111111111111");
        }

        @Test
        void should_encode_110001001010010111110100011100_to_111111111(){
            check("110001001010010111110100011100", "111111111");
        }

    }
}
