package question2;

import java.awt.Robot;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Random;


public class IHMQuestion2_1Test extends junit.framework.TestCase
{
    private static Random random= new Random();
    private JFrame f;
    private Robot robot;

    public void test_presence_fichiers_question2() {
        try{  
            Class.forName("question2.IHMQuestion2_1");
            Class.forName("question2.JButtonObserver");
            Class.forName("question2.JMouseObserver");
        }catch(ClassNotFoundException e){
            fail("classe absente " + e.getMessage());
        }
    }


    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() throws java.lang.Exception{
        f = new IHMQuestion2_1();
        f.pack();
        f.setVisible(true);
        while(!(f.isShowing())){}
        f.setAlwaysOnTop(true);
        f.setLocation(random.nextInt(500), random.nextInt(500));
        robot = new Robot();
        robot.delay(100);
    }

    protected void tearDown(){ // throws java.lang.Exception
        f.dispose();
            f=null;
        System.gc();
        robot.delay(200);
    }

    public void test_clic_bouton_A() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("ihm invalide ?, ne pas modifier l'interface", components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface", subComponents[2] instanceof JButton);


        JButton bouton_A = ((JButton)subComponents[0]);
        bouton_A.doClick(200);
        TextArea sortie = (TextArea)components[1];
        StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
        assertTrue("Cliquer sur le bouton A, 3 lignes sont attendues !!!", st.countTokens()==3); 
    
    }
    public void test_clic_bouton_B() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("--ihm invalide ?, ne pas modifier l'interface",components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

        JButton bouton_B = ((JButton)subComponents[1]);
        bouton_B.doClick();
        TextArea sortie = (TextArea)components[1];
        StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
        assertTrue("Cliquer sur le bouton B, 2 lignes sont attendues !!!", st.countTokens()==2);
    
    

    }
    public void test_clic_bouton_C() throws Exception{
        Container panel = f.getContentPane();
        Component[] components = panel.getComponents();
        assertEquals("ihm invalide ?, ne pas modifier l'interface",components.length, 2);

        // la bonne IHM
        assertTrue("ihm invalide ?, ne pas modifier l'interface",components[0] instanceof JPanel);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",components[1] instanceof TextArea);

        Component[] subComponents = ((JPanel)components[0]).getComponents();
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[0] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[1] instanceof JButton);
        assertTrue("ihm invalide ?, ne pas modifier l'interface",subComponents[2] instanceof JButton);

        JButton bouton_C = ((JButton)subComponents[2]);
        bouton_C.doClick();
        TextArea sortie = (TextArea)components[1];
        StringTokenizer st = new StringTokenizer(sortie.getText(),"\n");
        assertTrue("Cliquer sur le bouton B, 1 ligne est attendue !!!", st.countTokens()==1);
    }

        
       

   
    public void mouseMoveAndClick(int x, int y){
        robot.mouseMove( x,y);

        robot.delay(60);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(60);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(60);
    }//end mouseMoveAndClick

}
