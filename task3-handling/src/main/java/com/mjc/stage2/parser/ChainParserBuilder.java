package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        // Write your code here!
        return this;
    }

    public AbstractTextParser build() {
        // Write your code here!
        // Связываем парсеры в цепочку
        for (int i = 0; i < parsers.size() - 1; i++) {
            parsers.get(i).setNextParser(parsers.get(i + 1));
        }

        // Возвращаем первый парсер в цепочке
        return parsers.isEmpty() ? null : parsers.get(0);
    }
}
