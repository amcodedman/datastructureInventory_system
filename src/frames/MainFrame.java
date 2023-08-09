package frames;

import ConnectorP.Performcollection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.sql.SQLException;

public class MainFrame extends JFrame implements MouseListener {

    ClassLoader cl= this.getClass().getClassLoader();
    URL dirr1=cl.getResource("frames/icons/stocks.png");
    ImageIcon icon7=new ImageIcon(dirr1);
    Image minuss = icon7.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon stac=new ImageIcon(minuss);



    URL dirr2=cl.getResource("frames/icons/suppp.png");
    ImageIcon suppl=new ImageIcon(dirr2);
    Image suppli = suppl.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon supply=new ImageIcon(suppli);
    URL dirr3=cl.getResource("frames/icons/stocks.png");
    ImageIcon icon3=new ImageIcon(dirr3);
    Image addstock = icon3.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon newstock=new ImageIcon(addstock);

    ImageIcon icon4=new ImageIcon(cl.getResource("frames/icons/products.png"));
    Image producc = icon4.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon prodimage=new ImageIcon(producc);

    ImageIcon icon5=new ImageIcon(cl.getResource("frames/icons/saless.png"));
    Image icon5i = icon5.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon newsale=new ImageIcon(icon5i);

    ImageIcon icon9=new ImageIcon(cl.getResource("frames/icons/person.png"));
    Image icon9i = icon9.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon newperson=new ImageIcon(icon9i);
    ImageIcon icon6=new ImageIcon(cl.getResource("frames/icons/recordsss.png"));
    Image icon6i = icon6.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon recordbook=new ImageIcon(icon6i);


    CardLayout card;
    JPanel pan;
    JPanel pan1;
    JPanel pan2;


    ShowProduces viewg;
JLabel personlid;
    JLabel lb1;
    JLabel lb2;
    JLabel lb3;
    JLabel lb4;
    JLabel lb5;
    JLabel lb6;
    JLabel spacc;
    JLabel spacc1;
    JLabel spacc2;
    JLabel spacc3;
    JLabel spacc4;
    Border borderl;
    Border margin;
    JLabel personlable;
    private Performcollection controller;
    MainFrame() throws Exception {
        super("MyShop Keeper By James Mensah");

        /**  ***********  IMPORT PAGES ****************************************************************/
        Suppliers vendorp=new Suppliers();

        viewg=new ShowProduces();
        addStockProduct addgood=new addStockProduct(viewg);
        viewBill_p viewb=new viewBill_p();
        issueGoodpanel issueg=new issueGoodpanel();
        displaySold_p viewissueg=new displaySold_p();
      controller=new Performcollection();
        ClassLoader cl= this.getClass().getClassLoader();



        pan =new JPanel(   new FlowLayout(FlowLayout.CENTER));

        pan2 =new JPanel();

        card =new CardLayout();
        pan1 =new JPanel(card);

        /** label tabs*/

        spacc=new JLabel("           ");
        spacc1=new JLabel("           ");
        spacc2=new JLabel("           ");
        spacc3=new JLabel("           ");
        spacc4=new JLabel("           ");

        lb1=new JLabel("  My Suppliers",JLabel.LEFT);

        lb2=new JLabel("  Add Products",JLabel.CENTER);
        lb3=new JLabel("   All Products",JLabel.CENTER);
        lb4=new JLabel("   VIEW BILLS",JLabel.CENTER);
        lb5=new JLabel("   Start Sales",JLabel.CENTER);
        lb6=new JLabel("   Sales History",JLabel.CENTER);
        lb1.setIcon(supply);
        lb2.setIcon(newstock);
        lb3.setIcon(prodimage);
        lb5.setIcon(newsale);

        lb6.setIcon(recordbook);


        borderl=BorderFactory.createMatteBorder(0,0,5,0,new Color(72, 134, 181));
        margin = new EmptyBorder(10,10,10,10);
        lb1.addMouseListener(this);
        lb2.addMouseListener(this);
        lb3.addMouseListener(this);
        lb4.addMouseListener(this);
        lb5.addMouseListener(this);
        lb6.addMouseListener(this);

        lb1.setForeground(Color.WHITE);
        lb1.setBorder( new CompoundBorder(borderl,margin));
        lb2.setForeground(Color.WHITE);
        lb3.setForeground(Color.WHITE);
        lb4.setForeground(Color.WHITE);
        lb5.setForeground(Color.WHITE);
        lb6.setForeground(Color.WHITE);
        setLayout(new BorderLayout());


        pan.add(spacc);
        pan.add(spacc);
        pan.add(spacc);
        pan.add(spacc);

        pan.add(lb1);
        pan.add(spacc);
        pan.add(spacc);
        pan.add(spacc);
        pan.add(lb2);
        pan.add(spacc1);
        pan.add(spacc);
        pan.add(lb3);
        pan.add(spacc2);
        pan.add(spacc);

        /** // pan.add(lb4);
       pan.add(spacc3);*/

        pan.add(lb5);
        pan.add(spacc4);
        pan.add(spacc);

        pan.add(lb6);
        pan.setBackground(new Color( 3, 148, 252));
        add(pan,BorderLayout.PAGE_START);
        pan1.add(vendorp,"pan2");

        pan1.add(addgood,"pan3");
        pan1.add(viewg,"pan4");
        pan1.add(viewb,"pan5");
        pan1.add(issueg,"pan6");
        pan1.add(viewissueg,"pan7");




        add(pan1,BorderLayout.CENTER);
        setIconImage(stac.getImage());



    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==lb1){
            lb1.setBorder(new CompoundBorder(borderl,margin));
            lb2.setBorder(margin);
            lb3.setBorder(margin);
            lb4.setBorder(margin);
            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan2");




        }

        else if(e.getSource()==lb2){
            lb2.setBorder(new CompoundBorder(borderl,margin));
            lb1.setBorder(margin);
            lb3.setBorder(margin);
            lb4.setBorder(margin);
            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan3");

        }
        else if(e.getSource()==lb3){
            lb3.setBorder(new CompoundBorder(borderl,margin));
            try {
                controller.connect();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            try {

                controller.load();
                viewg.setD(controller.getgood());
                    viewg.setp(controller.getall());
                    viewg.setq(controller.getqgood());
                    viewg.setList(controller.getlistg());
                viewg.refresh();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }



            lb2.setBorder(margin);
            lb1.setBorder(margin);
            lb4.setBorder(margin);
            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan4");
        }
        else if(e.getSource()==lb4){
            lb4.setBorder(new CompoundBorder(borderl,margin));
            lb2.setBorder(margin);
            lb3.setBorder(margin);
            lb1.setBorder(margin);
            lb5.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan5");
        }
        else if(e.getSource()==lb5){
            lb5.setBorder(new CompoundBorder(borderl,margin));
            lb2.setBorder(margin);
            lb3.setBorder(margin);
            lb4.setBorder(margin);
            lb1.setBorder(margin);
            lb6.setBorder(margin);
            card.show(pan1,"pan6");
        }
        else if(e.getSource()==lb6){
            lb6.setBorder(new CompoundBorder(borderl,margin));

            lb2.setBorder(margin);
            lb3.setBorder(margin);
            lb4.setBorder(margin);
            lb5.setBorder(margin);
            lb1.setBorder(margin);
            card.show(pan1,"pan7");

        }








    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public void actions(){
        System.out.print("okkk");
        viewg.setBackground(Color.RED);
    }
}
