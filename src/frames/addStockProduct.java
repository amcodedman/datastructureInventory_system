package frames;

import Tables.goodTablemodel;
import ConnectorP.Performcollection;
import database.collections;
import database.sales_contractor;


import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Map;


public class addStockProduct extends JPanel implements ActionListener {
   public JComboBox combo1;
   public JComboBox combo2;
   public Font robotoFont;
   public JLabel catl;
   public JLabel prodl;
   public JLabel datl;
   public JLabel quatl;
   public JLabel purchl;
   public JLabel salel;
   public JLabel grossl;
   public JLabel grosSalel;
   public JLabel addnamel;
    public JFormattedTextField datename;
    public JTextField quatname;
    public JTextField purchname;
    public JTextField salename;
    public JTextField grosname;
    public JTextField grosSalename;
    public JButton savebtn;
    public JButton refrestbtn;
    public JButton addbtn;
    public JButton removebtn;
    public Color colorsave;
    public JLabel vendorl;


    public JComboBox vendorname;
    public collections DB;
    public int vendorids=0;


    DefaultComboBoxModel bevlist;
    DefaultComboBoxModel Breadlist;
    DefaultComboBoxModel Cannedlist;
    DefaultComboBoxModel Dairylist;
    DefaultComboBoxModel Drylist;
    DefaultComboBoxModel Frozenlist;
    DefaultComboBoxModel Meatlist;
    DefaultComboBoxModel Producelist;
    DefaultComboBoxModel Cleanerslist;
    DefaultComboBoxModel Paperlist;
    DefaultComboBoxModel Personallist;
    DefaultComboBoxModel ded;
    DefaultComboBoxModel vendorllist;
    Font labelf;
    Dimension setdimension;
    Border borderd;
    Border borderfocus;
    MainFrame des;


private Performcollection controller;

private final ShowProduces viewGood_p;
    public addStockProduct(ShowProduces vg) throws Exception {
        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        ClassLoader cl= this.getClass().getClassLoader();
        URL dir=cl.getResource("frames/icons/Refresh.png");
        ImageIcon icon9=new ImageIcon(dir);
        Image refresh = icon9.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
        ImageIcon refff=new ImageIcon(refresh);
controller=new Performcollection();
controller.loadname();

        viewGood_p=vg;
DB=new collections();
        System.out.println(controller.getvendorsid());

        URL dirr=cl.getResource("frames/icons/addd.png");
        ImageIcon icon6=new ImageIcon(dirr);
        Image adds = icon6.getImage().getScaledInstance(15 ,15, Image.SCALE_DEFAULT);
        ImageIcon ad=new ImageIcon(adds);

        URL dirr1=cl.getResource("frames/icons/minus.png");
        ImageIcon icon7=new ImageIcon(dirr1);
        Image minuss = icon7.getImage().getScaledInstance(15 ,15, Image.SCALE_DEFAULT);
        ImageIcon mi=new ImageIcon(minuss);

        URL dirr2=cl.getResource("frames/icons/save.png");
        ImageIcon icon8=new ImageIcon(dirr2);
        Image savedb = icon8.getImage().getScaledInstance(15 ,15, Image.SCALE_DEFAULT);
        ImageIcon sicon=new ImageIcon(savedb);
        borderd= BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(164, 165, 166));
        borderfocus= BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLUE);


        DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/dd");
        datename= new JFormattedTextField(dateFormat);

        datename.setValue(new Date());
        datename.setPreferredSize(new Dimension(100,50));


        setdimension=new Dimension(350,30);
        colorsave=new Color( 3, 98, 252);
        labelf=robotoFont.deriveFont(Font.BOLD,16f);
        setLayout(new GridBagLayout());
        vendorl=new JLabel("Supplier Name");
        vendorl.setFont(labelf);
        vendorl.setForeground(colorsave);
       catl=new JLabel(" Product Category");
       catl.setFont(labelf);
       catl.setForeground(colorsave);
     prodl=new JLabel("Good Name");
        prodl.setFont(labelf);
        prodl.setForeground(colorsave);
     datl=new JLabel("Date");
        datl.setFont(labelf);
        datl.setForeground(colorsave);
       quatl=new JLabel("Total Quantity");
        quatl.setFont(labelf);
        quatl.setForeground(colorsave);
        purchl=new JLabel("Purchasing price per unit");
        purchl.setFont(labelf);
        purchl.setForeground(colorsave);
     salel=new JLabel("Selling Price");
        salel.setFont(labelf);
        salel.setForeground(colorsave);
         grossl=new JLabel("Gross Price");
        grossl.setFont(labelf);
        grossl.setForeground(colorsave);
     grosSalel=new JLabel("Gross Sales");
        grosSalel.setFont(labelf);
        grosSalel.setForeground(colorsave);
      addnamel=new JLabel("Add Good");
        addnamel.setFont(labelf);
        addnamel.setForeground(colorsave);

       refrestbtn=new JButton("Refresh");

        datename.setPreferredSize( new Dimension(280,30));
        datename.setBorder(borderd);

        quatname=new JTextField(20);
        quatname.setPreferredSize( setdimension);
        quatname.setBorder(borderd);
        purchname=new JTextField(20);
        purchname.setPreferredSize( setdimension);

        salename=new JTextField(20);
        salename.setPreferredSize( setdimension);

        grosname=new JTextField(20);
        grosname.setPreferredSize( setdimension);
        grosname.setBorder(borderd);
        grosSalename=new JTextField(20);
        grosSalename.setPreferredSize( setdimension);
        grosSalename.setBorder(borderd);
       savebtn=new JButton("Save");
       purchname.setBorder(borderd);
       salename.setBorder(borderd);
       removebtn=new JButton("   REMOVE GOOD");
       addbtn=new JButton("  Add Product");
       savebtn.setBackground(colorsave);

        buttdesign(refrestbtn);
       removebtn.setBackground(colorsave);
       addbtn.setBackground(colorsave);
       savebtn.setForeground(Color.WHITE);
       removebtn.setForeground(Color.WHITE);
       addbtn.setForeground(Color.WHITE);

       addbtn.setPreferredSize(new Dimension(150,40));
       removebtn.setPreferredSize(new Dimension(150,40));
       savebtn.setPreferredSize(new Dimension(150,40));

