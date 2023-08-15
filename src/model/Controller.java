package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}

	public Calendar crearCalendario(int dia, int mes, int año){

		Calendar calendario = new GregorianCalendar(dia,mes,año);

		return calendario; 
	}

	
	//Incomplete
	public boolean RegisterProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget, int type){

		Type typeProject = Type.DESARROLLO;

		switch(type){
			case 1:
			typeProject=Type.DESARROLLO;
			break;
			case 2:
			typeProject=Type.MANTENIMIENTO;
			break;
			case 3:
			typeProject=Type.DESPLIEGUE;
			break;

		}

		Project nuevoProyecto= new Project(name, clientName, initialDate, finalDate, budget, typeProject);


        for (int i=0; i<projects.length; i++){

            if (projects[i]==null){
                projects[i]=nuevoProyecto;
                
                return true;

            }
        }
       		return false;
	}

	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate(Calendar calendarioEntrada)throws ParseException {

		String msg = "";

		for (int i=0; i<projects.length;i++){

			if (projects[i]!=null){
				int validacion=calendarioEntrada.compareTo(projects[i].getFinalDate());

			if (validacion==1){
				msg+= projects[i].getProjectInfo();

			}
		}
	}
		return msg;

	}

	
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate(Calendar calendarioEntrada) throws ParseException {

		String msg = "";


		for (int i=0; i<projects.length;i++){

			if (projects[i]!=null){
				int validacion=calendarioEntrada.compareTo(projects[i].getInitialDate());

			if (validacion==-1){
				msg+= projects[i].getProjectInfo();

			}
		}

	}
		return msg;
	}
	
	


	

}

	

