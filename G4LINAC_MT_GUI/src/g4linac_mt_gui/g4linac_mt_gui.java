/*
G4Linac_MT, a Geant4-based application for Medical Linear Accelerator
Developed by Dr.Jaafar EL Bakkali,Assistant Prof. of Nuclear Physics
Rabat, Morocco, 10/10/ 2017
Webpage :https://github.com/EL-Bakkali-Jaafar/G4Linac_MT
 */
package g4linac_mt_gui; 
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author jaafar
 */
public class g4linac_mt_gui extends javax.swing.JFrame  {
String run_macro_script_linac_head,axis_flag="",

       macro_script_for_dose_cal,
       geant4_installation_dir,
       g4linac_installation_dir,
       root_installation_dir,
       valgrind_installation_dir,heprep_installation_dir,
       physics_quantity,
       vis_macro_script_linac_head,
        vis_macro_script_dose_cal,
       h5phase_space_path;
       settings _settings                    =        new  settings();
       aboutme _aboutme                      =        new  aboutme();
       geomModeling _geomModeling            =        new  geomModeling();
       g4linac_singelton myg4linac_singelton =        g4linac_singelton.getInstance();
   int index                                 =        0;
   Color BUTTON_BACKGROUD_COLOR__SELECTED_STATE= new Color(255,0,54), BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE= new Color(0,0,154);

   
   public g4linac_mt_gui() 
   {
    initComponents();
           setExtendedState(g4linac_mt_gui.MAXIMIZED_BOTH);        
    axis.setVisible(false);
    lbl_axis.setVisible(false);
    combo_box_type_of_particle.setBackground(java.awt.Color.DARK_GRAY);
    _POSITION_DIS_TYPE_G4LINAC_HEAD.setBackground(java.awt.Color.DARK_GRAY);
    combo_box_energy.setBackground(java.awt.Color.DARK_GRAY);
    _HISTO_CHOICE_G4LINAC_DATA_ANALYSIS.setBackground(java.awt.Color.DARK_GRAY);
    combo_box_vrt.setBackground(java.awt.Color.DARK_GRAY);
    combo_box_vrt.setBackground(java.awt.Color.DARK_GRAY);
    Dosimetric_functions.setBackground(java.awt.Color.DARK_GRAY);
    PrintStream printStream = new PrintStream(new custom_output_stream(g4linac_mt_console));  
    System.setOut(printStream);
    System.setErr(printStream);
    DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
   

   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tb = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbl_number_of_threads = new javax.swing.JLabel();
        etxt_number_of_threads = new javax.swing.JTextField();
        lbl_number_of_events_per_thread = new javax.swing.JLabel();
        etxt_number_of_events_per_thread = new javax.swing.JTextField();
        lbl_z_stop = new javax.swing.JLabel();
        lbl_h5_phase_space_name = new javax.swing.JLabel();
        ext_z_stop = new javax.swing.JTextField();
        etxt_h5_phase_space_name = new javax.swing.JTextField();
        lbl_geom_file = new javax.swing.JLabel();
        etxt_geom_file = new javax.swing.JTextField();
        lbl_enable_bremspe = new javax.swing.JLabel();
        lbl_number_of_fractionnements = new javax.swing.JLabel();
        etxt_number_of_fractionnement = new javax.swing.JTextField();
        combo_box_type_of_particle = new javax.swing.JComboBox<>();
        lbl_type_of_particle = new javax.swing.JLabel();
        lbl_direction_of_particle = new javax.swing.JLabel();
        etext_dir_x = new javax.swing.JTextField();
        etext_dir_y = new javax.swing.JTextField();
        etext_dir_z = new javax.swing.JTextField();
        _POSITION_DIS_TYPE_G4LINAC_HEAD = new javax.swing.JComboBox<>();
        lbl_type_of_distribution_pos = new javax.swing.JLabel();
        lbl_source_position = new javax.swing.JLabel();
        lbl_half_pos = new javax.swing.JLabel();
        lbl_sigma = new javax.swing.JLabel();
        lbl_cut = new javax.swing.JLabel();
        combo_box_energy = new javax.swing.JComboBox<>();
        lbl_energy_type = new javax.swing.JLabel();
        lbl_energy = new javax.swing.JLabel();
        etext_mono_energy = new javax.swing.JTextField();
        _POS_X_G4LINAC_HEAD = new javax.swing.JTextField();
        etext_pos_y = new javax.swing.JTextField();
        etext_pos_z = new javax.swing.JTextField();
        etext_half_y = new javax.swing.JTextField();
        _PHOTON_CUT_G4LINAC_HEAD = new javax.swing.JTextField();
        _ELECTRON_CUT_G4LINAC_HEAD = new javax.swing.JTextField();
        _POSITRON_CUT_G4LINAC_HEAD = new javax.swing.JTextField();
        etext_half_x = new javax.swing.JTextField();
        etext_sigma_x = new javax.swing.JTextField();
        etext_sigma_y = new javax.swing.JTextField();
        etxt_sigma_energy = new javax.swing.JTextField();
        btn_geom_file_loader = new javax.swing.JButton();
        check_box_enable_bremspe = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        btn_build_g4linac_head = new javax.swing.JButton();
        btn_view_geom_g4linac_head = new javax.swing.JButton();
        btn_start_g4linac_head = new javax.swing.JButton();
        btn_debug_g4linac_head = new javax.swing.JButton();
        btn_load_param_g4linac_head = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_number_of_events_per_threads = new javax.swing.JLabel();
        etxt_thread_number = new javax.swing.JTextField();
        lbl_z_coordinate_h5_phsp = new javax.swing.JLabel();
        etxt_z_stop_new = new javax.swing.JTextField();
        lbl_h5_phsp_file_name = new javax.swing.JLabel();
        h5_phsp_name = new javax.swing.JTextField();
        lbl_voxalized_phantom_dim = new javax.swing.JLabel();
        etxt_voxalized_phantom_size_y = new javax.swing.JTextField();
        etxt_voxalized_phantom_size_x = new javax.swing.JTextField();
        etxt_voxalized_phantom_size_z = new javax.swing.JTextField();
        lbl_vrt = new javax.swing.JLabel();
        lbl_number_of_fractionnement = new javax.swing.JLabel();
        etxt_n_frac = new javax.swing.JTextField();
        lbl_cut_production = new javax.swing.JLabel();
        etxt_cut_electron = new javax.swing.JTextField();
        etxt_cut_photon = new javax.swing.JTextField();
        etxt_cut_positron = new javax.swing.JTextField();
        lbl_readout_geom = new javax.swing.JLabel();
        readout_x_position = new javax.swing.JTextField();
        readout_y_position = new javax.swing.JTextField();
        readout_z_position = new javax.swing.JTextField();
        lbl_geom_from_text = new javax.swing.JLabel();
        etxt_geom_from_text = new javax.swing.JTextField();
        button_open_geom_file1 = new javax.swing.JButton();
        lbl_number_of_voxels = new javax.swing.JLabel();
        etxt_nvoxel_x = new javax.swing.JTextField();
        etxt_nvoxel_y = new javax.swing.JTextField();
        etxt_nvoxel_z = new javax.swing.JTextField();
        btn_h5_phase_space_name = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BUILD_G4LINAC_DOSECAL = new javax.swing.JButton();
        VIEW_GEOM_G4LINAC_DOSECAL = new javax.swing.JButton();
        START_G4LINAC_DOSECAL = new javax.swing.JButton();
        DEBUG_G4LINAC_DOSECAL = new javax.swing.JButton();
        LOAD_PARAM_G4LINAC_DOSE_CAL = new javax.swing.JButton();
        lbl_rotation_gantry = new javax.swing.JLabel();
        rotation_gantry_flag = new javax.swing.JCheckBox();
        combo_box_vrt = new javax.swing.JComboBox<>();
        lbl_patient_weight2 = new javax.swing.JLabel();
        etxt_gantry_rotation_angle = new javax.swing.JTextField();
        lbl_rotation_collimator = new javax.swing.JLabel();
        rot_colimator_flag = new javax.swing.JCheckBox();
        etext_collimator_rotation = new javax.swing.JTextField();
        lbl_patient_weight4 = new javax.swing.JLabel();
        lbl_stepmax = new javax.swing.JLabel();
        add_step_max_flag = new javax.swing.JCheckBox();
        lbl_stepmax_value = new javax.swing.JLabel();
        etxt_step_max_value = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lbl_patient_name10 = new javax.swing.JLabel();
        _PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS = new javax.swing.JTextField();
        button_open_geom_file_G4LINAC_DOSECAL1 = new javax.swing.JButton();
        lbl_patient_name11 = new javax.swing.JLabel();
        _HISTO_CHOICE_G4LINAC_DATA_ANALYSIS = new javax.swing.JComboBox<>();
        btn_get_it = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lbl_patient_name12 = new javax.swing.JLabel();
        _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS = new javax.swing.JTextField();
        select_dosimetric_file = new javax.swing.JButton();
        lbl_patient_name13 = new javax.swing.JLabel();
        axis = new javax.swing.JComboBox<>();
        btn_get_it_for_dosimetric = new javax.swing.JButton();
        b = new javax.swing.JTextField();
        a = new javax.swing.JTextField();
        lbl_a = new javax.swing.JLabel();
        lbl_b = new javax.swing.JLabel();
        lbl_axis = new javax.swing.JLabel();
        Dosimetric_functions = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        BTN_SAVE_OUTPUT_G4LINAC_HEAD = new javax.swing.JButton();
        BTN_CLEAR__G4LINAC_HEAD = new javax.swing.JButton();
        btn_summary = new javax.swing.JButton();
        lbl_mt_console = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        g4linac_mt_console = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_file = new javax.swing.JMenu();
        jMenuItem_exit = new javax.swing.JMenuItem();
        jMenu_Settings = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu_geom_modeling = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu_help = new javax.swing.JMenu();
        jMenuItem_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("G4Linac_MT_GUI");

        tb.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tb.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        lbl_number_of_threads.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_number_of_threads.setText("Number Of Threads ");

        etxt_number_of_threads.setBackground(java.awt.SystemColor.menu);
        etxt_number_of_threads.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_number_of_events_per_thread.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_number_of_events_per_thread.setText("Number Of Events Per Thread ");

        etxt_number_of_events_per_thread.setBackground(java.awt.SystemColor.menu);
        etxt_number_of_events_per_thread.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_z_stop.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_z_stop.setText("Z-Coordinate of h5PhaseSpace (cm)");

        lbl_h5_phase_space_name.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_h5_phase_space_name.setText("h5PhaseSpace Name");

        ext_z_stop.setBackground(java.awt.SystemColor.menu);
        ext_z_stop.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_h5_phase_space_name.setBackground(java.awt.SystemColor.menu);
        etxt_h5_phase_space_name.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_geom_file.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_geom_file.setText("Path to Geant4 Geometry From Text File");

        etxt_geom_file.setBackground(java.awt.SystemColor.menu);
        etxt_geom_file.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_enable_bremspe.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_enable_bremspe.setText("Enable Bremspe Technique");

        lbl_number_of_fractionnements.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_number_of_fractionnements.setText("Number Of Fractionnements");

        etxt_number_of_fractionnement.setBackground(java.awt.SystemColor.menu);
        etxt_number_of_fractionnement.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        combo_box_type_of_particle.setBackground(java.awt.SystemColor.menu);
        combo_box_type_of_particle.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        combo_box_type_of_particle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gamma", "e-", "e+", "proton", "neutron" }));

        lbl_type_of_particle.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_type_of_particle.setText("Type Of Particle");

        lbl_direction_of_particle.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_direction_of_particle.setText("Direction of Particle");

        etext_dir_x.setBackground(java.awt.SystemColor.menu);
        etext_dir_x.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_dir_y.setBackground(java.awt.SystemColor.menu);
        etext_dir_y.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_dir_z.setBackground(java.awt.SystemColor.menu);
        etext_dir_z.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        _POSITION_DIS_TYPE_G4LINAC_HEAD.setBackground(java.awt.SystemColor.menu);
        _POSITION_DIS_TYPE_G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _POSITION_DIS_TYPE_G4LINAC_HEAD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "beam" }));

        lbl_type_of_distribution_pos.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_type_of_distribution_pos.setText("Type Of  Position Distribution");

        lbl_source_position.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_source_position.setText("Coordinates of the source  (cm,cm,cm)");

        lbl_half_pos.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_half_pos.setText("Half-x  and Half-y Of Position (cm,cm)");

        lbl_sigma.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_sigma.setText("Sigma-x  and Sigma-y Of Position (cm,cm)");

        lbl_cut.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_cut.setText("cut of photon, electron and positron ( mm,mm,mm)");

        combo_box_energy.setBackground(java.awt.SystemColor.menu);
        combo_box_energy.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        combo_box_energy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "guassian" }));

        lbl_energy_type.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_energy_type.setText("Type Of Energy");

        lbl_energy.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_energy.setText("Mono  and Sigma Of Energy (MeV)");

        etext_mono_energy.setBackground(java.awt.SystemColor.menu);
        etext_mono_energy.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        _POS_X_G4LINAC_HEAD.setBackground(java.awt.SystemColor.menu);
        _POS_X_G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_pos_y.setBackground(java.awt.SystemColor.menu);
        etext_pos_y.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_pos_z.setBackground(java.awt.SystemColor.menu);
        etext_pos_z.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_half_y.setBackground(java.awt.SystemColor.menu);
        etext_half_y.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        _PHOTON_CUT_G4LINAC_HEAD.setBackground(java.awt.SystemColor.menu);
        _PHOTON_CUT_G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        _ELECTRON_CUT_G4LINAC_HEAD.setBackground(java.awt.SystemColor.menu);
        _ELECTRON_CUT_G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        _POSITRON_CUT_G4LINAC_HEAD.setBackground(java.awt.SystemColor.menu);
        _POSITRON_CUT_G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_half_x.setBackground(java.awt.SystemColor.menu);
        etext_half_x.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_sigma_x.setBackground(java.awt.SystemColor.menu);
        etext_sigma_x.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etext_sigma_y.setBackground(java.awt.SystemColor.menu);
        etext_sigma_y.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_sigma_energy.setBackground(java.awt.SystemColor.menu);
        etxt_sigma_energy.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        btn_geom_file_loader.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btn_geom_file_loader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_geom_file_loaderActionPerformed(evt);
            }
        });

        check_box_enable_bremspe.setBackground(java.awt.SystemColor.menu);
        check_box_enable_bremspe.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        check_box_enable_bremspe.setText("True");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btn_build_g4linac_head.setBackground(java.awt.Color.blue);
        btn_build_g4linac_head.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_build_g4linac_head.setForeground(java.awt.SystemColor.text);
        btn_build_g4linac_head.setText("build");
        btn_build_g4linac_head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_build_g4linac_headMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_build_g4linac_headMouseEntered(evt);
            }
        });
        btn_build_g4linac_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_build_g4linac_headActionPerformed(evt);
            }
        });

        btn_view_geom_g4linac_head.setBackground(java.awt.Color.blue);
        btn_view_geom_g4linac_head.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_view_geom_g4linac_head.setForeground(java.awt.SystemColor.text);
        btn_view_geom_g4linac_head.setText("view geom");
        btn_view_geom_g4linac_head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_view_geom_g4linac_headMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_view_geom_g4linac_headMouseEntered(evt);
            }
        });
        btn_view_geom_g4linac_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_view_geom_g4linac_headActionPerformed(evt);
            }
        });

        btn_start_g4linac_head.setBackground(java.awt.Color.blue);
        btn_start_g4linac_head.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_start_g4linac_head.setForeground(java.awt.SystemColor.text);
        btn_start_g4linac_head.setText("start");
        btn_start_g4linac_head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_start_g4linac_headMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_start_g4linac_headMouseEntered(evt);
            }
        });
        btn_start_g4linac_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_start_g4linac_headActionPerformed(evt);
            }
        });

        btn_debug_g4linac_head.setBackground(java.awt.Color.blue);
        btn_debug_g4linac_head.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_debug_g4linac_head.setForeground(java.awt.SystemColor.text);
        btn_debug_g4linac_head.setText("debug");
        btn_debug_g4linac_head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_debug_g4linac_headMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_debug_g4linac_headMouseEntered(evt);
            }
        });
        btn_debug_g4linac_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_debug_g4linac_headActionPerformed(evt);
            }
        });

        btn_load_param_g4linac_head.setBackground(java.awt.Color.blue);
        btn_load_param_g4linac_head.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_load_param_g4linac_head.setForeground(java.awt.SystemColor.text);
        btn_load_param_g4linac_head.setText("previous config");
        btn_load_param_g4linac_head.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_load_param_g4linac_headMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_load_param_g4linac_headMouseEntered(evt);
            }
        });
        btn_load_param_g4linac_head.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_load_param_g4linac_headActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_load_param_g4linac_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btn_build_g4linac_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btn_view_geom_g4linac_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btn_start_g4linac_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btn_debug_g4linac_head, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_view_geom_g4linac_head)
                    .addComponent(btn_start_g4linac_head)
                    .addComponent(btn_debug_g4linac_head)
                    .addComponent(btn_build_g4linac_head)
                    .addComponent(btn_load_param_g4linac_head)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_cut, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_energy_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_energy, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(combo_box_energy, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(_ELECTRON_CUT_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(_PHOTON_CUT_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(_POSITRON_CUT_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(etext_mono_energy, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(etxt_sigma_energy, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_sigma, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etext_sigma_x, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_half_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etext_half_x, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etext_half_y, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etext_sigma_y, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_number_of_events_per_thread, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_z_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_h5_phase_space_name, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_geom_file, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_enable_bremspe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbl_number_of_fractionnements, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbl_direction_of_particle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_type_of_particle, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_type_of_distribution_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_number_of_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(check_box_enable_bremspe, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_POSITION_DIS_TYPE_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(etext_dir_x, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(etext_dir_y, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(etext_dir_z, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(combo_box_type_of_particle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etxt_number_of_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etxt_number_of_fractionnement, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etxt_h5_phase_space_name, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ext_z_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etxt_number_of_events_per_thread, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(etxt_geom_file, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btn_geom_file_loader, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_source_position, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_POS_X_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(etext_pos_y, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(etext_pos_z, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbl_cut, lbl_direction_of_particle, lbl_enable_bremspe, lbl_energy, lbl_energy_type, lbl_geom_file, lbl_h5_phase_space_name, lbl_half_pos, lbl_number_of_events_per_thread, lbl_number_of_fractionnements, lbl_sigma, lbl_source_position, lbl_type_of_distribution_pos, lbl_type_of_particle, lbl_z_stop});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etxt_number_of_threads, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_number_of_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etxt_number_of_events_per_thread, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_number_of_events_per_thread, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ext_z_stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_z_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_h5_phase_space_name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_h5_phase_space_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_geom_file, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etxt_geom_file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_geom_file_loader)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_enable_bremspe, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_box_enable_bremspe))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etxt_number_of_fractionnement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_number_of_fractionnements, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_type_of_particle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_box_type_of_particle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etext_dir_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_dir_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_dir_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_direction_of_particle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_type_of_distribution_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_POSITION_DIS_TYPE_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_source_position, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_pos_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_POS_X_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_pos_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_half_pos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_half_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_half_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etext_sigma_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_sigma_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sigma, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_ELECTRON_CUT_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_PHOTON_CUT_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_POSITRON_CUT_G4LINAC_HEAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cut, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_box_energy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_energy_type, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etext_mono_energy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_sigma_energy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_energy, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_number_of_events_per_thread, lbl_number_of_threads, lbl_z_stop});

        tb.addTab("G4Linac_Head", jPanel1);

        lbl_number_of_events_per_threads.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_number_of_events_per_threads.setText("Number Of Events Per Thread ");

        etxt_thread_number.setBackground(java.awt.SystemColor.menu);
        etxt_thread_number.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_z_coordinate_h5_phsp.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_z_coordinate_h5_phsp.setText("Z-Coordinate of h5PhaseSpace (cm)");

        etxt_z_stop_new.setBackground(java.awt.SystemColor.menu);
        etxt_z_stop_new.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_h5_phsp_file_name.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_h5_phsp_file_name.setText("Path of h5PhaseSpace file");

        h5_phsp_name.setBackground(java.awt.SystemColor.menu);
        h5_phsp_name.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_voxalized_phantom_dim.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_voxalized_phantom_dim.setText("Voxalized Phantom dimensions (x,y,z)  (cm, cm, cm)");

        etxt_voxalized_phantom_size_y.setBackground(java.awt.SystemColor.menu);
        etxt_voxalized_phantom_size_y.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_voxalized_phantom_size_x.setBackground(java.awt.SystemColor.menu);
        etxt_voxalized_phantom_size_x.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_voxalized_phantom_size_z.setBackground(java.awt.SystemColor.menu);
        etxt_voxalized_phantom_size_z.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_vrt.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_vrt.setText("Variance reduction technique");

        lbl_number_of_fractionnement.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_number_of_fractionnement.setText("Number of Splitting/Recycling");

        etxt_n_frac.setBackground(java.awt.SystemColor.menu);
        etxt_n_frac.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        etxt_n_frac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etxt_n_fracActionPerformed(evt);
            }
        });

        lbl_cut_production.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_cut_production.setText("Cut of photon, electron and positron ( mm,mm,mm)");

        etxt_cut_electron.setBackground(java.awt.SystemColor.menu);
        etxt_cut_electron.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_cut_photon.setBackground(java.awt.SystemColor.menu);
        etxt_cut_photon.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_cut_positron.setBackground(java.awt.SystemColor.menu);
        etxt_cut_positron.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        etxt_cut_positron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etxt_cut_positronActionPerformed(evt);
            }
        });

        lbl_readout_geom.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_readout_geom.setText("ReadOut Geometry Positions (x,y,z) (cm, cm, cm)");

        readout_x_position.setBackground(java.awt.SystemColor.menu);
        readout_x_position.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        readout_y_position.setBackground(java.awt.SystemColor.menu);
        readout_y_position.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        readout_y_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readout_y_positionActionPerformed(evt);
            }
        });

        readout_z_position.setBackground(java.awt.SystemColor.menu);
        readout_z_position.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        readout_z_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readout_z_positionActionPerformed(evt);
            }
        });

        lbl_geom_from_text.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_geom_from_text.setText("Path Of Geant4 Geometry From Text File");

        etxt_geom_from_text.setBackground(java.awt.SystemColor.menu);
        etxt_geom_from_text.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        button_open_geom_file1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        button_open_geom_file1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_open_geom_file1ActionPerformed(evt);
            }
        });

        lbl_number_of_voxels.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_number_of_voxels.setText("Number of Voxels allong x,y and z");

        etxt_nvoxel_x.setBackground(java.awt.SystemColor.menu);
        etxt_nvoxel_x.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_nvoxel_y.setBackground(java.awt.SystemColor.menu);
        etxt_nvoxel_y.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        etxt_nvoxel_z.setBackground(java.awt.SystemColor.menu);
        etxt_nvoxel_z.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        btn_h5_phase_space_name.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        btn_h5_phase_space_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_h5_phase_space_nameActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BUILD_G4LINAC_DOSECAL.setBackground(java.awt.Color.blue);
        BUILD_G4LINAC_DOSECAL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        BUILD_G4LINAC_DOSECAL.setForeground(java.awt.SystemColor.text);
        BUILD_G4LINAC_DOSECAL.setText("build");
        BUILD_G4LINAC_DOSECAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BUILD_G4LINAC_DOSECALMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BUILD_G4LINAC_DOSECALMouseEntered(evt);
            }
        });
        BUILD_G4LINAC_DOSECAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUILD_G4LINAC_DOSECALActionPerformed(evt);
            }
        });

        VIEW_GEOM_G4LINAC_DOSECAL.setBackground(java.awt.Color.blue);
        VIEW_GEOM_G4LINAC_DOSECAL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        VIEW_GEOM_G4LINAC_DOSECAL.setForeground(java.awt.SystemColor.text);
        VIEW_GEOM_G4LINAC_DOSECAL.setText("view geom");
        VIEW_GEOM_G4LINAC_DOSECAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VIEW_GEOM_G4LINAC_DOSECALMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VIEW_GEOM_G4LINAC_DOSECALMouseEntered(evt);
            }
        });
        VIEW_GEOM_G4LINAC_DOSECAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEW_GEOM_G4LINAC_DOSECALActionPerformed(evt);
            }
        });

        START_G4LINAC_DOSECAL.setBackground(java.awt.Color.blue);
        START_G4LINAC_DOSECAL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        START_G4LINAC_DOSECAL.setForeground(java.awt.SystemColor.text);
        START_G4LINAC_DOSECAL.setText("start");
        START_G4LINAC_DOSECAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                START_G4LINAC_DOSECALMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                START_G4LINAC_DOSECALMouseEntered(evt);
            }
        });
        START_G4LINAC_DOSECAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                START_G4LINAC_DOSECALActionPerformed(evt);
            }
        });

        DEBUG_G4LINAC_DOSECAL.setBackground(java.awt.Color.blue);
        DEBUG_G4LINAC_DOSECAL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        DEBUG_G4LINAC_DOSECAL.setForeground(java.awt.SystemColor.text);
        DEBUG_G4LINAC_DOSECAL.setText("debug");
        DEBUG_G4LINAC_DOSECAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DEBUG_G4LINAC_DOSECALMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DEBUG_G4LINAC_DOSECALMouseEntered(evt);
            }
        });
        DEBUG_G4LINAC_DOSECAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DEBUG_G4LINAC_DOSECALActionPerformed(evt);
            }
        });

        LOAD_PARAM_G4LINAC_DOSE_CAL.setBackground(java.awt.Color.blue);
        LOAD_PARAM_G4LINAC_DOSE_CAL.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        LOAD_PARAM_G4LINAC_DOSE_CAL.setForeground(java.awt.SystemColor.text);
        LOAD_PARAM_G4LINAC_DOSE_CAL.setText("previous config");
        LOAD_PARAM_G4LINAC_DOSE_CAL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LOAD_PARAM_G4LINAC_DOSE_CALMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LOAD_PARAM_G4LINAC_DOSE_CALMouseEntered(evt);
            }
        });
        LOAD_PARAM_G4LINAC_DOSE_CAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOAD_PARAM_G4LINAC_DOSE_CALActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(LOAD_PARAM_G4LINAC_DOSE_CAL, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(BUILD_G4LINAC_DOSECAL, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(VIEW_GEOM_G4LINAC_DOSECAL, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(START_G4LINAC_DOSECAL, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(DEBUG_G4LINAC_DOSECAL, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VIEW_GEOM_G4LINAC_DOSECAL)
                    .addComponent(START_G4LINAC_DOSECAL)
                    .addComponent(DEBUG_G4LINAC_DOSECAL)
                    .addComponent(BUILD_G4LINAC_DOSECAL)
                    .addComponent(LOAD_PARAM_G4LINAC_DOSE_CAL))
                .addGap(0, 0, 0))
        );

        lbl_rotation_gantry.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_rotation_gantry.setText("Rotating Gantry ");

        rotation_gantry_flag.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        rotation_gantry_flag.setText("True");

        combo_box_vrt.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        combo_box_vrt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "particle rotational splitting", "particle recycling" }));
        combo_box_vrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_box_vrtActionPerformed(evt);
            }
        });

        lbl_patient_weight2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_patient_weight2.setText("Gantry Total Rotation Angle ( Degree)");

        etxt_gantry_rotation_angle.setBackground(java.awt.SystemColor.menu);
        etxt_gantry_rotation_angle.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_rotation_collimator.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_rotation_collimator.setText("Rotating Collimator ");

        rot_colimator_flag.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        rot_colimator_flag.setText("True");

        etext_collimator_rotation.setBackground(java.awt.SystemColor.menu);
        etext_collimator_rotation.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_patient_weight4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_patient_weight4.setText("Collimator  Rotation Angle ( Degree)");

        lbl_stepmax.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_stepmax.setText("Add Step Max ");

        add_step_max_flag.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        add_step_max_flag.setText("True");

        lbl_stepmax_value.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_stepmax_value.setText("Step Max Value (mm)");

        etxt_step_max_value.setBackground(java.awt.SystemColor.menu);
        etxt_step_max_value.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        etxt_step_max_value.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etxt_step_max_valueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_patient_weight2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(etxt_gantry_rotation_angle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_rotation_gantry, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rotation_gantry_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_geom_from_text, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(etxt_geom_from_text, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(button_open_geom_file1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbl_cut_production, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(etxt_cut_photon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(lbl_readout_geom, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(readout_x_position, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, 0)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(etxt_cut_electron, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(etxt_cut_positron, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(readout_y_position, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(readout_z_position, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_number_of_fractionnement, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(etxt_n_frac, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_vrt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(combo_box_vrt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_number_of_events_per_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_z_coordinate_h5_phsp, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_h5_phsp_file_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbl_voxalized_phantom_dim, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(etxt_voxalized_phantom_size_x, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(etxt_voxalized_phantom_size_y, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(etxt_voxalized_phantom_size_z, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(etxt_z_stop_new)
                                    .addComponent(etxt_thread_number)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(h5_phsp_name, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btn_h5_phase_space_name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_number_of_voxels, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(etxt_nvoxel_x, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(etxt_nvoxel_y, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(etxt_nvoxel_z, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_stepmax_value, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(etxt_step_max_value, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_stepmax, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(add_step_max_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_rotation_collimator, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rot_colimator_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_patient_weight4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(etext_collimator_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etxt_thread_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_number_of_events_per_threads, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etxt_z_stop_new, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_z_coordinate_h5_phsp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_h5_phsp_file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(h5_phsp_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_h5_phase_space_name)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_voxalized_phantom_dim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_voxalized_phantom_size_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_voxalized_phantom_size_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_voxalized_phantom_size_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_number_of_voxels, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_nvoxel_y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_nvoxel_x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_nvoxel_z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_box_vrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vrt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_number_of_fractionnement, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_n_frac))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etxt_cut_electron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_cut_positron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cut_production, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_cut_photon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readout_x_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(readout_y_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(readout_z_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_readout_geom, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_geom_from_text, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etxt_geom_from_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_open_geom_file1)))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotation_gantry_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rotation_gantry, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_patient_weight2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_gantry_rotation_angle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rot_colimator_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rotation_collimator, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_patient_weight4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etext_collimator_rotation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_step_max_flag, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_stepmax, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_stepmax_value, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etxt_step_max_value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tb.addTab("G4Linac_DoseCal", jPanel4);

        jTabbedPane2.setBorder(new javax.swing.border.MatteBorder(null));
        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_patient_name10.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_patient_name10.setText(" Make histogramming for");

        _PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS.setBackground(java.awt.SystemColor.menu);
        _PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        button_open_geom_file_G4LINAC_DOSECAL1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        button_open_geom_file_G4LINAC_DOSECAL1.setToolTipText("");
        button_open_geom_file_G4LINAC_DOSECAL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_open_geom_file_G4LINAC_DOSECAL1ActionPerformed(evt);
            }
        });

        lbl_patient_name11.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_patient_name11.setText("Path of h5PhaseSpace file");

        _HISTO_CHOICE_G4LINAC_DATA_ANALYSIS.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        _HISTO_CHOICE_G4LINAC_DATA_ANALYSIS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "photon_energy_spectrum", "electron_energy_spectrum", "photon_angular_distribution", "electron_angular_distribution ", "photon_spatial_distribution_xy", "electron_spatial_distribution_xy", "spatial_distribution_xy", "photon_spatial_distribution_xy_with_kinetic", "electron_spatial_distribution_xy_with_kinetic", "spatial_distribution_xy_with_kinetic" }));
        _HISTO_CHOICE_G4LINAC_DATA_ANALYSIS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _HISTO_CHOICE_G4LINAC_DATA_ANALYSISActionPerformed(evt);
            }
        });

        btn_get_it.setBackground(java.awt.Color.blue);
        btn_get_it.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_get_it.setForeground(java.awt.SystemColor.text);
        btn_get_it.setText("Get it !");
        btn_get_it.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_get_itMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_get_itMouseEntered(evt);
            }
        });
        btn_get_it.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_get_itActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_patient_name11)
                    .addComponent(lbl_patient_name10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(_PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS)
                            .addGap(0, 0, 0)
                            .addComponent(button_open_geom_file_G4LINAC_DOSECAL1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(_HISTO_CHOICE_G4LINAC_DATA_ANALYSIS, javax.swing.GroupLayout.Alignment.LEADING, 0, 437, Short.MAX_VALUE)
                        .addComponent(btn_get_it, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lbl_patient_name11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_open_geom_file_G4LINAC_DOSECAL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lbl_patient_name10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(_HISTO_CHOICE_G4LINAC_DATA_ANALYSIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_get_it)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("h5PhaseSpace Data", jPanel10);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_patient_name12.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_patient_name12.setText(" Make histogramming for");

        _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.setBackground(java.awt.SystemColor.menu);
        _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        select_dosimetric_file.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        select_dosimetric_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_dosimetric_fileActionPerformed(evt);
            }
        });

        lbl_patient_name13.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_patient_name13.setText("Path to dosimetric data file");

        axis.setBackground(java.awt.SystemColor.menu);
        axis.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        axis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "x", "y", "z" }));
        axis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axisActionPerformed(evt);
            }
        });

        btn_get_it_for_dosimetric.setBackground(java.awt.Color.blue);
        btn_get_it_for_dosimetric.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_get_it_for_dosimetric.setForeground(java.awt.SystemColor.text);
        btn_get_it_for_dosimetric.setText("Get it !");
        btn_get_it_for_dosimetric.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_get_it_for_dosimetricMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_get_it_for_dosimetricMouseEntered(evt);
            }
        });
        btn_get_it_for_dosimetric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_get_it_for_dosimetricActionPerformed(evt);
            }
        });

        b.setBackground(java.awt.SystemColor.menu);
        b.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        a.setBackground(java.awt.SystemColor.menu);
        a.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N

        lbl_a.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_a.setText("X_ID");

        lbl_b.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_b.setText("Y_ID");

        lbl_axis.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lbl_axis.setText("Axis");

        Dosimetric_functions.setBackground(java.awt.SystemColor.menu);
        Dosimetric_functions.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        Dosimetric_functions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Percentage_Depth_Dose_Curve", "Percentage_Depth_Dose_Curve_Rsd", "Cross-plane_Dose_Profile", "Cross-plane_Dose_Profile_Rsd", "In-plane_Dose_Profile", "In-plane_Dose_Profile_Rsd", "2D_Dose_HeatMap" }));
        Dosimetric_functions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dosimetric_functionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(axis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(_DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS)
                .addGap(0, 0, 0)
                .addComponent(select_dosimetric_file, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lbl_axis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_get_it_for_dosimetric, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(a)
            .addComponent(b)
            .addComponent(lbl_patient_name12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_patient_name13, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
            .addComponent(Dosimetric_functions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(lbl_patient_name13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_dosimetric_file, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lbl_patient_name12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Dosimetric_functions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_axis, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(axis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_a, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_b, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_get_it_for_dosimetric)
                .addGap(0, 0, 0))
        );

        jTabbedPane2.addTab("Dosimetric Data", jPanel9);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        tb.addTab("G4Linac_DataAnalysis", jPanel7);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        BTN_SAVE_OUTPUT_G4LINAC_HEAD.setBackground(java.awt.Color.blue);
        BTN_SAVE_OUTPUT_G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        BTN_SAVE_OUTPUT_G4LINAC_HEAD.setForeground(java.awt.SystemColor.text);
        BTN_SAVE_OUTPUT_G4LINAC_HEAD.setText("save");
        BTN_SAVE_OUTPUT_G4LINAC_HEAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_SAVE_OUTPUT_G4LINAC_HEADMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_SAVE_OUTPUT_G4LINAC_HEADMouseEntered(evt);
            }
        });
        BTN_SAVE_OUTPUT_G4LINAC_HEAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SAVE_OUTPUT_G4LINAC_HEADActionPerformed(evt);
            }
        });

        BTN_CLEAR__G4LINAC_HEAD.setBackground(java.awt.Color.blue);
        BTN_CLEAR__G4LINAC_HEAD.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        BTN_CLEAR__G4LINAC_HEAD.setForeground(java.awt.SystemColor.text);
        BTN_CLEAR__G4LINAC_HEAD.setText("clear");
        BTN_CLEAR__G4LINAC_HEAD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BTN_CLEAR__G4LINAC_HEADMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BTN_CLEAR__G4LINAC_HEADMouseEntered(evt);
            }
        });
        BTN_CLEAR__G4LINAC_HEAD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CLEAR__G4LINAC_HEADActionPerformed(evt);
            }
        });

        btn_summary.setBackground(java.awt.Color.blue);
        btn_summary.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btn_summary.setForeground(java.awt.SystemColor.text);
        btn_summary.setText("summary");
        btn_summary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_summaryMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_summaryMouseEntered(evt);
            }
        });
        btn_summary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_summaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(BTN_SAVE_OUTPUT_G4LINAC_HEAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(BTN_CLEAR__G4LINAC_HEAD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btn_summary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_CLEAR__G4LINAC_HEAD)
                    .addComponent(BTN_SAVE_OUTPUT_G4LINAC_HEAD)
                    .addComponent(btn_summary))
                .addGap(0, 0, 0))
        );

        lbl_mt_console.setBackground(java.awt.SystemColor.menu);
        lbl_mt_console.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lbl_mt_console.setText("  G4Linac_MT Console  ");
        lbl_mt_console.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        g4linac_mt_console.setEditable(false);
        g4linac_mt_console.setBackground(java.awt.SystemColor.menu);
        g4linac_mt_console.setColumns(20);
        g4linac_mt_console.setFont(new java.awt.Font("TlwgMono", 1, 12)); // NOI18N
        g4linac_mt_console.setLineWrap(true);
        g4linac_mt_console.setRows(5);
        g4linac_mt_console.setText("                                                                            ");
        g4linac_mt_console.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        g4linac_mt_console.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(g4linac_mt_console);

        jMenuBar1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N

        jMenu_file.setText("File");

        jMenuItem_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_exit.setText("exit");
        jMenuItem_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_exitActionPerformed(evt);
            }
        });
        jMenu_file.add(jMenuItem_exit);

        jMenuBar1.add(jMenu_file);

        jMenu_Settings.setText("Settings");
        jMenu_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_SettingsActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Setup G4Linac_MT_GUI");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu_Settings.add(jMenuItem1);

        jMenuBar1.add(jMenu_Settings);

        jMenu_geom_modeling.setText("Tools");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_TAB, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("GeomModeling");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu_geom_modeling.add(jMenuItem2);

        jMenuBar1.add(jMenu_geom_modeling);

        jMenu_help.setText("Help");

        jMenuItem_about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem_about.setText("about");
        jMenuItem_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_aboutActionPerformed(evt);
            }
        });
        jMenu_help.add(jMenuItem_about);

        jMenuBar1.add(jMenu_help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tb, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_mt_console)
                        .addGap(0, 478, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_mt_console)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2)
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addComponent(tb)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
 
