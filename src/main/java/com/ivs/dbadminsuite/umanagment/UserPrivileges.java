package com.ivs.dbadminsuite.umanagment;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.Objects;

public class UserPrivileges {
    private String user;
    //private String authenticationString;
    private String host;
    private Boolean accountLocked;
    private Boolean selectPriv;
    private Boolean insertPriv;
    private Boolean updatePriv;
    private Boolean deletePriv;
    private Boolean createPriv;
    private Boolean dropPriv;
    private Boolean grantPriv;
    private Boolean referencesPriv;
    private Boolean alterPriv;
    private Boolean createTmpTablePriv;
    private Boolean lockTablesPriv;
    private Boolean executePriv;
    private Boolean createViewPriv;
    private Boolean showViewPriv;
    private Boolean createRoutinePriv;
    private Boolean alterRoutinePriv;
    private Boolean eventPriv;
    private Boolean triggerPriv;

    // Конструктор
    public UserPrivileges(String user, String host, Boolean accountLocked, Boolean selectPriv, Boolean insertPriv, Boolean updatePriv, Boolean deletePriv, Boolean createPriv, Boolean dropPriv, Boolean grantPriv, Boolean referencesPriv, Boolean alterPriv, Boolean createTmpTablePriv, Boolean lockTablesPriv, Boolean executePriv, Boolean createViewPriv, Boolean showViewPriv, Boolean createRoutinePriv, Boolean alterRoutinePriv, Boolean eventPriv, Boolean triggerPriv) {
        this.user = user;
        this.host = host;
        this.accountLocked = accountLocked;
        //this.authenticationString = authenticationString;
        this.selectPriv = selectPriv;
        this.insertPriv = insertPriv;
        this.updatePriv = updatePriv;
        this.deletePriv = deletePriv;
        this.createPriv = createPriv;
        this.dropPriv = dropPriv;
        this.grantPriv = grantPriv;
        this.referencesPriv = referencesPriv;
        this.alterPriv = alterPriv;
        this.createTmpTablePriv = createTmpTablePriv;
        this.lockTablesPriv = lockTablesPriv;
        this.executePriv = executePriv;
        this.createViewPriv = createViewPriv;
        this.showViewPriv = showViewPriv;
        this.createRoutinePriv = createRoutinePriv;
        this.alterRoutinePriv = alterRoutinePriv;
        this.eventPriv = eventPriv;
        this.triggerPriv = triggerPriv;
    }

