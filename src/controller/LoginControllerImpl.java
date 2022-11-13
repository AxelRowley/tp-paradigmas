package controller;

import model.DBManager;
import model.DBManagerImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginControllerImpl implements LoginController {
    
    private boolean valid;
    private DBManager manager = new DBManagerImpl();
    
    @Override
    public boolean validate(String user, String password) throws SQLException {
        
        List<Object> list = new ArrayList<>();
        list = manager.results("SELECT * FROM users where user='"+user+"' AND password='"+password+"'");
       
        if(list.size()>0){
            valid=true;
        }
      
        return valid;
    }
    
}
