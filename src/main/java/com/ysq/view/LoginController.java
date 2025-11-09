package com.ysq.view;

import com.ysq.dao.UserDao;
import com.ysq.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;

// 761,523
public class LoginController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberCheckbox;

    @FXML
    private Hyperlink forgotPasswordLink;

    @FXML
    private Hyperlink registerLink;

    @FXML
    private Button loginButton;

    @FXML
    private void initialize() {
        System.out.println("登录控制器初始化完成");
    }

    @FXML
    private void handleLogin() {
        // TODO
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        boolean remember = rememberCheckbox.isSelected();

        User user = UserDao.getUserByName(username);
        if (user == null) {
            showAlert(Alert.AlertType.WARNING, "输入错误", "用户不存在。");
        } else if (!user.getPassword().equals(password)) {
            showAlert(Alert.AlertType.ERROR, "密码错误", "输入密码不正确，请重新检查。");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "登录成功", "欢迎回来，" + user.getFamilyName());
        }
    }

    @FXML
    private void handleForgotPassword() {

    }

    @FXML
    private void handleRegister() {

    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
