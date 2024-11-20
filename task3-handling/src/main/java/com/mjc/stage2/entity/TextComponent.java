package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder content = new StringBuilder();
        for (AbstractTextComponent child : componentList) {
            content.append(child.operation());
            content.append(getComponentType().getDelimiter());
        }
        return content.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (AbstractTextComponent component : componentList) {
            totalSize += component.getSize(); // Суммируем размеры дочерних компонентов
        }
        return totalSize;
    }

    public List<AbstractTextComponent> getComponentList() {
        return componentList; // Возвращаем список дочерних компонентов
    }
// Write your code here!
}
