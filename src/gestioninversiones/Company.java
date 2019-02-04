
package gestioninversiones;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Estudiante
 */

public class Company {
    private String name;
    private HashMap<Integer,Client> clientes;
    private ArrayList<Asset> activos;
     
    public Company(String name){
        this.name=name;
        this.clientes = new HashMap<>();
        this.activos = new ArrayList<>();
    }
    
    //Para añadir cliente. Retorna verdadero si se inserto el cliente porque cliente es objeto, por tanto, cliente!=null
    public boolean addClient(int id, String name, String lastName, String email){
        return this.clientes.put(id, new Client(id, name, lastName, email)) == null;
    }
    //Métodos para añadir activos
    public boolean addAssetStock(int totalShares, String symbol, double totalCost, double currentPrice){
        return this.activos.add(new Stock(totalShares, symbol, totalCost, currentPrice));
    }
    
    public boolean addAssetMutualFund(double totalShares, String symbol, double totalCost, double currentPrice){
        return this.activos.add(new MutualFund(totalShares, symbol, totalCost, currentPrice));
    }
    
    public boolean addAssetDividendStock(double dividends, int totalShares, String symbol, double totalCost, double currentPrice){
        return this.activos.add(new DividendStock(dividends, totalShares, symbol, totalCost, currentPrice));
    }
    
    public boolean addAssetCash(double amount){
        return this.activos.add(new Cash(amount));
    }
    
    //Método para añadir activo a cliente
    public boolean addAssettoClient(int pos, int id){
        return this.clientes.get(id).addAsset(this.activos.get(pos));
    }
    
    //Otros métodos
    
    //Valor total del mercado
    public double getAllMarketValue(){
        double marketvalue = 0;
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                marketvalue+=asset.getMarketValue();
            }
        }
        return marketvalue;
    }
    
    //Obtener valor del mercado y beneficio total obtenido para un tipo de activo
    public void getMarketValueandProfitofAsset(int pos){
        System.out.println("El valor del mercado del activo es: "+this.activos.get(pos).getMarketValue());
        System.out.println("El beneficio del activo es: "+this.activos.get(pos).getProfit());
    }
    
    //Beneficio total obtenido
    public double getAllProfit(){
        double profit = 0;
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                profit+=asset.getProfit();
            }
        }
        return profit;
    }
    
    //Hacer método rango de edades...
    //Hacer método para conocer cliente mayores beneficios...
    //Hcaer método para listado de clientes con valor en el mercado de los activo...
    
    
    //Para acceder a un método particular de un hijo que desconoce el padre...
    public double getAllMarketValue(){
        double marketvalue = 0;
        for(Client client : clientes.values()){
            for(Asset asset : client.getAssets()){
                if(asset instanceof DividendStock){
                   DividendStock d =(DividendStock)asset;
                   d.add();
                }
                marketvalue+=asset.getMarketValue();
            }
        }
        return marketvalue;
    }
}
