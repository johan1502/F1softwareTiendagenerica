package co.edu.unbosque.model.persistence;
import java.io.*;
import java.util.*;

public class Persistencia {
	
	private File archivo;
	
	public Persistencia() {}
	
	public Persistencia(String file) {
		archivo = new File(file);
	}
		
	public <T> void agregarDato(T value, File file) {
		ObjectOutputStream escribir;
		try {
			if(file.length() == 0) {
				escribir = new ObjectOutputStream(new FileOutputStream(file));
			}else {
				escribir = new ObjectOutputStreamWriter(new FileOutputStream(file, true));
			}
			
			escribir.writeObject(value);
			escribir.writeUTF("\n");
			escribir.flush();
			escribir.close();
			
		}catch(Exception e) {}
	}
	
	@SuppressWarnings("unchecked")
	public <T> LinkedList <T> lecturaArchivo(File file){
		LinkedList <T> lista = new LinkedList <T> ();
		T objeto;
		try {
			ObjectInputStream leer = new ObjectInputStream(new FileInputStream(file));
			try {
				while(true) {
					objeto = (T) leer.readObject(); leer.readUTF();
					lista.add(objeto);
				}
			} catch(EOFException f) {}
			leer.close();
		} catch(Exception e) {}
		return lista;
	}
	
	public void escrituraCheques(String cheque, File file) {
		FileOutputStream flujo;
		DataOutputStream escritura;
		try {
			flujo = new FileOutputStream(file, true);
			escritura = new DataOutputStream(flujo);
			
			escritura.writeUTF(cheque);
			escritura.close();
			flujo.close();
			
		} catch(Exception e) {}
	}
	
	public String lecturaCheque(File file) {
		FileInputStream flujo;
		DataInputStream leer;
		String contenido = "";
		try {
			flujo = new FileInputStream(file);
			leer = new DataInputStream(flujo);
			while(leer.available() > 0) {
				contenido += leer.readUTF();
			}
		} catch(Exception r) {}
		return contenido;
	}
	
	
	
	static class ObjectOutputStreamWriter extends ObjectOutputStream{

		public ObjectOutputStreamWriter(OutputStream out) throws IOException{
			super(out);
		}
		
		public ObjectOutputStreamWriter() throws IOException, SecurityException {
			super();
		}
		
		@Override
		protected void writeStreamHeader() throws IOException{}

	}

}