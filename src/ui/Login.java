package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField usuarioTxt;
	private JPasswordField passTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login");
		
		usuarioTxt = new JTextField();
		usuarioTxt.setBounds(180, 83, 130, 26);
		frame.getContentPane().add(usuarioTxt);
		usuarioTxt.setColumns(10);
		
		JLabel usuariolabel = new JLabel("Usuario");
		usuariolabel.setBounds(90, 88, 61, 16);
		frame.getContentPane().add(usuariolabel);
		
		JLabel passlabel = new JLabel("Password");
		passlabel.setBounds(90, 122, 61, 16);
		frame.getContentPane().add(passlabel);
		
		JLabel lblHhrrManagementV = new JLabel("HHRR Management v1.0.0");
		lblHhrrManagementV.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHhrrManagementV.setBounds(103, 19, 252, 26);
		frame.getContentPane().add(lblHhrrManagementV);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesión");
		btnIniciarSesin.setBounds(165, 187, 117, 29);
		frame.getContentPane().add(btnIniciarSesin);
		
		passTxt = new JPasswordField();
		passTxt.setBounds(180, 117, 130, 26);
		frame.getContentPane().add(passTxt);
		
		
		// Handlers
		
		btnIniciarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(usuarioTxt.getText().isEmpty() || new String(passTxt.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(frame, "Debes introducir un usuario y contraseña!","Autenticación",JOptionPane.ERROR_MESSAGE );
				} else{
					PersonalFrame pFrame = new PersonalFrame();
					pFrame.setVisible(true);
					frame.dispose();
				}
			}
		});
	}
}
