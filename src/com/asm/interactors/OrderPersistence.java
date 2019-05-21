package com.asm.interactors;

import com.asm.entities.order.Order;

import java.util.List;

public interface OrderPersistence {

    List<Order> readAll();
}
