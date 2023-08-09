package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.*;

public class collections {
    public Stack<good> stackGood;
    public Queue<good> queueGood;
    public List<good>listgood;


    public HashMap<String, supplier_constructor> venderdetails;
    public HashMap<String,Integer> vendornames;
    public List<good>Productlist;
    public List<good>Filtergood;
    public List<String>categorystack;
    public List<String>categoryqueue;
    public List<String>categorylist;
    private int rand;
    public  Map<Integer, sales_contractor>sales;

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    private String displayType;


    private Connection con;


    public collections(){

        stackGood= new Stack<>();
        queueGood= new LinkedList<>();
      venderdetails=new HashMap<>();
        listgood=new ArrayList<>();
        Productlist=new ArrayList<>();
        Filtergood=new ArrayList<>();
        vendornames=new HashMap<>();


sales=new HashMap<>();



categorystack=new ArrayList<>();
categoryqueue=new ArrayList<>();
categorylist=new ArrayList<>();


categorystack.add("Beverages");
categorystack.add("Bread/Bakery");
categorystack.add("Canned/Jarred Goods");
categorystack.add("Dairy");

categoryqueue.add("Dry/Baking Goods");
categoryqueue.add("Frozen Foods");
categoryqueue.add("Meat");
categorylist.add("Produce");
categorylist.add("Cleaners");
categorylist.add("Paper Goods");
categorylist.add("Personal Care");





    }
    /** queue****************************************************************************************/
    /** Add ap product to queue--------------------------------------------------------------------- */
    public  void addQueuegood(good g)
    {
        queueGood.add(g);
    }
    /** Remove from QUEUE********************************************************************************/
    public void removeQueue_good(){
        queueGood.remove();

    }
    public Queue<good> getQlist(){
        return queueGood;
    }
    /** **********************QUEUE LINE ENDS*******************************************************************************************/




    /*** ********************STACK BEGINS******************************************************************************************/


    /** stack   ADD    */
    public void addgood(good g){

        stackGood.push(g);


    }
public void FilterProduct(String a){

for(good g:Productlist){
    if(Objects.equals(a, g.getCategory())){
        Filtergood.add(g);

    }

}

}
    /** *******************REMOVE FROM  STACK ***********************/
    public void removegood() throws SQLException {
         good nw=stackGood.pop();
        String deletestate="delete from good where id="+nw.getId();
        PreparedStatement stm=con.prepareStatement(deletestate);
        stm.executeUpdate();
        stm.close();



    }
    public void removeg_list(int a) throws SQLException {
        good nw=listgood.remove(a);
        String deletestate="delete from good where id="+nw.getId();
        PreparedStatement stm=con.prepareStatement(deletestate);
        stm.executeUpdate();
        stm.close();



    }
    public void removegood_queue() throws SQLException {
        good nw=queueGood.remove();
        String deletestate="delete from good where id="+nw.getId();
        PreparedStatement stm=con.prepareStatement(deletestate);
        stm.executeUpdate();
        stm.close();



    }

    public int a_l(){
        return Productlist.size();
    }


    /*** GET GOOD FROM stack***********************************/


