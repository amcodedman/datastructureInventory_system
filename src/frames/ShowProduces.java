package frames;

import ConnectorP.Performcollection;
import Tables.goodTablemodel;
import database.collections;
import database.good;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShowProduces extends JPanel implements ActionListener {
    ClassLoader cl= this.getClass().getClassLoader();
    URL dirr=cl.getResource("frames/icons/peopeque.png");
    ImageIcon icon6=new ImageIcon(dirr);
    Image adds = icon6.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon queu=new ImageIcon(adds);

    URL dirr1=cl.getResource("frames/icons/bstack.png");
    ImageIcon icon7=new ImageIcon(dirr1);
    Image minuss = icon7.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon stac=new ImageIcon(minuss);

    URL dir=cl.getResource("frames/icons/reloader.png");
    ImageIcon icon8=new ImageIcon(dir);
    Image refresh = icon8.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon refff=new ImageIcon(refresh);

    URL dirr2=cl.getResource("frames/icons/listme.png");
    ImageIcon icon0=new ImageIcon(dirr2);

    Image savedb = icon0.getImage().getScaledInstance(40 ,40, Image.SCALE_DEFAULT);
    ImageIcon lis=new ImageIcon(savedb);

    goodTablemodel model;
    JTable table;
    JButton  stacktab;
    JButton listtab;
    JButton queuetab;
    JButton queuepoll;
    JButton listgetbtn;
    JButton refreshtab;
    JButton  popbtn;
    JButton peektbn;
    JButton qpeektbn;
    JButton qremovetbn;
    JPanel TopPanel;
    JPanel CenterPanel;
    JButton stackpeek;
    JLabel stackpeekl;
    JLabel stackemptyl;
    JButton stackemtybtn;
    JPanel leftPanel;
    JPanel optionpanel;
    JLabel qcount;
    JPanel Tablep;
    public Font robotoFont;

    JButton lremovetbn;
JLabel listrl;
    GridBagLayout fl=new GridBagLayout();
    JPanel Action_tabs;
    Border newborder;
    Border margin;
    JButton collection;
    JButton searcsort;
    JComboBox searchbox;
    DefaultComboBoxModel bb;
    JLabel searchl;


JTextField listr;
    private Performcollection control;
    collections db=new collections();
    ShowProduces() throws IOException, FontFormatException {

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        listr=new JTextField(5);
        listrl=new JLabel("ID");
        /*******************  JPANELS *****************************************************************/
        BorderLayout newb=new BorderLayout();

        BorderLayout Tablelayout=new BorderLayout();
        BorderLayout Centerlayout=new BorderLayout();

        Tablep=new JPanel(Tablelayout);
TopPanel=new JPanel(newb);
CenterPanel=new JPanel();
CenterPanel.setLayout(Centerlayout);
GridBagLayout leftgrid=new GridBagLayout();
leftPanel=new JPanel(leftgrid);
        queuepoll=new JButton("Poll ()");
Action_tabs=new JPanel(fl);
GridBagLayout op=new GridBagLayout();
optionpanel=new JPanel(op);
optionpanel.setBackground(new Color(213, 219, 247));

optionpanel.setPreferredSize(new Dimension(300,50));
TopPanel.add(optionpanel,BorderLayout.WEST);
TopPanel.add(Action_tabs,BorderLayout.CENTER);
Action_tabs.setBorder(new CompoundBorder(new EmptyBorder(8,10,3,10),new RoundedBorder(20)));
optionpanel.setBorder(new CompoundBorder(new EmptyBorder(8,10,3,10),new RoundedBorder(20)));
searchbox=new JComboBox();
searchbox.setPreferredSize(new Dimension(140,40));
        listgetbtn=new JButton("Get (ID)");
searchl=new JLabel("Filter By");
searcsort=new JButton("Find");
collection=new JButton("Collection");


        control=new Performcollection();
        stacktab=new JButton("Stack Action");
        queuetab=new JButton("Queue Action");
        listtab=new JButton("List Action");
        refreshtab=new JButton("Refresh");

      stackpeek=new JButton("Stack Peek");
       stackpeekl=new JLabel("Stack Peek will show here");
       stackemptyl=new JLabel("");
       stackemtybtn=new JButton("Stack Empty?");

        newborder=BorderFactory.createTitledBorder("Actions Controls");
        margin=new EmptyBorder(10,0,10,0);

qcount=new JLabel("a");
qcount.setForeground(Color.RED);

/***** action perform button **/
        popbtn=new JButton("Pop");
         peektbn=new JButton("Peek");
        qpeektbn=new JButton("Peek");
         qremovetbn=new JButton("Remove");



        lremovetbn=new JButton("Remove");


setLayout(new BorderLayout());
GridBagLayout   gd=new GridBagLayout();
        model=new goodTablemodel();
        table=new JTable(model);

        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());



            Border bd=new EmptyBorder(15,15,15,15);
            table.setBorder(bd);
            JScrollPane ScrollTable=new JScrollPane(table);
            ScrollTable.setBorder(bd);
        ScrollTable.setBackground(new Color(213, 219, 247));


        add(TopPanel,BorderLayout.PAGE_START);



        /**                         Layout for Action Action_tabs          ***/
        buttondesign(stacktab);
        buttondesign(queuetab);
        buttondesign(refreshtab);
        buttondesign(listtab);
queuetab.setIcon(queu);
stacktab.setIcon(stac);
bb=new DefaultComboBoxModel();
    bb.addElement("Frozen Foods");
bb.addElement("Meat");
        bb.addElement("Produce");
        bb.addElement("Cleaners");
        bb.addElement("Paper Goods");
        bb.addElement("Personal Care");
        bb.addElement("Dry/Baking Goods");
        bb.addElement("Dairy");
        bb.addElement("Canned/Jarred Goods");
        bb.addElement("Bread/Bakery");
        bb.addElement("Beverages");
        searchbox.setModel(bb);


listtab.setIcon(lis);
Action_tabs.setBackground(new Color(213, 219, 247));









/************************* Searching action *******************************************************/
searchbox.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedcat=(String) searchbox.getSelectedItem();
        try {
            control.connect();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        try {
            control.getFilterg().clear();
            control.load();
            control.performfilter(selectedcat);
            db.FilterProduct(selectedcat);

            setp(control.getFilterg());
            refresh();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
});
refreshtab.setIcon(refff);
        searchbox.setVisible(false);
        searchl.setVisible(false);


        qcount.setVisible(false);
refreshtab.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {



    }
});




stackemtybtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
           control.connect();
            control.load();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        stackemptyl.setText(String.valueOf(control.getgood().isEmpty()));
    }
});



        stackpeek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    control.connect();
                    control.load();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

               stackpeekl.setText(String.valueOf(control.getgood().peek().getGood()));
            }
        });




/**************** LAYOUT DESIGN**************************/


GridBagConstraints opl=new GridBagConstraints();
opl.gridy=0;
opl.gridx=0;
optionpanel.add(collection,opl);
opl.gridy=6;
optionpanel.add(searcsort,opl);


        buttdesign(searcsort);
        buttdesign(collection);

        GridBagConstraints tg=new GridBagConstraints();
        tg.gridx=3;
        tg.insets=new Insets(0,0,0,10);
        Action_tabs.add(searchl,tg);
        tg.gridy=1;
        Action_tabs.add(searchbox);
        tg.gridx=6;
        tg.gridy=0;


        tg.insets=new Insets(0,0,0,0);
        tg.gridx=0;
        tg.gridy=0;
        tg.anchor=GridBagConstraints.LINE_START;
        Action_tabs.add(refreshtab,tg);
refreshtab.addActionListener(this);
        tg.gridx=1;
        Action_tabs.add(stacktab,tg);
        tg.gridx=3;
        Action_tabs.add(listtab,tg);
        tg.gridx=5;
        Action_tabs.add(queuetab,tg);
        stacktab.addActionListener(this);
        listtab.addActionListener(this);
        queuetab.addActionListener(this);

        tg.gridx=2;
        tg.gridy=5;
tg.insets=new Insets(10,-150,0,0);


buttonp(peektbn);
        buttonp(popbtn);
        buttonp(qpeektbn);
        buttonp(qremovetbn);
        buttonp(stackpeek);
        buttonp(queuepoll);
        buttonp(listgetbtn);

        buttonp(stackemtybtn);

        buttonp(lremovetbn);
        popbtn.setVisible(false);
        peektbn.setVisible(false);

        lremovetbn.setVisible(false);
        qpeektbn.setVisible(false);
        queuepoll.setVisible(false);
        qremovetbn.setVisible(false);
        listr.setVisible(false);
        listrl.setVisible(false);
        stackpeek.setVisible(false);

        stackpeekl.setVisible(false);
        stackemtybtn.setVisible(false);
        listgetbtn.setVisible(false);
        stackemptyl.setVisible(false);





        leftPanel.setPreferredSize(new Dimension(300,800));
       leftPanel.setBackground(new Color(213, 219, 247));
        leftPanel.setBorder(new CompoundBorder(new EmptyBorder(8,10,3,10),new RoundedBorder(20)));



        GridBagConstraints leftgb=new GridBagConstraints();