    public UserPrivileges() {
        this.user = "";
        this.host = "";
        this.accountLocked = false;
        //this.authenticationString = "";
        this.selectPriv = false;
        this.insertPriv = false;
        this.updatePriv = false;
        this.deletePriv = false;
        this.createPriv = false;
        this.dropPriv = false;
        this.grantPriv = false;
        this.referencesPriv = false;
        this.alterPriv = false;
        this.createTmpTablePriv = false;
        this.lockTablesPriv = false;
        this.executePriv = false;
        this.createViewPriv = false;
        this.showViewPriv = false;
        this.createRoutinePriv = false;
        this.alterRoutinePriv = false;
        this.eventPriv = false;
        this.triggerPriv = false;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /*public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString;
    }*/

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Boolean isSelectPriv() {
        return selectPriv;
    }

    public void setSelectPriv(Boolean selectPriv) {
        this.selectPriv = selectPriv;
    }

    public Boolean isInsertPriv() {
        return insertPriv;
    }

    public void setInsertPriv(Boolean insertPriv) {
        this.insertPriv = insertPriv;
    }

    public Boolean isUpdatePriv() {
        return updatePriv;
    }

    public void setUpdatePriv(Boolean updatePriv) {
        this.updatePriv = updatePriv;
    }

    public Boolean isDeletePriv() {
        return deletePriv;
    }

    public void setDeletePriv(Boolean deletePriv) {
        this.deletePriv = deletePriv;
    }

    public Boolean isCreatePriv() {
        return createPriv;
    }

    public void setCreatePriv(Boolean createPriv) {
        this.createPriv = createPriv;
    }

    public Boolean isDropPriv() {
        return dropPriv;
    }

    public void setDropPriv(Boolean dropPriv) {
        this.dropPriv = dropPriv;
    }

    public Boolean isGrantPriv() {
        return grantPriv;
    }

    public void setGrantPriv(Boolean grantPriv) {
        this.grantPriv = grantPriv;
    }

    public Boolean isReferencesPriv() {
        return referencesPriv;
    }

    public void setReferencesPriv(Boolean referencesPriv) {
        this.referencesPriv = referencesPriv;
    }

    public Boolean isAlterPriv() {
        return alterPriv;
    }

    public void setAlterPriv(Boolean alterPriv) {
        this.alterPriv = alterPriv;
    }

    public Boolean isCreateTmpTablePriv() {
        return createTmpTablePriv;
    }

    public void setCreateTmpTablePriv(Boolean createTmpTablePriv) {
        this.createTmpTablePriv = createTmpTablePriv;
    }

    public Boolean isLockTablesPriv() {
        return lockTablesPriv;
    }

    public void setLockTablesPriv(Boolean lockTablesPriv) {
        this.lockTablesPriv = lockTablesPriv;
    }

    public Boolean isExecutePriv() {
        return executePriv;
    }

    public void setExecutePriv(Boolean executePriv) {
        this.executePriv = executePriv;
    }

    public Boolean isCreateViewPriv() {
        return createViewPriv;
    }

    public void setCreateViewPriv(Boolean createViewPriv) {
        this.createViewPriv = createViewPriv;
    }

    public Boolean isShowViewPriv() {
        return showViewPriv;
    }

    public void setShowViewPriv(Boolean showViewPriv) {
        this.showViewPriv = showViewPriv;
    }

    public Boolean isCreateRoutinePriv() {
        return createRoutinePriv;
    }

    public void setCreateRoutinePriv(Boolean createRoutinePriv) {
        this.createRoutinePriv = createRoutinePriv;
    }

    public Boolean isAlterRoutinePriv() {
        return alterRoutinePriv;
    }

    public void setAlterRoutinePriv(Boolean alterRoutinePriv) {
        this.alterRoutinePriv = alterRoutinePriv;
    }

    public Boolean isEventPriv() {
        return eventPriv;
    }

    public void setEventPriv(Boolean eventPriv) {
        this.eventPriv = eventPriv;
    }

    public Boolean isTriggerPriv() {
        return triggerPriv;
    }

    public void setTriggerPriv(Boolean triggerPriv) {
        this.triggerPriv = triggerPriv;
    }

    public BooleanProperty selectPrivProperty() {
        return new SimpleBooleanProperty(selectPriv);
    }

    public BooleanProperty insertPrivProperty() {
        return new SimpleBooleanProperty(insertPriv);
    }

    public BooleanProperty updatePrivProperty() {
        return new SimpleBooleanProperty(updatePriv);
    }

    public BooleanProperty deletePrivProperty() {
        return new SimpleBooleanProperty(deletePriv);
    }

    public BooleanProperty createPrivProperty() {
        return new SimpleBooleanProperty(createPriv);
    }

    public BooleanProperty dropPrivProperty() {
        return new SimpleBooleanProperty(dropPriv);
    }

    public BooleanProperty grantPrivProperty() {
        return new SimpleBooleanProperty(grantPriv);
    }

    public BooleanProperty referencesPrivProperty() {
        return new SimpleBooleanProperty(referencesPriv);
    }

    public BooleanProperty alterPrivProperty() {
        return new SimpleBooleanProperty(alterPriv);
    }

    public BooleanProperty createTmpTablePrivProperty() {
        return new SimpleBooleanProperty(createTmpTablePriv);
    }

    public BooleanProperty lockTablesPrivProperty() {
        return new SimpleBooleanProperty(lockTablesPriv);
    }

    public BooleanProperty executePrivProperty() {
        return new SimpleBooleanProperty(executePriv);
    }

    public BooleanProperty createViewPrivProperty() {
        return new SimpleBooleanProperty(createViewPriv);
    }

    public BooleanProperty showViewPrivProperty() {
        return new SimpleBooleanProperty(showViewPriv);
    }

    public BooleanProperty createRoutinePrivProperty() {
        return new SimpleBooleanProperty(createRoutinePriv);
    }

    public BooleanProperty alterRoutinePrivProperty() {
        return new SimpleBooleanProperty(alterRoutinePriv);
    }

    public BooleanProperty eventPrivProperty() {
        return new SimpleBooleanProperty(eventPriv);
    }

    public BooleanProperty triggerPrivProperty() {
        return new SimpleBooleanProperty(triggerPriv);
    }

    public void updatePrivilege(String privilegeName, boolean newValue) {
        switch (privilegeName) {
            case "selectPriv":
                setSelectPriv(newValue);
                break;
            case "insertPriv":
                setInsertPriv(newValue);
                break;
            case "updatePriv":
                setUpdatePriv(newValue);
                break;
            case "deletePriv":
                setDeletePriv(newValue);
                break;
            case "createPriv":
                setCreatePriv(newValue);
                break;
            case "dropPriv":
                setDropPriv(newValue);
                break;
            case "grantPriv":
                setGrantPriv(newValue);
                break;
            case "referencesPriv":
                setReferencesPriv(newValue);
                break;
            case "alterPriv":
                setAlterPriv(newValue);
                break;
            case "createTmpTablePriv":
                setCreateTmpTablePriv(newValue);
                break;
            case "lockTablesPriv":
                setLockTablesPriv(newValue);
                break;
            case "executePriv":
                setExecutePriv(newValue);
                break;
            case "createViewPriv":
                setCreateViewPriv(newValue);
                break;
            case "showViewPriv":
                setShowViewPriv(newValue);
                break;
            case "createRoutinePriv":
                setCreateRoutinePriv(newValue);
                break;
            case "alterRoutinePriv":
                setAlterRoutinePriv(newValue);
                break;
            case "eventPriv":
                setEventPriv(newValue);
                break;
            case "triggerPriv":
                setTriggerPriv(newValue);
                break;
            default:
                System.out.println("Unknown privilege name: " + privilegeName);
                break;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserPrivileges other = (UserPrivileges) obj;
        return Objects.equals(user, other.user) &&
                Objects.equals(host, other.host) &&
                Objects.equals(accountLocked, other.accountLocked) &&
                Objects.equals(selectPriv, other.selectPriv) &&
                Objects.equals(insertPriv, other.insertPriv) &&
                Objects.equals(updatePriv, other.updatePriv) &&
                Objects.equals(deletePriv, other.deletePriv) &&
                Objects.equals(createPriv, other.createPriv) &&
                Objects.equals(dropPriv, other.dropPriv) &&
                Objects.equals(grantPriv, other.grantPriv) &&
                Objects.equals(referencesPriv, other.referencesPriv) &&
                Objects.equals(alterPriv, other.alterPriv) &&
                Objects.equals(createTmpTablePriv, other.createTmpTablePriv) &&
                Objects.equals(lockTablesPriv, other.lockTablesPriv) &&
                Objects.equals(executePriv, other.executePriv) &&
                Objects.equals(createViewPriv, other.createViewPriv) &&
                Objects.equals(showViewPriv, other.showViewPriv) &&
                Objects.equals(createRoutinePriv, other.createRoutinePriv) &&
                Objects.equals(alterRoutinePriv, other.alterRoutinePriv) &&
                Objects.equals(eventPriv, other.eventPriv) &&
                Objects.equals(triggerPriv, other.triggerPriv);
    }
}