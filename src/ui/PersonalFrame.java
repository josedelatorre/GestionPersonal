package ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.Empleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PersonalFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApe;
	private String[] puestos = {"Jefe supremo", "Currante", "Programador","Becario"};
	private JTextField textField;
	private List<Empleado> empleados = new ArrayList<Empleado>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalFrame frame = new PersonalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnModo = new JMenu("Modo");
		menuBar.add(mnModo);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mnModo.add(mntmCrear);
		
		JMenuItem mntmLeer = new JMenuItem("Leer");
		mnModo.add(mntmLeer);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmScameDeAqu = new JMenuItem("Sácame de aquí");
		mnAyuda.add(mntmScameDeAqu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGestinDePersonal = new JLabel("Gestión de personal - Modo Crear");
		lblGestinDePersonal.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblGestinDePersonal.setBounds(41, 17, 504, 44);
		contentPane.add(lblGestinDePersonal);
		
		JLabel lblNombreEmpleado = new JLabel("Nombre");
		lblNombreEmpleado.setBounds(86, 101, 131, 16);
		contentPane.add(lblNombreEmpleado);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(229, 96, 130, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(86, 134, 131, 16);
		contentPane.add(lblApellido);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		txtApe.setBounds(229, 129, 130, 26);
		contentPane.add(txtApe);
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(86, 177, 141, 23);
		contentPane.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBounds(229, 177, 141, 23);
		contentPane.add(rdbtnMujer);
		
		bg.add(rdbtnHombre);
		bg.add(rdbtnMujer);
		
		JLabel lblPuestoEnLa = new JLabel("Puesto en la empresa");
		lblPuestoEnLa.setBounds(86, 233, 154, 16);
		contentPane.add(lblPuestoEnLa);
		
		JToggleButton tglbtnEstDeVacaciones = new JToggleButton("Está de vacaciones");
		tglbtnEstDeVacaciones.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		tglbtnEstDeVacaciones.setBounds(470, 96, 277, 59);
		contentPane.add(tglbtnEstDeVacaciones);
		
		JSlider slider = new JSlider();
		
		slider.setMaximum(10000);
		slider.setBounds(557, 178, 190, 29);
		contentPane.add(slider);
		
		JList list = new JList(puestos);
		list.setBounds(229, 233, 141, 75);
		contentPane.add(list);
		
		JLabel lblSueldo = new JLabel("Sueldo (0-10000)");
		lblSueldo.setBounds(414, 183, 131, 16);
		contentPane.add(lblSueldo);
		
		JLabel lblAntigedad = new JLabel("Antigüedad");
		lblAntigedad.setBounds(87, 320, 131, 63);
		contentPane.add(lblAntigedad);
		
		textField = new JTextField();
		textField.setText("01/01/1990");
		textField.setColumns(10);
		textField.setBounds(192, 338, 130, 26);
		contentPane.add(textField);
		
		JPanel pnlSueldo = new JPanel();
		pnlSueldo.setBounds(500, 221, 241, 63);
		contentPane.add(pnlSueldo);
		
		JLabel lblValorSueldo= new JLabel(slider.getValue() + "€ al mes");
		pnlSueldo.add(lblValorSueldo);
		lblValorSueldo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(414, 343, 131, 16);
		contentPane.add(lblComentarios);
		
		JTextArea txtComentarios = new JTextArea();
		txtComentarios.setBounds(424, 367, 323, 157);
		contentPane.add(txtComentarios);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(103, 437, 198, 63);
		contentPane.add(btnCrear);
        
        
		
		
		// Handlers
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int sueldo = slider.getValue();
				if(sueldo < 3000){
					pnlSueldo.setBackground(Color.GREEN);
				} else if(sueldo < 5000) {
					pnlSueldo.setBackground(Color.YELLOW);
				} else if(sueldo < 8000) {
					pnlSueldo.setBackground(Color.ORANGE);
				}  else{
					pnlSueldo.setBackground(Color.RED);
				} 					
				
				lblValorSueldo.setText(slider.getValue() + "€ al mes");
			}
		});
		

		mntmLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGestinDePersonal.setText("Gestión de Personal - Modo Leer");
				toggleReadOnly(true);
			}
		});
		
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGestinDePersonal.setText("Gestión de Personal - Modo Crear");
				toggleReadOnly(false);
			}
		});
		
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//empleados.add(new Empleado(txtNombre.getText(), txtApe.getText(),))
			}
		});
			
	}
	
	private void toggleReadOnly(boolean mode){
		for (Component cp : contentPane.getComponents() ){
	        cp.setEnabled(!mode);
	 }
	}
}
