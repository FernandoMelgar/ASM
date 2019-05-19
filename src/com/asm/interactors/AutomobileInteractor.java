package com.asm.interactors;

import com.asm.entities.Automobile;
import com.asm.entities.MockData;
import com.asm.view.controller.properties.AutomobileProperty;

import java.util.ArrayList;
import java.util.List;

public class AutomobileInteractor {


    public List<AutomobileProperty> changeToAutomobileProperty(List<Automobile> automobiles){

        List<AutomobileProperty> automobileProperties = new ArrayList<>();

        for (Automobile a: automobiles){
            AutomobileProperty property = new AutomobileProperty(
                    a.getId(),
                    a.getManufacture(),
                    a.getModel(),
                    String.valueOf(a.getYear()),
                    a.getLicencePlate(),
                    a.getSerialNumber(),
                    String.valueOf(a.getCurrentKilometers()));

            automobileProperties.add(property);
        }

        return automobileProperties;
    }

    public static void main(String[] args) {
        AutomobileInteractor automobileInteractor = new AutomobileInteractor();
        List<AutomobileProperty> automobileProperties = automobileInteractor.changeToAutomobileProperty(MockData.createMockAutomobileList());
        for (AutomobileProperty property: automobileProperties){
            System.out.println(property.getModel());
        }
    }
}
