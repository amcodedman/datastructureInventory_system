package database;

public class supplier_constructor {
    private  int count=0;

    private int Id;
    private String VendorName;
    private String Address;
    private int Contact;
    private java.sql.Date Date;
    private String Company;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public void setProducts(String products) {
        Products = products;
    }

    private String Country;
    private String name;
    private String Town;
    private  String Products;

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

    public String getVendorName() {
        return VendorName;
    }
    public String getProducts() {
        return Products;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public supplier_constructor(String address, String company, int contact, String country, String town){

        this.Address=address;
        this.Company=company;
        this.Contact=contact;
        this.Country=country;
        this.Town=town;


    }
    public supplier_constructor(int id, String address, String company, int contact, String country, String town){

        this.Address=address;
        this.Company=company;
        this.Contact=contact;
        this.Country=country;
        this.Town=town;
        this.Id=id;


    }





}
