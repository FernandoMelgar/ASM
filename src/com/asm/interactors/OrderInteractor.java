package com.asm.interactors;

import com.asm.entities.MockData;
import com.asm.entities.order.Order;
import com.asm.entities.worker.Employee;
import com.asm.view.controller.properties.OrderProperty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderInteractor {

    private OrderPersistence persistence;

    public OrderInteractor() {
        this.persistence = new OrderMockPersistence();
    }

    public List<OrderProperty> readAsOrderProperty() throws IOException {
        List<Order> orders = persistence.readAll();
        return getAsOrdersProperty(orders);
    }

    public static List<OrderProperty> getAsOrdersProperty(List<Order> orders) {
        List<OrderProperty> orderProperties = new ArrayList<>();

        for (Order o :
                orders) {
            orderProperties.add(new OrderProperty(
                   String.valueOf(o.getId()),
                    o.getClient().getName(),
                    o.getAutomobile().getManufacture() + " "
                            + o.getAutomobile().getModel(),
                    o.getService().name,
                    o.getMechanic().getName(),
                    o.getDescription(),
                    "Basic service",
                    "No extra pieces",
                    String.valueOf(o.getHourlyRequiredTime()),
                    String.valueOf(o.getPrice()),
                    "2019-08-17",
                    o.getStatus().toString(),
                   String.valueOf(o.getOrderScore())
            ));

        }
        return orderProperties;
    }

}

class OrderMockPersistence  implements OrderPersistence{

    @Override
    public List<Order> readAll() {
        return MockData.createMockOrders();
    }
}