/** input text helper  */
        purchname.setFont(labelf);
        purchname.setToolTipText("Price by unit (GHC)");
        quatname.setFont(labelf);
        quatname.setToolTipText("Total number of goods");
        grosSalename.setToolTipText("Total cost plus addition expenses (GHC)");
        grosSalename.setFont(labelf);
        salename.setFont(labelf);
        salename.setToolTipText("Sale price (GHC) ");
        grosname.setToolTipText("Total cost plus addition expenses (GHC)");
grosname.setFont(labelf);

setBorder(new EmptyBorder(0,5,0,5));



combo1=new JComboBox();
combo2=new JComboBox();

combo2.setEditable(true);
combo1.setEditable(true);
vendorname=new JComboBox();
        vendorllist=new DefaultComboBoxModel();
        Personallist=new DefaultComboBoxModel();
        bevlist=new DefaultComboBoxModel();
        Breadlist=new DefaultComboBoxModel();
        Cannedlist=new DefaultComboBoxModel();
        Dairylist=new DefaultComboBoxModel();
        Drylist=new DefaultComboBoxModel();
        Frozenlist=new DefaultComboBoxModel();
        Meatlist=new DefaultComboBoxModel();
        Producelist=new DefaultComboBoxModel();
        Cleanerslist=new DefaultComboBoxModel();
        Paperlist=new DefaultComboBoxModel();
        ded=new DefaultComboBoxModel();

DefaultComboBoxModel listcat=new DefaultComboBoxModel();
listcat.addElement("Beverages");
listcat.addElement("Bread/Bakery");
listcat.addElement("Canned/Jarred Goods");
listcat.addElement("Dairy");
listcat.addElement("Dry/Baking Goods");
listcat.addElement("Frozen Foods");
listcat.addElement("Meat");
listcat.addElement("Produce");
listcat.addElement("Cleaners");
listcat.addElement("Paper Goods");
listcat.addElement("Personal Care");