public void save_vis_macro_script_file(String text , String Target ){
try {
FileWriter lu = new FileWriter(Target);
try (BufferedWriter fluxS = new BufferedWriter(lu) 
) {
fluxS.write(text); 
fluxS.close(); 
} 
} catch (IOException er) {
 System.out.println(er.getMessage());
}
}   
public void save_run_macro_script_file(String text , String Target ){
try {
FileWriter lu = new FileWriter(Target);
try (BufferedWriter fluxS = new BufferedWriter(lu) 
) {
fluxS.write(text); 
fluxS.close(); 
} 
} catch (IOException er) {
 System.out.println(er.getMessage());
}
}
void construct_run_macro_script_for_dose_cal(){
          
    String  StepMaxFlag="",collimator_total_angle="",gantry_total_angle ="",H5PhaseSpaceName_flag,ZSTOP_flag,VoxalizedPhantomSize_flag,numberOfVoxels_flag,GeneratorFlag,Nsplit_flag,NumberOfEventsPerThread_flag,PhotonCut_Flag, ElectronCut_Flag,PositronCut_Flag,ROGcenterPos_flag,UseGeomFromText_flag,NameOfGeomFromTextFile_fal;

    String NameOfGeomFromTextFile_falg;
    H5PhaseSpaceName_flag= "/Parameters/H5PhaseSpaceName "+h5_phsp_name.getText();
    ZSTOP_flag= "\n/Parameters/ZSTOP "+etxt_z_stop_new.getText()+" cm";
    VoxalizedPhantomSize_flag ="\n/Parameters/VoxalizedPhantomSizeX "+ etxt_voxalized_phantom_size_x.getText()+" cm\n"+
    "/Parameters/VoxalizedPhantomSizeY "+ etxt_voxalized_phantom_size_y.getText()+" cm\n"+
    "/Parameters/VoxalizedPhantomSizeZ "+ etxt_voxalized_phantom_size_z.getText()+" cm\n";
    numberOfVoxels_flag="\n/Parameters/numberOfVoxelsAlongX "+ etxt_nvoxel_x.getText()+"\n/Parameters/numberOfVoxelsAlongY "+etxt_nvoxel_y.getText()+"\n/Parameters/numberOfVoxelsAlongZ "+etxt_nvoxel_z.getText();
    GeneratorFlag ="\n/Parameters/GeneratorFlag "  +combo_box_vrt.getSelectedIndex();
    Nsplit_flag ="\n/Parameters/Nsplit "+ etxt_n_frac.getText();
    NumberOfEventsPerThread_flag ="\n/Parameters/NumberOfEventsPerThread "+ etxt_thread_number.getText();
    PhotonCut_Flag = "\n/Physics/setGCut "+ etxt_cut_photon.getText()+" mm";
    ElectronCut_Flag = "\n/Physics/setECut "+ etxt_cut_electron.getText()+" mm";
    PositronCut_Flag = "\n/Physics/setPCut "+ etxt_cut_positron.getText()+" mm";
    ROGcenterPos_flag = "\n/Parameters/ROGcenterPos "+ readout_x_position.getText()+" "+ readout_y_position.getText()+" "+readout_z_position.getText()+" cm";
    NameOfGeomFromTextFile_falg ="\n/Parameters/NameOfGeomFromTextFile "+etxt_geom_from_text.getText();
if (add_step_max_flag.isSelected()==true){

StepMaxFlag="\n/Parameters/DefineStepMax true \n/Parameters/StepMaxValue "+etxt_step_max_value.getText()+" mm";
}
    if (rotation_gantry_flag.isSelected()==true)
    {
    gantry_total_angle="\n/Parameters/GantryRotAngleFlag  true\n" +
    "/Parameters/GantryRotAngle "+ etxt_gantry_rotation_angle.getText()+ " degree";
    }
    
     if (rot_colimator_flag.isSelected()==true)
    {
    collimator_total_angle="\n/Parameters/CollimatorRotAngleFlag  true\n" +
    "/Parameters/CollimatorRotAngle "+ etext_collimator_rotation.getText()+ " degree";
    }
    macro_script_for_dose_cal=H5PhaseSpaceName_flag+ZSTOP_flag+VoxalizedPhantomSize_flag+
    numberOfVoxels_flag+GeneratorFlag+Nsplit_flag+NumberOfEventsPerThread_flag+PhotonCut_Flag+
    ElectronCut_Flag+PositronCut_Flag+ROGcenterPos_flag+gantry_total_angle+collimator_total_angle+
    NameOfGeomFromTextFile_falg+StepMaxFlag+
    "\n/run/geometryModified\n" +
   
    "\n/run/initialize";  
    vis_macro_script_dose_cal= 
   H5PhaseSpaceName_flag+ZSTOP_flag+VoxalizedPhantomSize_flag+
    numberOfVoxels_flag+GeneratorFlag+Nsplit_flag+NumberOfEventsPerThread_flag+PhotonCut_Flag+
    ElectronCut_Flag+PositronCut_Flag+ROGcenterPos_flag+gantry_total_angle+collimator_total_angle+
    NameOfGeomFromTextFile_falg+
    "\n/run/geometryModified\n" +
                       "/run/numberOfThreads 1"+"\n"+
 
    "/run/initialize\n" +
   
    "/vis/open OGL 600x600-0+0\n" +
    "/vis/drawVolume";
    }

    void construct_run_macro_script_for_linac_head(){   
   String  particle_energy_values,particle_position_sigma_values,particle_position_half_values,particle_position_origin,particle_distribution_type,
           particle_direction,particle_kind,number_of_threads_flag,
           number_of_events_per_thread_flag,z_coordinate_phase_space_flag,update_geom_flag,
           use_Bremspe_text_flag,  init_geom_flag,name_of_h5_phase_space_file_flag
           ,name_of_geant_geom_from_text_flag,positron_cut_flag,electron_cut_flag,photon_cut_flag;
   z_coordinate_phase_space_flag      ="/Parameters/ZStop "+ext_z_stop.getText();
   number_of_events_per_thread_flag  ="/Parameters/NumberOfEventsPerThread "+etxt_number_of_events_per_thread.getText();
   name_of_h5_phase_space_file_flag  ="/Parameters/H5PhaseSpaceName "+etxt_h5_phase_space_name.getText();
   name_of_geant_geom_from_text_flag ="/Parameters/NameOfGeomFromTextFile "+ etxt_geom_file.getText(); 
   photon_cut_flag                   = "/Physics/setGCut " + _PHOTON_CUT_G4LINAC_HEAD.getText()+ " mm ";
   electron_cut_flag                 = "/Physics/setECut " + _ELECTRON_CUT_G4LINAC_HEAD.getText()+" mm ";
   positron_cut_flag                 = "/Physics/setPCut " + _POSITRON_CUT_G4LINAC_HEAD.getText()+" mm ";
   update_geom_flag ="/run/geometryModified";
   number_of_threads_flag= "/run/numberOfThreads "+etxt_number_of_threads.getText();
   init_geom_flag ="/run/initialize";
   if (check_box_enable_bremspe.isSelected()  ==true) {
   use_Bremspe_text_flag    ="/Physics/Bremspe_Enabled true \n"+"/Physics/Bremspe_Nsplit "+ etxt_number_of_fractionnement.getText();      
   } else{
   use_Bremspe_text_flag     ="/Physics/Bremspe_Enabled false ";
   }
    particle_kind = "/gps/particle "+combo_box_type_of_particle.getSelectedItem().toString();
    particle_direction="/gps/direction "+etext_dir_x.getText()+" "+etext_dir_y.getText()+" "+etext_dir_z.getText();
    particle_distribution_type= "/gps/pos/type Beam";
    particle_position_origin ="/gps/pos/centre "+_POS_X_G4LINAC_HEAD.getText()+" "+etext_pos_y.getText()+"   "+ etext_pos_z.getText()+"  cm ";
    particle_position_half_values ="/gps/pos/halfx "+etext_half_x.getText()+" cm "+"\n/gps/pos/halfy "+etext_half_y.getText()+" cm ";
    particle_position_sigma_values ="/gps/pos/sigma_x "+etext_sigma_x.getText()+" cm "+"\n/gps/pos/sigma_y "+etext_sigma_y.getText()+" cm ";
    particle_energy_values="/gps/ene/type Gauss"+"\n/gps/ene/mono "+etext_mono_energy.getText()+" MeV " +"\n/gps/ene/sigma "+etxt_sigma_energy.getText()+" MeV "; 
    run_macro_script_linac_head=  
    number_of_events_per_thread_flag+"\n"+
    z_coordinate_phase_space_flag+" cm\n"+
    name_of_h5_phase_space_file_flag+"\n"+
    name_of_geant_geom_from_text_flag+"\n"+
    positron_cut_flag+"\n"+
    electron_cut_flag+"\n"+
    photon_cut_flag+"\n"+
    update_geom_flag+"\n"+
    number_of_threads_flag+"\n"+
    init_geom_flag+"\n"+
    use_Bremspe_text_flag+"\n"+
    particle_kind+"\n"+
    particle_position_origin+"\n"+
    particle_distribution_type+"\n"+
    particle_position_sigma_values+"\n"+
    particle_position_half_values+"\n"+
    particle_direction+"\n"+
    particle_energy_values;
    vis_macro_script_linac_head= 
    z_coordinate_phase_space_flag+" cm\n"+
    name_of_h5_phase_space_file_flag+"\n"+
    name_of_geant_geom_from_text_flag+"\n"+
    positron_cut_flag+"\n"+
    electron_cut_flag+"\n"+
    photon_cut_flag+"\n"+
    update_geom_flag+"\n"+
            "/run/numberOfThreads 1"+"\n"+
    init_geom_flag+"\n"+
    use_Bremspe_text_flag+"\n"+
    particle_kind+"\n"+
    particle_position_origin+"\n"+
    particle_distribution_type+"\n"+
    particle_position_sigma_values+"\n"+
    particle_position_half_values+"\n"+
    particle_direction+"\n"+
    particle_energy_values+"\n"+
    "\n/run/geometryModified\n" +
    "/run/initialize\n" +
 "/vis/open OGL 600x600-0+0\n" +
"/vis/drawVolume";
   
    }
    private void jMenuItem_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem_exitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        _settings.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_SettingsActionPerformed

    }//GEN-LAST:event_jMenu_SettingsActionPerformed
