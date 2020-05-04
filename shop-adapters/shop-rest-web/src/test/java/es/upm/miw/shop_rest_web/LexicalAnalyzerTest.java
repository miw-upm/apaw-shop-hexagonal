package es.upm.miw.shop_rest_web;

import es.upm.miw.shop_domain.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LexicalAnalyzerTest {

    @Test
    void testExtractAssuredFirst() {
        assertEquals("ana", new LexicalAnalyzer().extractAssured("name:ana", "name"));
        assertEquals("ana", new LexicalAnalyzer().extractAssured("name:ana;surname:gil", "name"));
        assertEquals("", new LexicalAnalyzer().extractAssured("name", "name"));
        assertEquals("", new LexicalAnalyzer().extractAssured("name;surname:gil", "name"));
    }

    @Test
    void testExtractAssuredSecond() {
        assertEquals("gil", new LexicalAnalyzer().extractAssured("name:ana;surname:gil", "surname"));
        assertEquals("", new LexicalAnalyzer().extractAssured("name:ana;surname", "surname"));
    }

    @Test
    void testExtractAssuredBadRequestKeyNotFound() {
        assertThrows(BadRequestException.class, () ->
                new LexicalAnalyzer().extractAssured("name:ana;surname:gil", "ana"));
    }

    @Test
    void testExtractAssuredBadRequestEmpty() {
        assertThrows(BadRequestException.class, () ->
                new LexicalAnalyzer().extractAssured("", "name"));
    }

    @Test
    void testExtractConvertedAssured() {
        BigDecimal price = new LexicalAnalyzer().extractAssured("price:10.12", "price", BigDecimal::new);
        assertEquals(0, new BigDecimal("10.12").compareTo(price));
    }

    @Test
    void testExtractConvertedAssuredError() {
        assertThrows(BadRequestException.class, () ->
                new LexicalAnalyzer().extractAssured("price:kk", "price", BigDecimal::new));
    }

}