leftgb.insets=new Insets(0,0,10,10);
leftgb.gridy=0;
leftgb.gridx=0;
        leftPanel.add(popbtn,leftgb);
        leftgb.gridy=1;
        leftPanel.add(stackpeek,leftgb);

        leftgb.gridy=2;


        leftPanel.add(queuepoll,leftgb);
        leftPanel.add( stackpeekl,leftgb);
        leftgb.gridy=3;

        leftPanel.add( stackemtybtn,leftgb);


        leftgb.gridy=4;
        leftPanel.add(stackemptyl,leftgb);


        leftgb.gridx=0;
        leftPanel.add(qremovetbn,leftgb);
        leftgb.gridx=2;
        leftPanel.add(qcount,leftgb);


        leftgb.gridy=0;
        leftgb.gridx=1;

        leftPanel.add(listrl,leftgb);
        leftgb.gridy=0;
        leftgb.gridx=2;
        leftPanel.add(listr,leftgb);
        leftgb.gridy=0;
        leftgb.gridx=0;
        leftPanel.add(lremovetbn,leftgb);






/******           tab end                                          ***/
collection.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {


        stacktab.setVisible(true);
        queuetab.setVisible(true);
        listtab.setVisible(true);
        searchbox.setVisible(false);
        searchl.setVisible(false);




    }
});
searcsort.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        popbtn.setVisible(false);
        peektbn.setVisible(false);
        qcount.setVisible(false);
listrl.setVisible(false);
        lremovetbn.setVisible(false);
        qpeektbn.setVisible(false);
        qremovetbn.setVisible(false);
        stacktab.setVisible(false);
        queuetab.setVisible(false);
        listtab.setVisible(false);
        searchbox.setVisible(true);
        searchl.setVisible(true);


    }
});

        Action_tabs.setPreferredSize(new Dimension(100,200));



Tablep.add(ScrollTable,BorderLayout.CENTER);
add(CenterPanel,BorderLayout.CENTER);
CenterPanel.add(Tablep,BorderLayout.CENTER);
CenterPanel.add(leftPanel,BorderLayout.WEST);

setBackground(new Color(213, 219, 247));
lremovetbn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int index=Integer.parseInt(listr.getText());
        try {
            control.delectList(index);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,"ERROR '"+ex+"'");
            throw new RuntimeException(ex);
        }

        try {
            control.load();
            JOptionPane.showMessageDialog(null ,"list Item with index'"+index+"'");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        refresh();
        setD(control.getgood());
        setp(control.getall());

    }
});
qremovetbn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            control.delectQueue();
          int a=(control.getqgood().size());
            qcount.setText(String.valueOf(a));
            JOptionPane.showMessageDialog(null ,"Queue Item removed");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,"ERROR"+ex+"'");
            throw new RuntimeException(ex);
        }

        try {
            control.load();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        setD(control.getgood());
        setp(control.getall());
        refresh();
    }

});


        queuepoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    control.connect();
                    control.load();

                   String textout=control.getqgood().poll().getGood();
                    String textresult= String.valueOf(control.getqgood().poll());
                   if(textresult==null){
                       JOptionPane.showMessageDialog(null ,"Queue Poll() returned Null");
                   }
                   else{
                       JOptionPane.showMessageDialog(null ,"Queue item removed :"+ textout);
                   }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null ,"ERROR"+ex+"'");
                    throw new RuntimeException(ex);
                }

                try {
                    control.load();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setD(control.getgood());
                setp(control.getall());
                refresh();
            }

        });


popbtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            control.delectStack();

            control.load();
            setD(control.getgood());
            setp(control.getall());
            refresh();
            JOptionPane.showMessageDialog(null ,"Stack item remove");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null ,"ERROR'"+ex+"'");
            throw new RuntimeException(ex);
        }
    }
});
    }

