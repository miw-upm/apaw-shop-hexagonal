package es.upm.miw.shop_rest_web;

import es.upm.miw.shop_domain.exceptions.BadRequestException;

import java.util.function.Function;
import java.util.stream.Stream;

public class LexicalAnalyzer {

    private static final String ASSIGNMENT = ":";
    private static final String BOOKMARK = ";";

    public String extractAssured(String q, String key) {
        String[] token = Stream.of(q.split(BOOKMARK))
                .filter(item -> item.startsWith(key))
                .map(item -> item.split(ASSIGNMENT))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Key not found: " + key));
        return token.length > 1 ? token[1] : "";
    }

    public <T> T extractAssured(String q, String key, Function<String, T> convert) {
        String value = this.extractAssured(q, key);
        try {
            return convert.apply(value);
        } catch (Exception e) {
            throw new BadRequestException("q: incorrect type: " + value);
        }
    }

}
