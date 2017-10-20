package g4linac_mt_gui;

/*
G4Linac_MT, a Geant4-based application for Medical Linear Accelerator
Developed by Dr.Jaafar EL Bakkali,Assistant Prof. of Nuclear Physics
Rabat, Morocco, 10/10/ 2017
Webpage :https://github.com/EL-Bakkali-Jaafar/G4Linac_MT
 */
/**
 *
 * @author jaafar
 */
public class g4linac_singelton {
    
  private String geant4_installation_directory;
  private String g4linac_mt_installation_directory;
  private String root_installation_directory;
  private String valgrind_installation_directory;

  private static g4linac_singelton singleton = new g4linac_singelton( );

  
  private g4linac_singelton(){ }
   
   /* Static 'instance' method */
   public static g4linac_singelton getInstance( ) {
      return singleton;
   }
   
  public void Set_Valgrind_installation_directory(String _valgrind_installation_directory){
  
  this.valgrind_installation_directory=_valgrind_installation_directory;
  }
  
  public void Set_Geant4_installation_directory(String _geant4_installation_directory){
  
  this.geant4_installation_directory=_geant4_installation_directory;
  }
  
  public void Set_G4linac_installation_directory(String _g4linac_installation_directory){
  
  this.g4linac_mt_installation_directory=_g4linac_installation_directory;
  }  
  public void Set_Root_installation_directory(String _root_installation_directory){
  
  this.root_installation_directory=_root_installation_directory;
  }  
  
 
  String  Get_Geant4_installation_directory(){
  
  return this.geant4_installation_directory;
  }

 String  Get_G4linac_installation_directory(){
  
  return this.g4linac_mt_installation_directory;
  }
String  Get_Valgrind_installation_directory(){
  
  return this.valgrind_installation_directory;
  }
String  Get_Root_installation_directory(){
  
  return this.root_installation_directory;
  }


}
