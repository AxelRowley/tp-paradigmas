package corralon.model;

import java.sql.*;
import java.util.List;

public interface DBManager {
    
    public void connect() throws SQLException;
    
    public void closeConnection() throws SQLException;
    
    public void execute(String sql) throws SQLException;
    
    public ResultSet getData(String sql) throws SQLException;
    
    public List<Object> results(String sql) throws SQLException;
    
}
