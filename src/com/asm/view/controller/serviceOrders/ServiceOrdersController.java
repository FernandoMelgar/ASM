package com.asm.view.controller.serviceOrders;

import com.asm.entities.order.Status;
import com.asm.interactors.OrderInteractor;
import com.asm.view.controller.properties.OrderProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServiceOrdersController  implements Initializable{

    private ObservableList<OrderProperty> ordersData;
    private String currentUserID;
    private OrderInteractor interactor;
    private String baseURL = "http://localhost:8080";
    private ScrollPane mainScrollPane;

    // Anchor pane for forms
    @FXML
    private AnchorPane mainAnchorPane;

    // Clients table items
    @FXML private TableView<OrderProperty> ordersTable;
    @FXML private TableColumn<OrderProperty, String> columnID;
    @FXML private TableColumn<OrderProperty, String> columnClientName;
    @FXML private TableColumn<OrderProperty, String> columnAutomobileName;
    @FXML private TableColumn<OrderProperty, String> columnService;
    @FXML private TableColumn<OrderProperty, String> columnEmployee;

    @FXML private TableColumn<OrderProperty, String> columnRequiredTime;
    @FXML private TableColumn<OrderProperty, String> columnPrice;
    @FXML private TableColumn<OrderProperty, String> columnStatus;


    // Client Details labels
    @FXML private SplitPane clientDetailSplitPane;
    @FXML private AnchorPane clientDetailsPane;
    @FXML private VBox clientDetailsVBox;
    @FXML private VBox carDetailsVBox;
    @FXML private Label serviceTypeDetail;
    @FXML private Label serviceDescriptionDetail;
    @FXML private Label serviceClientDetail;
    @FXML private Label serviceCarDetail;
    @FXML private Label serviceEmployeeDetail;
    @FXML private Label serviceStartDateDetail;
    @FXML private Label serviceFinishDateDetail;
    @FXML private Label servicePriceDetail;

    private OrderProperty selectedOrder;


    public ServiceOrdersController() {
        this.interactor = new OrderInteractor();
        try {
            this.ordersData = FXCollections.observableArrayList(interactor.readAsOrderProperty());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<OrderProperty> getOrdersData() {
        return ordersData;
    }

    private void setUpTable() {
        ordersTable.setItems(getOrdersData());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnID.setCellValueFactory(cellData-> cellData.getValue().idProperty());
        columnClientName.setCellValueFactory(cellData -> cellData.getValue().clientProperty());
        columnAutomobileName.setCellValueFactory(cellData -> cellData.getValue().automobileProperty());
        columnEmployee.setCellValueFactory(cellData -> cellData.getValue().mechanicProperty());
        columnService.setCellValueFactory(cellData -> cellData.getValue().serviceProperty());
        columnRequiredTime.setCellValueFactory(cellData-> cellData.getValue().hourlyRequiredTimeProperty());
        columnPrice.setCellValueFactory(cellData-> cellData.getValue().priceProperty());
        columnStatus.setCellValueFactory(cellData-> cellData.getValue().statusProperty());
        showEmployeeDetails(null);

//        columnNSS.setCellValueFactory(cellData-> cellData.getValue().nssProperty());
        ordersTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEmployeeDetails(newValue)
        );
        setUpTable();
    }

    private void showClientDetailsPane(boolean visible) {
        clientDetailsPane.setVisible(visible);
        clientDetailsPane.setManaged(visible);
    }

    public void showEmployeeDetails(OrderProperty OrderProperty) {
        System.out.println("Here on earth");
        if (OrderProperty != null) {
            this.selectedOrder = OrderProperty;
            showClientDetailsPane(true);
            carDetailsVBox.getChildren().clear();
            clientDetailSplitPane.setDividerPositions(new double[]{0.5});
            serviceTypeDetail.setText( OrderProperty.getService());
            serviceDescriptionDetail.setText(OrderProperty.getDescription());
            serviceClientDetail.setText(OrderProperty.getClient());
            serviceEmployeeDetail.setText(OrderProperty.getMechanic());
            serviceCarDetail.setText(OrderProperty.getAutomobile());
            serviceStartDateDetail.setText(OrderProperty.getStartDate());
            servicePriceDetail.setText("$"+OrderProperty.getPrice());
        } else {
            showClientDetailsPane(false);
            clientDetailSplitPane.setDividerPositions(new double[]{1});
            serviceTypeDetail.setText("");
            serviceDescriptionDetail.setText("");
            serviceClientDetail.setText("");
            serviceEmployeeDetail.setText("");
            serviceCarDetail.setText("");
            servicePriceDetail.setText("");
            currentUserID = "";
        }
    }

    public void closeClientDetails(MouseEvent mouseEvent) {
        showClientDetailsPane(false);
        clientDetailSplitPane.setDividerPositions(new double[]{1});
        serviceTypeDetail.setText("");
        serviceDescriptionDetail.setText("");
        serviceClientDetail.setText("");
        currentUserID = "";
    }

    public void newOrderClicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/services_views/newServiceOrder.fxml"));
        Parent root = loader.load();
        NewServiceOrderController newServiceOrderController= loader.getController();
        newServiceOrderController.init(mainScrollPane);
        this.mainScrollPane.setContent(root);
        mainScrollPane.setFitToWidth(true);
        System.out.println("New Order");
    }

    public int initToGetCount() {
        return getOrdersData().size();
    }

    public double getTotalIncome() {
        double total = 0;
        for (int i = 0; i < ordersData.size(); i++) {
            OrderProperty order = ordersData.get(i);
            String orderStatus = order.getStatus();
            if (orderStatus.equals("FINISHED")) {
                total += new Double(order.getPrice());
            }
        }

        return total;
    }

    public void init(ScrollPane mainScrollPane) {
        this.mainScrollPane = mainScrollPane;
    }

    public void initWithNewOrder(ScrollPane mainScrollPane, OrderProperty createdOrder) {
        this.mainScrollPane = mainScrollPane;
        this.ordersData.add(createdOrder);
    }

    public void finishOrder(MouseEvent mouseEvent) {
        if (this.selectedOrder != null) {
            selectedOrder.setStatus(Status.FINISHED.toString());
        }
    }

    public void cancelOrder(MouseEvent mouseEvent) {
    }
}
