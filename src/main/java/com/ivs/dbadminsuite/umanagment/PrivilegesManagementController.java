package com.ivs.dbadminsuite.umanagment;

import com.ivs.dbadminsuite.errorhandler.ErrorHandler;
import com.ivs.dbadminsuite.db.DatabaseGetData;
import com.ivs.dbadminsuite.db.DatabaseSetData;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrivilegesManagementController {
    @FXML
    private TableView<UserPrivileges> privilegesTableView;
    @FXML
    private TableColumn<UserPrivileges, String> userColumn;
    //@FXML
    //private TableColumn<UserPrivileges, String> authenticationStringColumn;
    @FXML
    private TableColumn<UserPrivileges, String> hostColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> selectPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> insertPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> updatePrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> deletePrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> createPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> dropPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> grantPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> referencesPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> alterPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> createTmpTablePrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> lockTablesPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> executePrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> createViewPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> showViewPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> createRoutinePrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> alterRoutinePrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> eventPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> triggerPrivColumn;
    @FXML
    private TableColumn<UserPrivileges, Boolean> accountLockedColumn;


    private List<UserPrivileges> userPrivilegesList;

    public void initialize() {
        try {
            userColumn.setCellValueFactory(new PropertyValueFactory<>("user"));
            hostColumn.setCellValueFactory(new PropertyValueFactory<>("host"));
            selectPrivColumn.setCellValueFactory(new PropertyValueFactory<>("selectPriv"));
            selectPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isSelectPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic(); // Получаем чекбокс из графического содержимого ячейки
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected(); // Инвертируем текущее значение чекбокса
                            rowData.setSelectPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"selectPriv", newStatus);
                            cell.commitEdit(newStatus); // Применяем изменения к ячейке
                        }
                    }
                });

                return cell;
            });
            insertPrivColumn.setCellValueFactory(new PropertyValueFactory<>("insertPriv"));
            insertPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isInsertPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setInsertPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"insertPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            updatePrivColumn.setCellValueFactory(new PropertyValueFactory<>("updatePriv"));
            updatePrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isUpdatePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setUpdatePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"updatePriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            deletePrivColumn.setCellValueFactory(new PropertyValueFactory<>("deletePriv"));
            deletePrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isDeletePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setDeletePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"deletePriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            createPrivColumn.setCellValueFactory(new PropertyValueFactory<>("createPriv"));
            createPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isCreatePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setCreatePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"createPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            dropPrivColumn.setCellValueFactory(new PropertyValueFactory<>("dropPriv"));
            dropPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isDropPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setDropPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"dropPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            grantPrivColumn.setCellValueFactory(new PropertyValueFactory<>("grantPriv"));
            grantPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isGrantPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setGrantPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"grantPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            referencesPrivColumn.setCellValueFactory(new PropertyValueFactory<>("referencesPriv"));
            referencesPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isReferencesPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setReferencesPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"referencesPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            alterPrivColumn.setCellValueFactory(new PropertyValueFactory<>("alterPriv"));
            alterPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isAlterPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setAlterPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"alterPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            createTmpTablePrivColumn.setCellValueFactory(new PropertyValueFactory<>("createTmpTablePriv"));
            createTmpTablePrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isCreateTmpTablePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setCreateTmpTablePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"createTmpTablePriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            lockTablesPrivColumn.setCellValueFactory(new PropertyValueFactory<>("lockTablesPriv"));
            lockTablesPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isLockTablesPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setLockTablesPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"lockTablesPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            executePrivColumn.setCellValueFactory(new PropertyValueFactory<>("executePriv"));
            executePrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isExecutePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setExecutePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"executePriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            createViewPrivColumn.setCellValueFactory(new PropertyValueFactory<>("createViewPriv"));
            createViewPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isCreateViewPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setCreateViewPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"createViewPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            showViewPrivColumn.setCellValueFactory(new PropertyValueFactory<>("showViewPriv"));
            showViewPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isShowViewPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setShowViewPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"showViewPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });

            createRoutinePrivColumn.setCellValueFactory(new PropertyValueFactory<>("createRoutinePriv"));
            createRoutinePrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isCreateRoutinePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setCreateRoutinePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"createRoutinePriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            alterRoutinePrivColumn.setCellValueFactory(new PropertyValueFactory<>("alterRoutinePriv"));
            alterRoutinePrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isAlterRoutinePriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setAlterRoutinePriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"alterRoutinePriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            eventPrivColumn.setCellValueFactory(new PropertyValueFactory<>("eventPriv"));
            eventPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isEventPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setEventPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"eventPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            triggerPrivColumn.setCellValueFactory(new PropertyValueFactory<>("triggerPriv"));
            triggerPrivColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isTriggerPriv());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic();
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected();
                            rowData.setTriggerPriv(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"triggerPriv", newStatus);//ZDES'
                            cell.commitEdit(newStatus);
                        }
                    }
                });

                return cell;
            });
            accountLockedColumn.setCellValueFactory(new PropertyValueFactory<>("accountLocked"));
            accountLockedColumn.setCellFactory(column -> {
                javafx.scene.control.cell.CheckBoxTableCell<UserPrivileges, Boolean> cell = new CheckBoxTableCell<>(index -> {
                    UserPrivileges userPrivileges = privilegesTableView.getItems().get(index);
                    return new SimpleBooleanProperty(userPrivileges.isAccountLocked());//ZDES'
                });
                cell.setOnMouseClicked(event -> {
                    if (!cell.isEmpty()) {
                        CheckBox checkBox = (CheckBox) cell.getGraphic(); // Получаем чекбокс из графического содержимого ячейки
                        if (checkBox != null) {
                            TableView<UserPrivileges> tableView = cell.getTableView();
                            UserPrivileges rowData = tableView.getItems().get(cell.getIndex());
                            boolean newStatus = !checkBox.isSelected(); // Инвертируем текущее значение чекбокса
                            rowData.setAccountLocked(newStatus);//ZDES'
                            updateUserPrivilegesList(rowData,"accountLocked", newStatus);
                            cell.commitEdit(newStatus); // Применяем изменения к ячейке
                        }
                    }
                });

                return cell;
            });

            userPrivilegesList = new ArrayList<>();
            DatabaseGetData databaseGetData = new DatabaseGetData();
            userPrivilegesList = databaseGetData.getUserPrivilegesList();
            for (UserPrivileges userPrivileges : userPrivilegesList) {
                privilegesTableView.getItems().add(userPrivileges);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateUserPrivilegesList(UserPrivileges updatedUserPrivileges, String privilege, boolean newStatus) {
        if (updatedUserPrivileges == null || updatedUserPrivileges.getUser() == null) {
            ErrorHandler.showError("Ошибка", "Невозможно обновить права. Передан некорректный объект UserPrivileges.");
            return;
        }
        if (userPrivilegesList == null || userPrivilegesList.isEmpty()) {
            ErrorHandler.showError("Ошибка", "Список с правами пуст.");
            return;
        }
        boolean found = false;
        for (UserPrivileges userPrivileges : userPrivilegesList) {
            if (userPrivileges.getUser() != null && userPrivileges.getUser().equals(updatedUserPrivileges.getUser())) {
                userPrivileges.updatePrivilege(privilege, newStatus);
                found = true;
                break;
            }
        }
        if (!found) {
            ErrorHandler.showError("Ошибка", "Пользователь " + updatedUserPrivileges.getUser() + " не найдена.");
        }
        privilegesTableView.refresh();
    }

    @FXML
    private void addNewUser() {
        AddUser addUser = new AddUser();
        Stage stage = new Stage();
        try {
            addUser.openAddUser(stage);
        } catch (IOException e) {
            e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }
    @FXML
    private void deleteUser() {
        DeleteUser deleteUser = new DeleteUser();
        Stage stage = new Stage(); // Создаем новый Stage для нового окна
        try {
            deleteUser.openDeleteUser(stage);
        } catch (IOException e) {
            e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }
    @FXML
    private void editUser() {
        UpdateUser updateUser = new UpdateUser();
        Stage stage = new Stage(); // Создаем новый Stage для нового окна
        try {
            updateUser.openUpdateUser(stage);
        } catch (IOException e) {
            e.printStackTrace();
            ErrorHandler.showError("Ошибка загрузки окна.", "Во время открытия произошла ошибка." + e.getMessage());
        }
    }

    @FXML
    private void savePermissions() throws SQLException {

        DatabaseGetData databaseGetData = new DatabaseGetData();
        DatabaseSetData databaseSetData = new DatabaseSetData();
        List<UserPrivileges> existingPrivilegesList = databaseGetData.getUserPrivilegesList();
        int countOfChanges = 0;
        int countOfErrors = 0;
        int rowsAffected = 0;
        if (existingPrivilegesList.size() != userPrivilegesList.size()) {
            ErrorHandler.showError("Ошибка", "Невозможно обновить. Списки пользователей разной длины.");
        } else {
            for (int i = 0; i < existingPrivilegesList.size(); i++) {
                UserPrivileges existingPrivileges = existingPrivilegesList.get(i);
                UserPrivileges newPrivileges = userPrivilegesList.get(i);

                if (!existingPrivileges.equals(newPrivileges)) {
                    rowsAffected = databaseSetData.editPrivileges(newPrivileges);
                    if ((rowsAffected > 0)) {
                        countOfChanges++;
                    } else {
                        countOfErrors++;
                    }

                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Результаты сохранения:");
            Image icon = new Image(Objects.requireNonNull(ErrorHandler.class.getResourceAsStream("/icon.png")));
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(icon);
            alert.setContentText("Изменено: " + countOfChanges + " строк.\nПроизошло ошибок: " + countOfErrors + ".");
            alert.showAndWait();
        }
    }
}