void execute_command(String _command){
try {
String outputLineFromCommand;
Process process = Runtime.getRuntime().exec(_command);
BufferedReader errorStream;
try ( // Capture the output
BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
// Get the output of the process
while ((outputLineFromCommand = inputStream.readLine()) != null) {
// This will be displayed in the console...
System.out.println("\n"+outputLineFromCommand);
}
}
// Same for errors, if any
while ((outputLineFromCommand = errorStream.readLine()) != null) {
System.out.println("\n"+outputLineFromCommand);
}
errorStream.close();
process.waitFor();
} catch (IOException | InterruptedException | HeadlessException err) {
}
}
    private void btn_build_g4linac_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_build_g4linac_headActionPerformed
    index=1;

java.awt.EventQueue.invokeLater(() -> {
g4linac_mt_console.setText("");
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
PrintStream printStream = new PrintStream(_custom_output_stream);
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
save_parameters_linac_head(
etxt_number_of_threads.getText()+
"\n"+etxt_number_of_events_per_thread.getText()+
"\n"+ext_z_stop.getText()+
"\n"+etxt_h5_phase_space_name.getText()+
"\n"+etxt_geom_file.getText()+
"\n"+check_box_enable_bremspe.isSelected()+
"\n"+etxt_number_of_fractionnement.getText()+
"\n"+combo_box_type_of_particle.getSelectedItem().toString()+
"\n"+etext_dir_x.getText()+
"\n"+etext_dir_y.getText()+
"\n"+etext_dir_z.getText()+
"\n"+_POS_X_G4LINAC_HEAD.getText()+
"\n"+etext_pos_y.getText()+
"\n"+etext_pos_z.getText()+
"\n"+etext_half_x.getText()+
"\n"+etext_half_y.getText()+
"\n"+etext_sigma_x.getText()+
"\n"+etext_sigma_y.getText()+
"\n"+_PHOTON_CUT_G4LINAC_HEAD.getText()+
"\n"+_ELECTRON_CUT_G4LINAC_HEAD.getText()+
"\n"+_POSITRON_CUT_G4LINAC_HEAD.getText()+
"\n"+etext_mono_energy.getText()+
"\n"+etxt_sigma_energy.getText()
);     
GetConfiguration();
construct_run_macro_script_for_linac_head();
save_run_macro_script_file(run_macro_script_linac_head,g4linac_installation_dir+"/G4Linac_Head/run.mac");
save_vis_macro_script_file(vis_macro_script_linac_head,g4linac_installation_dir+"/G4Linac_Head/vis.mac");
String run_g4linac_head;
run_g4linac_head = g4linac_installation_dir+"/G4Linac_Head/scripts/g4linac_head_build.sh "+
g4linac_installation_dir+" "+geant4_installation_dir;
execute_command(run_g4linac_head);
_custom_output_stream.Dump();
showMessageDialog(g4linac_mt_gui.this.getParent(), "The project G4Linac_Had has been successfully built ! ", "G4Linac_MT_GUI", JOptionPane.INFORMATION_MESSAGE);
});
    }//GEN-LAST:event_btn_build_g4linac_headActionPerformed
