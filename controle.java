package jogo1;
import java.util.Random;
import javax.swing.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class controle {
	static int jo=0,pal=0,ini=0,fin=0,aux=0,numc,num,pa=0;
	static String s,nome,numf="",tudo="",in="";
	static Scanner sc = new Scanner(System.in);
	static ArrayList< jogador> l = new ArrayList();
	public String iniciaJogo()
	{
		try {
			do
			{
				s=JOptionPane.showInputDialog(null,"Digite 1 para iniciar o jogo ou 2 para finalizalo");
				pa = Integer.parseInt(s);
				if (pa==1)
				{
					in = "O jogo sera iniciado";
				}
				else
				{
					if(pa==2)
					{
						in = "O jogo sera finalizado";
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Valor invalido");
					}
				}
			}while(pa !=1 && pa!=2);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Valor invalido por favor digitar novamente");
			sc = new Scanner(System.in);
		}
		return in;
	}
	public int numjo()
	{
		do
		{
			try {
				s=JOptionPane.showInputDialog(null,"Informe o numero de jogadores minimo 3");
				jo = Integer.parseInt(s);
				if(jo<3)
				{
					JOptionPane.showMessageDialog(null,"Valor invalido minimo de 3");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Valor invalido por favor digitar novamente");
				sc = new Scanner(System.in);
			}
		}while(jo<3);
		return jo;
	}
	public int numpa()
	{
		do
		{
			try {
				s=JOptionPane.showInputDialog(null,"Informe a quantidade de palpites entre 1 e 4");
				pal = Integer.parseInt(s);
				if(pal<1 || pal>4)
				{
					JOptionPane.showMessageDialog(null,"Valor invalido informar valor entre 1 e 4");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Valor invalido por favor digitar novamente");
				sc = new Scanner(System.in);
			}
		}while(pal<1 || pal>4);
		return pal;
	}
	public int entraini()
	{

		try {
			s=JOptionPane.showInputDialog(null,"Informe o valor inicial");
			ini = Integer.parseInt(s);
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Valor invalido por favor digitar novamente");
			sc = new Scanner(System.in);
		}
		
		return ini;
	}
	public int entrafin()
	{
		do
		{
			try {
				s=JOptionPane.showInputDialog(null,"Informe o valor final");
				fin = Integer.parseInt(s);
				if(fin<ini+50)
				{
					JOptionPane.showMessageDialog(null,"Valor informado nao atendo o intervalo");
				}
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Valor invalido por favor digitar novamente");
				sc = new Scanner(System.in);
			}
		}while(fin<ini+50);
		
		return ini;
	}
	public String fim()
	{
		tudo="";
		do
		{
			numc = geraNumero(ini, fin);
		}while(numc<ini||numc>fin);
		for(int i =0;i<jo;i++)
		{
			jogador jg = new jogador();
			nome = geraNome();
			jg.setNome(nome);
			for(int j=0;j<pal;)
			{
				num = geraNumero(ini, fin);
				if(num>=ini && num<=fin)
				{
					if( num == numc)
					{
						numf += num + "-certo\n";
					}
					else
					{
						numf += num + "-errado\n";
					}
					jg.setNum(numf);
					j++;
				}
			}
			l.add(jg);
			numf="";
		}
		for(int i =0;i<l.size();i++)
		{
			jogador jg = l.get(i);
			tudo += jg.getNome() +"\n"+ jg.getNum();
		}
		l.clear();
		tudo +="O numero certo é ="+ numc+"\n";
		return tudo;
	}
	public int geraNumero(int y,int z)
	{
		Random r = new Random();
		int aux=0;
		aux = r.nextInt(z)+y;
		return aux;
	}
	public String geraNome()
	{
		Random r = new Random();
		int numero;
		char letra;
		String nome="";
		numero = r.nextInt(26)+65;
		letra = (char)numero;
		nome += Character.toString(letra);
		for(int i=0;i<9;i++)
		{
			numero = r.nextInt(26)+97;
			letra = (char)numero;
			nome += Character.toString(letra);
		}
		return nome;
	}

}