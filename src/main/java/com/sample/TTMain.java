package com.sample;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class TTMain {

    public static final void main(String[] args) {
        try {
        	JFrame.setDefaultLookAndFeelDecorated(true);
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
        	JFrame frame = new JFrame("Welcome");
        	JOptionPane.showMessageDialog(frame, "This program will help you choose a timetravel-themed movie.\n" + "On each step, choose the option you prefer.\n" + "At the end the program will show you one or more suggestions.", "Time-Travel Movies Picker", JOptionPane.PLAIN_MESSAGE);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    
    public static class Zapytanie{
    	private  String pytanie;
		private  String odp1;
    	private  String odp2;
    	private  String odpowiedz;
    	
    	
    	public String getOdpowiedz() {
			return odpowiedz;
		}


		public void setOdpowiedz(String odpowiedz) {
			this.odpowiedz = odpowiedz;
		}


		public  String getPytanie() {
			return pytanie;
		}


		public  void setPytanie(String pytanie) {
			this.pytanie = pytanie;
		}


		public  String getOdp1() {
			return odp1;
		}


		public  void setOdp1(String odp1) {
			this.odp1 = odp1;
		}


		public  String getOdp2() {
			return odp2;
		}


		public  void setOdp2(String odp2) {
			this.odp2 = odp2;
		}


    	
    	
    	public Zapytanie(String p, String od1, String od2)
    	{
    		this.pytanie = p;
    		this.odp1 = od1;
    		this.odp2 = od2; 
    		this.odpowiedz = this.zapytaj();
    	}
    	
    	public String zapytaj() {
    		String result = "";
    		if(this.odp1==this.odp2)
    		{
    			System.out.println("Bledne zapytanie. " + this.pytanie +  "Obie odpowiedzi sa takie same.");
    		}
    		else {
    			JFrame frame = new JFrame("Test");
    			
    			//JOptionPane.showMessageDialog(frame,"Problem writing to backup directory:.");
    			Object[] options = { this.odp1, this.odp2};
    			int i = -1;
    			i = JOptionPane.showOptionDialog(frame, this.pytanie, "Do you want...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    			if(i != -1)
    			{
    				result = options[i].toString();
    			}
    			
        		
    		}
    		return result;
    		
    	}
    	
    	
    }
    
    public static class Odpowiedz{
    	private String odpowiedz;
    	
    	public Odpowiedz(String od)
    	{
    		this.odpowiedz = od;
    		
    		JFrame frame = new JFrame("Test");
        	JOptionPane.showMessageDialog(frame, this.odpowiedz, "Suggestion", JOptionPane.WARNING_MESSAGE);
        	
    	}
    	
    	
    }

}
