package database;


import java.sql.Date;

public class good {

    private  int count=0;
    private int Id;
    private int Vendor;
    private String Category;
    private String Good;
    private  Date Date;
    private int Quant;
    private  Double Unit_price;
    private  Double Saleprice;
    private Double Grossprice;

    public  good(String category,String product,Date date,int quant,Double unit_p,Double sale_p,Double grossp ,int vendor){
        this.Category=category;
       this.Good=product;
       this.Date=date;
        this.Grossprice=grossp;

        this.Quant=quant;
        this.Unit_price=unit_p;
        this.Vendor=vendor;
        this.Id=count;
        count++;

        this.Saleprice=sale_p;



    }
    public  good(int id,String category,String product,Date date,int quant,Double unit_p,Double sale_p,Double grossp,int vendor){
        this(category,product,date,quant,unit_p, sale_p, grossp, vendor);
        this.Id=id;


        this.Saleprice=sale_p;



    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getVendor() {
        return Vendor;
    }

    public void setVendor(int vendor) {
        Vendor = vendor;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getGood() {
        return Good;
    }

    public void setGood(String good) {
        Good = good;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public int getQuant() {
        return Quant;
    }

    public void setQuant(int quant) {
        Quant = quant;
    }

    public Double getUnit_price() {
        return Unit_price;
    }

    public void setUnit_price(Double unit_price) {
        Unit_price = unit_price;
    }

    public Double getSaleprice() {
        return Saleprice;
    }

    public void setSaleprice(Double saleprice) {
        Saleprice = saleprice;
    }

    public Double getGrossprice() {
        return Grossprice;
    }

    public void setGrossprice(Double grossprice) {
        Grossprice = grossprice;
    }



}
