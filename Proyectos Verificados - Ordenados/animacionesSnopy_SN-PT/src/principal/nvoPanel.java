/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author josej
 */
public class nvoPanel extends JPanel {
    Image offScreen;
    
    
    @Override
    public void invalidate(){
    super.invalidate();
    offScreen=null;
    }
    
    @Override
    public void update( Graphics g){
        paint(g);  
    }
    
    @Override
    public void paint(Graphics g){
if(offScreen==null){
    offScreen=createImage(getSize().width,getSize().height);
}        
Graphics og=offScreen.getGraphics();
og.setClip(0,0,getSize().width,getSize().height);
super.paint(g);
g.drawImage(offScreen,0,0,null);
og.dispose();
    }
}
