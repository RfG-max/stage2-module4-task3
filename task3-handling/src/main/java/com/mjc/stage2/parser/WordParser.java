package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;

public class WordParser extends AbstractTextParser {
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String input) {
        // В данном случае WordParser может быть использован для дальнейшей обработки
        TextComponent wordComponent = (TextComponent) abstractTextComponent;

        // Логика обработки слов может быть добавлена здесь
        // Например, вы можете добавить дополнительную обработку слов

        // Если есть следующий парсер, передаем управление ему
        if (nextParser != null) {
            nextParser.parse(wordComponent, input);
        }
    }

    // Write your code here!

}
