package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser{
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String input) {
        TextComponent textComponent = (TextComponent) abstractTextComponent;
        String[] lexemes = input.split(LEXEME_REGEX); // Разделяем текст на лексемы

        for (String lexeme : lexemes) {
            if (!lexeme.isEmpty()) {
                TextComponent wordComponent = new TextComponent(TextComponentType.WORD);
               // Matcher matcher = Pattern.compile(WORD_REGEX).matcher(lexeme);

               //while (matcher.find()) {
               //     String word = matcher.group();
                    for (char c : lexeme.toCharArray()) {
                        wordComponent.add(new SymbolLeaf(c));
                    }

                textComponent.add(wordComponent);
            }
        }

        // Если есть следующий парсер, передаем управление ему
        if (nextParser != null) {
            nextParser.parse(textComponent, input);
        }
    }

    // Write your code here!

}
