package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver  implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();

        double square = sideA * sideB;
        double perimeter = 2 * (sideA + sideB);

        RectangleWarehouse warehouse = RectangleWarehouse.getInstance();
        warehouse.put(rectangle.getId(), new RectangleValues(square, perimeter));

    }
}
