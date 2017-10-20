/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g4linac_mt_gui;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;
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
public class custom_output_stream extends OutputStream {
String s="",d="";
String l="";
String content="";
    private final JTextArea textArea;
  public void Clean(){
  content="";
  }
    public void Dump(){
     this.textArea.setText(content);
    
    }
    public custom_output_stream(JTextArea _textArea) {
        this.textArea = _textArea;
  
    }

    @Override
    public void write(int paramInt) throws IOException {
        // redirects data to the text area
        s=String.valueOf((char)paramInt);
        d=d+s;      
if ("\n".equals(s)){
           
textArea.setText(textArea.getText() + d);
textArea.update(textArea.getGraphics());
content+=d;
textArea.setCaretPosition(textArea.getDocument().getLength());
if (textArea.getDocument().getLength()> 600){
textArea.setText("");
}
d="";
    }
        
    }
}