for(Map.Entry<String, Integer>e:controller.getvendorsid().entrySet()){
            vendorllist.addElement(e.getKey().trim());


}


vendorname.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        vendorids= controller.getvendorsid().get((String) vendorname.getSelectedItem());
System.out.println(controller.getvendorsid());



    }
});
        combo1.setModel(listcat);
vendorname.setModel(vendorllist);
        combo1.addActionListener(this);
        combo1.setPreferredSize(new Dimension(280,30));
        vendorname.setPreferredSize(new Dimension(280,30));
        combo2.setPreferredSize(new Dimension(280,30));

GridBagConstraints gc=new GridBagConstraints();
/**  vendor*/
gc.gridx=0;
gc.gridy=0;
gc.anchor=GridBagConstraints.FIRST_LINE_START;
gc.insets=new Insets(0,0,10,150);
add(vendorl,gc);

gc.gridy=1;
gc.anchor=GridBagConstraints.FIRST_LINE_START;
gc.insets=new Insets(0,0,30,150);
add(vendorname,gc);

/** category */
gc.gridy=2;
gc.insets=new Insets(0,0,10,0);

add(catl,gc);

gc.gridy=3;
gc.insets=new Insets(0,0,30,0);
add(combo1,gc);

/** good name */





gc.gridy=4;

gc.insets=new Insets(0,0,10,0);

add(prodl,gc);


gc.gridy=5;

gc.insets=new Insets(0,0,0,0);

add(combo2,gc);



/** date */

        gc.gridx=1;
        gc.gridy=0;

        gc.insets=new Insets(0,0,10,100);

        add(datl,gc);

        /** datename */
        gc.gridy=1;

        gc.insets=new Insets(0,0,0,100);

        add(datename,gc);



        /** quantity*/

        gc.gridy=2;
        add(quatl,gc);




        gc.gridy=3;

        gc.insets=new Insets(0,0,10,100);

        add(quatname,gc);

/*** purchase*/

gc.gridy=4;
        gc.insets=new Insets(0,0,0,100);

        add(purchl,gc);

        gc.gridy=5;

        gc.insets=new Insets(0,0,0,100);

        add(purchname,gc);

        /** sales  price */

        gc.gridy=0;
        gc.gridx=2;

        gc.insets=new Insets(0,0,10,0);

        add(salel,gc);




        gc.gridy=1;

        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(salename,gc);


        /**  Gross price */

        gc.gridy=2;

        gc.insets=new Insets(0,0,10,0);
        add(grossl,gc);



        gc.gridy=3;
        gc.insets=new Insets(0,0,0,0);
        add(grosname,gc);




/** add button */
        gc.gridy=6;
        gc.gridx=0;
        gc.insets=new Insets(50,0,0,0);

        add(addbtn,gc);
/**  remove button*/
        gc.gridx=1;
        gc.gridy=6;
        gc.insets=new Insets(50,-240,0,0);


        add(removebtn,gc);
/**  save */
        gc.gridx=2;
        gc.gridy=6;
        gc.insets=new Insets(50,0,0,0);
        add(savebtn,gc);

        gc.gridx=2;
        gc.gridy=7;
        gc.insets=new Insets(50,0,0,0);
        refrestbtn.setPreferredSize(new Dimension(145,40));
        add(refrestbtn,gc);




        setBackground(new Color(223, 242, 239));



