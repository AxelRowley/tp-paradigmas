package corralon.model;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class DBManagerImpl implements DBManager{
    
    private Connection connection;
    private Statement statement;
    private ResultSet result;
    
    @Override
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:data.db");
    }
    
    @Override
    public void closeConnection() throws SQLException {
        if(!this.connection.isClosed()){
            this.connection.close();
        }
    }
    
    @Override
    public void execute(String sql) throws SQLException{
        connect();
        statement = connection.createStatement();
        statement.execute(sql);
        closeConnection();
    }
    
    @Override
    public ResultSet getData(String sql) throws SQLException{
        connect();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        return result;
    }
    
    @Override
    public List<Object> results(String sql) throws SQLException{
        List<Object> list = new ArrayList<>();
        connect();
        statement = connection.createStatement();
        result = statement.executeQuery(sql);
        if(result.next()){
            for(int i=1; i<=result.getMetaData().getColumnCount(); i++){
                list.add(result.getObject(i));
            }
        }
        closeConnection();
        return list;
    }
}
