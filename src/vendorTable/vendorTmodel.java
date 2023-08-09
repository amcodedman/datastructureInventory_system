package vendorTable;

import database.collections;
import database.good;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class vendorTmodel extends AbstractTableModel {


    Stack<good>product;
    collections DB=new collections();
    private String [] col={ "ID","VENDOR","ADDRESS","CONTACT","DATE","COMPANY"};
    @Override
    public String getColumnName(int column) {
        return col[column];
    }

    private static  int count=0;

    @Override
    public int getRowCount() {
        return count;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        good g=product.get(rowIndex);
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




        }
        return null;
    }

    public void setData(Stack<good> product){
        this.product=product;
        count=this.product.size();
    }
    public  String dateform(Date e){
        String ee=new SimpleDateFormat("YYYY/MM/dd").format(e);
        return ee;



    }
    public void count(){
        System.out.print("ALL"+DB.Productlist.size());
        System.out.print("stack"+DB.stackGood.size());
    }

}
