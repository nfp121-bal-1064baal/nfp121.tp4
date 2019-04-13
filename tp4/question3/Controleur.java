package question3;

 

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

 
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        
            ButtonsActionListener actionListener = new ButtonsActionListener();
        donnee.addActionListener(actionListener);
        
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(actionListener);
        boutons.add(add);  add.addActionListener(actionListener);
        boutons.add(sub);    sub.addActionListener(actionListener);
        boutons.add(mul);   mul.addActionListener(actionListener);
        boutons.add(div);     div.addActionListener(actionListener);
        boutons.add(clear); clear.addActionListener(actionListener);
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
       if(!pile.estPleine()){push.setEnabled(true);}    
        else{push.setEnabled(false);}   
        
        verifiePile();
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

     public class ButtonsActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String actionCommand = event.getActionCommand();
            
            if(actionCommand.equals("push")){
                try{
                    pile.empiler(operande());
                    verifiePile();
                } 
                catch(NumberFormatException nfe){
                }
                catch(PilePleineException ppe) {
                    ppe.printStackTrace();
                }
            } 
            else if(actionCommand.equals("[]")){
                while(!pile.estVide()){
                    try{
                        pile.depiler();
                    } 
                    catch(PileVideException pve){
                        pve.printStackTrace();
                    }
                }
            } 
            else if(actionCommand.equals("+")||actionCommand.equals("-")||actionCommand.equals("*")||actionCommand.equals("/")){
                int operande1 = 0;
                int operande2 = 0;
                boolean divisionParZero = false;
                try{
                    operande1 = pile.depiler();
                    operande2 = pile.depiler();
                } 
                catch(PileVideException e){
                    e.printStackTrace();
                }
                
                int resultat = 0;
            
                if(actionCommand.equals("+")){
                    resultat = operande2 + operande1;
                }
                else if(actionCommand.equals("-")){
                    resultat = operande2 - operande1;
                }
                else if(actionCommand.equals("*")) 
                    resultat = operande2 * operande1;
                
                else if(actionCommand.equals("/")) {
                    if(operande1 == 0){
                        divisionParZero = true;
                    }
                    else{
                        resultat = operande2 / operande1;
                    }   
                }
                try{
                    if(divisionParZero){
                        pile.empiler(operande2);
                        pile.empiler(operande1);
                    }
                    else pile.empiler(resultat);
                }
                catch(PilePleineException ex){
                    ex.printStackTrace();
                }
}
            }
        }
            
        public void verifiePile(){
            if(pile.taille() < 2){
             div.setEnabled(false);
                add.setEnabled(false);
                
                mul.setEnabled(false);
               
                
                sub.setEnabled(false);
        } 
		else {
			
            sub.setEnabled(true);div.setEnabled(true);
            mul.setEnabled(true);add.setEnabled(true);
            
        }
        }
     

}

