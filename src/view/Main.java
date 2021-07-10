package view;

import business.control.Facade;
import util.InfraException;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		IForms sistemUI = null;
		try {
			sistemUI = new SistemUI();
		} catch (InfraException e) {
			e.printStackTrace();
		}
		Boolean cond = true;

//		try {
//			sistemUI = new SistemUI();
//		}
//		catch (InfraException e){
//			JOptionPane.showMessageDialog(null, e.getMessage());
//			return;
//		}

		while(cond){
			cond = sistemUI.menu();
		}
		try{
			Facade.getInstance().saveData();
		}
		catch (InfraException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
//		sistemUI.close();
	}

}
