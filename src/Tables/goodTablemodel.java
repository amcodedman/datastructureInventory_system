package Tables;

import ConnectorP.Performcollection;
import database.collections;
import database.good;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class goodTablemodel extends AbstractTableModel {


        Stack<good>product;
        collections DB=new collections();
        Performcollection C=new Performcollection();
        List<good> allp;
        List<good>listp;
        Queue<good>queuegood;
        String type="ALL";
good g;

private String [] col={ "ID","VENDOR","CATEGOORY","PRODUCT","DATE","QUANTITY","PURCHASE PER UNIT","SALE PRICE","GROSS PRICE","GROSS SALE"};
    @Override
    public String getColumnName(int column) {
        return col[column];
    }

    private static  int ac=0;
    private static  int sc=0;
    private static  int lc=0;

    @Override
    public int getRowCount() {
        if(type=="ALL"){
            return ac;
        }
        if(type=="STACK"){
            return sc;
        }
        if(type=="LIST"){
            return lc;
        }
        return ac;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
if(type=="ALL"){
    g=allp.get(rowIndex);
}
if(type=="STACK"){
    g=product.get(rowIndex);
}
if(type=="LIST"){
    g=listp.get(rowIndex);
}


        switch(columnIndex){
            case 0:
                return g.getId();
            case 1:
                return g.getVendor();
            case 2:
                return g.getCategory();
            case 3:
                return g.getGood();
            case 4:
                return dateform(g.getDate());
            case 5:
                return g.getQuant();
            case 6:
                return g.getUnit_price();
            case 7:
                return g.getSaleprice();
            case 8:
                return g.getGrossprice();




        }
        return null;
    }

    public void setp(List<good> product){
        this.allp=product;
        System.out.println("all count"+allp.size());
        ac=this.allp.size();

    }
    public  void gettype(String s){
        this.type=s;
    }
    public void setData(Stack<good> product){
        this.product=product;
        sc=this.product.size();
        System.out.println("stack count"+type);

    }
    public void setq(Queue<good> product){
        this.queuegood=product;


    }

    public void setL(List<good> product){
        this.listp=product;
        lc=listp.size();


    }

    public  String dateform(Date e){
        String ee=new SimpleDateFormat("YYYY/MM/dd").format(e);
        return ee;



    }


}
