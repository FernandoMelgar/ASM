package com.asm.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;

public class DashboardController {
    private ScrollPane mainScrollPane;

    @FXML private Label activeClientsLabel;
    @FXML private Label activeEmployeesLabel;
    @FXML private Label currentOrdersLabel;
    @FXML private Label totalIncomeLabel;

    public void activeClientsBoxOnClick(MouseEvent event) {

    }

    public void activeEmployeesBoxOnClick(MouseEvent event) {

    }

    public void currentOrdersOnClick(MouseEvent event) {

    }

    public void incomeBoxOnClick(MouseEvent event) {

    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }
}
