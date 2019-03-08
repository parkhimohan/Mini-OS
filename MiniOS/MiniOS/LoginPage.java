//importing all essential packages ( step 1 )
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
// creating another seperate class LoginPage ( step 3 )
class LoginPage extends JFrame implements ActionListener
{
        /* Creating objects of Container two JLabels,one JTextField,
              one JPasswordField and one JButton ( step 5 ) */
	Container c;
	JLabel userlabel=new JLabel("USERNAME");
	JLabel pwdlabel=new JLabel("PASSWORD");
	JTextField u_tf=new JTextField();
	JPasswordField p_pf=new JPasswordField();
	JButton btn=new JButton("LOGIN");
	
	// Creating constructor of LoginPage class ( step 6 )
	LoginPage()
	{
         // Calling getContentPane() method ( step 7 )
	c=this.getContentPane();
         // Setting Layout manager ( step 8 )
	c.setLayout(null);
           // Setting Background color ( step 9 )
	c.setBackground(SystemColor.activeCaption);
           //Setting Location and Size of above created components ( step 10 )
	userlabel.setBounds(100,161,100,50);
	pwdlabel.setBounds(100,243,100,50);
	u_tf.setBounds(200,161,200,50);
	p_pf.setBounds(200,243,200,50);
	btn.setBounds(250,332,100,50);
         // adding each component to the container ( step 11 ) 
	c.add(u_tf);
	c.add(p_pf);
	c.add(pwdlabel);
	c.add(userlabel);
	c.add(btn);
	
	JButton btnNewButton = new JButton("");
	btnNewButton.setBounds(259, 44, 91, 84);
	getContentPane().add(btnNewButton);
	btnNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png")));
         // adding ActionListener to the button ( step 15 )
	btn.addActionListener(this);
		
	}
         // overriding actionPerformed() method ( step 12 )
	public void actionPerformed(ActionEvent e)
	{
                  // desired codes inside our actioPerformed() method ( step 14 )
		if(e.getSource()==btn)
		{
			String username=u_tf.getText();
			String pwd=p_pf.getText();
			if(username.equals("minios") && pwd.equals("12345") )
			{
				new Desktop().setVisible(true);
				
			}
			else 
			{
				warning.setText("wrong username or password");
				warning.setBounds(200,350,300,50);
				c.add(warning);
			}
				
		
		}
		
		
		
	}
	
         // Creating two JLabels ( step 13 ) 
	JLabel success=new JLabel();
	
	JLabel warning=new JLabel();
	public static void main(String[] args)
	{
                // Creating object of LoginPage class and setting it's properties ( step 4 ) 
		LoginPage f=new LoginPage();
		f.setTitle("Login Form");
		f.setVisible(true);
		f.setBounds(100,100,700,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
// creating a class LoginFormDemo ( step 2 )
