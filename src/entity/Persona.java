package entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable{
	private String nombre;
	private int edad;
	private String mail;
	
	public Persona(String nombre, int edad, boolean sexo, String mail) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.mail = mail;
	}
	
	public Persona(Parcel in) {
		// TODO Auto-generated constructor stub
		nombre = in.readString();
		edad = in.readInt();
		mail = in.readString();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(nombre);
		dest.writeInt(edad);
		dest.writeString(nombre);
		dest.writeString(mail);
	}
	
	public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
		public Persona createFromParcel(Parcel in) {
			return new Persona(in);
		}

		public Persona[] newArray(int size) {
			return new Persona[size];
		}
	};
}
