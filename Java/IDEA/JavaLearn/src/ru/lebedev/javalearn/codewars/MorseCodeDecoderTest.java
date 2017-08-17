package ru.lebedev.javalearn.codewars;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MorseCodeDecoderTest {
    @Test
    public void testA() {
        assertThat(MorseCodeDecoder.decode(".-"), is("A"));
    }

    @Test
    public void testB() {
        assertThat(MorseCodeDecoder.decode("-..."), is("B"));
    }

    @Test
    public void testAB() {
        assertThat(MorseCodeDecoder.decode(".- -..."), is("AB"));
    }

    @Test
    public void testTwoWords() {
        assertThat(MorseCodeDecoder.decode("  .- -...   .- -... "), is("AB AB"));
    }
}