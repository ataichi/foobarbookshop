/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import Beans.AccountBean;
import org.owasp.esapi.errors.AccessControlException;

public class AccessControl implements org.owasp.esapi.AccessController {

    protected static boolean createcustomer;
    protected static boolean editcustomer;
    protected static boolean deletecustomer;

    protected static boolean createproductmanager;
    protected static boolean editproductmanager;
    protected static boolean deleteproductmanager;

    protected static boolean createaccountingmanager;
    protected static boolean editaccountingmanager;
    protected static boolean deleteaccountingmanager;

    protected static boolean postmessage;
    protected static boolean editmessage;
    protected static boolean viewmessage;
    protected static boolean deletemessage;

    protected static boolean addproduct;
    protected static boolean editproduct;
    protected static boolean deleteproduct;
    protected static boolean restockproduct;

    protected static boolean viewsales;
    protected static boolean unlockuser;
    protected static boolean viewtransactions;
    protected static boolean viewactivity;
    protected static boolean buyproduct;

    protected AccountBean account;

    public static boolean isCreatecustomer() {
        return createcustomer;
    }

    public static void setCreatecustomer(boolean createcustomer) {
        AccessControl.createcustomer = createcustomer;
    }

    public static boolean isEditcustomer() {
        return editcustomer;
    }

    public static void setEditcustomer(boolean editcustomer) {
        AccessControl.editcustomer = editcustomer;
    }

    public static boolean isDeletecustomer() {
        return deletecustomer;
    }

    public static void setDeletecustomer(boolean deletecustomer) {
        AccessControl.deletecustomer = deletecustomer;
    }

    public static boolean isCreateproductmanager() {
        return createproductmanager;
    }

    public static void setCreateproductmanager(boolean createproductmanager) {
        AccessControl.createproductmanager = createproductmanager;
    }

    public static boolean isEditproductmanager() {
        return editproductmanager;
    }

    public static void setEditproductmanager(boolean editproductmanager) {
        AccessControl.editproductmanager = editproductmanager;
    }

    public static boolean isDeleteproductmanager() {
        return deleteproductmanager;
    }

    public static void setDeleteproductmanager(boolean deleteproductmanager) {
        AccessControl.deleteproductmanager = deleteproductmanager;
    }

    public static boolean isCreateaccountingmanager() {
        return createaccountingmanager;
    }

    public static void setCreateaccountingmanager(boolean createaccountingmanager) {
        AccessControl.createaccountingmanager = createaccountingmanager;
    }

    public static boolean isEditaccountingmanager() {
        return editaccountingmanager;
    }

    public static void setEditaccountingmanager(boolean editaccountingmanager) {
        AccessControl.editaccountingmanager = editaccountingmanager;
    }

    public static boolean isDeleteaccountingmanager() {
        return deleteaccountingmanager;
    }

    public static void setDeleteaccountingmanager(boolean deleteaccountingmanager) {
        AccessControl.deleteaccountingmanager = deleteaccountingmanager;
    }

    public static boolean isPostmessage() {
        return postmessage;
    }

    public static void setPostmessage(boolean postmessage) {
        AccessControl.postmessage = postmessage;
    }

    public static boolean isEditmessage() {
        return editmessage;
    }

    public static void setEditmessage(boolean editmessage) {
        AccessControl.editmessage = editmessage;
    }

    public static boolean isViewmessage() {
        return viewmessage;
    }

    public static void setViewmessage(boolean viewmessage) {
        AccessControl.viewmessage = viewmessage;
    }

    public static boolean isDeletemessage() {
        return deletemessage;
    }

    public static void setDeletemessage(boolean deletemessage) {
        AccessControl.deletemessage = deletemessage;
    }

    public static boolean isAddproduct() {
        return addproduct;
    }

    public static void setAddproduct(boolean addproduct) {
        AccessControl.addproduct = addproduct;
    }

    public static boolean isEditproduct() {
        return editproduct;
    }

    public static void setEditproduct(boolean editproduct) {
        AccessControl.editproduct = editproduct;
    }

    public static boolean isDeleteproduct() {
        return deleteproduct;
    }

    public static void setDeleteproduct(boolean deleteproduct) {
        AccessControl.deleteproduct = deleteproduct;
    }

    public static boolean isRestockproduct() {
        return restockproduct;
    }

    public static void setRestockproduct(boolean restockproduct) {
        AccessControl.restockproduct = restockproduct;
    }

    public static boolean isViewsales() {
        return viewsales;
    }

    public static void setViewsales(boolean viewsales) {
        AccessControl.viewsales = viewsales;
    }

    public static boolean isUnlockuser() {
        return unlockuser;
    }

    public static void setUnlockuser(boolean unlockuser) {
        AccessControl.unlockuser = unlockuser;
    }

    public static boolean isBuyproduct() {
        return buyproduct;
    }

    public static boolean isViewactivity() {
        return viewactivity;
    }

    public static boolean isViewtransactions() {
        return viewtransactions;
    }

    public void setAccount(AccountBean account) {
        this.account = account;
    }

    public static void setBuyproduct(boolean buyproduct) {
        AccessControl.buyproduct = buyproduct;
    }

    public static void setViewactivity(boolean viewactivity) {
        AccessControl.viewactivity = viewactivity;
    }

    public static void setViewtransactions(boolean viewtransactions) {
        AccessControl.viewtransactions = viewtransactions;
    }

    public boolean isAuthorized(Object o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorized(Object o, Object o1) throws AccessControlException { //check if user is authorized to access the function
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForURL(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForFunction(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForData(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForFile(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthorizedForService(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForURL(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForFunction(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForData(String string, Object o) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForFile(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void assertAuthorizedForService(String string) throws AccessControlException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
