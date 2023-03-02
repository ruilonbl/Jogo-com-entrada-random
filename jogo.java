package jogo1;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
public class jogo {
	public static void main(String[] args) {
		String inic = "";
		controle co = new controle();
		do
		{
			inic = co.iniciaJogo();
			JOptionPane.showMessageDialog(null,inic);
			switch(inic) {
				case "O jogo sera iniciado":
					co.entraini();
					co.entrafin();
					co.numjo();
					co.numpa();
				JOptionPane.showMessageDialog(null,co.fim());
				break;
			}
		}while(!inic.equals("O jogo sera finalizado"));

	}
		
}