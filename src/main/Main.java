package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("main.Main");

	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {

		new Thread(

				() -> {
					try {
						// Este elemento nos permite esperar una conexión.
						ServerSocket server = new ServerSocket(5000);

						// Esta linea me permite aceptar la conexión entrante.
						System.out.println("Esperando...");
						
						Socket socket = server.accept();
						
						System.out.println("Conexión aceptada");

						//lector
						InputStream is = socket.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader reader = new BufferedReader(isr);
						
						while(true){
							String line = reader.readLine();
							System.out.println(line);
							
							switch(line){
							case "UP":
								y-=5;
								break;
								
							}
						}
						

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		).start();
	}
	
	int x=250;
	int y=250;

	public void draw() {
		background(255);
		fill(255,60,60);
		noStroke();
		ellipse(x,y,50,50);
	}
}
