package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import Model.Doctor;
import Helper.Helper;

public class DoctorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel w_pane;

	private static Doctor doctor; 
	private JTable table_whour;
	private DefaultTableModel whourModel;
	private Object[] whourData = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor doctor = new Doctor();
					DoctorGUI frame = new DoctorGUI(doctor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoctorGUI(Doctor doctor) throws SQLException {
		
		whourModel = new DefaultTableModel();
		Object[] colWhour = new Object[2];
		colWhour[0] = "ID";
		colWhour[1] = "Tarih";
		whourModel.setColumnIdentifiers(colWhour);
		whourData = new Object[2];
		for(int i = 0 ;i < doctor.getWhourList(doctor.getId()).size(); i++) {
			whourData[0] = doctor.getWhourList(doctor.getId()).get(i).getId();
			whourData[1] = doctor.getWhourList(doctor.getId()).get(i).getWdate();
			whourModel.addRow(whourData);

			
		}
		
		this.doctor = doctor;

		setTitle("Hastane Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);

		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hoşgeldiniz, Sayın " + this.doctor.getName());
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 347, 24);
		w_pane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Çıkış Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI login = new LoginGUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btnNewButton.setBounds(623, 15, 101, 23);
		w_pane.add(btnNewButton);

		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		w_tab.setBounds(10, 59, 714, 391);
		w_pane.add(w_tab);

		JPanel w_whor = new JPanel();
		w_whor.setBackground(Color.WHITE);
		w_tab.addTab("Çalışma Saatleri", null, w_whor, null);
		w_whor.setLayout(null);

		JDateChooser select_date = new JDateChooser();
		select_date.setBounds(10, 11, 130, 22);
		w_whor.add(select_date);

		JComboBox<String> select_time = new JComboBox<>();
		select_time.setModel(new DefaultComboBoxModel<>(
				new String[] { "10.30", "11.00", "11.30", "12.00", "12.30", "13.00", "13.30", "14.00", "14.30", "15.00", "15.30" }
		));
		select_time.setBounds(150, 11, 65, 22);
		w_whor.add(select_time);

		JButton btn_addWhour = new JButton("Ekle");
		btn_addWhour.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn_addWhour.setBounds(229, 11, 87, 23);
		w_whor.add(btn_addWhour);

		btn_addWhour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Date picked = select_date.getDate();
				if (picked == null) {
					Helper.showMsg("Lütfen geçerli bir tarih seçiniz !");
					return;
				}

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = sdf.format(picked);

				// "10.30" -> "10:30:00"
				String timeStr = select_time.getSelectedItem().toString().replace('.', ':') + ":00";
				String selectDate = dateStr + " " + timeStr;

				try {
					boolean control = DoctorGUI.this.doctor.addWhour(
							DoctorGUI.this.doctor.getId(),
							DoctorGUI.this.doctor.getName(),
							selectDate
					);

					if (control) {
						Helper.showMsg("success");
						updateDoctorWhour(doctor);
					} else {
						Helper.showMsg("error");
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					Helper.showMsg("error");
				}
			}
		});

		JScrollPane w_scrollWhour = new JScrollPane();
		w_scrollWhour.setBounds(10, 49, 689, 297);
		w_whor.add(w_scrollWhour);

		table_whour = new JTable(whourModel);
		w_scrollWhour.setViewportView(table_whour);
		
		JButton btn_delWhour = new JButton("Sil");
		btn_delWhour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selRow = table_whour.getSelectedRow();
				if(selRow >= 0) {
					String selectRow = table_whour.getModel().getValueAt(selRow, 0).toString();
					int selID = Integer.parseInt(selectRow);
					boolean control;
					try {
						control = doctor.deleteWhour(selID);
						if(control) {
							Helper.showMsg("success");
							updateDoctorWhour(doctor);
						}else {
							Helper.showMsg("error");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {
					Helper.showMsg("Lütfen bir tarih seçiniz !");
				}
			}
		});
		btn_delWhour.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		btn_delWhour.setBounds(612, 11, 87, 23);
		w_whor.add(btn_delWhour);
	}

	private Object DefaultTableModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updateDoctorWhour(Doctor doctor) throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_whour.getModel();
		clearModel.setRowCount(0);
		for (int i = 0; i < doctor.getWhourList(doctor.getId()).size(); i++) {
			whourData[0] = doctor.getWhourList(doctor.getId()).get(i).getId();
			whourData[1] = doctor.getWhourList(doctor.getId()).get(i).getWdate();
			whourModel.addRow(whourData);
		}

	}
}
