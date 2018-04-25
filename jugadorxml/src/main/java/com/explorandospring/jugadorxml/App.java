package com.explorandospring.jugadorxml;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.explorandospring.jugadorxml.beans.Barcelona;
import com.explorandospring.jugadorxml.beans.Jugador;
import com.explorandospring.jugadorxml.beans.Juventus;

public class App 
{
    public static void main( String[] args )
    {
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Elija un equipo: 1- Barcelona 2_Juventus");
    	int respuesta = sc.nextInt();
    	
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("com/explorandospring/jugadorxml/xml/beans.xml");
        
        Jugador jug = (Jugador) appContext.getBean("jugador1");
    	
    	switch (respuesta) {
		case 1:
			jug.setEquipo(new Barcelona());
			break;
		case 2:
			jug.setEquipo(new Juventus());
			break;

		default:
			break;
		}
    	
        
        
        
        System.out.println(jug.getNombre() + "-" + jug.getEquipo().mostrar() + "-" + jug.getCamiseta().getNumero() + "-" + jug.getCamiseta().getNumero() + "-" + jug.getCamiseta().getMarca().getNombre());
         
        ((ConfigurableApplicationContext) appContext).close();
        
    }
}