@SuppressWarnings("empty-statement")
void copyGeomFile(String source_dir){

String Target_content="";
try    {  
File fileDir = new File(source_dir);
try (BufferedReader in = new BufferedReader(
new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
String str;
while ((str = in.readLine()) != null) {
Target_content=Target_content+"\n"+str;
}
}        
} catch (Exception  ex) {System.out.print(ex);}     
try {
GetConfiguration();
String target_dir=g4linac_installation_dir + "/G4Linac_Head/scripts/linac.geom";
 //System.out.println(target_dir);
FileWriter lu = new FileWriter(target_dir);
try (BufferedWriter fluxS = new BufferedWriter(lu) 
) {
fluxS.write(Target_content); 
fluxS.close(); 
} 
} catch (IOException er) {}
}
    private void btn_geom_file_loaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_geom_file_loaderActionPerformed
    JFileChooser fc = new JFileChooser(g4linac_installation_dir + "/G4Linac_Head"); 
    fc.setDialogTitle("Open an exsisting Geant4 Geometry from Text file");
    fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
    fc.setCurrentDirectory(new File (g4linac_installation_dir + "/G4Linac_Head"));
    int returnVal = fc.showOpenDialog(this);
    if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
    java.io.File file = fc.getSelectedFile( );
    etxt_geom_file.setText( file.toString( ));      
    JOptionPane.showMessageDialog(this, "The file entitled '"+file.getName()+"' has been successfully saved ! ");
    copyGeomFile(file.toString( ));  
    }        
    }//GEN-LAST:event_btn_geom_file_loaderActionPerformed

    private void BTN_CLEAR__G4LINAC_HEADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CLEAR__G4LINAC_HEADActionPerformed
        g4linac_mt_console.setText("");
    }//GEN-LAST:event_BTN_CLEAR__G4LINAC_HEADActionPerformed

    private void btn_debug_g4linac_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_debug_g4linac_headActionPerformed

        java.awt.EventQueue.invokeLater(() -> {

        g4linac_mt_console.setText("");


 custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
 PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
GetConfiguration();
construct_run_macro_script_for_linac_head();
save_run_macro_script_file(run_macro_script_linac_head,g4linac_installation_dir+"/G4Linac_Head/run.mac");
String _command=g4linac_installation_dir+"/G4Linac_Head/scripts/g4linac_head_debug.sh "+
g4linac_installation_dir+" "+geant4_installation_dir+" "+valgrind_installation_dir;
execute_command(_command);
_custom_output_stream.Dump();
});

    }//GEN-LAST:event_btn_debug_g4linac_headActionPerformed

    private void btn_view_geom_g4linac_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_view_geom_g4linac_headActionPerformed