setcolor(quatname);
setcolor(datename);
setcolor(purchname);
setcolor(salename);
setcolor(grosname);
setcolor(grosSalename);



        /**      ADD BUTTOM LISTENERS*/

        removebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.delectStack();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        refrestbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    controller.loadname();
                    vendorllist.removeAllElements();
                    for(Map.Entry<String, Integer>ei:controller.getvendorsid().entrySet()){


                        vendorllist.addElement(ei.getKey());


                    }

                    System.out.println(controller.getvendorsid());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {


                    goodTablemodel gm=new goodTablemodel();
                    collections c=new collections();

                    Date dd=new Date(datename.getText());
                    java.sql.Date newt= new java.sql.Date(dd.getTime());
                    int quatn= Integer.parseInt(quatname.getText().trim());
                    double purchn=Double.parseDouble(purchname.getText().trim());
                    double salena=Double.parseDouble(salename.getText().trim());
                    double  grosna=Double.parseDouble(grosname.getText().trim());


                    int vendorn=vendorids;
                    String catsel=(String) combo1.getSelectedItem();
                    String productsel=(String) combo2.getSelectedItem();
                    int result = JOptionPane.showConfirmDialog(null, " click Yes to add to Stocks", "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.YES_OPTION) {


                        viewGood_p.refresh();
                        if(DB.categorystack.contains(catsel)){
                            controller.addgoodstack(catsel,productsel,newt,quatn,purchn,salena,grosna,catsel,productsel,vendorn);
                            controller.connect();
                            controller.load();
                            controller.getgood().clear();
                            controller.save_with_stack();

                        }
                        if(DB.categoryqueue.contains(catsel)){
                            controller.addgoodqueue(catsel,productsel,newt,quatn,purchn,salena,grosna,catsel,productsel,vendorn);
                            controller.connect();
                            controller.load();
                            controller.getqgood().clear();
                            controller.save_with_queue();

                            viewGood_p.refresh();
                        }
                        if(DB.categorylist.contains(catsel)){
                            controller.addgoodlist(catsel,productsel,newt,quatn,purchn,salena,grosna,catsel,productsel,vendorn);
                            controller.connect();
                            controller.load();
                            controller.getlistg().clear();
                            controller.save_with_list();

                            viewGood_p.refresh();
                        }








                    } else if (result == JOptionPane.NO_OPTION) {

JOptionPane.showMessageDialog(null,"Operation exit");


                    } else if (result == JOptionPane.CLOSED_OPTION) {
                        // User closed the dialog box
                        System.out.println("User closed the dialog box.");
                    }


                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                    throw new RuntimeException(ex);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Error: Field required "+ ex.getMessage());
                    throw new RuntimeException(ex);
                }






                viewGood_p.setD(controller.getgood());
                viewGood_p.setp(controller.getall());





            }
        });
    }

    /**  remove rows*/







    public void actionPerformed(ActionEvent e)  {
        String combo1_t=(String) combo1.getSelectedItem();
        try {
            controller.loadname();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(DB.getvendorsname());
/** beverage list */
        bevlist.addElement("coffee/tea");
        bevlist.addElement("juice");
        bevlist.addElement(" soda");
        bevlist.addElement("pepsi");
        bevlist.addElement("Sparkling drink");
        bevlist.addElement("Mocktail");
        bevlist.addElement("Milkshake");
/**   Breadlist*/
        Breadlist.addElement("sandwich loaves");
        Breadlist.addElement("dinner rolls");
        Breadlist.addElement("tortillas");
        Breadlist.addElement("bagels");
        Breadlist.addElement(" banana bread");
        Breadlist.addElement("corn bread");
        Breadlist.addElement("irish soda bread");
        Breadlist.addElement("rye bread");
      /**   Canned/Jarred Goods*/
        Cannedlist.addElement("coconut milk");
        Cannedlist.addElement("spaghetti sauce");
        Cannedlist.addElement("ketchup");
        Cannedlist.addElement("baby corn");
        Cannedlist.addElement("olives");
        Cannedlist.addElement("diced green chiles");
        Cannedlist.addElement("pumpkin");
        Cannedlist.addElement("jackfruit");
    /** Dairy */
        Dairylist.addElement("cheeses");
        Dairylist.addElement("eggs");
        Dairylist.addElement("milk");
        Dairylist.addElement("yoghurt");
        Dairylist.addElement("butter");
        Dairylist.addElement("sour cream");
        Dairylist.addElement("Ice Cream");
        Dairylist.addElement("heavy cream");


    /**  Dry/Baking Goods*/
        Drylist.addElement("pasta");
        Drylist.addElement("sugar");
        Drylist.addElement("flour");
        Drylist.addElement("cereals");
        Drylist.addElement("salt");
        Drylist.addElement("fats");
        Drylist.addElement("leaveners");
        Drylist.addElement("baking Soda");

        /**     Frozen Foods*/


        Frozenlist.addElement(" waffles,");
        Frozenlist.addElement("ice cream");
        Frozenlist.addElement("vegetables");
        Frozenlist.addElement("ice cream");
        Frozenlist.addElement("plain chicken");
        Frozenlist.addElement("sausages");
        Frozenlist.addElement("pizza");
        Frozenlist.addElement("frozen bananas");
        Frozenlist.addElement("soy beans");


        /**   Meat list */



        Meatlist.addElement(" lunch meat");
        Meatlist.addElement("turkey");
        Meatlist.addElement("beef");
        Meatlist.addElement("pork");
        Meatlist.addElement("chicken");
        Meatlist.addElement("prawns");
        Meatlist.addElement("crab");
        Meatlist.addElement("lobster");

        /**  Produce – */
        Producelist.addElement("strawberries");
        Producelist.addElement("vegetables");
        Producelist.addElement("spinach");
        Producelist.addElement("nectarines");
        Producelist.addElement("apples");
        Producelist.addElement("grapes");
        Producelist.addElement("hot Peppers");
        Producelist.addElement("cherries");

        /**   Cleaners */
        Cleanerslist.addElement("laundry detergent");
        Cleanerslist.addElement("dishwashing liquid");
        Cleanerslist.addElement("all-purpose cleaner");
        Cleanerslist.addElement("oven cleaner");
        Cleanerslist.addElement("baking soda");
        Cleanerslist.addElement("white vinegar");
        Cleanerslist.addElement("scrubbing sponges");


        /**  Paper Goods*/

        Paperlist.addElement("paper towels");
        Paperlist.addElement("toilet paper");
        Paperlist.addElement("aluminium foil");
        Paperlist.addElement("sandwich bags");
        Paperlist.addElement("paper Packs");
        Paperlist.addElement("linerboard");
        Paperlist.addElement("paperboard");


        /**  Personal Care*/

        Personallist.addElement("shampoo");
        Personallist.addElement("soap");
        Personallist.addElement("hand soap");
        Personallist.addElement("shaving cream");
        Personallist.addElement("hair clippers");
        Personallist.addElement("cotton pads");
        Personallist.addElement("shaving cream");
        Personallist.addElement("baby powder");
        Personallist.addElement("perfumes");

        ded.addElement("enter the name of good");

/** switch controller */
switch(combo1_t){
    case "Beverages":
        combo2.setModel(bevlist);
        break;
    case "Bread/Bakery":
        combo2.setModel(Breadlist);
        break;
    case "Canned/Jarred Goods":
        combo2.setModel(Cannedlist);
        break;
    case "Dairy":
        combo2.setModel(Dairylist);
        break;
    case "Dry/Baking Goods":
        combo2.setModel(Drylist);
        break;
    case "Frozen Foods":
        combo2.setModel(Frozenlist);
        break;
    case "Meat":
        combo2.setModel(Meatlist);
        break;
    case "Produce":
        combo2.setModel(Producelist);
        break;
    case "Cleaners":
        combo2.setModel(Cleanerslist);
        break;
    case "Paper Goods":
        combo2.setModel(Paperlist);
        break;
    case "Personal Care":
        combo2.setModel(Personallist);
        break;
    default:
        combo2.setModel(ded);
        break;


}





    }

    private void setcolor(JTextField p){
        p.setBackground(new Color(223, 242, 239));

    }
    private void buttdesign(JButton b){

        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(180,60));
        b.setBorder(new ShowProduces.RoundedBorder(20));

        b.setOpaque(false);
        b.setFocusPainted(false);


        b.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
