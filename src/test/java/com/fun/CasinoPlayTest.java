package com.fun;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * the algo here is to find the sequence witch provider the minimum sum in a number array (int) (size : 1 to 10_000, value : -3000 to 3000)
 *
 * if the sum > 0, none will be selected
 *
 * output : the minimum sum
 * */
public class CasinoPlayTest {

    private CasinoPlay casinoPlay = new CasinoPlay();

    private void assertMinSum(final Integer[] input, final int expectedOutput) {
        final int sum = casinoPlay.beatMe(input);
        assertThat(sum).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("sum : 0 when input : {0}")
    void should_return_0__1() {
        final Integer[] input = {0};
        int expectedOutput = 0;
        assertMinSum(input, expectedOutput);
    }

    @Test
    @DisplayName("sum : -1 when input : {-1}")
    void should_return_minus1__1() {
        final Integer[] input = {-1};
        int expectedOutput = -1;
        assertMinSum(input, expectedOutput);
    }

    @Test
    @DisplayName("sum : 0 when input : {1, 0}")
    void should_return_0__2() {
        assertMinSum(new Integer[]{1, 0}, 0);
    }

    @Test
    @DisplayName("sum : -2 when input : {1, -1, -1}")
    void should_return_minus1__2() {
        assertMinSum(new Integer[]{1, -1, -1}, -2);
    }

    @Test
    @DisplayName("sum : -6 when input : {2, -3, 5, -1, -2, -3, 6}")
    void should_return_minus6__1() {
        assertMinSum(new Integer[]{2, -3, 5, -1, -2, -3, 6}, -6);
    }

    @Test
    @DisplayName("sum : -31 when input : {2, -3, 5, -1, -2, -3, 6}")
    void examine_1() {
        assertMinSum(new Integer[]{5, -13, 2, -15, -5, 14}, -31);
    }

    @Test
    @DisplayName("sum : -32 when input : {2, -3, 5, -1, -2, -3, 6}")
    void examine_2() {
        assertMinSum(new Integer[]{10, -28, 19,
                16,
                2,
                -2,
                -24,
                -6,
                24,
                -2,
                20}, -32);
    }
    @Test
    @DisplayName("sum : -5 when input : { 1, -5}")
    void examine_3() {
        assertMinSum(new Integer[]{1, -5}, -5);
    }


}