g4linac_mt_console.setText("");
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
 PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
 _custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
 GetConfiguration();
 construct_run_macro_script_for_linac_head();
save_run_macro_script_file(run_macro_script_linac_head,g4linac_installation_dir+"/G4Linac_Head/run.mac");
String _command=g4linac_installation_dir+"/G4Linac_Head/scripts/g4linac_head_vis.sh "+g4linac_installation_dir+" "+geant4_installation_dir;
 execute_command(_command);
 _custom_output_stream.Dump();

    }//GEN-LAST:event_btn_view_geom_g4linac_headActionPerformed
@SuppressWarnings("empty-statement")
        
void save_parameters_dosecal(String _content){
    try {
    String app_dir=  getJarContainingFolder(g4linac_mt_gui.class);  
   String  parameters_dosecal_file= app_dir+"/linac_dosecal.param";   
 
                    FileWriter lu = new FileWriter(parameters_dosecal_file);
    try (BufferedWriter fluxS = new BufferedWriter(lu) 
    ) {
        fluxS.write(_content); 

        fluxS.close(); 
    } 
     } catch (Exception er) {}
   
      showMessageDialog(this.getParent(), "The parameters of the last configuration of dosecal has been successfully saved ! ", "G4Linac_MT", JOptionPane.INFORMATION_MESSAGE) ;           
}
void save_parameters_linac_head(String _content){

    try {
 String app_dir=  getJarContainingFolder(g4linac_mt_gui.class);  
String  parameters_linac_head_file= app_dir+"/linac_head.param";
FileWriter lu = new FileWriter(parameters_linac_head_file);
    try (BufferedWriter fluxS = new BufferedWriter(lu) 
    ) {
        fluxS.write(_content); 

        fluxS.close(); 
    } 
     } catch (Exception er) {}
   
      showMessageDialog(this.getParent(), "The parameters of the last configuration of head has been successfully saved ! ", "G4Linac_MT", JOptionPane.INFORMATION_MESSAGE) ;      

      


}
     void load_parameters_linac_dosecal(){
     
         try    {  
    String app_dir=  getJarContainingFolder(g4linac_mt_gui.class);  
   String  parameters_linac_head_file= app_dir+"/linac_dosecal.param";
   
   
  File fileDir = new File(parameters_linac_head_file);

        try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
            int i=0;
        String str;
        while ((str = in.readLine()) != null) {
            i++;
            if (i==1) {etxt_thread_number.setText(str);}
            if (i==2) {etxt_z_stop_new.setText(str);}
            if (i==3) {h5_phsp_name.setText(str);}
            if (i==4) {etxt_voxalized_phantom_size_x.setText(str);}
            if (i==5) {etxt_voxalized_phantom_size_y.setText(str);}
            if (i==6) {etxt_voxalized_phantom_size_z.setText(str);}
            if (i==7) {etxt_nvoxel_x.setText(str);}
            if (i==8) {etxt_nvoxel_y.setText(str);}
            if (i==9) {etxt_nvoxel_z.setText(str);}
            if (i==10) {combo_box_vrt.setSelectedItem(str);}
            if (i==11) {etxt_n_frac.setText(str);}
            if (i==12) {etxt_cut_photon.setText(str);}
            if (i==13) {etxt_cut_electron.setText(str);}
            if (i==14) {etxt_cut_positron.setText(str);}
            if (i==15) {readout_x_position.setText(str);}
            if (i==16) {readout_y_position.setText(str);}
            if (i==17) {readout_z_position.setText(str);}
            if (i==18) {etxt_geom_from_text.setText(str);}
            if (i==19) {  if ("true".equals(str))rotation_gantry_flag.setSelected(true);  }
            if (i==20) {etxt_gantry_rotation_angle.setText(str);  }
            if (i==21) {  if ("true".equals(str))rot_colimator_flag.setSelected(true);  }
            if (i==22) {etext_collimator_rotation.setText(str);  }
            if (i==23) {  if ("true".equals(str))add_step_max_flag.setSelected(true);  }
            if (i==24) {etxt_step_max_value.setText(str);  }
         
}
        }
 } catch (Exception  ex) {System.out.print(ex);}
