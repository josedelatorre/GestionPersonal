package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.print.MultiDocPrintJob;
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
import java.io.LineNumberInputStream;

@SuppressWarnings("serial")
public class PersonalFrame extends JFrame {

	private int indice;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApe;
	//private String[] puestos = { "Jefe supremo", "Currante", "Programador", "Becario" };
	// 0 crear, 1 leer
	private int modo = 0;
	private JTextField txtFecha;
	private List<Empleado> empleados = new ArrayList<Empleado>();
	private JButton btnAnt;
	private JButton btnSig;
	private JLabel lblContador;
	private JRadioButton rdbtnHombre;
	private JList listPuestos;
	private JTextArea txtComentarios;
	private JToggleButton tglbtnEstDeVacaciones;
	private JSlider slider;
	private JLabel lblSueldo;

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
		this.modo = 0;
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

		rdbtnHombre = new JRadioButton("Hombre");
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

		tglbtnEstDeVacaciones = new JToggleButton("Está de vacaciones");
		tglbtnEstDeVacaciones.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		tglbtnEstDeVacaciones.setBounds(470, 96, 277, 59);
		contentPane.add(tglbtnEstDeVacaciones);

		slider = new JSlider();

		slider.setMaximum(10000);
		slider.setBounds(557, 178, 190, 29);
		contentPane.add(slider);

		listPuestos = new JList();
		listPuestos.setBounds(229, 233, 141, 75);
		contentPane.add(listPuestos);

		lblSueldo = new JLabel("Sueldo (0-10000)");
		lblSueldo.setBounds(414, 183, 131, 16);
		contentPane.add(lblSueldo);

		JLabel lblAntigedad = new JLabel("Antigüedad");
		lblAntigedad.setBounds(87, 320, 131, 63);
		contentPane.add(lblAntigedad);

		txtFecha = new JTextField();
		txtFecha.setText("01/01/1990");
		txtFecha.setColumns(10);
		txtFecha.setBounds(192, 338, 130, 26);
		contentPane.add(txtFecha);

		JPanel pnlSueldo = new JPanel();
		pnlSueldo.setBounds(500, 221, 241, 63);
		contentPane.add(pnlSueldo);

		JLabel lblValorSueldo = new JLabel(slider.getValue() + "€ al mes");
		pnlSueldo.add(lblValorSueldo);
		lblValorSueldo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(414, 343, 131, 16);
		contentPane.add(lblComentarios);

		txtComentarios = new JTextArea();
		txtComentarios.setBounds(424, 367, 323, 157);
		contentPane.add(txtComentarios);

		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(103, 437, 198, 63);
		contentPane.add(btnCrear);

		btnAnt = new JButton("<");
		btnAnt.setBounds(580, 17, 43, 44);
		contentPane.add(btnAnt);
		btnAnt.setVisible(false);

		btnSig = new JButton(">");
		btnSig.setBounds(704, 17, 43, 44);
		contentPane.add(btnSig);

		lblContador = new JLabel("0 de 0");
		lblContador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContador.setBounds(633, 26, 62, 29);
		contentPane.add(lblContador);
		btnSig.setVisible(false);

		lblContador.setVisible(false);

		// Handlers
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int sueldo = slider.getValue();
				if (sueldo < 3000) {
					pnlSueldo.setBackground(Color.GREEN);
				} else if (sueldo < 5000) {
					pnlSueldo.setBackground(Color.YELLOW);
				} else if (sueldo < 8000) {
					pnlSueldo.setBackground(Color.ORANGE);
				} else {
					pnlSueldo.setBackground(Color.RED);
				}

				lblValorSueldo.setText(slider.getValue() + "€ al mes");
			}
		});

		mntmLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGestinDePersonal.setText("Gestión de Personal - Modo Leer");
				toggleReadOnly(true);
				modo = 1;
				btnAnt.setVisible(true);
				btnSig.setVisible(true);
				lblContador.setVisible(true);

				loadEmployee();
				updateContador();
			}
		});

		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGestinDePersonal.setText("Gestión de Personal - Modo Crear");
				toggleReadOnly(false);
				modo = 0;
				btnAnt.setVisible(false);
				btnSig.setVisible(false);
				lblContador.setVisible(false);
				clean();
			}
		});

		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				empleados.add(new Empleado(txtNombre.getText(), txtApe.getText(), rdbtnHombre.isSelected(),
						listPuestos.getSelectedIndex(), slider.getValue(), txtFecha.getText(),
						tglbtnEstDeVacaciones.isSelected(), txtComentarios.getText()));

				indice = empleados.size() - 1;
				clean();
			}
		});

		btnSig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextEmployee();
				loadEmployee();
				updateContador();
			}
		});
		btnAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prevEmployee();
				loadEmployee();
				updateContador();
			}
		});

	}

	private void toggleReadOnly(boolean mode) {
		for (Component cp : contentPane.getComponents()) {
			cp.setEnabled(!mode);
		}
		btnAnt.setEnabled(true);
		btnSig.setEnabled(true);
		lblContador.setEnabled(true);
	}

	private String getContador() {
		if (!empleados.isEmpty()) {
			return indice + 1 + " de " + empleados.size();
		} else {
			return "0 de 0";
		}
	}

	private int nextEmployee() {
		++indice;
		if (indice == empleados.size()) {
			indice = 0;
		}
		return indice;
	}

	private int prevEmployee() {
		--indice;
		if (indice < 0) {
			indice = empleados.size() - 1;
		}
		return indice;
	}

	private void loadEmployee() {
		if (!empleados.isEmpty()) {
			Empleado p = empleados.get(indice);
			txtNombre.setText(p.getNombre());
			txtApe.setText(p.getApellido());
			rdbtnHombre.setSelected(p.isHombre());
			txtFecha.setText(p.getFecha());
			tglbtnEstDeVacaciones.setSelected(p.isVacas());
			slider.setValue(p.getSueldo());
			lblSueldo.setText(p.getSueldo() + "€ al mes");
			txtComentarios.setText(p.getComentarios());
		}
	}

	private void updateContador() {
		lblContador.setText(getContador());
	}

	private void clean() {
		txtNombre.setText("");
		txtApe.setText("");
		rdbtnHombre.setSelected(true);
		txtFecha.setText("");
		tglbtnEstDeVacaciones.setSelected(false);
		slider.setValue(50);
		lblSueldo.setText(50 + "€ al mes");
		txtComentarios.setText("");

	}
}