    public Stack<good> getgood(){
        return stackGood;
    }
/*****



 / **************LIST FOR ADD CATEGORY 8 TO 11 ****************************************/
/** add */
public void add_good_to_list(good g){
    listgood.add(g);
}
    public void add_vendorname(String name,Integer id){
        vendornames.put(name,id);
    }
    public Map<String,Integer> getvendorsname(){
    return vendornames;
    }

/** *****REMOVE FROM LIST************************************ */

public List<good> getgood_list(){
    return listgood;
}

/**********END ************************************ **/


/********************** ADD******************/




/****************************        STORE VENDOR DETAILS USING HASHMAP***/
public void Addvendor(String name, supplier_constructor detail){
    venderdetails.put(name,detail);
}

/****      sales record                   ******************     ***/
public  Map<Integer, sales_contractor> getSales(){
return sales;
}
public void storesale(int id, sales_contractor s){
    sales.put(id,s);
}
/*************  GET SALE RECORDS ******/

/********** Get vendors*********************/
public HashMap<String, supplier_constructor> Getvendors(){
    return venderdetails;
}

public void removevendor(String n){
    venderdetails.remove(n);
}
/*************** end of hashmap****/





/********   DATABASE CONNECTION *******************************************/
    public void connect() throws Exception  {
        String databaseFile = "inventorydata.db";
        if(con !=null) return;
        con = DriverManager.getConnection("jdbc:sqlite:"+databaseFile);
        System.out.println("driver connected");
        Statement statement = con.createStatement();
        String goodtable= "CREATE TABLE IF NOT EXISTS `good` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`category` VARCHAR(50) DEFAULT NULL,"
                + "`product` VARCHAR(50) DEFAULT NULL,"
                + "`date` DATE DEFAULT NULL,"
                + "`quantity` INTEGER DEFAULT NULL,"
                + "`unit_price` DOUBLE DEFAULT NULL,"
                + "`sale_price` DOUBLE DEFAULT NULL,"
                + "`gross_price` DOUBLE DEFAULT NULL,"
                + "`vendorId` INTEGER DEFAULT NULL"
                + ")";
        String issuegoodtable = "CREATE TABLE IF NOT EXISTS `issued_good` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`productId` INTEGER DEFAULT NULL,"
                + "`quantity` INTEGER DEFAULT NULL,"
                + "`unit_price` DOUBLE DEFAULT NULL,"
                + "`total_price` DOUBLE DEFAULT NULL,"
                + "`date_issued` DATE DEFAULT NULL,"
                + "FOREIGN KEY (`productId`) REFERENCES `products` (`id`)"
                + ")";
        String producttable = "CREATE TABLE IF NOT EXISTS `product` ("
                + "`id` INTEGER NOT NULL,"
                + "`category` VARCHAR(50) DEFAULT NULL,"
                + "`product` VARCHAR(50) DEFAULT NULL,"
                + "`date` DATE DEFAULT NULL,"
                + "`quantity` INTEGER DEFAULT NULL,"
                + "`unit_price` DOUBLE DEFAULT NULL,"
                + "`sale_price` DOUBLE DEFAULT NULL,"
                + "`gross_price` DOUBLE DEFAULT NULL,"
                + "`gross_sales` DOUBLE DEFAULT NULL,"
                + "`vendorId` INTEGER DEFAULT NULL,"
                + "PRIMARY KEY (`id`)"
                + ")";

        String prodtable = "CREATE TABLE IF NOT EXISTS `products` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`category` VARCHAR(40) DEFAULT NULL,"
                + "`product` VARCHAR(40) DEFAULT NULL,"
                + "`date` DATE DEFAULT NULL,"
                + "`quantity` INTEGER DEFAULT NULL,"
                + "`unit_price` DOUBLE DEFAULT NULL,"
                + "`sale_price` DOUBLE DEFAULT NULL,"
                + "`gross_price` DOUBLE DEFAULT NULL,"
                + "`gross_sales` DOUBLE DEFAULT NULL,"
                + "`vendorId` INTEGER DEFAULT NULL,"
                + "FOREIGN KEY (`vendorId`) REFERENCES `vendors` (`id`)"
                + ")";
        String saletable = "CREATE TABLE IF NOT EXISTS `sales` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`product` VARCHAR(50) DEFAULT NULL,"
                + "`category` VARCHAR(50) DEFAULT NULL,"
                + "`quantity` INTEGER DEFAULT NULL,"
                + "`u_price` DOUBLE DEFAULT NULL,"
                + "`price` DOUBLE DEFAULT NULL,"
                + "`customer` VARCHAR(40) DEFAULT NULL,"
                + "`date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                + "`prodid` INTEGER DEFAULT NULL,"
                + "FOREIGN KEY (`prodid`) REFERENCES `products` (`id`)"
                + ")";

        String vendortable= "CREATE TABLE IF NOT EXISTS `vendors` ("
                + "`id` INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "`name` VARCHAR(50) NOT NULL,"
                + "`address` VARCHAR(30) DEFAULT NULL,"
                + "`firm` VARCHAR(50) DEFAULT NULL,"
                + "`contact_number` INTEGER DEFAULT NULL,"
                + "`country` VARCHAR(30) DEFAULT NULL,"
                + "`city` VARCHAR(30) DEFAULT NULL"
                + ")";
statement.executeUpdate(vendortable);
        statement.executeUpdate(saletable);
        statement.executeUpdate(prodtable);
        statement.executeUpdate(producttable);
        statement.executeUpdate(goodtable);
        statement.executeUpdate(issuegoodtable);


    }

