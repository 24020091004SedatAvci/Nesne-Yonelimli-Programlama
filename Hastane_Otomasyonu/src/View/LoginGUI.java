package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import Helper.*;
import Model.Bashekim;
import Model.Doctor;
import Model.Hasta;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel w_pane;
	private JTextField fld_hastaTc;
	private JTextField fld_doktorTc;
	private JPasswordField pfld_doktorSifre;
	private JPasswordField pfld_hastaSifre;
	private DBConnection conn = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginGUI() {
		setResizable(false);
		setTitle("Hastane Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(255, 255, 255));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
		lbl_logo.setBounds(202, 0, 80, 80);
		w_pane.add(lbl_logo);

		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(10, 129, 464, 221);
		w_tabpane.setBackground(new Color(255, 255, 255));
		w_pane.add(w_tabpane);

		// ---------------- HASTA LOGIN PANELİ ----------------
		JPanel w_hastaLogin = new JPanel();
		w_hastaLogin.setBackground(new Color(255, 255, 255));
		w_tabpane.addTab("Hasta Girişi", null, w_hastaLogin, null);
		w_hastaLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("T.C. Numaranız: ");
		lblNewLabel.setBounds(44, 29, 142, 27);
		w_hastaLogin.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));

		JLabel lblifreniz = new JLabel("Şifreniz: ");
		lblifreniz.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lblifreniz.setBounds(44, 63, 77, 27);
		w_hastaLogin.add(lblifreniz);

		fld_hastaTc = new JTextField();
		fld_hastaTc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 19));
		fld_hastaTc.setBounds(192, 28, 175, 27);
		w_hastaLogin.add(fld_hastaTc);
		fld_hastaTc.setColumns(10);

		JButton btn_hastaKayit = new JButton("Kayıt Ol");
		btn_hastaKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterGUI rGUI = new RegisterGUI();
				rGUI.setVisible(true);
				dispose();
			}
		});
		btn_hastaKayit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btn_hastaKayit.setBounds(44, 137, 125, 45);
		w_hastaLogin.add(btn_hastaKayit);

		JButton btn_hastaGiris = new JButton("Giriş Yap");
		btn_hastaGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_hastaTc.getText().length() == 0 || pfld_hastaSifre.getPassword().length == 0) {
					Helper.showMsg("fill");
				} else {
					boolean loginSuccess = false;
					Connection con = conn.connDb();
					try {
						Statement st = con.createStatement();
						// Sadece girilen TC ve Şifreye ait kullanıcıyı getiriyoruz
						String sql = "SELECT * FROM user WHERE tcno = '" + fld_hastaTc.getText() + "'";
						ResultSet rs = st.executeQuery(sql);
						
						if (rs.next()) {
							String dbSifre = rs.getString("password");
							String girilenSifre = new String(pfld_hastaSifre.getPassword());

							if(dbSifre.equals(girilenSifre)) {
								if (rs.getString("type").equals("hasta")) {
									Hasta hasta = new Hasta();
									hasta.setId(rs.getInt("id"));
									hasta.setPassword(rs.getString("password"));
									hasta.setTcno(rs.getString("tcno"));
									hasta.setName(rs.getString("name"));
									hasta.setType(rs.getString("type"));
									
									HastaGUI hGUI = new HastaGUI(hasta);
									hGUI.setVisible(true);
									dispose();
									loginSuccess = true;
								} else {
									Helper.showMsg("Bu giriş sadece hastalar içindir!");
									loginSuccess = true; // Kullanıcı bulundu ama yetki yanlış, hata gösterme diye true yapıyoruz
								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					if (!loginSuccess) {
						Helper.showMsg("Kullanıcı bulunamadı veya şifre hatalı.");
					}
				}
			}
		});
		btn_hastaGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btn_hastaGiris.setBounds(247, 137, 125, 45);
		w_hastaLogin.add(btn_hastaGiris);

		pfld_hastaSifre = new JPasswordField();
		pfld_hastaSifre.setBounds(192, 67, 175, 27);
		w_hastaLogin.add(pfld_hastaSifre);

		// ---------------- DOKTOR LOGIN PANELİ ----------------
		JPanel w_doktorLogin = new JPanel();
		w_doktorLogin.setBackground(Color.WHITE);
		w_tabpane.addTab("Doktor Girişi", null, w_doktorLogin, null);
		w_doktorLogin.setLayout(null);

		JLabel lbl_doktorTc = new JLabel("T.C. Numaranız: ");
		lbl_doktorTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lbl_doktorTc.setBounds(44, 29, 142, 27);
		w_doktorLogin.add(lbl_doktorTc);

		JLabel lbl_doktorSifre = new JLabel("Şifreniz: ");
		lbl_doktorSifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lbl_doktorSifre.setBounds(44, 63, 77, 27);
		w_doktorLogin.add(lbl_doktorSifre);

		fld_doktorTc = new JTextField();
		fld_doktorTc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 19));
		fld_doktorTc.setColumns(10);
		fld_doktorTc.setBounds(192, 28, 175, 27);
		w_doktorLogin.add(fld_doktorTc);

		JButton btn_doktorGiris = new JButton("Giriş Yap");
		btn_doktorGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_doktorTc.getText().length() == 0 || pfld_doktorSifre.getPassword().length == 0) {
					Helper.showMsg("fill");
				} else {
					boolean loginSuccess = false;
					Connection con = conn.connDb();
					try {
						Statement st = con.createStatement();
						// Sadece girilen TC'ye ait kullanıcıyı çekiyoruz
						String sql = "SELECT * FROM user WHERE tcno = '" + fld_doktorTc.getText() + "'";
						ResultSet rs = st.executeQuery(sql);

						if (rs.next()) {
							String dbSifre = rs.getString("password");
							String girilenSifre = new String(pfld_doktorSifre.getPassword());
							
							if(dbSifre.equals(girilenSifre)) {
								String userType = rs.getString("type");
								
								if (userType.equals("bashekim")) {
									Bashekim bhekim = new Bashekim();
									bhekim.setId(rs.getInt("id"));
									bhekim.setPassword(rs.getString("password"));
									bhekim.setTcno(rs.getString("tcno"));
									bhekim.setName(rs.getString("name"));
									bhekim.setType(rs.getString("type"));
									
									BashekimGUI bGUI = new BashekimGUI(bhekim);
									bGUI.setVisible(true);
									dispose();
									loginSuccess = true;
									
								} else if (userType.equals("doktor")) {
									Doctor doctor = new Doctor();
									doctor.setId(rs.getInt("id"));
									doctor.setPassword(rs.getString("password"));
									doctor.setTcno(rs.getString("tcno"));
									doctor.setName(rs.getString("name"));
									doctor.setType(rs.getString("type"));
									
									DoctorGUI dGUI = new DoctorGUI(doctor);
									dGUI.setVisible(true);
									dispose();
									loginSuccess = true;
								} else {
									Helper.showMsg("Bu giriş sadece Doktor veya Başhekim içindir.");
									loginSuccess = true;
								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					if (!loginSuccess) {
						Helper.showMsg("Kullanıcı bulunamadı veya şifre hatalı.");
					}
				}
			}
		});
		btn_doktorGiris.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btn_doktorGiris.setBounds(44, 137, 337, 45);
		w_doktorLogin.add(btn_doktorGiris);

		pfld_doktorSifre = new JPasswordField();
		pfld_doktorSifre.setBounds(192, 67, 175, 27);
		w_doktorLogin.add(pfld_doktorSifre);
	}
}