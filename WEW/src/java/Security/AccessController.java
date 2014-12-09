/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import Beans.AccountBean;
import org.owasp.esapi.errors.AccessControlException;

public class AccessController {

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

    protected static boolean addtoshoppingcart;
    protected static boolean editshoppingcart;
    protected static boolean removeproductfromshoppingcart ;
    protected static boolean viewproduct;

    protected static boolean editpassword;

    protected static boolean editadmin;
    protected static boolean addadmin;
    protected static boolean deleteadmin;

    public static boolean isAddadmin() {
        return addadmin;
    }

    public static boolean isDeleteadmin() {
        return deleteadmin;
    }

    public static boolean isEditadmin() {
        return editadmin;
    }

    public static void setAddadmin(boolean addadmin) {
        AccessController.addadmin = addadmin;
    }

    public static void setDeleteadmin(boolean deleteadmin) {
        AccessController.deleteadmin = deleteadmin;
    }

    public static void setEditadmin(boolean editadmin) {
        AccessController.editadmin = editadmin;
    }

    public static boolean isEditpassword() {
        return editpassword;
    }

    public static void setEditpassword(boolean editpassword) {
        AccessController.editpassword = editpassword;
    }

    public static boolean isViewproduct() {
        return viewproduct;
    }

    public static void setViewproduct(boolean viewproduct) {
        AccessController.viewproduct = viewproduct;
    }

    public static void setRemoveproductfromshoppingcart(boolean removeproductfromshoppingcart) {
        AccessController.removeproductfromshoppingcart = removeproductfromshoppingcart;
    }

    public static void setEditshoppingcart(boolean editshoppingcart) {
        AccessController.editshoppingcart = editshoppingcart;
    }

    public static void setAddtoshoppingcart(boolean addtoshoppingcart) {
        AccessController.addtoshoppingcart = addtoshoppingcart;
    }

    public static boolean isRemoveproductfromshoppingcart() {
        return removeproductfromshoppingcart;
    }

    public static boolean isEditshoppingcart() {
        return editshoppingcart;
    }

    public static boolean isAddtoshoppingcart() {
        return addtoshoppingcart;
    }

    public static boolean isCreatecustomer() {
        return createcustomer;
    }

    public static void setCreatecustomer(boolean createcustomer) {
        AccessController.createcustomer = createcustomer;
    }

    public static boolean isEditcustomer() {
        return editcustomer;
    }

    public static void setEditcustomer(boolean editcustomer) {
        AccessController.editcustomer = editcustomer;
    }

    public static boolean isDeletecustomer() {
        return deletecustomer;
    }

    public static void setDeletecustomer(boolean deletecustomer) {
        AccessController.deletecustomer = deletecustomer;
    }

    public static boolean isCreateproductmanager() {
        return createproductmanager;
    }

    public static void setCreateproductmanager(boolean createproductmanager) {
        AccessController.createproductmanager = createproductmanager;
    }

    public static boolean isEditproductmanager() {
        return editproductmanager;
    }

    public static void setEditproductmanager(boolean editproductmanager) {
        AccessController.editproductmanager = editproductmanager;
    }

    public static boolean isDeleteproductmanager() {
        return deleteproductmanager;
    }

    public static void setDeleteproductmanager(boolean deleteproductmanager) {
        AccessController.deleteproductmanager = deleteproductmanager;
    }

    public static boolean isCreateaccountingmanager() {
        return createaccountingmanager;
    }

    public static void setCreateaccountingmanager(boolean createaccountingmanager) {
        AccessController.createaccountingmanager = createaccountingmanager;
    }

    public static boolean isEditaccountingmanager() {
        return editaccountingmanager;
    }

    public static void setEditaccountingmanager(boolean editaccountingmanager) {
        AccessController.editaccountingmanager = editaccountingmanager;
    }

    public static boolean isDeleteaccountingmanager() {
        return deleteaccountingmanager;
    }

    public static void setDeleteaccountingmanager(boolean deleteaccountingmanager) {
        AccessController.deleteaccountingmanager = deleteaccountingmanager;
    }

    public static boolean isPostmessage() {
        return postmessage;
    }

    public static void setPostmessage(boolean postmessage) {
        AccessController.postmessage = postmessage;
    }

    public static boolean isEditmessage() {
        return editmessage;
    }

    public static void setEditmessage(boolean editmessage) {
        AccessController.editmessage = editmessage;
    }

    public static boolean isViewmessage() {
        return viewmessage;
    }

    public static void setViewmessage(boolean viewmessage) {
        AccessController.viewmessage = viewmessage;
    }

    public static boolean isDeletemessage() {
        return deletemessage;
    }

    public static void setDeletemessage(boolean deletemessage) {
        AccessController.deletemessage = deletemessage;
    }

    public static boolean isAddproduct() {
        return addproduct;
    }

    public static void setAddproduct(boolean addproduct) {
        AccessController.addproduct = addproduct;
    }

    public static boolean isEditproduct() {
        return editproduct;
    }

    public static void setEditproduct(boolean editproduct) {
        AccessController.editproduct = editproduct;
    }

    public static boolean isDeleteproduct() {
        return deleteproduct;
    }

    public static void setDeleteproduct(boolean deleteproduct) {
        AccessController.deleteproduct = deleteproduct;
    }

    public static boolean isRestockproduct() {
        return restockproduct;
    }

    public static void setRestockproduct(boolean restockproduct) {
        AccessController.restockproduct = restockproduct;
    }

    public static boolean isViewsales() {
        return viewsales;
    }

    public static void setViewsales(boolean viewsales) {
        AccessController.viewsales = viewsales;
    }

    public static boolean isUnlockuser() {
        return unlockuser;
    }

    public static void setUnlockuser(boolean unlockuser) {
        AccessController.unlockuser = unlockuser;
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

    public static void setBuyproduct(boolean buyproduct) {
        AccessController.buyproduct = buyproduct;
    }

    public static void setViewactivity(boolean viewactivity) {
        AccessController.viewactivity = viewactivity;
    }

    public static void setViewtransactions(boolean viewtransactions) {
        AccessController.viewtransactions = viewtransactions;
    }

}
