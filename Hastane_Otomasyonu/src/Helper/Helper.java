package Helper;

import javax.swing.JOptionPane;

public class Helper {
	public static void showMsg(String str) {
		String msg;

		switch (str) {
		case "fill":
			msg = "Lütfen tüm alanları doldurunuz! ";
			break;
		case "success":
			msg = "İşlem başarılı.";
			break;
		case "error":
			msg = "Bir hata oluştu !";
			break;
		default:
			msg = str;
		}

		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean confirm(String str) {
		String msg = null;
		switch(str) {
		case "sure":
			msg = "Bu işlemi gerçekleştirmek istiyor musunuz? ";
			break;			
		}
		
		int res = JOptionPane.showConfirmDialog(null, msg, "Dikkat !", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			return true;
		}else {
			return false;
		}
	}
}
