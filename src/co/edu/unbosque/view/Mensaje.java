package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class Mensaje {
	
	public Mensaje() {}
	
	public int leerDato(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		int dato = Integer.parseInt(aux);
		return dato;
	}
	
	public String leerString(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		return aux;
	}
	
	public void mostrarInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void errorMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Algo esta mal, revisa", JOptionPane.ERROR_MESSAGE);
	}
	
	public void warningMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Peligroooo", JOptionPane.WARNING_MESSAGE);
	}
}