showMessageDialog(this.getParent(), "The linac configuration has been successfully loaded ! ", "G4Linac_MT", JOptionPane.INFORMATION_MESSAGE) ;          }
   
     void load_summary(){
          custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
 PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
 _custom_output_stream.Clean();
         String file_name="";
        if (index==1) {
      file_name=g4linac_installation_dir+"/bin_G4Linac_Head/"+ etxt_h5_phase_space_name.getText()+".summary";
        }
        else if (index==2){
        
              file_name=g4linac_installation_dir+"/bin_G4Linac_DoseCal/"+"dose.txt";

        }
  File fileDir = new File(file_name);
String  content="";
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
            int i=0;
        String str;
        while ((str = in.readLine()) != null) {
             content=content+str+"\n";

         }
         g4linac_mt_console.setText(content);
      
        } catch (Exception  ex) {
            
        }
        }
     
 void load_parameters_linac_head(){
 try   
 {  
String app_dir=  getJarContainingFolder(g4linac_mt_gui.class);  
String  parameters_linac_head_file= app_dir+"/linac_head.param";   
File fileDir = new File(parameters_linac_head_file);
try (BufferedReader in = new BufferedReader(
new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) 
{
            int i=0;
        String str;
        while ((str = in.readLine()) != null) {
            i++;
            if (i==1) {etxt_number_of_threads.setText(str);}
            if (i==2) {etxt_number_of_events_per_thread.setText(str);}
            if (i==3) {ext_z_stop.setText(str);}
            if (i==4) {etxt_h5_phase_space_name.setText(str);}
            if (i==5) {etxt_geom_file.setText(str);}
            if (i==6) { if ("true".equals(str))check_box_enable_bremspe.setSelected(true);}
            if (i==7) { etxt_number_of_fractionnement.setText(str);}
            if (i==8) {combo_box_type_of_particle.setSelectedItem(str);}
            if (i==9) {etext_dir_x.setText(str);}
            if (i==10) {etext_dir_y.setText(str);}
            if (i==11) {etext_dir_z.setText(str);}
            if (i==12) {_POS_X_G4LINAC_HEAD.setText(str);}
            if (i==13) {etext_pos_y.setText(str);}
            if (i==14) {etext_pos_z.setText(str);}
            if (i==15) {etext_half_x.setText(str);}
            if (i==16) {etext_half_y.setText(str);}
            if (i==17) {etext_sigma_x.setText(str);}
            if (i==18) {etext_sigma_y.setText(str);}
            if (i==19) {_PHOTON_CUT_G4LINAC_HEAD.setText(str);}
            if (i==20) {_ELECTRON_CUT_G4LINAC_HEAD.setText(str);}
            if (i==21) {_POSITRON_CUT_G4LINAC_HEAD.setText(str);}
            if (i==22) {etext_mono_energy.setText(str);}
            if (i==23) {etxt_sigma_energy.setText(str);}
}  
        }
 } catch (Exception  ex) {;}

      showMessageDialog(this.getParent(), "The linac configuration has been successfully loaded ! ", "G4Linac_MT", JOptionPane.INFORMATION_MESSAGE) ;      
}
 
    private void btn_start_g4linac_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_start_g4linac_headActionPerformed
java.awt.EventQueue.invokeLater(() -> {
    g4linac_mt_console.setText("");
    custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
    PrintStream printStream = new PrintStream(_custom_output_stream);
    System.setOut(printStream);
    System.setErr(printStream);
    _custom_output_stream.Clean();
    DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    GetConfiguration();
    construct_run_macro_script_for_linac_head();
    save_run_macro_script_file(run_macro_script_linac_head,g4linac_installation_dir+"/G4Linac_Head/run.mac");
    String _command=g4linac_installation_dir+"/G4Linac_Head/scripts/g4linac_head_start.sh "+
            g4linac_installation_dir+" "+geant4_installation_dir;
    execute_command(_command);
    _custom_output_stream.Dump();
});
    }//GEN-LAST:event_btn_start_g4linac_headActionPerformed

    private void btn_load_param_g4linac_headActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_load_param_g4linac_headActionPerformed


        g4linac_mt_console.setText("");
PrintStream printStream = new PrintStream(new custom_output_stream(g4linac_mt_console));      
System.setOut(printStream);
System.setErr(printStream);
load_parameters_linac_head();
    }//GEN-LAST:event_btn_load_param_g4linac_headActionPerformed

    private void etxt_cut_positronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etxt_cut_positronActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etxt_cut_positronActionPerformed

    private void readout_y_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readout_y_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readout_y_positionActionPerformed

    private void readout_z_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readout_z_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readout_z_positionActionPerformed

    private void button_open_geom_file1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_open_geom_file1ActionPerformed
JFileChooser fc = new JFileChooser(); 
    fc.setDialogTitle("Open an exsisting Geant4 Geometry from Text file");
    fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
    int returnVal = fc.showOpenDialog(this);
    if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
    java.io.File file = fc.getSelectedFile( );
    etxt_geom_from_text.setText( file.toString( ));      
    JOptionPane.showMessageDialog(this, "The file entitled '"+file.getName()+"' has been successfully saved ! ");
    copyGeomFile(file.toString( ));  
    }             // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_button_open_geom_file1ActionPerformed

    private void btn_h5_phase_space_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_h5_phase_space_nameActionPerformed
JFileChooser fc = new JFileChooser(); 
        fc.setDialogTitle("Open an exsisting h5PhaseSpace file");
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
        h5_phsp_name.setText( file.toString( )); 
         
             showMessageDialog(this.getParent(),"The file entitled '"+file.getName()+"' has been successfully opened ! ", "G4Linac_MT", JOptionPane.INFORMATION_MESSAGE) ;      

        }
        
        
              
        
        
    }//GEN-LAST:event_btn_h5_phase_space_nameActionPerformed

    private void BUILD_G4LINAC_DOSECALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUILD_G4LINAC_DOSECALActionPerformed
java.awt.EventQueue.invokeLater(() -> {    
g4linac_mt_console.setText("");
index=2;
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
 DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        save_parameters_dosecal(
etxt_thread_number.getText()+"\n"+
etxt_z_stop_new.getText()+"\n"+
h5_phsp_name.getText()+"\n"+
etxt_voxalized_phantom_size_x.getText()+"\n"+
etxt_voxalized_phantom_size_y.getText()+"\n"+
etxt_voxalized_phantom_size_z.getText()+"\n" +
etxt_nvoxel_x.getText()+"\n"+
etxt_nvoxel_y.getText()+"\n"+
etxt_nvoxel_z.getText()+"\n"+
combo_box_vrt.getSelectedItem().toString()+"\n"+
etxt_n_frac.getText()+"\n"+
etxt_cut_photon.getText()+"\n"+
etxt_cut_electron.getText()+"\n"+
etxt_cut_positron.getText()+"\n"+
readout_x_position.getText()+"\n"+
readout_y_position.getText()+"\n"+
readout_z_position.getText()+"\n" +
etxt_geom_from_text.getText()+"\n"+
rotation_gantry_flag.isSelected()+"\n"+etxt_gantry_rotation_angle.getText()+"\n"+
rot_colimator_flag.isSelected()+"\n"+
etext_collimator_rotation.getText()+"\n"+
add_step_max_flag.isSelected()+"\n"+
etxt_step_max_value.getText());
GetConfiguration();
construct_run_macro_script_for_dose_cal();
save_run_macro_script_file(macro_script_for_dose_cal,g4linac_installation_dir+"/G4Linac_DoseCal/run.mac");
save_vis_macro_script_file(vis_macro_script_dose_cal,g4linac_installation_dir+"/G4Linac_DoseCal/vis.mac");
execute_command( "chmod +x "+g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_vis.sh");
execute_command( "chmod +x "+g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_start.sh");
execute_command( "chmod +x "+g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_build.sh");
execute_command( "chmod +x "+g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_debug.sh");
String run_g4linac_dosecal=g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_build.sh "+g4linac_installation_dir+" "+geant4_installation_dir;
execute_command(run_g4linac_dosecal);
_custom_output_stream.Dump();
showMessageDialog(this.getParent(), "The G4Linac_DoseCal module has been successfully built ! ", "G4Linac_MT_GUI", JOptionPane.INFORMATION_MESSAGE) ;
});      
                
              }//GEN-LAST:event_BUILD_G4LINAC_DOSECALActionPerformed

    private void VIEW_GEOM_G4LINAC_DOSECALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEW_GEOM_G4LINAC_DOSECALActionPerformed

  g4linac_mt_console.setText("");
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
 PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
GetConfiguration();
construct_run_macro_script_for_linac_head();
save_run_macro_script_file(macro_script_for_dose_cal,g4linac_installation_dir+"/G4Linac_DoseCal/run.mac");
String _command=g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_vis.sh "+
g4linac_installation_dir+" "+geant4_installation_dir;
execute_command(_command);
_custom_output_stream.Dump();

    }//GEN-LAST:event_VIEW_GEOM_G4LINAC_DOSECALActionPerformed

    private void START_G4LINAC_DOSECALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_START_G4LINAC_DOSECALActionPerformed
java.awt.EventQueue.invokeLater(() -> {
g4linac_mt_console.setText("");
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
 _custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
GetConfiguration();
construct_run_macro_script_for_linac_head();
save_run_macro_script_file(macro_script_for_dose_cal,g4linac_installation_dir+"/G4Linac_DoseCal/run.mac");
String _command=g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_start.sh "+
g4linac_installation_dir+" "+geant4_installation_dir;
execute_command(_command);
_custom_output_stream.Dump();

});
    }//GEN-LAST:event_START_G4LINAC_DOSECALActionPerformed

    private void DEBUG_G4LINAC_DOSECALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DEBUG_G4LINAC_DOSECALActionPerformed
java.awt.EventQueue.invokeLater(() -> {
g4linac_mt_console.setText("");
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
GetConfiguration();
construct_run_macro_script_for_linac_head();
save_run_macro_script_file(macro_script_for_dose_cal,g4linac_installation_dir+"/G4Linac_DoseCal/run.mac");
String _command=g4linac_installation_dir+"/G4Linac_DoseCal/scripts/g4linac_dosecal_debug.sh "+
g4linac_installation_dir+" "+geant4_installation_dir+" "+valgrind_installation_dir;
execute_command(_command);
_custom_output_stream.Dump();
});
    }//GEN-LAST:event_DEBUG_G4LINAC_DOSECALActionPerformed

    private void LOAD_PARAM_G4LINAC_DOSE_CALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOAD_PARAM_G4LINAC_DOSE_CALActionPerformed
g4linac_mt_console.setText("");
index=2;
load_parameters_linac_dosecal();
    }//GEN-LAST:event_LOAD_PARAM_G4LINAC_DOSE_CALActionPerformed

    private void jMenuItem_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_aboutActionPerformed
 _aboutme.show();
     
    }//GEN-LAST:event_jMenuItem_aboutActionPerformed

    private void btn_get_itActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_get_itActionPerformed
custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
DefaultCaret caret = (DefaultCaret) g4linac_mt_console.getCaret();
caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
GetConfiguration();
execute_command( "chmod +x "+g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/phase_space.sh");
physics_quantity =_HISTO_CHOICE_G4LINAC_DATA_ANALYSIS.getSelectedItem().toString();
h5phase_space_path=_PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS.getText();
String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/phase_space.sh "+
g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ physics_quantity+" "+ h5phase_space_path;
execute_command(run_g4linac_data_analysis);
_custom_output_stream.Dump();

    }//GEN-LAST:event_btn_get_itActionPerformed

    private void _HISTO_CHOICE_G4LINAC_DATA_ANALYSISActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__HISTO_CHOICE_G4LINAC_DATA_ANALYSISActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__HISTO_CHOICE_G4LINAC_DATA_ANALYSISActionPerformed

    private void button_open_geom_file_G4LINAC_DOSECAL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_open_geom_file_G4LINAC_DOSECAL1ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select an h5PhaseSpace file");
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
            _PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS.setText( file.toString( ));
             showMessageDialog(this.getParent(),"The h5PhaseSpace file entitled '"+file.getName()+"' has been successfully selected ! "
, "G4Linac_MT", JOptionPane.INFORMATION_MESSAGE) ;      

        }

    }//GEN-LAST:event_button_open_geom_file_G4LINAC_DOSECAL1ActionPerformed

    private void select_dosimetric_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_dosimetric_fileActionPerformed
JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select an dosimetric file");
        fc.setFileSelectionMode( JFileChooser.FILES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File file = fc.getSelectedFile( );
        _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.setText( file.toString( ));
        JOptionPane.showMessageDialog(this, "The dosimetric file entitled '"+file.getName()+"' has been successfully selected ! ");
        }

    }//GEN-LAST:event_select_dosimetric_fileActionPerformed

    private void axisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axisActionPerformed

lbl_a.setText(axis.getSelectedItem().toString()+"_ID");

lbl_a.setVisible(true);
        
    }//GEN-LAST:event_axisActionPerformed

    private void btn_get_it_for_dosimetricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_get_it_for_dosimetricActionPerformed
g4linac_mt_console.setText("");
        custom_output_stream _custom_output_stream=       new custom_output_stream(g4linac_mt_console);
 PrintStream printStream = new PrintStream(_custom_output_stream);  
System.setOut(printStream);
System.setErr(printStream);
_custom_output_stream.Clean();
GetConfiguration();
axis_flag= axis.getSelectedItem().toString();
execute_command( "chmod +x "+g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh");
physics_quantity =_HISTO_CHOICE_G4LINAC_DATA_ANALYSIS.getSelectedItem().toString();
    
          // GET Percentage_Depth_Dose_Curve
 if (Dosimetric_functions.getSelectedItem().toString().equals("Percentage_Depth_Dose_Curve")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ 
             a.getText()+" "+b.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }
        
      
        
            // GET PROFILE  ALONG X AND Y AXIS
        if (Dosimetric_functions.getSelectedItem().toString().equals("Percentage_Depth_Dose_Curve_Rsd")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ 
             a.getText()+" "+b.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }
      
      
            // GET PROFILE  ALONG X AND Y AXIS
        if (Dosimetric_functions.getSelectedItem().toString().equals("Cross-plane_Dose_Profile")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ 
             a.getText()+" "+b.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }  
     
       
       
            // GET PROFILE  ALONG X AND Y AXIS
        if (Dosimetric_functions.getSelectedItem().toString().equals("Cross-plane_Dose_Profile_Rsd")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ 
             a.getText()+" "+b.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }  
     
             // GET PROFILE  ALONG X AND Y AXIS
        if (Dosimetric_functions.getSelectedItem().toString().equals("In-plane_Dose_Profile")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ 
             a.getText()+" "+b.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }  
        
        
        
             // GET PROFILE  ALONG X AND Y AXIS
        if (Dosimetric_functions.getSelectedItem().toString().equals("In-plane_Dose_Profile_Rsd")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ 
             a.getText()+" "+b.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }  
        
            // GET PROFILE  ALONG X AND Y AXIS
        if (Dosimetric_functions.getSelectedItem().toString().equals("2D_Dose_HeatMap")){
       
            String dosimetric_command=  _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS.getText()+" "+  Dosimetric_functions.getSelectedItem().toString()+     " "+ axis.getSelectedItem().toString()+" "
           + axis.getSelectedItem().toString()+" " + a.getText();

        String run_g4linac_data_analysis=g4linac_installation_dir+"/G4Linac_DataAnalysis/scripts/dosimetric.sh "+
        g4linac_installation_dir+" "+geant4_installation_dir+" "+ root_installation_dir+" "+ dosimetric_command;

        execute_command(run_g4linac_data_analysis); 
       
       
       }
       _custom_output_stream.Dump();
 
    }//GEN-LAST:event_btn_get_it_for_dosimetricActionPerformed
public static String getJarContainingFolder(Class aclass) throws Exception {
CodeSource codeSource = aclass.getProtectionDomain().getCodeSource();
File jarFile;
if (codeSource.getLocation() != null) {
jarFile = new File(codeSource.getLocation().toURI());
} else {
String path = aclass.getResource(aclass.getSimpleName() + ".class").getPath();
String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
jarFile = new File(jarFilePath);
}
return jarFile.getParentFile().getAbsolutePath();
}

    private void btn_summaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_summaryActionPerformed


        load_summary();


    }//GEN-LAST:event_btn_summaryActionPerformed

    private void BTN_SAVE_OUTPUT_G4LINAC_HEADActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SAVE_OUTPUT_G4LINAC_HEADActionPerformed

        JFileChooser fc = new JFileChooser(); 
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setDialogTitle("Save output in a file ");
        //fc.setFileSelectionMode( JFileChooser.);
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = fc.getSelectedFile( );
        etxt_geom_file.setText( file.toString( )); 
       
                    FileWriter lu = null;
            try {
                lu = new FileWriter(file.toString( ));
            } catch (IOException ex) {
                Logger.getLogger(g4linac_mt_gui.class.getName()).log(Level.SEVERE, null, ex);
            }
    try (BufferedWriter fluxS = new BufferedWriter(lu) 
    ) {
        fluxS.write(g4linac_mt_console.getText()); 

        fluxS.close(); 
    }       catch (IOException ex) { 
                Logger.getLogger(g4linac_mt_gui.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } 
    }//GEN-LAST:event_BTN_SAVE_OUTPUT_G4LINAC_HEADActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        _geomModeling.show();
            _geomModeling.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void Dosimetric_functionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dosimetric_functionsActionPerformed
          // TODO add your handling code here:
        String selected_value= Dosimetric_functions.getSelectedItem().toString();
    switch (selected_value) {
        case "Percentage_Depth_Dose_Curve":
            axis.setVisible(false);
            lbl_axis.setVisible(false);
            lbl_a.setText("X_ID ");
            lbl_b.setText("Y_ID ");
            lbl_b.setVisible(true)  ;
            b.setVisible(true);
            axis_flag="";
            break;
        case "Percentage_Depth_Dose_Curve_Rsd":
            axis.setVisible(false);
            lbl_axis.setVisible(false);
            lbl_a.setText("X_ID ");
            lbl_b.setText("Y_ID ");
            lbl_b.setVisible(true)  ;
            b.setVisible(true);
                        axis_flag="";

            break;
        case "Cross-plane_Dose_Profile":
            axis.setVisible(false);
            lbl_axis.setVisible(false);
            lbl_a.setText("Y_ID ");
            lbl_b.setText("Z_ID ");
            lbl_b.setVisible(true)  ;
            b.setVisible(true);
                        axis_flag="";

            break;
        case "Cross-plane_Dose_Profile_Rsd":
            axis.setVisible(false);
            lbl_axis.setVisible(false);
            lbl_a.setText("Y_ID ");
            lbl_b.setText("Z_ID ");
            lbl_b.setVisible(true)  ;
            b.setVisible(true);
                        axis_flag="";

            break;
        case "In-plane_Dose_Profile":
            axis.setVisible(false);
            lbl_axis.setVisible(false);
            lbl_a.setText("X_ID ");
            lbl_b.setText("Z_ID ");
            lbl_b.setVisible(true)  ;
            b.setVisible(true);
                        axis_flag="";

            break;
        case "In-plane_Dose_Profile_Rsd":
            axis.setVisible(false);
            lbl_axis.setVisible(false);
            lbl_a.setText("X_ID ");
            lbl_b.setText("Z_ID ");
            lbl_b.setVisible(true)  ;
            b.setVisible(true);
                        axis_flag="";

            break;
        case "2D_Dose_HeatMap":
            axis.setVisible(true);
            lbl_a.setText(axis.getSelectedItem().toString());
            lbl_b.setVisible(false)  ;
            b.setVisible(false);
                        axis_flag=axis.getSelectedItem().toString();

            break;
        default:
            break;
    }

    }//GEN-LAST:event_Dosimetric_functionsActionPerformed

    private void btn_load_param_g4linac_headMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_load_param_g4linac_headMouseEntered
        // TODO add your handling code here:
                        btn_load_param_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                              btn_load_param_g4linac_head.setFont(new Font("Serif",Font.BOLD,15));


    }//GEN-LAST:event_btn_load_param_g4linac_headMouseEntered

    private void btn_load_param_g4linac_headMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_load_param_g4linac_headMouseExited
                btn_load_param_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                      btn_load_param_g4linac_head.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_load_param_g4linac_headMouseExited

    private void btn_build_g4linac_headMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_build_g4linac_headMouseEntered
              btn_build_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                    btn_build_g4linac_head.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_build_g4linac_headMouseEntered

    private void btn_build_g4linac_headMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_build_g4linac_headMouseExited
             btn_build_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                   btn_build_g4linac_head.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_build_g4linac_headMouseExited

    private void btn_view_geom_g4linac_headMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_view_geom_g4linac_headMouseEntered
                         btn_view_geom_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                               btn_view_geom_g4linac_head.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_view_geom_g4linac_headMouseEntered

    private void btn_view_geom_g4linac_headMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_view_geom_g4linac_headMouseExited
                btn_view_geom_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                      btn_view_geom_g4linac_head.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_view_geom_g4linac_headMouseExited

    private void btn_start_g4linac_headMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_start_g4linac_headMouseEntered
                    btn_start_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                          btn_start_g4linac_head.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_start_g4linac_headMouseEntered

    private void btn_start_g4linac_headMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_start_g4linac_headMouseExited
             btn_start_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);    
             btn_start_g4linac_head.setFont(new Font("Serif",Font.BOLD,12));

             
    }//GEN-LAST:event_btn_start_g4linac_headMouseExited

    private void btn_debug_g4linac_headMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_debug_g4linac_headMouseEntered
                      btn_debug_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                            btn_debug_g4linac_head.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_debug_g4linac_headMouseEntered

    private void btn_debug_g4linac_headMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_debug_g4linac_headMouseExited
                btn_debug_g4linac_head.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                      btn_debug_g4linac_head.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_debug_g4linac_headMouseExited

    private void BTN_SAVE_OUTPUT_G4LINAC_HEADMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_SAVE_OUTPUT_G4LINAC_HEADMouseEntered
                  BTN_SAVE_OUTPUT_G4LINAC_HEAD.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
              BTN_SAVE_OUTPUT_G4LINAC_HEAD.setFont(new Font("Serif",Font.BOLD,15));
          
    }//GEN-LAST:event_BTN_SAVE_OUTPUT_G4LINAC_HEADMouseEntered

    private void BTN_SAVE_OUTPUT_G4LINAC_HEADMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_SAVE_OUTPUT_G4LINAC_HEADMouseExited
                        BTN_SAVE_OUTPUT_G4LINAC_HEAD.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
      BTN_SAVE_OUTPUT_G4LINAC_HEAD.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_BTN_SAVE_OUTPUT_G4LINAC_HEADMouseExited

    private void BTN_CLEAR__G4LINAC_HEADMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_CLEAR__G4LINAC_HEADMouseEntered
                BTN_CLEAR__G4LINAC_HEAD.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
             BTN_CLEAR__G4LINAC_HEAD.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_BTN_CLEAR__G4LINAC_HEADMouseEntered

    private void BTN_CLEAR__G4LINAC_HEADMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_CLEAR__G4LINAC_HEADMouseExited
                    BTN_CLEAR__G4LINAC_HEAD.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                   BTN_CLEAR__G4LINAC_HEAD.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_BTN_CLEAR__G4LINAC_HEADMouseExited

    private void btn_summaryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_summaryMouseEntered
                     btn_summary.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                    btn_summary.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_summaryMouseEntered

    private void btn_summaryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_summaryMouseExited
                       btn_summary.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                      btn_summary.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_summaryMouseExited