public void setD(Stack<good> p){model.setData(p);
}
    public void setp(List<good> p){model.setp(p);
    }
    public void setList(List<good> p){model.setL(p);
    }
    public void setq(Queue<good> p){model.setq(p);
    }
    public void settype(String s){model.gettype(s);}

    public void refresh(){

        model.fireTableDataChanged();
;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var btn=e.getSource();


Performcollection control=new Performcollection();
        try {
            control.connect();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        if(btn==refreshtab) {
                settype("ALL");
                try {
                    control.load();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setD(control.getgood());
                setp(control.getall());
                setList(control.getlistg());
                refresh();
                popbtn.setVisible(false);
                listrl.setVisible(false);
                peektbn.setVisible(false);
                lremovetbn.setVisible(false);
                qpeektbn.setVisible(false);
                qremovetbn.setVisible(false);
            qcount.setVisible(false);
            listr.setVisible(false);
        stackpeek.setVisible(false);
            queuepoll.setVisible(false);
            listgetbtn.setVisible( false);

        stackpeekl.setVisible(false);
         stackemtybtn.setVisible(false);

        stackemptyl.setVisible(false);
            }
           if(btn==stacktab) {
settype("STACK");
               try {
                   control.load();
               } catch (SQLException ex) {
                   throw new RuntimeException(ex);
               }
               setD(control.getgood());
               setp(control.getall());
               setList(control.getlistg());
               refresh();
               listrl.setVisible(false);
               queuepoll.setVisible(false);
               popbtn.setVisible(true);
               peektbn.setVisible(true);
               stackpeek.setVisible(true);
               stackpeekl.setVisible(true);
               stackemtybtn.setVisible(true);
               listgetbtn.setVisible( false);
               stackemptyl.setVisible(true);
               listr.setVisible(false);
               lremovetbn.setVisible(false);
               qpeektbn.setVisible(false);
               qremovetbn.setVisible(false);
               qcount.setVisible(false);

           }
            if(btn==queuetab) {
                try {
                    control.load();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setq(control.getqgood());
                refresh();
                int a=(control.getqgood().size());
                qcount.setText(String.valueOf(a));
listrl.setVisible(false);
                popbtn.setVisible(false);
                listgetbtn.setVisible( false);
                peektbn.setVisible(false);
                queuepoll.setVisible(true);
listr.setVisible(false);
                lremovetbn.setVisible(false);
                qpeektbn.setVisible(true);
                qremovetbn.setVisible(true);
                qcount.setVisible(true);
                stackpeek.setVisible(false);

                stackpeekl.setVisible(false);
                stackemtybtn.setVisible(false);

                stackemptyl.setVisible(false);

            }
            if(btn==listtab) {
settype("LIST");
                try {
                    control.load();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setD(control.getgood());
                setp(control.getall());
                setList(control.getlistg());
                refresh();
                popbtn.setVisible(false);
                peektbn.setVisible(false);
                listr.setVisible(true);
listrl.setVisible(true);
                lremovetbn.setVisible(true);
                listgetbtn.setVisible(true);
                queuepoll.setVisible(false);
                qpeektbn.setVisible(false);
                qremovetbn.setVisible(false);
                qcount.setVisible(false);
                stackpeek.setVisible(false);

                stackpeekl.setVisible(false);
                stackemtybtn.setVisible(false);

                stackemptyl.setVisible(false);

            }





    }

    /************remove  button acton ************************  *******/

    static class RoundedBorder implements Border {

        private int radius;


        RoundedBorder(int radius) {
            this.radius = radius;
        }


        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }


        public boolean isBorderOpaque() {
            return true;
        }


        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
        }
    }
    private void buttondesign(JButton b){

        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(180,40));
       b.setBorder(new RoundedBorder(20));

        b.setOpaque(false);
       b.setFocusPainted(false);
       b.setBorderPainted(false);

       b.setFont(new Font("Arial", Font.BOLD, 14));
    }
    private void buttdesign(JButton b){

        b.setBackground(Color.WHITE);
        b.setPreferredSize(new Dimension(150,40));

        b.setBorder( new CompoundBorder(new EmptyBorder(5,0,5,0),new RoundedBorder(20)));

        b.setOpaque(false);
        b.setFocusPainted(false);


        b.setFont(robotoFont.deriveFont(Font.BOLD,14f));

    }
    private void buttonp(JButton b){
        b.setOpaque(false);
        b.setBackground(new Color(139, 138, 145));
        b.setForeground(Color.blue);
        b.setPreferredSize(new Dimension(130,40));
        b.setBorder(new RoundedBorder(20));
        b.setFocusPainted(false);
        b.setFont(new Font("Arial", Font.BOLD, 16));
    }


    private class RoundedBorderTableCellRenderer extends DefaultTableCellRenderer {

        private final Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        private final int borderRadius = 10;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


            setOpaque(true);
            setForeground(Color.DARK_GRAY);
            setBackground(new Color(201, 235, 240));
            setFont(robotoFont.deriveFont(Font.BOLD,12f));

            setHorizontalAlignment(CENTER);
            // Set the rounded border for the ce
            // ll renderer component
            ((JComponent) rendererComponent).setBorder(new EmptyBorder(5,5,5,5));

            return rendererComponent;
        }
    }



    private class CustomTableHeaderRenderer extends JLabel implements TableCellRenderer {

        public CustomTableHeaderRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(Color.GRAY);
            setHorizontalAlignment(CENTER);
            setFont(robotoFont.deriveFont(Font.BOLD,13f));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }









}


