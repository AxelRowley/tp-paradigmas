package corralon.controller;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public interface ProductController {
    
    void create(String... data) throws SQLException;
    
    DefaultTableModel getProducts() throws SQLException;
    
    DefaultTableModel editProducts() throws SQLException;
    
    void edit(int id, String... data) throws SQLException;
    
    void delete(int id) throws SQLException;
    
}
