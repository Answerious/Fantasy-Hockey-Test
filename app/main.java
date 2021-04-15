import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.WindowConstants;



public class main{

  public static void main(String[] args) {
    JFrame f = new JFrame("Game");
    f.setTitle("Hockey");
    f.setSize(500, 500);
    f.setLocation(300,300);
    f.getContentPane().setBackground(new java.awt.Color(0, 0, 0));
    final JLabel Title = new JLabel("Hockey");
    Title.setSize(300,300);
    Title.setBounds(213, 5, 120, 50);
    Title.setFont(new Font("Serif", Font.PLAIN, 24));
    Title.setForeground(new java.awt.Color(255,255,255));

    /* Below is credit labels */

    final JLabel cre1 = new JLabel("Made by");
    cre1.setSize(300,300);
    cre1.setBounds(213, 30, 120, 50);
    cre1.setFont(new Font("Serif", Font.PLAIN, 24));
    cre1.setForeground(new java.awt.Color(255,255,255));

    final JLabel cre2 = new JLabel("Jake Leroux");
    cre2.setSize(300,300);
    cre2.setBounds(195, 70, 120, 50);
    cre2.setFont(new Font("Serif", Font.PLAIN, 24));
    cre2.setForeground(new java.awt.Color(255,255,255));

    final JLabel cre3 = new JLabel("2021-2022(c)");
    cre3.setSize(300,300);
    cre3.setBounds(190, 120, 140, 50);
    cre3.setFont(new Font("Serif", Font.PLAIN, 24));
    cre3.setForeground(new java.awt.Color(255,255,255));

    /* Buttons */

    final JButton Start = new JButton("Start Game");
    Dimension size = Start.getPreferredSize();
    Start.setBounds(210, 50, size.width, size.height);
    Start.setBackground(new java.awt.Color(0,0,0));
    Start.setForeground(new java.awt.Color(255,255,255));
    Start.setSize(80,40);

    final JButton Options = new JButton(" Credits ");
    Dimension size2 = Options.getPreferredSize();
    Options.setBounds(210, 120, size2.width, size2.height);
    Options.setBackground(new java.awt.Color(0,0,0));
    Options.setForeground(new java.awt.Color(255,255,255));
    Options.setSize(80,40);

    final JButton Quit = new JButton(" Quit ");
    Dimension size3 = Quit.getPreferredSize();
    Quit.setBounds(210, 190, size3.width, size3.height);
    Quit.setBackground(new java.awt.Color(0,0,0));
    Quit.setForeground(new java.awt.Color(255,255,255));
    Quit.setSize(80,40);

    final JButton Back1 = new JButton(" Back ");
    Dimension size4 = Back1.getPreferredSize();
    Back1.setBounds(210, 400, size4.width, size4.height);
    Back1.setBackground(new java.awt.Color(0,0,0));
    Back1.setForeground(new java.awt.Color(255,255,255));
    Back1.setSize(80,40);

    Quit.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });

    Start.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(false);
        Title.setVisible(false);
        Quit.setVisible(false);
        Options.setVisible(false);
        System.out.println("SUCCESS");
        System.exit(0);
      }
    });

    Back1.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(true);
        Title.setVisible(true);
        Quit.setVisible(true);
        Options.setVisible(true);
        Back1.setVisible(false);
        cre1.setVisible(false);
        cre2.setVisible(false);
        cre3.setVisible(false);
      }
    });

    Options.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(false);
        Title.setVisible(false);
        Quit.setVisible(false);
        Options.setVisible(false);
        Back1.setVisible(true);
        cre1.setVisible(true);
        cre2.setVisible(true);
        cre3.setVisible(true);
      }
    });

    f.setLayout(null);
    f.add(Start);
    f.add(Title);
    f.add(Options);
    f.add(Quit);
    f.add(Back1);
    f.add(cre1);
    f.add(cre2);
    f.add(cre3);
    Back1.setVisible(false);
    cre1.setVisible(false);
    cre2.setVisible(false);
    cre3.setVisible(false);

    f.setVisible(true);
  }

}

    /*
    final JTextArea textArea = new JTextArea(10, 40);
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    
    final JButton button = new JButton("Click Me");
    f.getContentPane().add(BorderLayout.SOUTH, button);
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.append("Button was clicked\n");
            System.out.println("Button was clicked");

        }
    });
    */