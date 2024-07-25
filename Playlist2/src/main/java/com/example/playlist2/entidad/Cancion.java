package com.example.playlist2.entidad;


import jakarta.persistence.*;

@Entity
public class Cancion {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String titulo;
	    private String artista;
	    private String album;
	    private int anio;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getArtista() {
			return artista;
		}
		public void setArtista(String artista) {
			this.artista = artista;
		}
		public String getAlbum() {
			return album;
		}
		public void setAlbum(String album) {
			this.album = album;
		}
		public int getAño() {
			return anio;
		}
		public void setAño(int año) {
			this.anio = año;
		}
	    
	    
}
