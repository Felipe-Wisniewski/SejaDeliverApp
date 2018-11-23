package br.com.flmwg.provadeliver.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CharactersTest {

    private Characters chars;

    @Test
    public void shouldReturn_biggerSequence() {
        chars = new Characters("preessaAao");

        Assert.assertEquals("aaa", chars.getBiggerSequence());
    }

    @Test
    public void shouldReturn_null() {
        chars = new Characters("paralelepipedo");

        Assert.assertEquals("Não possue sequência!", chars.getBiggerSequence());
    }
}