/*
G4Linac_MT, a Geant4-based application for Medical Linear Accelerator
Developed by Dr.Jaafar EL Bakkali,Assistant Prof. of Nuclear Physics
Rabat, Morocco, 10/10/ 2017
Webpage :https://github.com/EL-Bakkali-Jaafar/G4Linac_MT
 */
package g4linac_mt_gui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jsyntaxpane.DefaultSyntaxKit;
/**
 *
 * @author jaafar
 */
public final class geomModeling extends javax.swing.JFrame {
              g4linac_singelton myg4linac_singelton =        g4linac_singelton.getInstance();
   Color BUTTON_BACKGROUD_COLOR__SELECTED_STATE= new Color(255,0,54), BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE= new Color(0,0,154);

    String r_z="", isotopename_fraction="",material_name_proportion_of_material_in_the_mixture="";
    String simple_mat[]=
    {"G4_H","G4_He","G4_Li","G4_Be","G4_B","G4_C","G4_N","G4_O","G4_F","G4_Ne","G4_Na","G4_Mg","G4_Al","G4_Si","G4_P",
     "G4_S","G4_Cl","G4_Ar","G4_K","G4_Ca","G4_Sc","G4_Ti","G4_V","G4_Cr","G4_Mn","G4_Fe","G4_Co","G4_Ni","G4_Cu","G4_Zn",
     "G4_Ga","G4_Ge","G4_As","G4_Se","G4_Br","G4_Kr","G4_Rb","G4_Sr","G4_Y","G4_Zr","G4_Nb","G4_Mo",
     "G4_Tc","G4_Ru","G4_Rh","G4_Pd","G4_Ag","G4_Cd","G4_In","G4_Sn","G4_Sb","G4_Te","G4_I","G4_Xe",
     "G4_Cs","G4_Ba","G4_La","G4_Ce","G4_Pr","G4_Nd","G4_Pm","G4_Sm","G4_Eu","G4_Gd","G4_Tb","G4_Dy",
     "G4_Ho","G4_Er","G4_Tm","G4_Yb","G4_Lu","G4_Hf","G4_Ta","G4_W","G4_Re","G4_Os","G4_Ir","G4_Pt",
     "G4_Au","G4_Hg","G4_Tl","G4_Pb","G4_Bi","G4_Po","G4_At","G4_Rn","G4_Fr","G4_Ra","G4_Ac",
     "G4_Th","G4_Pa","G4_U","G4_Np","G4_Pu","G4_Am","G4_Cm","G4_Bk","G4_Cf"

    };
  String nist_cmp[]={"G4_A-150_TISSUE","G4_ACETONE","G4_ACETYLENE","G4_ADENINE","G4_ADIPOSE_TISSUE_ICRP","G4_AIR","G4_ALANINE",
  "G4_ALUMINUM_OXIDE","G4_AMBER","G4_AMMONIA","G4_ANILINE","G4_ANTHRACENE","G4_B-100_BONE",
  "G4_BAKELITE","G4_BARIUM_FLUORIDE","G4_BARIUM_SULFATE","G4_BENZENE","G4_BERYLLIUM_OXIDE","G4_BGO","G4_BLOOD_ICRP",
  "G4_BONE_COMPACT_ICRU","G4_BONE_CORTICAL_ICRP","G4_BORON_CARBIDE","G4_BORON_OXIDE","G4_BRAIN_ICRP",
  "G4_BUTANE","G4_N-BUTYL_ALCOHOL","G4_C-552","G4_CADMIUM_TELLURIDE","G4_CADMIUM_TUNGSTATE","G4_CALCIUM_CARBONATE",
  "G4_CALCIUM_FLUORIDE","G4_CALCIUM_OXIDE","G4_CALCIUM_SULFATE","G4_CALCIUM_TUNGSTATE","G4_CARBON_DIOXIDE",
  "G4_CARBON_TETRACHLORIDE","G4_CELLULOSE_CELLOPHANE","G4_CELLULOSE_BUTYRATE",
   "G4_CELLULOSE_NITRATE","G4_CERIC_SULFATE","G4_CESIUM_FLUORIDE","G4_CESIUM_IODIDE","G4_CHLOROBENZENE","G4_CHLOROFORM",
   "G4_CONCRETE","G4_CYCLOHEXANE","G4_1,2-DICHLOROBENZENE","G4_DICHLORODIETHYL_ETHER","G4_1,2-DICHLOROETHANE","G4_DIETHYL_ETHER",
   "G4_N,N-DIMETHYL_FORMAMIDE","G4_DIMETHYL_SULFOXIDE","G4_ETHANE","G4_ETHYL_ALCOHOL","G4_ETHYL_CELLULOSE","G4_ETHYLENE",
  "G4_EYE_LENS_ICRP","G4_FERRIC_OXIDE","G4_FERROBORIDE","G4_FERROUS_OXIDE","G4_FERROUS_SULFATE","G4_FREON-12","G4_FREON-12B2","G4_FREON-13",
  "G4_FREON-13B1","G4_FREON-13I1","G4_GADOLINIUM_OXYSULFIDE","G4_GALLIUM_ARSENIDE","G4_GEL_PHOTO_EMULSION","G4_Pyrex_Glass","G4_GLASS_LEAD","G4_GLASS_PLATE","G4_GLUTAMINE",
  "G4_GLYCEROL","G4_GUANINE","G4_GYPSUM","G4_N-HEPTANE","G4_N-HEXANE","G4_KAPTON","G4_LANTHANUM_OXYBROMIDE","G4_LANTHANUM_OXYSULFIDE","G4_LEAD_OXIDE",
  "G4_LITHIUM_AMIDE","G4_LITHIUM_CARBONATE","G4_LITHIUM_FLUORIDE","G4_LITHIUM_HYDRIDE","G4_LITHIUM_IODIDE","G4_LITHIUM_OXIDE","G4_LITHIUM_TETRABORATE","G4_LUNG_ICRP","G4_M3_WAX",
  "G4_MAGNESIUM_CARBONATE","G4_MAGNESIUM_FLUORIDE","G4_MAGNESIUM_OXIDE","G4_MAGNESIUM_TETRABORATE","G4_MERCURIC_IODIDE","G4_METHANE",
  "G4_METHANOL","G4_MIX_D_WAX","G4_MS20_TISSUE","G4_MUSCLE_SKELETAL_ICRP",
  "G4_MUSCLE_STRIATED_ICRU","G4_MUSCLE_WITH_SUCROSE","G4_MUSCLE_WITHOUT_SUCROSE","G4_NAPHTHALENE","G4_NITROBENZENE",
  "G4_NITROUS_OXIDE","G4_NYLON-8062","G4_NYLON-6-6","G4_NYLON-6-10",
  "G4_NYLON-11_RILSAN","G4_OCTANE","G4_PARAFFIN","G4_N-PENTANE","G4_PHOTO_EMULSION",
  "G4_PLASTIC_SC_VINYLTOLUENE","G4_PLUTONIUM_DIOXIDE","G4_POLYACRYLONITRILE","G4_POLYCARBONATE",
  "G4_POLYCHLOROSTYRENE","G4_POLYETHYLENE","G4_MYLAR","G4_PLEXIGLASS","G4_POLYOXYMETHYLENE",
  "G4_POLYPROPYLENE","G4_POLYSTYRENE","G4_TEFLON","G4_POLYTRIFLUOROCHLOROETHYLENE","G4_POLYVINYL_ACETATE","G4_POLYVINYL_ALCOHOL",
  "G4_POLYVINYL_BUTYRAL","G4_POLYVINYL_CHLORIDE","G4_POLYVINYLIDENE_CHLORIDE",
  "G4_POLYVINYLIDENE_FLUORIDE","G4_POLYVINYL_PYRROLIDONE",
  "G4_POTASSIUM_IODIDE","G4_POTASSIUM_OXIDE","G4_PROPANE",
  "G4_lPROPANE","G4_N-PROPYL_ALCOHOL","G4_PYRIDINE","G4_RUBBER_BUTYL",
  "G4_RUBBER_NATURAL","G4_RUBBER_NEOPRENE","G4_SILICON_DIOXIDE","G4_SILVER_BROMIDE",
  "G4_SILVER_CHLORIDE","G4_SILVER_HALIDES","G4_SILVER_IODIDE","G4_SKIN_ICRP",
  "G4_SODIUM_CARBONATE","G4_SODIUM_IODIDE","G4_SODIUM_MONOXIDE",
  "G4_SODIUM_NITRATE","G4_STILBENE","G4_SUCROSE","G4_TERPHENYL","G4_TESTIS_ICRP",
  "G4_TETRACHLOROETHYLENE","G4_THALLIUM_CHLORIDE","G4_TISSUE_SOFT_ICRP",
  "G4_TISSUE_SOFT_ICRU-4","G4_TISSUE-METHANE","G4_TISSUE-PROPANE","G4_TITANIUM_DIOXIDE",
  "G4_TOLUENE","G4_TRICHLOROETHYLENE","G4_TRIETHYL_PHOSPHATE","G4_TUNGSTEN_HEXAFLUORIDE",
  "G4_URANIUM_DICARBIDE","G4_URANIUM_MONOCARBIDE","G4_URANIUM_OXIDE","G4_UREA",
  "G4_VALINE","G4_VITON","G4_WATER","G4_WATER_VAPOR","G4_XYLENE","G4_GRAPHITE"


  };
  
