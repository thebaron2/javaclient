package org.tempuri;

public class IShopServiceProxy implements org.tempuri.IShopService {
  private String _endpoint = null;
  private org.tempuri.IShopService iShopService = null;
  
  public IShopServiceProxy() {
    _initIShopServiceProxy();
  }
  
  public IShopServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIShopServiceProxy();
  }
  
  private void _initIShopServiceProxy() {
    try {
      iShopService = (new org.tempuri.ShopServiceLocator()).getBasicHttpBinding_IShopService();
      if (iShopService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iShopService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iShopService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iShopService != null)
      ((javax.xml.rpc.Stub)iShopService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IShopService getIShopService() {
    if (iShopService == null)
      _initIShopServiceProxy();
    return iShopService;
  }
  
  public org.datacontract.schemas._2004._07.ShopServerLibrary.Product[] getAllProducts() throws java.rmi.RemoteException{
    if (iShopService == null)
      _initIShopServiceProxy();
    return iShopService.getAllProducts();
  }
  
  public java.lang.String buyProduct(org.datacontract.schemas._2004._07.ShopServerLibrary.User u, org.datacontract.schemas._2004._07.ShopServerLibrary.Product p, java.lang.Integer amount) throws java.rmi.RemoteException{
    if (iShopService == null)
      _initIShopServiceProxy();
    return iShopService.buyProduct(u, p, amount);
  }
  
  public java.lang.Integer login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (iShopService == null)
      _initIShopServiceProxy();
    return iShopService.login(username, password);
  }
  
  public java.lang.String register(java.lang.String username) throws java.rmi.RemoteException{
    if (iShopService == null)
      _initIShopServiceProxy();
    return iShopService.register(username);
  }
  
  public org.datacontract.schemas._2004._07.ShopServerLibrary.Product[] getBoughtProducts() throws java.rmi.RemoteException{
    if (iShopService == null)
      _initIShopServiceProxy();
    return iShopService.getBoughtProducts();
  }
  
  
}