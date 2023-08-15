package ui;

import java.text.ParseException;
import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws ParseException {

		Executable exe = new Executable();
		exe.menu();

	}

	// Incomplete
	public void menu() throws ParseException {

		
        System.out.println("Bienvenido al menu de GreenSQA");
        boolean flag=false;
    
        while (!flag){

            System.out.println("1.Crear un proyecto"); 
            System.out.println("2.Consultar Proyectos antes de una fecha");
            System.out.println("3.Consultar Proyectos despues de una fecha");
			System.out.println("4.Salir");
            int opcion=reader.nextInt();


            switch (opcion){
                case 1:
                RegisterProject();
                break;
                case 2:
				searchProjectsAfterDate();
                break;
                case 3:
                searchProjectsBeforeDate();
                break;
                case 4:
				flag=true;
				break;
            }
        }



	}

	//Incomplete
	public void RegisterProject() {

		reader.nextLine();

        System.out.println("Digite a contunuacion la informacion de un proyecto");

        System.out.println("Digite el nombre del proyecto");
        String name= reader.nextLine();

        System.out.println("Digite el nombre del cliente");
        String clientName= reader.nextLine();

        System.out.println("Digite la fecha de inicio del proyecto");
        System.out.println("Digite el dia");
        int diaInicial= reader.nextInt();
        System.out.println("Digite el mes");
        int mesInicial= reader.nextInt();
        System.out.println("Digite el año");
        int añoInicial= reader.nextInt();


        System.out.println("Digite la fecha planeada para la finalizacion del proyecto");
        System.out.println("Digite el dia");
        int diaFinal= reader.nextInt();
        System.out.println("Digite el mes");
        int mesFinal= reader.nextInt();
        System.out.println("Digite el año");
        int añoFinal= reader.nextInt();

        reader.nextLine();

       
        System.out.println("Digite el presupuesto del proyecto");
        double budget= reader.nextDouble();

		System.out.println("Digite el tipo del proyecto \n1.Desarrollo \n2.Mantenimiento \n3.Desplguie");
		int type= reader.nextInt();

		if (controller.RegisterProject(name, clientName, controller.crearCalendario(diaInicial, mesInicial, añoInicial), controller.crearCalendario(diaFinal, mesFinal, añoFinal), budget, type)){
            
            System.out.println("El proyecto ha sido registrado exitosamente");

        }else{

            System.out.println("Memoria llena, no se pudo registrar el Proyecto");
            
        }

	}

	//Incomplete
	public void searchProjectsAfterDate() throws ParseException {

		System.out.println("Digite la fecha para consultar proyectos que finalizan antes de la misma");
		System.out.println("Digite el dia");
		int diaDigitado=reader.nextInt();
		System.out.println("Digite el mes");
		int mesDigitado=reader.nextInt();
		System.out.println("Digite el año");
		int añoDigitado=reader.nextInt();
		


		System.out.println(controller.searchProjectsAfterDate(controller.crearCalendario(diaDigitado, mesDigitado, añoDigitado)));

	}
	
	//Incomplete
	public void searchProjectsBeforeDate() throws ParseException {

		System.out.println("Digite la fecha para consultar proyectos que finalizan antes de la misma");
		System.out.println("Digite el dia");
		int diaDigitadoA=reader.nextInt();
		System.out.println("Digite el mes");
		int mesDigitadoA=reader.nextInt();
		System.out.println("Digite el año");
		int añoDigitadoA=reader.nextInt();

		
		System.out.println(controller.searchProjectsBeforeDate(controller.crearCalendario(diaDigitadoA, mesDigitadoA, añoDigitadoA)));
	




	}

	public int suma(){
		return 23+3;
	}
}