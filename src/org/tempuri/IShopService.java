/**
 * IShopService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IShopService extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.ShopServerLibrary.Product[] getAllProducts() throws java.rmi.RemoteException;
    public java.lang.String buyProduct(org.datacontract.schemas._2004._07.ShopServerLibrary.User u, org.datacontract.schemas._2004._07.ShopServerLibrary.Product p, java.lang.Integer amount) throws java.rmi.RemoteException;
    public java.lang.Integer login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String register(java.lang.String username) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.ShopServerLibrary.Product[] getBoughtProducts() throws java.rmi.RemoteException;
}