    /*** DISCONNECT***************************/
    public void disconnected()  {
if(con !=null){
    try{
        con.close();
    }
    catch(SQLException e){
      System.out.println("not close");
    }

}
    }
/****************************sAVE VENDORS**********************************/
public void save_To_database_vendor() throws SQLException {


    String Doc="insert into vendors (name,address,firm,contact_number,country,city) values(?,?,?,?,?,?)";

    PreparedStatement insertDoc=con.prepareStatement(Doc);
    Iterator hash = venderdetails.entrySet().iterator();
for(HashMap.Entry<String, supplier_constructor>e:venderdetails.entrySet()){
    String name=e.getKey().toString();
    String add=e.getValue().getAddress();
   int cont=e.getValue().getContact();
    String comp=e.getValue().getCompany();
    String count=e.getValue().getCountry();
    String town=e.getValue().getTown();
    int size=venderdetails.size()+1;
    insertDoc.setString(1,name);
    insertDoc.setString(2,add);

    insertDoc.setString(3,comp);
    insertDoc.setInt(4,cont);
    insertDoc.setString(5,count);
    insertDoc.setString(6,town);

    insertDoc.executeUpdate();
    System.out.print("vendor saved");

}
    stackGood.clear();
    insertDoc.close();
    ;
}


    /********    adding to database  using *****************/
    public void save_To_database_stack() throws SQLException {

        int size=Productlist.size()+1;
        String Doc="insert into good(id,category,product,date,quantity,unit_price,sale_price,gross_price,vendorId) values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement insertDoc=con.prepareStatement(Doc);

        for(good g:stackGood){

            int id=g.getId();


            String  cat=g.getCategory();
            String p=g.getGood();

           Date dat= (Date) g.getDate();
            int quan=g.getQuant();
            Double up=g.getUnit_price();
            Double sp=g.getSaleprice();
            Double gp=g.getGrossprice();

            int ven=g.getVendor();

insertDoc.setInt(1,size);
            System.out.println("inserted");
                insertDoc.setString(2,cat);
                insertDoc.setString(3,p);
                insertDoc.setDate(4,dat);
                insertDoc.setInt(5,quan);
                insertDoc.setDouble(6,up);
                insertDoc.setDouble(7,sp);
                insertDoc.setDouble(8,gp);
                insertDoc.setDouble(9,ven);

                insertDoc.executeUpdate();
System.out.println("inserted");





        }



insertDoc.close();
        getgood().clear();
        Productlist.clear();


    }


    /**************** queues *********************************************************************/

    public void save_To_database_queue() throws SQLException {


        String Doc="insert into good(id,category,product,date,quantity,unit_price,sale_price,gross_price,vendorId) values(?,?,?,?,?,?,?,?,?)";

        PreparedStatement insertDoc=con.prepareStatement(Doc);

        int size= Productlist.size()+1;
        for(good g:queueGood){

            int id=g.getId();


            String  cat=g.getCategory();
            String p=g.getGood();
            Date dat= (Date) g.getDate();
            int quan=g.getQuant();
            Double up=g.getUnit_price();
            Double sp=g.getSaleprice();
            Double gp=g.getGrossprice();

            int ven=g.getVendor();







                insertDoc.setInt(1,size);
                insertDoc.setString(2,cat);

                insertDoc.setString(3,p);
                insertDoc.setDate(4,dat);
                insertDoc.setInt(5,quan);
                insertDoc.setDouble(6,up);
                insertDoc.setDouble(7,sp);
                insertDoc.setDouble(8,gp);
                insertDoc.setDouble(9,ven);

                insertDoc.executeUpdate();
                System.out.println("queeee eeeee"+getQlist().size()+g.getCategory());

            }





        Productlist.clear();
       queueGood.clear();
        insertDoc.close();

    }

/********           Storing product with list ************/
    public void save_To_database_list() throws SQLException {


        String Doc="insert into good(id,category,product,date,quantity,unit_price,sale_price,gross_price,vendorId) values(?,?,?,?,?,?,?,?,?)";
        int size=Productlist.size()+1;

        PreparedStatement insertDoc=con.prepareStatement(Doc);
        System.out.println("list head");
        for(good g:listgood){
            System.out.println("dg"+Productlist.size());
            int id=g.getId();


            String  cat=g.getCategory();
            String p=g.getGood();

            Date dat= (Date) g.getDate();
            int quan=g.getQuant();
            Double up=g.getUnit_price();
            Double sp=g.getSaleprice();
            Double gp=g.getGrossprice();

            int ven=g.getVendor();







                insertDoc.setInt(1,size);
                insertDoc.setString(2,cat);

                insertDoc.setString(3,p);
                insertDoc.setDate(4,dat);
                insertDoc.setInt(5,quan);
                insertDoc.setDouble(6,up);
                insertDoc.setDouble(7,sp);
                insertDoc.setDouble(8,gp);
                insertDoc.setDouble(9,ven);


                insertDoc.executeUpdate();

            }





        Productlist.clear();
        listgood.clear();
        insertDoc.close();

    }

