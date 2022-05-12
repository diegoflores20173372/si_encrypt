import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class UISeguridadInformatica extends JFrame {

	public UISeguridadInformatica() {
		JPanel panel = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));

		JLabel titleOTP = new JLabel("Encriptación por OTP:");
		panel.add(titleOTP);
		JLabel filled = new JLabel("                                                                   ");
		panel.add(filled);

		JLabel textEncryptOTP = new JLabel("Texto a Encriptar:");
		panel.add(textEncryptOTP);

		JTextField fieldTextEncryptOTP = new JTextField(36);
		panel.add(fieldTextEncryptOTP);

		JLabel passEncryptOTP = new JLabel("Clave de Encriptado");
		panel.add(passEncryptOTP);

		JTextField fieldPassEncryptOTP = new JTextField(36);
		panel.add(fieldPassEncryptOTP);

		JLabel textResultEncryptOTP = new JLabel("Texto Encriptado:");
		panel.add(textResultEncryptOTP);

		JTextArea resultEncryptOTP = new JTextArea(8, 36);
		panel.add(new JScrollPane(resultEncryptOTP));

		JButton buttonEncryptOTP = new JButton("Cifrar por OneTimePad");
		panel.add(buttonEncryptOTP);
		buttonEncryptOTP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String textEncrypt = fieldTextEncryptOTP.getText();
				String passEncrypt = fieldPassEncryptOTP.getText();
				if (textEncrypt.length() == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un texto para encriptar", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else if (passEncrypt.length() == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar una clave para encriptar", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else if (textEncrypt.length() != passEncrypt.length()) {
					JOptionPane.showMessageDialog(null, "El texto y clave deben tener la misma longitud", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					OneTimePad encryptOTP = new OneTimePad();
					resultEncryptOTP.setText(encryptOTP.cifrarTextoOneTimePad(textEncrypt, passEncrypt));
				}
			}
		});

		JLabel filled2 = new JLabel("                            ");
		panel.add(filled2);

		JLabel titleAB = new JLabel("Desencriptación por Atbash");
		panel.add(titleAB);

		JLabel filled3 = new JLabel("                                                    ");
		panel.add(filled3);

		JLabel textDesencryptAB = new JLabel("Texto a Descifrar");
		panel.add(textDesencryptAB);

		JTextArea fieldDesencryptAB = new JTextArea(6, 36);
		panel.add(new JScrollPane(fieldDesencryptAB));

		JLabel textResultDesencryptAB = new JLabel("Texto Descifrado:");
		panel.add(textResultDesencryptAB);

		JTextArea resultDesencryptAB = new JTextArea(6, 36);
		panel.add(new JScrollPane(resultDesencryptAB));

		JButton buttonDesencryptAB = new JButton("Descifrar por Atbash");
		panel.add(buttonDesencryptAB);
		buttonDesencryptAB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textDesencrypt = fieldDesencryptAB.getText();

				if (textDesencrypt.length() == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un texto para desencriptar", "Alerta",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Atbash desencryptAB = new Atbash();
					resultDesencryptAB.setText(desencryptAB.descifrarTextoAtbash(textDesencrypt));
				}
			}
		});

		add(panel);
	}

	public static void main(String[] args) {
		UISeguridadInformatica gui = new UISeguridadInformatica();
		gui.setBounds(0, 0, 450, 750);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