   String HEP_and_Nuclear_cmp[]={
   
   "G4_lH2","G4_lN2","G4_lO2","G4_lAr","G4_lBr","G4_lKr","G4_lXe","G4_PbWO4",
   "G4_Galactic","G4_GRAPHITE_POROUS","G4_LUCITE","G4_BRASS","G4_BRONZE",
   "G4_STAINLESS-STEEL","G4_CR39","G4_OCTADECANOL"
   
   };
   
String bio_chemical_cmp[]=
{
"G4_CYTOSINE",
"G4_THYMINE",
"G4_URACIL",
"G4_DNA_ADENINE",
"G4_DNA_GUANINE",
"G4_DNA_CYTOSINE",
"G4_DNA_THYMINE",
"G4_DNA_URACIL",
"G4_DNA_ADENOSINE",
"G4_DNA_GUANOSINE",
"G4_DNA_CYTIDINE",
"G4_DNA_URIDINE",
"G4_DNA_METHYLURIDINE",
"G4_DNA_MONOPHOSPHATE",
"G4_DNA_A",
"G4_DNA_G",
"G4_DNA_C",
"G4_DNA_U",
"G4_DNA_MU"
};
  
      
      
    
    final void reset_mat(){
        add_element.setVisible(false);
            i_2.setVisible(false);
            i_3.setVisible(false);
            i_4.setVisible(false);
            i_5.setVisible(false);
            i_6.setVisible(false);
            i_7.setVisible(false);
            elmen.setVisible(false);
            i_1.setVisible(false);
            mat_1.setVisible(false);
            mat_2.setVisible(false);
            mat_3.setVisible(false);
            mat_4.setVisible(false);
            mat_5.setVisible(false);
            mat_6.setVisible(false);
            mat_7.setVisible(false);
            mat_1.setText("");
            mat_2.setText("");
            mat_3.setText("");
            mat_4.setText("");
            mat_5.setText("");
            mat_6.setText("");
            mat_7.setText("");
            db_t.setVisible(false);
            db_t1.setVisible(false);
            elmen.setVisible(false);
            type.setVisible(false);
            
    }
    final void reset_solid(){
            add.setVisible(false);
            l_1.setVisible(false);
            l_2.setVisible(false);
            l_3.setVisible(false);
            l_4.setVisible(false);
            l_5.setVisible(false);
            l_6.setVisible(false);
            l_7.setVisible(false);
            l_8.setVisible(false);
            l_9.setVisible(false);
            target_1.setVisible(false);
            target_2.setVisible(false);
            target_3.setVisible(false);
            target_4.setVisible(false);
            target_5.setVisible(false);
            target_6.setVisible(false);
            target_7.setVisible(false);
            target_8.setVisible(false);
            target_9.setVisible(false);
            target_0.setText("");
            target_1.setText("");
            target_2.setText("");
            target_3.setText("");
            target_4.setText("");
            target_5.setText("");
            target_6.setText("");
            target_7.setText("");
            target_8.setText("");
            target_9.setText("");
    }
    public geomModeling() {
        initComponents();
            DefaultSyntaxKit.initKit();  
           setExtendedState(geomModeling.MAXIMIZED_BOTH);        

      buttonGroup1.add(jRadioButton_overlap_off);
      buttonGroup1.add(jRadioButton_overlap_on);
      vol_type.setSelectedIndex(0);
      buttonGroup2.add(vis_on);
buttonGroup2.add(vis_off);
reset_solid();
reset_mat();
 
 text_heighlighter();
 
    }
public void text_heighlighter() {

//
target.setContentType("text/bash");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        commands_tab = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        volume_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton_overlap_on = new javax.swing.JRadioButton();
        jRadioButton_overlap_off = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        _comment = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        db_e = new javax.swing.JComboBox<>();
        i_1 = new javax.swing.JLabel();
        mat_1 = new javax.swing.JTextField();
        i_2 = new javax.swing.JLabel();
        mat_2 = new javax.swing.JTextField();
        i_3 = new javax.swing.JLabel();
        mat_3 = new javax.swing.JTextField();
        i_4 = new javax.swing.JLabel();
        mat_4 = new javax.swing.JTextField();
        i_5 = new javax.swing.JLabel();
        mat_5 = new javax.swing.JTextField();
        i_6 = new javax.swing.JLabel();
        mat_6 = new javax.swing.JTextField();
        elmen = new javax.swing.JLabel();
        mat_7 = new javax.swing.JTextField();
        vis_clear6 = new javax.swing.JButton();
        vis_insert5 = new javax.swing.JButton();
        add_element = new javax.swing.JButton();
        i_7 = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        db_t = new javax.swing.JComboBox<>();
        db_t1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        parameter_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        parameter_value = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        rot_z = new javax.swing.JTextField();
        rot_y = new javax.swing.JTextField();
        rot_x = new javax.swing.JTextField();
        rot_name = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        vis_insert1 = new javax.swing.JButton();
        vis_clear1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        target_0 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        solid_type = new javax.swing.JComboBox<>();
        l_1 = new javax.swing.JLabel();
        target_1 = new javax.swing.JTextField();
        l_2 = new javax.swing.JLabel();
        target_2 = new javax.swing.JTextField();
        l_3 = new javax.swing.JLabel();
        target_3 = new javax.swing.JTextField();
        l_4 = new javax.swing.JLabel();
        target_4 = new javax.swing.JTextField();
        l_5 = new javax.swing.JLabel();
        target_5 = new javax.swing.JTextField();
        l_6 = new javax.swing.JLabel();
        target_6 = new javax.swing.JTextField();
        l_7 = new javax.swing.JLabel();
        target_7 = new javax.swing.JTextField();
        l_8 = new javax.swing.JLabel();
        target_8 = new javax.swing.JTextField();
        l_9 = new javax.swing.JLabel();
        target_9 = new javax.swing.JTextField();
        vis_insert4 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        vis_clear5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        vis_off = new javax.swing.JRadioButton();
        vis_on = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        volume_name_vis = new javax.swing.JTextField();
        vis_insert = new javax.swing.JButton();
        vis_clear = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        v_name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        red = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        COLOR_BTN = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        green = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        blue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        trans = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        v_name_lv = new javax.swing.JTextField();
        solid_name_lv = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        material_name_lv = new javax.swing.JTextField();
        vis_insert3 = new javax.swing.JButton();
        vis_clear3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        vol_type = new javax.swing.JComboBox<>();
        lbl_1 = new javax.swing.JLabel();
        arg_1 = new javax.swing.JTextField();
        lbl_2 = new javax.swing.JLabel();
        arg_2 = new javax.swing.JTextField();
        lbl_3 = new javax.swing.JLabel();
        arg_3 = new javax.swing.JTextField();
        lbl_4 = new javax.swing.JLabel();
        arg_4 = new javax.swing.JTextField();
        lbl_5 = new javax.swing.JLabel();
        arg_5 = new javax.swing.JTextField();
        arg_8 = new javax.swing.JTextField();
        lbl_8 = new javax.swing.JLabel();
        lbl_7 = new javax.swing.JLabel();
        arg_7 = new javax.swing.JTextField();
        arg_6 = new javax.swing.JTextField();
        lbl_6 = new javax.swing.JLabel();
        physical_volume_insert_btn = new javax.swing.JButton();
        physical_volumes_clear_btn = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        target = new javax.swing.JEditorPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem_open = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GeomModeling");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        commands_tab.setBackground(new java.awt.Color(255, 234, 103));
        commands_tab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        commands_tab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        commands_tab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        commands_tab.setToolTipText("");
        commands_tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        volume_name.setBackground(java.awt.SystemColor.menu);

        jLabel4.setText("Volume name");

        jButton5.setBackground(java.awt.Color.blue);
        jButton5.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton5.setForeground(java.awt.SystemColor.text);
        jButton5.setText("clear");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(java.awt.Color.blue);
        jButton6.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton6.setForeground(java.awt.SystemColor.text);
        jButton6.setText("Insert");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setText("check overlaps");

        jRadioButton_overlap_on.setText("ON");
        jRadioButton_overlap_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_overlap_onActionPerformed(evt);
            }
        });

        jRadioButton_overlap_off.setText("OFF");
        jRadioButton_overlap_off.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_overlap_offActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jRadioButton_overlap_on, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jRadioButton_overlap_off, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
            .addComponent(volume_name, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(volume_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jRadioButton_overlap_on)
                .addGap(0, 0, 0)
                .addComponent(jRadioButton_overlap_off)
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(0, 0, 0))
        );

        commands_tab.addTab("Check overlaps", jPanel9);

        _comment.setBackground(java.awt.SystemColor.menu);

        jLabel3.setText("Comment");

        jButton3.setBackground(java.awt.Color.blue);
        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton3.setForeground(java.awt.SystemColor.text);
        jButton3.setText("Insert");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(java.awt.Color.blue);
        jButton4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton4.setForeground(java.awt.SystemColor.text);
        jButton4.setText("clear");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_comment, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(_comment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(0, 0, 0))
        );

        commands_tab.addTab("Comment", jPanel10);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("The default units are:\n• length: mm\n• angle: degrees\n• density: g/cm3\n• atomic mass: g/mole\n");
        jScrollPane2.setViewportView(jTextArea1);

        commands_tab.addTab("Default units", jScrollPane2);

        db_e.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Isotope", "Element made of one unique isotope", "Element composed of several isotopes", "Material made of one element", "Material made of a mixture of elements or materials", "Geant4 internal database" }));
        db_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_eActionPerformed(evt);
            }
        });

        i_1.setText("Solid name");

        mat_1.setBackground(java.awt.SystemColor.menu);

        i_2.setText("Solid name");

        mat_2.setBackground(java.awt.SystemColor.menu);
        mat_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mat_2ActionPerformed(evt);
            }
        });

        i_3.setText("Solid name");

        mat_3.setBackground(java.awt.SystemColor.menu);

        i_4.setText("Solid name");

        mat_4.setBackground(java.awt.SystemColor.menu);

        i_5.setText("Solid name");

        mat_5.setBackground(java.awt.SystemColor.menu);

        i_6.setText("val 2");

        mat_6.setBackground(java.awt.SystemColor.menu);

        elmen.setText("element");

        mat_7.setBackground(java.awt.SystemColor.menu);
        mat_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mat_7ActionPerformed(evt);
            }
        });

        vis_clear6.setBackground(java.awt.Color.blue);
        vis_clear6.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_clear6.setForeground(java.awt.SystemColor.text);
        vis_clear6.setText("clear");
        vis_clear6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_clear6MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_clear6MouseEntered(evt);
            }
        });
        vis_clear6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_clear6ActionPerformed(evt);
            }
        });

        vis_insert5.setBackground(java.awt.Color.blue);
        vis_insert5.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_insert5.setForeground(java.awt.SystemColor.text);
        vis_insert5.setText("Insert");
        vis_insert5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_insert5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_insert5MouseEntered(evt);
            }
        });
        vis_insert5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_insert5ActionPerformed(evt);
            }
        });

        add_element.setText("add element");
        add_element.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_elementMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_elementMouseEntered(evt);
            }
        });
        add_element.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_elementActionPerformed(evt);
            }
        });

        i_7.setText("val4");

        type.setText("Type");

        db_t.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple Materials", "NIST Compounds", "HEP and Nuclear Materials", "Bio-Chemical Materials" }));
        db_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_tActionPerformed(evt);
            }
        });

        db_t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                db_t1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(i_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(i_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(i_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(i_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_4, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(i_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_5, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(i_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_6, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(elmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mat_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(i_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(db_t, javax.swing.GroupLayout.Alignment.TRAILING, 0, 313, Short.MAX_VALUE)
                    .addComponent(db_e, 0, 313, Short.MAX_VALUE)
                    .addComponent(db_t1, 0, 313, Short.MAX_VALUE)
                    .addComponent(add_element, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(vis_clear6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vis_insert5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(db_e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_1)
                .addGap(0, 0, 0)
                .addComponent(mat_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_2)
                .addGap(0, 0, 0)
                .addComponent(mat_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_3)
                .addGap(0, 0, 0)
                .addComponent(mat_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_4)
                .addGap(0, 0, 0)
                .addComponent(mat_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_5)
                .addGap(0, 0, 0)
                .addComponent(mat_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_6)
                .addGap(0, 0, 0)
                .addComponent(mat_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(i_7)
                .addGap(0, 0, 0)
                .addComponent(mat_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(add_element)
                .addGap(0, 0, 0)
                .addComponent(type)
                .addGap(0, 0, 0)
                .addComponent(db_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(elmen)
                .addGap(0, 0, 0)
                .addComponent(db_t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vis_insert5)
                    .addComponent(vis_clear6)))
        );

        commands_tab.addTab("Elements and materials", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Name");

        parameter_name.setBackground(java.awt.SystemColor.menu);

        jLabel2.setText("Value");

        parameter_value.setBackground(java.awt.SystemColor.menu);

        jButton1.setBackground(java.awt.Color.blue);
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton1.setForeground(java.awt.SystemColor.text);
        jButton1.setText("Insert");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.blue);
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton2.setForeground(java.awt.SystemColor.text);
        jButton2.setText("clear");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addComponent(parameter_value, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parameter_name)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(parameter_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(parameter_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 0, 0))
        );

        commands_tab.addTab("Parameters", jPanel1);

        rot_z.setBackground(java.awt.SystemColor.menu);

        rot_y.setBackground(java.awt.SystemColor.menu);

        rot_x.setBackground(java.awt.SystemColor.menu);

        rot_name.setBackground(java.awt.SystemColor.menu);

        jLabel13.setText("Name");

        jLabel14.setText("Angle of rotation around global X axis");

        jLabel15.setText("Angle of rotation around global Yaxis");

        jLabel16.setText("Angle of rotation around global Z axis");

        vis_insert1.setBackground(java.awt.Color.blue);
        vis_insert1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_insert1.setForeground(java.awt.SystemColor.text);
        vis_insert1.setText("Insert");
        vis_insert1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_insert1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_insert1MouseEntered(evt);
            }
        });
        vis_insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_insert1ActionPerformed(evt);
            }
        });

        vis_clear1.setBackground(java.awt.Color.blue);
        vis_clear1.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_clear1.setForeground(java.awt.SystemColor.text);
        vis_clear1.setText("clear");
        vis_clear1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_clear1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_clear1MouseEntered(evt);
            }
        });
        vis_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_clear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rot_y)
                    .addComponent(rot_z, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rot_x)
                    .addComponent(rot_name)
                    .addComponent(jLabel13)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(vis_clear1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vis_insert1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addGap(0, 0, 0)
                .addComponent(rot_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14)
                .addGap(0, 0, 0)
                .addComponent(rot_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel15)
                .addGap(0, 0, 0)
                .addComponent(rot_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16)
                .addGap(0, 0, 0)
                .addComponent(rot_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vis_insert1)
                    .addComponent(vis_clear1))
                .addGap(0, 0, 0))
        );

        commands_tab.addTab("Rotation matrix", jPanel6);

        jLabel21.setText("Solid name");

        target_0.setBackground(java.awt.SystemColor.menu);

        jLabel22.setText("Solid Type");

        solid_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "box", "tube", "tube section", "cone", "cone section", "sphere", "full solid sphere", "torus", "polycone", "elliptical tube", "elliptical cone", "Boolean solids" }));
        solid_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solid_typeActionPerformed(evt);
            }
        });

        l_1.setText("Solid name");

        target_1.setBackground(java.awt.SystemColor.menu);

        l_2.setText("Solid name");

        target_2.setBackground(java.awt.SystemColor.menu);
        target_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                target_2ActionPerformed(evt);
            }
        });

        l_3.setText("Solid name");

        target_3.setBackground(java.awt.SystemColor.menu);

        l_4.setText("Solid name");

        target_4.setBackground(java.awt.SystemColor.menu);

        l_5.setText("Solid name");

        target_5.setBackground(java.awt.SystemColor.menu);

        l_6.setText("Solid name");

        target_6.setBackground(java.awt.SystemColor.menu);

        l_7.setText("Solid name");

        target_7.setBackground(java.awt.SystemColor.menu);

        l_8.setText("Solid name");

        target_8.setBackground(java.awt.SystemColor.menu);

        l_9.setText("Solid name");

        target_9.setBackground(java.awt.SystemColor.menu);

        vis_insert4.setBackground(java.awt.Color.blue);
        vis_insert4.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_insert4.setForeground(java.awt.SystemColor.text);
        vis_insert4.setText("Insert");
        vis_insert4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_insert4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_insert4MouseEntered(evt);
            }
        });
        vis_insert4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_insert4ActionPerformed(evt);
            }
        });

        add.setBackground(java.awt.Color.blue);
        add.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        add.setForeground(java.awt.SystemColor.text);
        add.setText("add (r,z) values");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        vis_clear5.setBackground(java.awt.Color.blue);
        vis_clear5.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_clear5.setForeground(java.awt.SystemColor.text);
        vis_clear5.setText("clear");
        vis_clear5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_clear5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_clear5MouseEntered(evt);
            }
        });
        vis_clear5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_clear5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(target_9)
            .addComponent(target_8)
            .addComponent(target_7)
            .addComponent(target_6)
            .addComponent(target_5)
            .addComponent(target_4)
            .addComponent(target_3)
            .addComponent(target_2)
            .addComponent(target_1)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(vis_clear5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vis_insert4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(0, 0, 0)
                .addComponent(solid_type, 0, 1, Short.MAX_VALUE))
            .addComponent(l_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(l_3)
            .addComponent(l_4)
            .addComponent(l_5)
            .addComponent(l_6)
            .addComponent(l_7)
            .addComponent(l_9)
            .addComponent(l_8)
            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(l_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(target_0)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {l_3, l_4, l_5, l_6, l_7, l_8, l_9});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(solid_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addGap(0, 0, 0)
                .addComponent(target_0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_1)
                .addGap(0, 0, 0)
                .addComponent(target_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_2)
                .addGap(0, 0, 0)
                .addComponent(target_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_3)
                .addGap(0, 0, 0)
                .addComponent(target_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_4)
                .addGap(0, 0, 0)
                .addComponent(target_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_5)
                .addGap(0, 0, 0)
                .addComponent(target_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_6)
                .addGap(0, 0, 0)
                .addComponent(target_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_7)
                .addGap(0, 0, 0)
                .addComponent(target_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_8)
                .addGap(0, 0, 0)
                .addComponent(target_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(l_9)
                .addGap(0, 0, 0)
                .addComponent(target_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(add)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vis_insert4)
                    .addComponent(vis_clear5))
                .addGap(0, 0, 0))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {l_1, l_2, l_3});

        commands_tab.addTab("Solids volumes", jPanel3);

        vis_off.setText("OFF");

        vis_on.setText("ON");
        vis_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_onActionPerformed(evt);
            }
        });

        jLabel11.setText("Visibility");

        jLabel12.setText("Volume name");

        volume_name_vis.setBackground(java.awt.SystemColor.menu);

        vis_insert.setBackground(java.awt.Color.blue);
        vis_insert.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_insert.setForeground(java.awt.SystemColor.text);
        vis_insert.setText("Insert");
        vis_insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_insertMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_insertMouseEntered(evt);
            }
        });
        vis_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_insertActionPerformed(evt);
            }
        });

        vis_clear.setBackground(java.awt.Color.blue);
        vis_clear.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_clear.setForeground(java.awt.SystemColor.text);
        vis_clear.setText("clear");
        vis_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_clearMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_clearMouseEntered(evt);
            }
        });
        vis_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(vis_on, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(vis_off, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(vis_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vis_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(volume_name_vis)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addGap(0, 0, 0)
                .addComponent(volume_name_vis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addGap(0, 0, 0)
                .addComponent(vis_on)
                .addGap(0, 0, 0)
                .addComponent(vis_off)
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vis_insert)
                    .addComponent(vis_clear))
                .addGap(0, 0, 0))
        );

        commands_tab.addTab("Visibility", jPanel7);

        v_name.setBackground(java.awt.SystemColor.menu);

        jLabel6.setText("Volume name");

        jLabel7.setText("Red colour proportion");

        red.setBackground(java.awt.SystemColor.menu);

        jButton7.setBackground(java.awt.Color.blue);
        jButton7.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jButton7.setForeground(java.awt.SystemColor.text);
        jButton7.setText("clear");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        COLOR_BTN.setBackground(java.awt.Color.blue);
        COLOR_BTN.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        COLOR_BTN.setForeground(java.awt.SystemColor.text);
        COLOR_BTN.setText("Insert");
        COLOR_BTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                COLOR_BTNMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                COLOR_BTNMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                COLOR_BTNMouseEntered(evt);
            }
        });
        COLOR_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COLOR_BTNActionPerformed(evt);
            }
        });

        jLabel8.setText("Green colour proportion");

        green.setBackground(java.awt.SystemColor.menu);

        jLabel9.setText("Blue colour proportion");

        blue.setBackground(java.awt.SystemColor.menu);

        jLabel10.setText("Transparency");

        trans.setBackground(java.awt.SystemColor.menu);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(v_name)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(COLOR_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(trans)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blue)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(green)
                    .addComponent(red)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(v_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addComponent(red, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(green, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addGap(0, 0, 0)
                .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(trans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(COLOR_BTN)
                    .addComponent(jButton7))
                .addGap(0, 0, 0))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel6, jLabel7, jLabel8, jLabel9});

        commands_tab.addTab("Colour and transparency", jPanel8);

        jLabel18.setText("Volume name");

        v_name_lv.setBackground(java.awt.SystemColor.menu);

        solid_name_lv.setBackground(java.awt.SystemColor.menu);
        solid_name_lv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solid_name_lvActionPerformed(evt);
            }
        });

        jLabel19.setText("Solid name");

        jLabel20.setText("Material name");

        material_name_lv.setBackground(java.awt.SystemColor.menu);
        material_name_lv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                material_name_lvActionPerformed(evt);
            }
        });

        vis_insert3.setBackground(java.awt.Color.blue);
        vis_insert3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_insert3.setForeground(java.awt.SystemColor.text);
        vis_insert3.setText("Insert");
        vis_insert3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_insert3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_insert3MouseEntered(evt);
            }
        });
        vis_insert3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_insert3ActionPerformed(evt);
            }
        });

        vis_clear3.setBackground(java.awt.Color.blue);
        vis_clear3.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        vis_clear3.setForeground(java.awt.SystemColor.text);
        vis_clear3.setText("clear");
        vis_clear3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vis_clear3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vis_clear3MouseEntered(evt);
            }
        });
        vis_clear3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vis_clear3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(vis_clear3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vis_insert3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(material_name_lv)
                    .addComponent(solid_name_lv)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(v_name_lv)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel18)
                .addGap(0, 0, 0)
                .addComponent(v_name_lv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(solid_name_lv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(material_name_lv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vis_insert3)
                    .addComponent(vis_clear3))
                .addGap(0, 0, 0))
        );

        commands_tab.addTab("Logical volumes", jPanel4);

        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel17.setText("Type");

        vol_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single placement", "Parameterisation", "Replica" }));
        vol_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vol_typeActionPerformed(evt);
            }
        });

        lbl_1.setText("Volume name");

        arg_1.setBackground(java.awt.SystemColor.menu);

        lbl_2.setText("Copy number");

        arg_2.setBackground(java.awt.SystemColor.menu);

        lbl_3.setText("Parent volume name");

        arg_3.setBackground(java.awt.SystemColor.menu);
        arg_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg_3ActionPerformed(evt);
            }
        });

        lbl_4.setText("Parameterisation type");

        arg_4.setBackground(java.awt.SystemColor.menu);
        arg_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arg_4ActionPerformed(evt);
            }
        });

        lbl_5.setText("Name of rotation matrix");

        arg_5.setBackground(java.awt.SystemColor.menu);

        arg_8.setBackground(java.awt.SystemColor.menu);

        lbl_8.setText("Offset");

        lbl_7.setText("Step");

        arg_7.setBackground(java.awt.SystemColor.menu);

        arg_6.setBackground(java.awt.SystemColor.menu);

        lbl_6.setText("Number of copies");

        physical_volume_insert_btn.setBackground(java.awt.Color.blue);
        physical_volume_insert_btn.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        physical_volume_insert_btn.setForeground(java.awt.SystemColor.text);
        physical_volume_insert_btn.setText("Insert");
        physical_volume_insert_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                physical_volume_insert_btnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                physical_volume_insert_btnMouseEntered(evt);
            }
        });
        physical_volume_insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physical_volume_insert_btnActionPerformed(evt);
            }
        });

        physical_volumes_clear_btn.setBackground(java.awt.Color.blue);
        physical_volumes_clear_btn.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        physical_volumes_clear_btn.setForeground(java.awt.SystemColor.text);
        physical_volumes_clear_btn.setText("clear");
        physical_volumes_clear_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                physical_volumes_clear_btnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                physical_volumes_clear_btnMouseEntered(evt);
            }
        });
        physical_volumes_clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physical_volumes_clear_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(arg_4)
            .addComponent(arg_5)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lbl_1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(physical_volumes_clear_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(physical_volume_insert_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(arg_8)
            .addComponent(arg_7)
            .addComponent(lbl_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(arg_6)
            .addComponent(lbl_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(arg_2)
            .addComponent(arg_3)
            .addComponent(lbl_2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(arg_1)
            .addComponent(vol_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addGap(0, 0, 0)
                .addComponent(vol_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_1)
                .addGap(0, 0, 0)
                .addComponent(arg_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_2)
                .addGap(0, 0, 0)
                .addComponent(arg_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_3)
                .addGap(0, 0, 0)
                .addComponent(arg_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_4)
                .addGap(0, 0, 0)
                .addComponent(arg_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_5)
                .addGap(0, 0, 0)
                .addComponent(arg_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_6)
                .addGap(0, 0, 0)
                .addComponent(arg_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_7)
                .addGap(0, 0, 0)
                .addComponent(arg_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_8)
                .addGap(0, 0, 0)
                .addComponent(arg_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(physical_volume_insert_btn)
                    .addComponent(physical_volumes_clear_btn))
                .addGap(0, 0, 0))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_3, lbl_4, lbl_5, lbl_6, lbl_7, lbl_8});

        commands_tab.addTab("Physical volumes", jPanel5);

        target.setBackground(java.awt.SystemColor.menu);
        target.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                targetAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane4.setViewportView(target);

        jTabbedPane2.addTab("Geant4 Geometry From Text Editor", jScrollPane4);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem_open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_open.setText("Open");
        jMenuItem_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_openActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_open);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("exit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commands_tab, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commands_tab)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       this.show(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        target.replaceSelection("//"+_comment.getText()+"\n");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String _Command="";
        String check_status="";
        if ( jRadioButton_overlap_on.isSelected()==true) {check_status="ON";}
        if ( jRadioButton_overlap_off.isSelected()==true) {check_status="OFF";}
        _Command="CHECK_OVERLAPS "+volume_name.getText()+" "+ check_status+"\n";
        target.replaceSelection(_Command);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        volume_name.setText("");
            commands_tab.setBackground( Color.BLUE);
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        v_name.setText("");
        red.setText("");
        green.setText("");
        blue.setText("");
        trans.setText("");

    }//GEN-LAST:event_jButton7ActionPerformed

    private void vis_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vis_clearActionPerformed

    private void vis_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_insertActionPerformed

        String _Command="";
        String check_status="";
        if ( vis_on.isSelected()==true) {check_status="ON";}
        if ( vis_off.isSelected()==true) {check_status="OFF";}
        _Command=":VIS "+volume_name_vis.getText()+" "+ check_status+"\n";
        target.replaceSelection(_Command);
    }//GEN-LAST:event_vis_insertActionPerformed

    private void vis_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_clear1ActionPerformed
        rot_x.setText("");
        rot_y.setText("");
        rot_z.setText("");
        rot_name.setText("");
    }//GEN-LAST:event_vis_clear1ActionPerformed

    private void vis_insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_insert1ActionPerformed
        String _Command=":ROTM "+rot_name.getText()+" "+ rot_x.getText()+" "+ rot_y.getText()+" "+ rot_z.getText()+"\n";
        target.replaceSelection(_Command);
    }//GEN-LAST:event_vis_insert1ActionPerformed

    private void physical_volumes_clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physical_volumes_clear_btnActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_physical_volumes_clear_btnActionPerformed

    private void physical_volume_insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physical_volume_insert_btnActionPerformed
        // TODO add your handling code here:
        if (vol_type.getSelectedItem().toString().equals("Single placement")) {
            String _command=":PLACE "+ arg_1.getText()+" "+ arg_2.getText()+" "+arg_3.getText()+" "+arg_4.getText()+" "+  arg_5.getText()+" "+ arg_6.getText()+" "+arg_7.getText()+" "+ arg_8.getText()+"\n";
            target.replaceSelection(_command);
        };
        if (vol_type.getSelectedItem().toString().equals("Parameterisation")) {
            String _command=":PLACE_PARAM "+ arg_1.getText()+" "+ arg_2.getText()+" "+arg_3.getText()+" "+arg_4.getText()+" "+  arg_5.getText()+" "+ arg_6.getText()+" "+arg_7.getText()+" "+ arg_8.getText()+"\n";
            target.replaceSelection(_command);
        };
        if (vol_type.getSelectedItem().toString().equals("Replica")) {
            String _command=":REPL "+ arg_1.getText()+" "+ arg_2.getText()+" "+arg_3.getText()+" "+arg_4.getText()+" "+  arg_5.getText()+" "+ arg_6.getText()+" "+arg_7.getText()+" "+ arg_8.getText()+"\n";
            target.replaceSelection(_command);
        };
    }//GEN-LAST:event_physical_volume_insert_btnActionPerformed

    private void vol_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vol_typeActionPerformed
        // TODO add your handling code here:
        if (vol_type.getSelectedItem().toString().equals("Single placement")) {
            lbl_4.setText("Name of Rotation Matrix");
            lbl_5.setText("X position");
            lbl_5.setVisible(true);
            lbl_6.setText("Y position");
            lbl_6.setVisible(true);
            lbl_7.setText("Z position");
            lbl_7.setVisible(true);
            arg_7.setVisible(true);
            lbl_8.setVisible(false);
            arg_8.setVisible(false);
        };
        if (vol_type.getSelectedItem().toString().equals("Parameterisation")) {
            lbl_4.setText("Parameterisation type");
            lbl_5.setText("Name of rotation matrix");
            lbl_6.setText("Number of copies");
            lbl_7.setText("Step");
            lbl_8.setVisible(true);
            arg_8.setVisible(true);
        };
        if (vol_type.getSelectedItem().toString().equals("Replica")) {
            lbl_3.setText("Axis of division");
            lbl_5.setText("Number of division");
            lbl_6.setText("Division width");
            lbl_7.setVisible(false);
            arg_7.setVisible(false);
            lbl_8.setVisible(false);
            lbl_8.setVisible(false);
            arg_8.setVisible(false);
        };
    }//GEN-LAST:event_vol_typeActionPerformed

    private void vis_clear3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_clear3ActionPerformed
        v_name_lv.setText("");
        solid_name_lv.setText("");
        material_name_lv.setText("");
    }//GEN-LAST:event_vis_clear3ActionPerformed

    private void vis_insert3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_insert3ActionPerformed
        // TODO add your handling code here:
        String _command=":VOLU "+ v_name_lv.getText()+" "+ solid_name_lv.getText()+" "+material_name_lv.getText()+"\n";
        target.replaceSelection(_command);

    }//GEN-LAST:event_vis_insert3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        parameter_name.setText("");
        parameter_value.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        target.replaceSelection(":P "+parameter_name.getText()+" "+parameter_value.getText()+"\n");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
  JFileChooser fc = new JFileChooser(); 
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setDialogTitle("Save Geant4 Geometry From  file ");
        //fc.setFileSelectionMode( JFileChooser.);
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
       
                    FileWriter lu = null;
            try {
                lu = new FileWriter(file.toString( ));
            } catch (IOException ex) {
                Logger.getLogger(g4linac_mt_gui.class.getName()).log(Level.SEVERE, null, ex);
            }
    try (BufferedWriter fluxS = new BufferedWriter(lu) 
    ) {
        fluxS.write(target.getText()); 

        fluxS.close(); 
    }       catch (IOException ex) { 
                Logger.getLogger(g4linac_mt_gui.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }     }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void solid_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solid_typeActionPerformed
  
         if (solid_type.getSelectedItem().toString().equals("box")) {
             reset_solid();
            l_1.setText("X Half-length");
            l_2.setText("Y Half-length");
            l_3.setText("Z Half-length");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            target_1.setVisible(true);
            target_2.setVisible(true);
            target_3.setVisible(true);
        }    
    if (solid_type.getSelectedItem().toString().equals("tube")) {
        reset_solid();
            l_1.setText("Inner radius");
            l_2.setText("Outer radius");
            l_3.setText("Half length in z");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
               target_1.setVisible(true);
              target_2.setVisible(true);
            target_3.setVisible(true);
            
        };    
        
        if (solid_type.getSelectedItem().toString().equals("tube section")) {
                    reset_solid();

            l_1.setText("Inner radius");
            l_2.setText("Outer radius");
            l_3.setText("Half length in z");
            l_4.setText("Starting phi angle");
            l_5.setText("Delta angle of the segment");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            l_5.setVisible(true);
              target_1.setVisible(true);
              target_2.setVisible(true);
            target_3.setVisible(true);
           target_4.setVisible(true);
           target_5.setVisible(true);
           
        };     
        if (solid_type.getSelectedItem().toString().equals("cone")) {
                    reset_solid();

            l_1.setText("Inner radius at -fDz");
            l_2.setText("Inner radius at +fDz");
            l_3.setText("Outer radius at -fDz");
            l_4.setText("Outer radius at +fDz");
            l_5.setText("Half length in z (=fDz)");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            l_5.setVisible(true);
           target_1.setVisible(true);
           target_2.setVisible(true);
           target_3.setVisible(true);
           target_4.setVisible(true);
           target_5.setVisible(true);
           target_6.setVisible(false);
           target_7.setVisible(false);
           target_8.setVisible(false);
           target_9.setVisible(false);
        };        
        
        if (solid_type.getSelectedItem().toString().equals("cone section")) {
                    l_1.setText("Inner radius at -fDz");
            l_2.setText("Inner radius at +fDz");
            l_3.setText("Outer radius at -fDz");
            l_4.setText("Outer radius at +fDz");
            l_5.setText("Half length in z (=fDz)");
            l_6.setText("Starting angle of the segment");
            l_7.setText("Delta angle of the segment");


            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            l_5.setVisible(true);
            l_6.setVisible(true);
            l_7.setVisible(true);
            l_8.setVisible(false);
            l_9.setVisible(false);
           target_1.setVisible(true);
           target_2.setVisible(true);
           target_3.setVisible(true);
           target_4.setVisible(true);
           target_5.setVisible(true);
           target_6.setVisible(true);
           target_7.setVisible(true);
           target_8.setVisible(false);
           target_9.setVisible(false);
            };  
            if (solid_type.getSelectedItem().toString().equals("sphere")) {
            l_1.setText("Inner radius ");
            l_2.setText("Outer radius ");
            l_3.setText("Starting angle of the segment");
            l_4.setText("Delta angle of the segment");
            l_5.setText("Theta starting angle of the segment");
            l_6.setText("Theta delta angle of the segment");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            l_5.setVisible(true);
            l_6.setVisible(true);
            l_7.setVisible(false);
            l_8.setVisible(false);
            l_9.setVisible(false);
             target_1.setVisible(true);
           target_2.setVisible(true);
           target_3.setVisible(true);
           target_4.setVisible(true);
           target_5.setVisible(true);
           target_6.setVisible(true);
           target_7.setVisible(false);
           target_8.setVisible(false);
           target_9.setVisible(false);
        };        
      if (solid_type.getSelectedItem().toString().equals("full solid sphere")) {
            l_1.setText("Outer radius ");
            l_1.setVisible(true);
            l_2.setVisible(false);
            l_3.setVisible(false);
            l_4.setVisible(false);
            l_5.setVisible(false);
            l_6.setVisible(false);
            l_7.setVisible(false);
            l_8.setVisible(false);
            l_9.setVisible(false);
           target_1.setVisible(true);
           target_2.setVisible(false);
           target_3.setVisible(false);
           target_4.setVisible(false);
           target_5.setVisible(false);
           target_6.setVisible(false);
           target_7.setVisible(false);
           target_8.setVisible(false);
           target_9.setVisible(false);
        }; 
        if (solid_type.getSelectedItem().toString().equals("torus")) {
            l_1.setText("Inside radius ");
            l_2.setText("Outside radius ");
            l_3.setText("Swept radius of torus ");
            l_4.setText("Starting Phi angle  ");
            l_5.setText("Delta angle of the segment  ");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            l_5.setVisible(true);
            l_6.setVisible(false);
            l_7.setVisible(false);
            l_8.setVisible(false);
            l_9.setVisible(false);
           target_1.setVisible(true);
           target_2.setVisible(true);
           target_3.setVisible(true);
           target_4.setVisible(true);
           target_5.setVisible(true);
           target_6.setVisible(false);
           target_7.setVisible(false);
           target_8.setVisible(false);
           target_9.setVisible(false);
        };    
        if (solid_type.getSelectedItem().toString().equals("polycone")) {
           add.setVisible(true);
           l_1.setText("Initial phi starting angle ");
           l_2.setText("Total phi angle ");
           l_3.setText("Number of z planes or Number of rz points");
           l_4.setText("r value ");
           l_5.setText("z value ");

           l_1.setVisible(true);
           l_2.setVisible(true);
           l_3.setVisible(true);
           l_4.setVisible(true);
           l_5.setVisible(true);
           l_6.setVisible(false);
           l_7.setVisible(false);
           l_8.setVisible(false);
           l_9.setVisible(false);
           target_1.setVisible(true);
           target_2.setVisible(true);
           target_3.setVisible(true);
           target_4.setVisible(true);
           target_5.setVisible(true);
           target_6.setVisible(false);
           target_7.setVisible(false);
           target_8.setVisible(false);
           target_9.setVisible(false);
        };    
        
        if (solid_type.getSelectedItem().toString().equals("elliptical tube")) {
             reset_solid();
            l_1.setText("X Half-length");
            l_2.setText("Y Half-length");
            l_3.setText("Z Half-length");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            target_1.setVisible(true);
            target_2.setVisible(true);
            target_3.setVisible(true);        }; 
        
       if (solid_type.getSelectedItem().toString().equals("elliptical cone")) {
            reset_solid(); 
            l_1.setText("Semiaxis in X");
            l_2.setText("Semiaxis in Y");
            l_3.setText("Height of elliptical cone");
            l_4.setText("Upper cut plane level");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            target_1.setVisible(true);
            target_2.setVisible(true);
            target_3.setVisible(true);
            target_4.setVisible(true);
        }
      
        if (solid_type.getSelectedItem().toString().equals("Boolean solids")) {
            reset_solid(); 
            l_1.setText("operation (UNION/SUBTRACTION/INTERSECTION)");
            l_2.setText("First component solid name");
            l_3.setText("Second component solid name");
            l_4.setText("Name of relative rotation matrix");
            l_5.setText("Relative X position");
            l_6.setText("Relative Y position");
            l_7.setText("Relative Z position");
            l_1.setVisible(true);
            l_2.setVisible(true);
            l_3.setVisible(true);
            l_4.setVisible(true);
            l_5.setVisible(true);
            l_6.setVisible(true);
            l_7.setVisible(true);
            target_1.setVisible(true);
            target_2.setVisible(true);
            target_3.setVisible(true);
            target_4.setVisible(true);
            target_4.setVisible(true);
            target_5.setVisible(true);
            target_6.setVisible(true);
            target_7.setVisible(true);
        }
    }//GEN-LAST:event_solid_typeActionPerformed

    private void vis_insert4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_insert4ActionPerformed
        if (solid_type.getSelectedItem().toString().equals("box")) {
         String _command=":SOLID "+target_0.getText()+" BOX "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+"\n";
         
         target.replaceSelection(_command);
        }    
        
         if (solid_type.getSelectedItem().toString().equals("tube")) {
         String _command=":SOLID "+target_0.getText()+" TUBE "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+"\n";
         
         target.replaceSelection(_command);
        }    
         
         
      if (solid_type.getSelectedItem().toString().equals("tube section")) {
         String _command=":SOLID "+target_0.getText()+" TUBS "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+" "+ target_4.getText()+ " "+target_5.getText()+"\n";
         
         target.replaceSelection(_command);
        }  
      
       if (solid_type.getSelectedItem().toString().equals("cone")) {
         String _command=":SOLID "+target_0.getText()+" CONE "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+" "+ target_4.getText()+ " "+target_5.getText()+"\n";
         
         target.replaceSelection(_command);
        }  
       
       if (solid_type.getSelectedItem().toString().equals("cone section")) {
         String _command=":SOLID "+target_0.getText()+" CONS "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+" "+ target_4.getText()+ " "+target_5.getText()+" "+ target_6.getText()+ " "+target_7.getText()+"\n";
         target.replaceSelection(_command);
        }  
        
      if (solid_type.getSelectedItem().toString().equals("sphere")) {
         String _command=":SOLID "+target_0.getText()+" SPHERE "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+" "+ target_4.getText()+ " "+target_5.getText()+" "+ target_6.getText()+ " "+"\n";
         target.replaceSelection(_command);
        }   
      
      
         
      if (solid_type.getSelectedItem().toString().equals("full solid sphere")) {
         String _command=":SOLID "+target_0.getText()+" ORB "   +target_1.getText()+"\n";
         target.replaceSelection(_command);
        }    
      
      if (solid_type.getSelectedItem().toString().equals("Boolean solids")) {
         String _command=":SOLID "+target_0.getText() +" " +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+" "+ target_4.getText()+ " "+target_5.getText()+" "+ target_6.getText()+ " "+ target_7.getText()+"\n";
         target.replaceSelection(_command);
        }    
 if (solid_type.getSelectedItem().toString().equals("polycone")) {
         String _command=":SOLID "+target_0.getText()+" POLYCONE "   +target_1.getText()+" "+ target_2.getText()+ " "+target_3.getText()+"\n"+r_z;
      
         target.replaceSelection(_command);
        } 
    }//GEN-LAST:event_vis_insert4ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        
      r_z= r_z+ "\n"+ target_4.getText()+" "+target_5.getText();
      target_4.setText("");
      target_5.setText("");
      
    }//GEN-LAST:event_addActionPerformed

    private void target_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_target_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_target_2ActionPerformed

    private void vis_clear5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_clear5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vis_clear5ActionPerformed

    private void db_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_eActionPerformed
        
        
        if (db_e.getSelectedItem().toString().equals("Geant4 internal database")) {
             reset_mat();
             
              db_t.setVisible(           true
);
            db_t1.setVisible(           true
);
            elmen.setVisible(           true
);
            type.setVisible(           true
);
             
        }    
        if (db_e.getSelectedItem().toString().equals("Element made of one unique isotope")) {
             reset_mat();
            i_1.setText("Name");
            i_2.setText("Symbol");
            i_3.setText("Z");
            i_4.setText("A");
            i_1.setVisible(true);
            i_2.setVisible(true);
            i_3.setVisible(true);
            i_4.setVisible(true);
            mat_1.setVisible(true);
            mat_2.setVisible(true);
            mat_3.setVisible(true);        
            mat_4.setVisible(true);
        }    
         if (db_e.getSelectedItem().toString().equals("Isotope")) {
             reset_mat();
            i_1.setText("Name");
            i_2.setText("Z");
            i_3.setText("N");
            i_4.setText("A");
            i_1.setVisible(true);
            i_2.setVisible(true);
            i_3.setVisible(true);
            i_4.setVisible(true);
            mat_1.setVisible(true);
            mat_2.setVisible(true);
            mat_3.setVisible(true);        
            mat_4.setVisible(true);
        }    
         
         if (db_e.getSelectedItem().toString().equals("Element composed of several isotopes")) {
             reset_mat();
            i_1.setText("Name");
            i_2.setText("Symbol");
            i_3.setText("Number of components");
            i_4.setText("isotope name");
            i_5.setText("fraction of number of atoms per volume");
            i_1.setVisible(true);
            i_2.setVisible(true);
            i_3.setVisible(true);
            i_4.setVisible(true);
            i_5.setVisible(true);
            mat_1.setVisible(true);
            mat_2.setVisible(true);
            mat_3.setVisible(true);        
            mat_4.setVisible(true);
            mat_5.setVisible(true);
            add_element.setVisible(true);
        }  
         if (db_e.getSelectedItem().toString().equals("Material made of one element")) {
             reset_mat();
            i_1.setText("Name");
            i_2.setText("Z");
            i_3.setText("A");
            i_4.setText("Density");
            i_1.setVisible(true);
            i_2.setVisible(true);
            i_3.setVisible(true);
            i_4.setVisible(true);
            mat_1.setVisible(true);
            mat_2.setVisible(true);
            mat_3.setVisible(true);        
            mat_4.setVisible(true);
            add_element.setVisible(false);
        }   
      if (db_e.getSelectedItem().toString().equals("Material made of a mixture of elements or materials")) {
             reset_mat();
            i_1.setText("Name");
            i_2.setText("Density");
            i_3.setText("Number of components");
            i_4.setText("material name");
            i_5.setText("proportion of material in the mixture");

            i_1.setVisible(true);
            i_2.setVisible(true);
            i_3.setVisible(true);
            i_4.setVisible(true);
            i_5.setVisible(true);

            mat_1.setVisible(true);
            mat_2.setVisible(true);
            mat_3.setVisible(true);        
            mat_4.setVisible(true);
            mat_5.setVisible(true);

            add_element.setVisible(true);
        }      
    }//GEN-LAST:event_db_eActionPerformed

    private void mat_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mat_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mat_2ActionPerformed

    private void vis_clear6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_clear6ActionPerformed
        // TODO add your handling code here:
            mat_1.setText("");
            mat_2.setText("");
            mat_3.setText("");        
            mat_4.setText("");
            mat_5.setText("");
    }//GEN-LAST:event_vis_clear6ActionPerformed

    private void vis_insert5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_insert5ActionPerformed

        switch (db_e.getSelectedItem().toString()) {
            case "Isotope":
                {
                    String _command=":ISOT "  +mat_1.getText()+" "+ mat_2.getText()+ " "+mat_3.getText()+" "+mat_4.getText()+"\n";
                    target.replaceSelection(_command);
                    break;
                }
            case "Element made of one unique isotope":
                {
                    String _command=":ELEM "  +mat_1.getText()+" "+ mat_2.getText()+ " "+mat_3.getText()+" "+mat_4.getText()+"\n";
                    target.replaceSelection(_command);
                    break;
                }
            case "Element composed of several isotopes":
                {
                    String _command=":ELEM_FROM_ISOT "  +mat_1.getText()+" "+ mat_2.getText()+ " "+mat_3.getText()+" "+isotopename_fraction+"\n";
                    target.replaceSelection(_command);
                    break;
                }
            case "Material made of one element":
                {
                    String _command=":MATE "  +mat_1.getText()+" "+ mat_2.getText()+ " "+mat_3.getText()+" "+mat_4.getText()+"\n";
                    target.replaceSelection(_command);
                    break;
                }
            case "Material made of a mixture of elements or materials":
                {
                    String _command=":MIXT "  +mat_1.getText()+" "+ mat_2.getText()+ " "+mat_3.getText()+" "+material_name_proportion_of_material_in_the_mixture+"\n";
                    target.replaceSelection(_command);
                    break;
                }
            case "Geant4 internal database":
                {
                    String _command=":MAT "+ db_t1.getSelectedItem().toString();
                    target.replaceSelection(_command+"\n");
                    break;
                } 
            default:
                break;
        }
    }//GEN-LAST:event_vis_insert5ActionPerformed

    private void add_elementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_elementActionPerformed
 isotopename_fraction= isotopename_fraction+ "\n"+ mat_4.getText()+" "+mat_5.getText();
     mat_4.setText("");
      mat_5.setText("");    }//GEN-LAST:event_add_elementActionPerformed

    private void jRadioButton_overlap_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_overlap_onActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_overlap_onActionPerformed

    private void mat_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mat_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mat_7ActionPerformed

    private void db_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_tActionPerformed
 db_t1.removeAllItems();
 
        switch (db_t.getSelectedItem().toString()) {
            case "Simple Materials":
                for (String simple_mat1 : simple_mat) {
                    db_t1.addItem(simple_mat1);
                }
                break;
            case "NIST Compounds":
                for (String nist_cmp1 : nist_cmp) {
                    db_t1.addItem(nist_cmp1);
                }
                break;
            case "HEP and Nuclear Materials":
                for (String HEP_and_Nuclear_cmp1 : HEP_and_Nuclear_cmp) {
                    db_t1.addItem(HEP_and_Nuclear_cmp1);
                }
                break;
            case "Bio-Chemical Materials":
                for (String bio_chemical_cmp1 : bio_chemical_cmp) {
                    db_t1.addItem(bio_chemical_cmp1);
                }
                break;
            default:
                break;
        }
                
    }//GEN-LAST:event_db_tActionPerformed

    private void db_t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_db_t1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_db_t1ActionPerformed

    private void jRadioButton_overlap_offActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_overlap_offActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_overlap_offActionPerformed

    private void solid_name_lvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solid_name_lvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_solid_name_lvActionPerformed

    private void arg_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arg_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arg_4ActionPerformed

    private void arg_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arg_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arg_3ActionPerformed

    private void vis_onActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vis_onActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vis_onActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void targetAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_targetAncestorAdded

    }//GEN-LAST:event_targetAncestorAdded

    private void material_name_lvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_material_name_lvActionPerformed
       
    }//GEN-LAST:event_material_name_lvActionPerformed

    private void jMenuItem_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_openActionPerformed
     JFileChooser fc = new JFileChooser(); 
    fc.setDialogTitle("Open an existing Geant4 Geometry from Text file");
    fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
    fc.setCurrentDirectory(new File (myg4linac_singelton.Get_G4linac_installation_directory() + "/G4Linac_Head"));
    int returnVal = fc.showOpenDialog(this);
    if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
    java.io.File file = fc.getSelectedFile( );
    
    