//
    private void btn_get_itMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_get_itMouseEntered
                     btn_get_it.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                     btn_get_it.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_get_itMouseEntered

    private void btn_get_itMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_get_itMouseExited
                     btn_get_it.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                    btn_get_it.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_get_itMouseExited

    private void btn_get_it_for_dosimetricMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_get_it_for_dosimetricMouseEntered
                    btn_get_it_for_dosimetric.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                   btn_get_it_for_dosimetric.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_btn_get_it_for_dosimetricMouseEntered

    private void btn_get_it_for_dosimetricMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_get_it_for_dosimetricMouseExited
                    btn_get_it_for_dosimetric.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                    btn_get_it_for_dosimetric.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_btn_get_it_for_dosimetricMouseExited

    private void LOAD_PARAM_G4LINAC_DOSE_CALMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOAD_PARAM_G4LINAC_DOSE_CALMouseEntered
                    LOAD_PARAM_G4LINAC_DOSE_CAL.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                    LOAD_PARAM_G4LINAC_DOSE_CAL.setFont(new Font("Serif",Font.BOLD,15));
                    
    }//GEN-LAST:event_LOAD_PARAM_G4LINAC_DOSE_CALMouseEntered

    private void LOAD_PARAM_G4LINAC_DOSE_CALMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LOAD_PARAM_G4LINAC_DOSE_CALMouseExited
                   LOAD_PARAM_G4LINAC_DOSE_CAL.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                   LOAD_PARAM_G4LINAC_DOSE_CAL.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_LOAD_PARAM_G4LINAC_DOSE_CALMouseExited

    private void BUILD_G4LINAC_DOSECALMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUILD_G4LINAC_DOSECALMouseEntered
                    BUILD_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                    BUILD_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_BUILD_G4LINAC_DOSECALMouseEntered

    private void BUILD_G4LINAC_DOSECALMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BUILD_G4LINAC_DOSECALMouseExited
                   BUILD_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                   BUILD_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_BUILD_G4LINAC_DOSECALMouseExited

    private void VIEW_GEOM_G4LINAC_DOSECALMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIEW_GEOM_G4LINAC_DOSECALMouseEntered
                         VIEW_GEOM_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                         VIEW_GEOM_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,15));


    }//GEN-LAST:event_VIEW_GEOM_G4LINAC_DOSECALMouseEntered

    private void VIEW_GEOM_G4LINAC_DOSECALMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VIEW_GEOM_G4LINAC_DOSECALMouseExited
                   VIEW_GEOM_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                   VIEW_GEOM_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_VIEW_GEOM_G4LINAC_DOSECALMouseExited

    private void START_G4LINAC_DOSECALMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_START_G4LINAC_DOSECALMouseEntered
                 START_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                 START_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_START_G4LINAC_DOSECALMouseEntered

    private void START_G4LINAC_DOSECALMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_START_G4LINAC_DOSECALMouseExited
                    START_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                     START_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_START_G4LINAC_DOSECALMouseExited

    private void DEBUG_G4LINAC_DOSECALMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DEBUG_G4LINAC_DOSECALMouseEntered
                    DEBUG_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__SELECTED_STATE);
                    DEBUG_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,15));

    }//GEN-LAST:event_DEBUG_G4LINAC_DOSECALMouseEntered

    private void DEBUG_G4LINAC_DOSECALMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DEBUG_G4LINAC_DOSECALMouseExited
                     DEBUG_G4LINAC_DOSECAL.setBackground(BUTTON_BACKGROUD_COLOR__UNSELECTED_STATE);
                     DEBUG_G4LINAC_DOSECAL.setFont(new Font("Serif",Font.BOLD,12));

    }//GEN-LAST:event_DEBUG_G4LINAC_DOSECALMouseExited

    private void combo_box_vrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_box_vrtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_box_vrtActionPerformed

    private void etxt_n_fracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etxt_n_fracActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etxt_n_fracActionPerformed

    private void etxt_step_max_valueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etxt_step_max_valueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etxt_step_max_valueActionPerformed
void GetConfiguration(){


             try    {  
    String app_dir=  getJarContainingFolder(g4linac_mt_gui.class);  
  String  g4linac_mt_config= app_dir+"/g4linac_mt.conf";
   
  File fileDir = new File(g4linac_mt_config);
{
        try (BufferedReader in = new BufferedReader(
            new InputStreamReader( new FileInputStream(fileDir), "UTF8"))) {
        String str;
        int i=0;
        while ((str = in.readLine()) != null) {
            i++;
            switch (i) {
                case 1:
                    geant4_installation_dir=str;
                    break;
                case 2:
                    g4linac_installation_dir=str;
                    break;
                case 3:
                    root_installation_dir=str;
                    break;
                case 4:
                    valgrind_installation_dir=str;
                    break;
                case 5:
                    heprep_installation_dir=str;
                    break;
                default:
                    break;
            }


{
}
}
 }   }
 } catch (Exception  ex) {System.out.print(ex);}
        
        
} 
  
  
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
            java.util.logging.Logger.getLogger(g4linac_mt_gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            new g4linac_mt_gui().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_CLEAR__G4LINAC_HEAD;
    private javax.swing.JButton BTN_SAVE_OUTPUT_G4LINAC_HEAD;
    private javax.swing.JButton BUILD_G4LINAC_DOSECAL;
    private javax.swing.JButton DEBUG_G4LINAC_DOSECAL;
    private javax.swing.JComboBox<String> Dosimetric_functions;
    private javax.swing.JButton LOAD_PARAM_G4LINAC_DOSE_CAL;
    private javax.swing.JButton START_G4LINAC_DOSECAL;
    private javax.swing.JButton VIEW_GEOM_G4LINAC_DOSECAL;
    private javax.swing.JTextField _DOSIMETRIC_DATA_G4LINAC_DATA_ANALYSIS;
    private javax.swing.JTextField _ELECTRON_CUT_G4LINAC_HEAD;
    private javax.swing.JComboBox<String> _HISTO_CHOICE_G4LINAC_DATA_ANALYSIS;
    private javax.swing.JTextField _PHASE_SPACE_NAME_G4LINAC_DATA_ANALYSIS;
    private javax.swing.JTextField _PHOTON_CUT_G4LINAC_HEAD;
    private javax.swing.JComboBox<String> _POSITION_DIS_TYPE_G4LINAC_HEAD;
    private javax.swing.JTextField _POSITRON_CUT_G4LINAC_HEAD;
    private javax.swing.JTextField _POS_X_G4LINAC_HEAD;
    private javax.swing.JTextField a;
    private javax.swing.JCheckBox add_step_max_flag;
    private javax.swing.JComboBox<String> axis;
    private javax.swing.JTextField b;
    private javax.swing.JButton btn_build_g4linac_head;
    private javax.swing.JButton btn_debug_g4linac_head;
    private javax.swing.JButton btn_geom_file_loader;
    private javax.swing.JButton btn_get_it;
    private javax.swing.JButton btn_get_it_for_dosimetric;
    private javax.swing.JButton btn_h5_phase_space_name;
    private javax.swing.JButton btn_load_param_g4linac_head;
    private javax.swing.JButton btn_start_g4linac_head;
    private javax.swing.JButton btn_summary;
    private javax.swing.JButton btn_view_geom_g4linac_head;
    private javax.swing.JButton button_open_geom_file1;
    private javax.swing.JButton button_open_geom_file_G4LINAC_DOSECAL1;
    private javax.swing.JCheckBox check_box_enable_bremspe;
    private javax.swing.JComboBox<String> combo_box_energy;
    private javax.swing.JComboBox<String> combo_box_type_of_particle;
    private javax.swing.JComboBox<String> combo_box_vrt;
    private javax.swing.JTextField etext_collimator_rotation;
    private javax.swing.JTextField etext_dir_x;
    private javax.swing.JTextField etext_dir_y;
    private javax.swing.JTextField etext_dir_z;
    private javax.swing.JTextField etext_half_x;
    private javax.swing.JTextField etext_half_y;
    private javax.swing.JTextField etext_mono_energy;
    private javax.swing.JTextField etext_pos_y;
    private javax.swing.JTextField etext_pos_z;
    private javax.swing.JTextField etext_sigma_x;
    private javax.swing.JTextField etext_sigma_y;
    private javax.swing.JTextField etxt_cut_electron;
    private javax.swing.JTextField etxt_cut_photon;
    private javax.swing.JTextField etxt_cut_positron;
    private javax.swing.JTextField etxt_gantry_rotation_angle;
    private javax.swing.JTextField etxt_geom_file;
    private javax.swing.JTextField etxt_geom_from_text;
    private javax.swing.JTextField etxt_h5_phase_space_name;
    private javax.swing.JTextField etxt_n_frac;
    private javax.swing.JTextField etxt_number_of_events_per_thread;
    private javax.swing.JTextField etxt_number_of_fractionnement;
    private javax.swing.JTextField etxt_number_of_threads;
    private javax.swing.JTextField etxt_nvoxel_x;
    private javax.swing.JTextField etxt_nvoxel_y;
    private javax.swing.JTextField etxt_nvoxel_z;
    private javax.swing.JTextField etxt_sigma_energy;
    private javax.swing.JTextField etxt_step_max_value;
    private javax.swing.JTextField etxt_thread_number;
    private javax.swing.JTextField etxt_voxalized_phantom_size_x;
    private javax.swing.JTextField etxt_voxalized_phantom_size_y;
    private javax.swing.JTextField etxt_voxalized_phantom_size_z;
    private javax.swing.JTextField etxt_z_stop_new;
    private javax.swing.JTextField ext_z_stop;
    private javax.swing.JTextArea g4linac_mt_console;
    private javax.swing.JTextField h5_phsp_name;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem_about;
    private javax.swing.JMenuItem jMenuItem_exit;
    private javax.swing.JMenu jMenu_Settings;
    private javax.swing.JMenu jMenu_file;
    private javax.swing.JMenu jMenu_geom_modeling;
    private javax.swing.JMenu jMenu_help;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_a;
    private javax.swing.JLabel lbl_axis;
    private javax.swing.JLabel lbl_b;
    private javax.swing.JLabel lbl_cut;
    private javax.swing.JLabel lbl_cut_production;
    private javax.swing.JLabel lbl_direction_of_particle;
    private javax.swing.JLabel lbl_enable_bremspe;
    private javax.swing.JLabel lbl_energy;
    private javax.swing.JLabel lbl_energy_type;
    private javax.swing.JLabel lbl_geom_file;
    private javax.swing.JLabel lbl_geom_from_text;
    private javax.swing.JLabel lbl_h5_phase_space_name;
    private javax.swing.JLabel lbl_h5_phsp_file_name;
    private javax.swing.JLabel lbl_half_pos;
    private javax.swing.JLabel lbl_mt_console;
    private javax.swing.JLabel lbl_number_of_events_per_thread;
    private javax.swing.JLabel lbl_number_of_events_per_threads;
    private javax.swing.JLabel lbl_number_of_fractionnement;
    private javax.swing.JLabel lbl_number_of_fractionnements;
    private javax.swing.JLabel lbl_number_of_threads;
    private javax.swing.JLabel lbl_number_of_voxels;
    private javax.swing.JLabel lbl_patient_name10;
    private javax.swing.JLabel lbl_patient_name11;
    private javax.swing.JLabel lbl_patient_name12;
    private javax.swing.JLabel lbl_patient_name13;
    private javax.swing.JLabel lbl_patient_weight2;
    private javax.swing.JLabel lbl_patient_weight4;
    private javax.swing.JLabel lbl_readout_geom;
    private javax.swing.JLabel lbl_rotation_collimator;
    private javax.swing.JLabel lbl_rotation_gantry;
    private javax.swing.JLabel lbl_sigma;
    private javax.swing.JLabel lbl_source_position;
    private javax.swing.JLabel lbl_stepmax;
    private javax.swing.JLabel lbl_stepmax_value;
    private javax.swing.JLabel lbl_type_of_distribution_pos;
    private javax.swing.JLabel lbl_type_of_particle;
    private javax.swing.JLabel lbl_voxalized_phantom_dim;
    private javax.swing.JLabel lbl_vrt;
    private javax.swing.JLabel lbl_z_coordinate_h5_phsp;
    private javax.swing.JLabel lbl_z_stop;
    private javax.swing.JTextField readout_x_position;
    private javax.swing.JTextField readout_y_position;
    private javax.swing.JTextField readout_z_position;
    private javax.swing.JCheckBox rot_colimator_flag;
    private javax.swing.JCheckBox rotation_gantry_flag;
    private javax.swing.JButton select_dosimetric_file;
    private javax.swing.JTabbedPane tb;
    // End of variables declaration//GEN-END:variables
}
