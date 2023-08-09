package frames;

import ConnectorP.Performcollection;
import database.collections;
import database.sales_contractor;
import database.supplier_constructor;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.sql.SQLException;

import java.util.Map;

public class displaySold_p extends JPanel implements  ActionListener{


    public collections DB;
    public DefaultTableModel model;




    JTable table;



    public Font robotoFont;



    public JButton addbtn;
    public JTextField search;
    public JButton searchbtn;



    private Performcollection control;

    private JPanel Toppanel;
    private JPanel centerpanel;

    public displaySold_p() throws IOException, FontFormatException {
        collections DB=new collections();

        robotoFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("fonts/RobotoCondensed-Regular.ttf"));

        model=new DefaultTableModel(0,0);
        model.addColumn("SALE_CODE");
        model.addColumn("PRODUCT");
        model.addColumn("CATEGORY");
        model.addColumn("QUANTITY");
        model.addColumn("UNIT_PRICE");
        model.addColumn("TOTAL_PRICE");
        model.addColumn("PRODUCT ID");
        model.addColumn("CUSTOMER");
        model.addColumn("DATE");

        table=new JTable(model);






        control=new Performcollection();
        GridBagLayout gb=new GridBagLayout();
        GridBagLayout tg=new GridBagLayout();
        Toppanel=new JPanel(new FlowLayout());
        centerpanel=new JPanel(gb);
        BorderLayout bl=new BorderLayout();
        setLayout(bl);

        setBackground(new Color(223, 242, 239));
        BorderLayout tbl=new BorderLayout();


/**   adding Jpanels left and right   ----------------------------------------------------------------   */
        add(Toppanel,BorderLayout.NORTH);
        Toppanel.setPreferredSize(new Dimension(200,100));
        add(centerpanel,BorderLayout.CENTER);
        addbtn=new JButton("Reload Sales Records");
        ldesign(addbtn);
        Toppanel.add(addbtn);
        Toppanel.setBackground(new Color(223, 242, 239));
        centerpanel.setBorder(new EmptyBorder(0,30,0,20));



        centerpanel.setBorder(new RoundedBorder(30));
        setBorder(new EmptyBorder(10, 10, 10, 10));

/**     ALIGNING LABLES IN LEFT PANEL---------------------------------------------------------------------*/




        table.setDefaultRenderer(Object.class,new RoundedBorderTableCellRenderer());
        table.getTableHeader().setDefaultRenderer(new CustomTableHeaderRenderer());


/*** --------------------------------------------------------------------------------------------------------- */






        centerpanel.setLayout(tbl);



/****                *********************                         ***/


        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {



                    Performcollection control=new Performcollection();
                    try {
                        control.connect();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }


                    try {
                        DB.connect();
                        DB.Load_data_SALE();
                        model.setRowCount(0);
                        for(Map.Entry<Integer, sales_contractor>ind:DB.getSales().entrySet()){
                            model.addRow(new Object[]{ind.getKey(),ind.getValue().getProduct(),
                                    ind.getValue().getCat(),
                                    ind.getValue().getQty(),
                                    ind.getValue().getPriceu(),
                                    ind.getValue().getTotal(),
                                    ind.getValue().getId()
                                    ,ind.getValue().getCus(),
                                    ind.getValue().getDate()});
                        }


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    for(Map.Entry<String, supplier_constructor>indes:DB.Getvendors().entrySet()){

                    }
                }catch (
                        Exception ee
                ){
                    JOptionPane.showMessageDialog(null,ee.getMessage());
                }
            }



        });




        Border bd=new EmptyBorder(50,50,50,50);



        JScrollPane spt=new JScrollPane(table);
        spt.setBorder(bd);
        centerpanel.add(spt,BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("ok button working");
    }

    public void ldesign(JButton b){
        b.setBackground(new Color(156, 121, 252));
        b.setPreferredSize(new Dimension(320,50));
        b.setBorder(new RoundedBorder(20));
        b.setOpaque(false);
        b.setFocusPainted(false);

    }


    private static class RoundedBorder implements Border {

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


