/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorybrowserant;

import java.sql.ResultSet;

/**
 *
 * @author Juanjo
 */
public class IdiomSearch {

    private MySqlConnector _con;

    public IdiomSearch() {
        _con = new MySqlConnector("jdbc:mysql://localhost:3306/idiomas", "root", "admin");
    }

    public String extract(String table, String id) {
        ResultSet result;
        String resultText = "¡ERROR!";
        result = _con.select("SELECT textOfProgram FROM " + table + " WHERE id LIKE '" + id + "';");
        try {
            result.next();
            resultText = result.getString(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultText;
    }
    
    public String extract(String table, String superId, String id) {
        ResultSet result;
        String resultText = "¡ERROR!";
        if (table.equals("espField") || table.equals("engField")){
            result = _con.select("SELECT textOfProgram FROM " + table + " WHERE id LIKE '" + id +"' AND commandId LIKE '"+superId+"';");
        } else if (table.equals("espSubfield") || table.equals("engSubfield")){
            result = _con.select("SELECT textOfProgram FROM " + table + " WHERE id LIKE '" + id +"' AND fieldId LIKE '"+superId+"';");
        } else {
            result = null;
        }
        try {
            result.next();
            resultText = result.getString(1);
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultText;
    }
}
