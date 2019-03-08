import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.text.DefaultEditorKit;
 
 
public class Notepad extends JFrame implements ActionListener {
    private JTextArea textArea = new JTextArea();
    private JScrollPane areaScrollPane;
    private JMenuBar menuBar = new JMenuBar();    
    private JMenu file = new JMenu();
    private JMenu edit = new JMenu();
    private JMenu format = new JMenu();
    private JMenu view = new JMenu();
    private JMenu help = new JMenu();
    private JMenuItem openFile = new JMenuItem();
    private JMenuItem saveFile = new JMenuItem();
    private JMenuItem close = new JMenuItem();
    private JMenuItem newFile = new JMenuItem();
    private JMenuItem undo = new JMenuItem();
    private JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
    private JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
    private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
    private JMenuItem delete = new JMenuItem();
    private JMenuItem wordwrap = new JMenuItem();
    private JMenuItem about = new JMenuItem();
 
    public Notepad() {
        this.setSize(500, 300);
        this.setTitle("Text Editor");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\balamuralikrishna\\Desktop\\MiniOS-Lazzarus--master\\MiniOS-Lazzarus--master\\texteditor.png"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));
        this.textArea.setDragEnabled(true);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
        this.areaScrollPane = new JScrollPane(textArea);
        this.areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.areaScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.areaScrollPane.setPreferredSize(new Dimension(250, 250));
        this.getContentPane().add(areaScrollPane);
 
        this.setJMenuBar(this.menuBar);
        this.menuBar.add(this.file);
        this.menuBar.add(this.edit);
        this.menuBar.add(this.help);
 
        this.file.setText("File");
        this.edit.setText("Edit");
        this.format.setText("Format");
        this.view.setText("View");
        this.help.setText("Help");
 
        this.newFile.setText("New");
        this.newFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newfile.png")));
        this.newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        this.newFile.addActionListener(this);
        this.newFile.setMnemonic(KeyEvent.VK_N);
        this.file.add(this.newFile);
 
        this.openFile.setText("Open");
        this.openFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png")));
        this.openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        this.openFile.addActionListener(this);
        this.openFile.setMnemonic(KeyEvent.VK_O);
        this.file.add(this.openFile);
 
        this.saveFile.setText("Save");
        this.saveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png")));
        this.saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        this.saveFile.addActionListener(this);
        this.saveFile.setMnemonic(KeyEvent.VK_S);
        this.file.add(this.saveFile);
 
        this.close.setText("Close");
        this.close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit.png")));
        this.close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
        this.close.setMnemonic(KeyEvent.VK_F4);
        this.close.addActionListener(this);
        this.file.add(this.close);
 
        this.undo.setText("Undo");
        this.undo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undo.png")));
        this.undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        this.undo.setMnemonic(KeyEvent.VK_U);
        this.undo.addActionListener(this);
        this.edit.add(this.undo);
        
        this.cut.setText("Cut");
        this.cut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cut.png")));
        this.cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        this.cut.setMnemonic(KeyEvent.VK_T);
        this.edit.add(this.cut);
 
        this.copy.setText("Copy");
        this.copy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/copy.png")));
        this.copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        this.copy.setMnemonic(KeyEvent.VK_C);
        this.copy.addActionListener(this);
        this.edit.add(this.copy);
 
        this.paste.setText("Paste");
        this.paste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paste.png")));
        this.paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        this.paste.setMnemonic(KeyEvent.VK_P);
        this.paste.addActionListener(this);
        this.edit.add(this.paste);
 
        this.about.setText("Authors");
        this.about.addActionListener(this);
        this.help.add(this.about);
    }
 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.close)
            this.dispose();
 
        else if (e.getSource() == this.openFile) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                this.textArea.setText("");
                try {
                    Scanner scan = new Scanner(new FileReader(open
                            .getSelectedFile().getPath()));
                    while (scan.hasNext())
                        this.textArea.append(scan.nextLine() + "\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
 
        else if (e.getSource() == this.saveFile) {
            JFileChooser save = new JFileChooser();
            int option = save.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(save
                            .getSelectedFile().getPath()));
                    out.write(this.textArea.getText());
                    out.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
 
        else if (e.getSource() == this.newFile) {
            JOptionPane jp = new JOptionPane();
            Object[] options = { "Save", "Don't Save", "Cancel" };
            int button = jp.showOptionDialog(null,
                    "Do you want to save changes to" + getTitle(), "Notepad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            if (button == 0) {
                JFileChooser newFile = new JFileChooser();
                int option = newFile.showSaveDialog(this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter(
                                newFile.getSelectedFile().getPath()));
                        out.write(this.textArea.getText());
                        out.close();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            } else if (button == 1) {
                textArea.setText(null);
            } else if (button == 2) {
 
            }
        } else if (e.getSource() == this.about) {
            JOptionPane jp = new JOptionPane();
            jp.showMessageDialog(null,
                    "mini-os project");
        }
    }
    public void appendtotextArea(String s) throws IOException{
        try {
            System.out.println("Notepad");
            textArea.read(new FileReader(s),null);
            //tab.setTitleAt(0,s.substring(s.lastIndexOf('/')+1));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public static void main(String args[]) {
        Notepad app = new Notepad();
        app.setVisible(true);
    }
}