String Target_content="";
try    {  
File fileDir = new File(file.toString( ));
try (BufferedReader in = new BufferedReader(
new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
String str;
while ((str = in.readLine()) != null) {
Target_content=Target_content+str+"\n";
}
}  
    target.setText( Target_content);     


} catch (Exception  ex) {System.out.print(ex);}     
    JOptionPane.showMessageDialog(this, "The file entitled '"+file.getName()+"' has been successfully saved ! ");
    
    }        
    }//GEN-LAST:event_jMenuItem_openActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
                       jButton5.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
                       jButton5.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
                       jButton6.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
                           jButton6.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);

    }//GEN-LAST:event_jButton6MouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
                       jButton4.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
                       jButton4.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
                       jButton3.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
                       jButton3.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_jButton3MouseExited

    private void add_elementMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_elementMouseEntered
                       add_element.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_add_elementMouseEntered

    private void add_elementMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_elementMouseExited
                       add_element.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_add_elementMouseExited

    private void vis_clear6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear6MouseEntered
                       vis_clear6.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_clear6MouseEntered

    private void vis_clear6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear6MouseExited
                       vis_clear6.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_clear6MouseExited

    private void vis_insert5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert5MouseEntered
                       vis_insert5.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_insert5MouseEntered

    private void vis_insert5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert5MouseExited
                       vis_insert5.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_insert5MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
                       jButton2.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
                       jButton2.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
                      jButton1.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
                      jButton1.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_jButton1MouseExited

    private void vis_clear1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear1MouseEntered
                       vis_clear1.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_clear1MouseEntered

    private void vis_clear1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear1MouseExited
                       vis_clear1.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_clear1MouseExited

    private void vis_insert1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert1MouseEntered
                       vis_insert1.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_insert1MouseEntered

    private void vis_insert1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert1MouseExited
                       vis_insert1.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_insert1MouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
                      add.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
                        add.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_addMouseExited

    private void vis_clear5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear5MouseEntered
                      vis_clear5.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_clear5MouseEntered

    private void vis_clear5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear5MouseExited
                       vis_clear5.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_clear5MouseExited

    private void vis_insert4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert4MouseEntered
                       vis_insert4.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_insert4MouseEntered

    private void vis_insert4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert4MouseExited
                       vis_insert4.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_insert4MouseExited

    private void vis_clearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clearMouseEntered
                      vis_clear.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_clearMouseEntered

    private void vis_clearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clearMouseExited
                       vis_clear.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_clearMouseExited

    private void vis_insertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insertMouseEntered
                       vis_insert.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_insertMouseEntered

    private void vis_insertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insertMouseExited
                     vis_insert.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_insertMouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
                   jButton7.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
                       jButton7.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_jButton7MouseExited

    private void COLOR_BTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COLOR_BTNMouseEntered
                      COLOR_BTN.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_COLOR_BTNMouseEntered

    private void COLOR_BTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COLOR_BTNMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_COLOR_BTNMouseClicked

    private void COLOR_BTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_COLOR_BTNMouseExited
                       COLOR_BTN.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_COLOR_BTNMouseExited

    private void vis_clear3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear3MouseEntered
                      vis_clear3.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_clear3MouseEntered

    private void vis_clear3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_clear3MouseExited
                       vis_clear3.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_clear3MouseExited

    private void vis_insert3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert3MouseEntered
                       vis_insert3.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_vis_insert3MouseEntered

    private void vis_insert3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vis_insert3MouseExited
                       vis_insert3.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_vis_insert3MouseExited

    private void physical_volumes_clear_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_physical_volumes_clear_btnMouseEntered
                       physical_volumes_clear_btn.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_physical_volumes_clear_btnMouseEntered

    private void physical_volumes_clear_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_physical_volumes_clear_btnMouseExited
                      physical_volumes_clear_btn.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_physical_volumes_clear_btnMouseExited

    private void physical_volume_insert_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_physical_volume_insert_btnMouseEntered
                       physical_volume_insert_btn.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
    }//GEN-LAST:event_physical_volume_insert_btnMouseEntered

    private void physical_volume_insert_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_physical_volume_insert_btnMouseExited
                       physical_volume_insert_btn.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
    }//GEN-LAST:event_physical_volume_insert_btnMouseExited

    private void COLOR_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COLOR_BTNActionPerformed

        String _Command="";
       
        _Command=":COLOR "+v_name.getText()+" "+ red.getText()+" "+green.getText()+" "+blue.getText()+"\n";
        target.replaceSelection(_Command);
    }//GEN-LAST:event_COLOR_BTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(geomModeling.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new geomModeling().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton COLOR_BTN;
    private javax.swing.JTextField _comment;
    private javax.swing.JButton add;
    private javax.swing.JButton add_element;
    private javax.swing.JTextField arg_1;
    private javax.swing.JTextField arg_2;
    private javax.swing.JTextField arg_3;
    private javax.swing.JTextField arg_4;
    private javax.swing.JTextField arg_5;
    private javax.swing.JTextField arg_6;
    private javax.swing.JTextField arg_7;
    private javax.swing.JTextField arg_8;
    private javax.swing.JTextField blue;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTabbedPane commands_tab;
    private javax.swing.JComboBox<String> db_e;
    private javax.swing.JComboBox<String> db_t;
    private javax.swing.JComboBox<String> db_t1;
    private javax.swing.JLabel elmen;
    private javax.swing.JTextField green;
    private javax.swing.JLabel i_1;
    private javax.swing.JLabel i_2;
    private javax.swing.JLabel i_3;
    private javax.swing.JLabel i_4;
    private javax.swing.JLabel i_5;
    private javax.swing.JLabel i_6;
    private javax.swing.JLabel i_7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem_open;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton_overlap_off;
    private javax.swing.JRadioButton jRadioButton_overlap_on;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel l_1;
    private javax.swing.JLabel l_2;
    private javax.swing.JLabel l_3;
    private javax.swing.JLabel l_4;
    private javax.swing.JLabel l_5;
    private javax.swing.JLabel l_6;
    private javax.swing.JLabel l_7;
    private javax.swing.JLabel l_8;
    private javax.swing.JLabel l_9;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_2;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    private javax.swing.JLabel lbl_6;
    private javax.swing.JLabel lbl_7;
    private javax.swing.JLabel lbl_8;
    private javax.swing.JTextField mat_1;
    private javax.swing.JTextField mat_2;
    private javax.swing.JTextField mat_3;
    private javax.swing.JTextField mat_4;
    private javax.swing.JTextField mat_5;
    private javax.swing.JTextField mat_6;
    private javax.swing.JTextField mat_7;
    private javax.swing.JTextField material_name_lv;
    private javax.swing.JTextField parameter_name;
    private javax.swing.JTextField parameter_value;
    private javax.swing.JButton physical_volume_insert_btn;
    private javax.swing.JButton physical_volumes_clear_btn;
    private javax.swing.JTextField red;
    private javax.swing.JTextField rot_name;
    private javax.swing.JTextField rot_x;
    private javax.swing.JTextField rot_y;
    private javax.swing.JTextField rot_z;
    private javax.swing.JTextField solid_name_lv;
    private javax.swing.JComboBox<String> solid_type;
    private javax.swing.JEditorPane target;
    private javax.swing.JTextField target_0;
    private javax.swing.JTextField target_1;
    private javax.swing.JTextField target_2;
    private javax.swing.JTextField target_3;
    private javax.swing.JTextField target_4;
    private javax.swing.JTextField target_5;
    private javax.swing.JTextField target_6;
    private javax.swing.JTextField target_7;
    private javax.swing.JTextField target_8;
    private javax.swing.JTextField target_9;
    private javax.swing.JTextField trans;
    private javax.swing.JLabel type;
    private javax.swing.JTextField v_name;
    private javax.swing.JTextField v_name_lv;
    private javax.swing.JButton vis_clear;
    private javax.swing.JButton vis_clear1;
    private javax.swing.JButton vis_clear3;
    private javax.swing.JButton vis_clear5;
    private javax.swing.JButton vis_clear6;
    private javax.swing.JButton vis_insert;
    private javax.swing.JButton vis_insert1;
    private javax.swing.JButton vis_insert3;
    private javax.swing.JButton vis_insert4;
    private javax.swing.JButton vis_insert5;
    private javax.swing.JRadioButton vis_off;
    private javax.swing.JRadioButton vis_on;
    private javax.swing.JComboBox<String> vol_type;
    private javax.swing.JTextField volume_name;
    private javax.swing.JTextField volume_name_vis;
    // End of variables declaration//GEN-END:variables
}