    /*******************************************************************************************/


    String gh="d";
    public void Load_data() throws SQLException {
        stackGood.clear();
        Productlist.clear();
        queueGood.clear();
        listgood.clear();
        String loader="select * from good";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String cat=result.getString("category");
            String good=result.getString("product");
           Date date=result.getDate("date");
            int quan=result.getInt("quantity");
            Double unitprice=result.getDouble("unit_price");
            Double salep=result.getDouble("sale_price");
            Double grossp=result.getDouble("gross_price");

            int vendor=result.getInt("vendorId");

            gh=cat;
        if(categorystack.contains(cat)) {

              addgood(new good(id,cat,good,date,quan,unitprice,salep,grossp,vendor));


            }
            if(categoryqueue.contains(cat)){

               addQueuegood(new good(id,cat,good,date,quan,unitprice,salep,grossp,vendor));

            }
            if(categorylist.contains(cat)){
                add_good_to_list(new good(id,cat,good,date,quan,unitprice,salep,grossp,vendor));

            }

            Productlist.add(new good(id,cat,good,date,quan,unitprice,salep,grossp,vendor));




        }


        result.close();
        state.close();




    }

    public void vendorname() throws SQLException {
        stackGood.clear();
        Productlist.clear();
        queueGood.clear();
        listgood.clear();
        String loader="select name, id from vendors";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){

            String name=result.getString("name");
            int id=result.getInt("id");
            add_vendorname(name,id);

        }
        result.close();
        state.close();




    }






    public void Load_data_v() throws SQLException {
        venderdetails.clear();
        Getvendors().clear();
        String loader="select * from vendors";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String name=result.getString("name");
            String address=result.getString("address");
            String company=result.getString("firm");
            int contact=result.getInt("contact_number");
            String country=result.getString("country");
            String city=result.getString("city");
            Addvendor(name,new supplier_constructor(id,address,company,contact,country,city));







        }



        for(Map.Entry<String, supplier_constructor>e:Getvendors().entrySet()){

        }
        result.close();
        state.close();





    }

    public void save_To_vsaleDate() throws SQLException {


        String Doc="insert into  sales (product ,category ,quantity ,u_price ,price,customer,prodid) values(?,?,?,?,?,?,?)";

        PreparedStatement insertDoc=con.prepareStatement(Doc);

        for(Map.Entry<Integer, sales_contractor>e:sales.entrySet()){
           int id=e.getKey();
            String cat=e.getValue().getCat();
            String prod=e.getValue().getProduct();
            String cus=e.getValue().getCus();
            int qty=e.getValue().getQty();
            double u_p=e.getValue().getPriceu();
           double total=e.getValue().getTotal();
            int size=sales.size()+1;
            insertDoc.setString(1,prod);
            insertDoc.setString(2,cat);

            insertDoc.setInt(3,qty);
            insertDoc.setDouble(4,u_p);
            insertDoc.setDouble(5,total);
            insertDoc.setString(6,cus);
            insertDoc.setInt(7,id);


           insertDoc.executeUpdate();


        }

        insertDoc.close();

    }


    public void update_vsaleD(int a,int b) throws SQLException {


        String Doc="update good set quantity='"+a+"' where id='"+b+"'";

        PreparedStatement insertDoc=con.prepareStatement(Doc);

        insertDoc.executeUpdate();

        insertDoc.close();
        System.out.println("table updatedAA");

    }


    public void Load_data_SALE() throws SQLException {


        String loader="select * from sales";
        Statement state=con.createStatement();
        ResultSet result=state.executeQuery(loader);
        while(result.next()){
            int id=result.getInt("id");
            String product=result.getString("product");
            String category=result.getString("category");
            int quan=result.getInt("quantity");
            Double up=result.getDouble("u_price");
            Double tp=result.getDouble("price");
            String cus=result.getString("customer");
            Date date=result.getDate("date");
            int fid=result.getInt("prodid");
            storesale(id,new sales_contractor(fid,product,category,up,quan,tp,cus,date));

        }



        for(Map.Entry<Integer, sales_contractor>e:getSales().entrySet()){
            System.out.println("loaded to MAP"+Getvendors().size());
        }
        result.close();
        state.close();





    }





}


