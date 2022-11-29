package corralon.controller;

import corralon.model.DBManagerImpl;
import corralon.model.DBManager;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ProductControllerImpl implements ProductController{
    
    private DBManager manager = new DBManagerImpl();

    @Override
    public void create(String... data) throws SQLException {
        manager.execute(String.format("INSERT INTO products("
                + "code, name, price, quantity, stock, seller"
                + ") VALUES('%s', '%s', %s, %s, %s, '%s')", data));
        
    }

    @Override
    public DefaultTableModel getProducts() throws SQLException {
        String[] table = {
            "Código",
            "Nombre",
            "Precio",
            "Cantidad",
            "Stock",
            "Proveedor"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, table);
        ResultSet result = manager.getData("SELECT * FROM products");
        String[] column = new String[6];
        while(result.next()){
            column[0] = result.getString("code");
            column[1] = result.getString("name");
            column[2] = result.getString("price");
            column[3] = result.getString("quantity");
            column[4] = result.getString("stock");
            column[5] = result.getString("seller");
            tableModel.addRow(column);
        }
        manager.closeConnection();
        return tableModel;
    }
    
    @Override
    public DefaultTableModel editProducts() throws SQLException {
        String[] table = {
            "Id",
            "Código",
            "Nombre",
            "Precio",
            "Cantidad",
            "Stock",
            "Proveedor"
        };
        DefaultTableModel tableModel = new DefaultTableModel(null, table);
        ResultSet result = manager.getData("SELECT * FROM products");
        String[] column = new String[7];
        while(result.next()){
            column[0] = String.valueOf(result.getInt("id"));
            column[1] = result.getString("code");
            column[2] = result.getString("name");
            column[3] = result.getString("price");
            column[4] = result.getString("quantity");
            column[5] = result.getString("stock");
            column[6] = result.getString("seller");
            tableModel.addRow(column);
        }
        manager.closeConnection();
        return tableModel;
    }
    
    @Override
    public void edit(int id, String... data) throws SQLException {
        manager.execute("UPDATE products SET "
                + "code='"+data[0]+"', "
                + "name='"+data[1]+"', "
                + "price="+data[2]+", "
                + "quantity="+data[3]+", "
                + "stock="+data[4]+", "
                + "seller='"+data[5]+"' "
                + " WHERE id="+id);
    }
    
    @Override
    public void delete(int id) throws SQLException {
        manager.execute("DELETE FROM products WHERE id="+id);
    }
}
