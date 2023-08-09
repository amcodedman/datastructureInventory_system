package ConnectorP;

import database.collections;
import database.good;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Performcollection {
    private good stack_good;
    private good Queue_good;
    private good list_good;

    collections db=new collections();

    public Stack<good> getgood(){
        return db.getgood();

    }
public List<good>getall(){
        return db.Productlist;
}

public List<good>getlistg(){
        return db.getgood_list();
}
    public Map<String,Integer> getvendorsid() {

       return  db.getvendorsname();
    }
public Queue<good>getqgood(){
        return  db.getQlist();
}

public void connect() throws Exception {

        db.connect();

}
public void performfilter(String a){
        db.FilterProduct(a);
}
public List<good> getFilterg(){
      return  db.Filtergood;
}
public void save_with_stack() throws SQLException {
        db.addgood(stack_good);
        db.save_To_database_stack();
}
    public void save_with_queue() throws SQLException {
        db.addQueuegood(Queue_good);
        db.save_To_database_queue();
    }
    public void save_with_list() throws SQLException {
        db.add_good_to_list(list_good);
        db.save_To_database_list();
    }

public void load() throws SQLException {

        db.Load_data();



}
    public void loadname() throws Exception {
        db.connect();
        db.vendorname();
    }
public void SetDISPLAYTYPE(String a){
        db.setDisplayType(a);
}
public String getDISPLAYTYPE(){
     return db.getDisplayType();
}

public void delectStack() throws Exception {
        db.connect();
        db.Load_data();
        db.removegood();
}
public void delectQueue() throws Exception{
       db.connect();
        db.Load_data();
        db.removegood_queue();
}

    public void delectList(int a) throws Exception{
        db.connect();
        db.Load_data();
      db.removeg_list(a);
    }
    public void addgoodstack(String catn, String prodn, Date daten, int quatn, double purchn, double salena, double grosna, String catsel, String productsel, int vendorn) throws ParseException {
      stack_good=new good(catn,prodn,daten,quatn,purchn,salena,grosna,vendorn);

    }
    public void addgoodqueue(String catn, String prodn, Date daten, int quatn, double purchn, double salena, double grosna,  String catsel, String productsel, int vendorn) throws ParseException {
        Queue_good = new good(catn, prodn, daten, quatn, purchn, salena, grosna,  vendorn);
    }
    public void addgoodlist(String catn, String prodn, Date daten, int quatn, double purchn, double salena, double grosna,  String catsel, String productsel, int vendorn) throws ParseException {
        list_good = new good(catn, prodn, daten, quatn, purchn, salena, grosna,  vendorn);
    }

}
