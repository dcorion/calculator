module com.prototype.calculator {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.prototype.calculator to javafx.fxml;
    exports com.prototype.calculator;
}