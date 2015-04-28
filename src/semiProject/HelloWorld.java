package semiProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JButton;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import edu.cmu.sphinx.instrumentation.AccuracyTracker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.speech.recognition.ResultToken;
import edu.cmu.sphinx.util.props.InternalConfigurationException;

public class HelloWorld extends OutputStream{
	private static int click=0;
	JTextArea textArea; 

    private final StringBuilder sb = new StringBuilder();

    public  HelloWorld(JTextArea textArea) {
        this.textArea = textArea;
    }

   @Override
    public void write(int b) throws IOException {

        if (b == '\r') {
            return;
        }

        if (b == '\n') {
            final String text = sb.toString() + "\n";

            textArea.append(text);
            sb.setLength(0);
        } else {
            sb.append((char) b);
        }
    }
   
	static int i=1;
	static String resultText;
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new BorderLayout());
    	JTextArea ta = new JTextArea(24,80);
    	JButton but = new JButton("START");
    	System.setOut(new PrintStream(new HelloWorld(ta)));
    	frame.add(but,BorderLayout.NORTH);
    	frame.add(new JScrollPane(ta), BorderLayout.CENTER);
    	frame.pack();
    	frame.setVisible(true);
    	but.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			System.out.println("Starting the recognizer....");
    		}
    	});
        try {
            System.out.println("Loading...");

            ConfigurationManager cm = new ConfigurationManager(HelloWorld.class.getResource("helloworld.config.xml"));
            

	        Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
	        recognizer.allocate();
	        Microphone microphone = (Microphone) cm.lookup("microphone");
	 
	        System.out.println("HI");
	    
            if (microphone.startRecording())
            {	
            	System.out.println("Say: (Command | Program| Browser | Bluetooth |  Device Manager |Power Options |Cal | Control | Player |task manager | Windows Security Center)");
            	System.out.println("Say: ( open word | open phot oshop|open Access|start Excel|start nero |start fire wall| open Pad |open Paint)");
            while (true) 
            {
            	
            	
		    System.out.println("Start speaking. Press Ctrl-C to quit.\n");		 
		    Result result = recognizer.recognize();
		    if (result != null)
		    {
		    	
		    		System.out.println("Enter your choise"+ "\n");
			 resultText = result.getBestFinalResultNoFiller();
			System.out.println("You said: " + resultText + "\n");
			
			if(resultText.equalsIgnoreCase("Command"))
 			{
 				try{
 				Process p;
 				p = Runtime.getRuntime().exec("cmd /c start cmd");
 				
 				}catch(Exception er)
 				{}
 			}if (resultText.equalsIgnoreCase("close command"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Power Options"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c powercfg.cpl");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Blue"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c fsquirt");
 		     
 		        }catch(Exception ae){}
 		    }
 			
 			if (resultText.equalsIgnoreCase("Close Blue"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im fsquirt.exe /f");
 		     
 		        }catch(Exception ae){}
 		    }
 		
 			if (resultText.equalsIgnoreCase("start photo shop"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start photoshop");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("calculator"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start calc");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("close calculator"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im fsquirt.exe /f");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("fire fox"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start firefox.exe");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Windows Security Center"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c wscui.cpl");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Player"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start wmplayer");
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Close Player"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im wmplayer.exe /f");
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Program"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start appwiz.cpl");
 		        }catch(Exception ae){}
 		    }
 			
 			if (resultText.equalsIgnoreCase("control"))
 			    {
 			        try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c control");
 			        }catch(Exception ae){}
 			    }

 			if (resultText.equalsIgnoreCase("open paint"))
 			{	 try{
 				        Process p;
 				        p = Runtime.getRuntime().exec("cmd /c start mspaint");
 				        }catch(Exception ae){}
 			}
 			if (resultText.equalsIgnoreCase("close paint"))
 			{	 try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im mspaint.exe /f");
 		        }catch(Exception ae){}
 			}
 			if (resultText.equalsIgnoreCase("close calculator"))
 			{	 try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
 		        }catch(Exception ae){}
 	}
 			if (resultText.equalsIgnoreCase("Browser"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start chrome.exe");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("close Browser"))
 			    {
 			        try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
 			        }catch(Exception ae){}
 			     }
 			
 			if(resultText.equalsIgnoreCase("task manager"))
 				{	 try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
 			        }catch(Exception ae){}
 				}
 			if(resultText.equalsIgnoreCase("Adobe"))
 			{	 try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start acrord32.exe");
 		        }catch(Exception ae){}
 			}
 			if(resultText.equalsIgnoreCase("site face book"))
 			{	 try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.facebook.com");
 		        }catch(Exception ae){}
 			}
 			if(resultText.equalsIgnoreCase("site go girl"))
 			{	 try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.google.com");
 		        }catch(Exception ae){}
 			}
 			if(resultText.equalsIgnoreCase("site mail"))
 			{	 try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start chrome https://mail.google.com");
 		        }catch(Exception ae){}
 			}
 		    if(resultText.equalsIgnoreCase("close task manager"))
 				{	 try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
 			        }catch(Exception ae){}
 		}
 			if (resultText.equalsIgnoreCase("open pad"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start notepad");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("close pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im notepad.exe /f");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("word"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start winword");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("close word"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im winword.exe /f");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("start word pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c  write");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("stop word pad"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c  start taskkill /im wordpad.exe /f");
 		        }catch(Exception ae){}
 		     }
 			
 			if (resultText.equalsIgnoreCase("start Excel"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start excel");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("stop Excel"))
 			    {
 			        try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im excel.exe /f");
 			        }catch(Exception ae){}
 			     }
 			if (resultText.equalsIgnoreCase("start firewall"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start firewall.cpl");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("close fire wall"))
 		    {
 		        try{
 		        Process p;
 		        String status = "status eq Windows Firewall";
 		        p = Runtime.getRuntime().exec("cmd /c taskkill /f /fi " +status );
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("start nero"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start nero");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("open Access"))
 		    {
 		        try{
 		        Process p;
 		        p = Runtime.getRuntime().exec("cmd /c start msaccess");
 		        }catch(Exception ae){}
 		     }
 			if (resultText.equalsIgnoreCase("close access"))
 		    {
 		        try{
 		        Process p;	
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im msaccess.exe /f");
 		        }catch(Exception ae){}
 		     }
 			if(resultText.equalsIgnoreCase("speech recognize complete"))
 		    {
 				try{
 					System.out.println("Thanks for using !");
 					recognizer.deallocate();
 					System.exit(0);}
 				catch(Exception ecomp ){}
 		    }
 			if(resultText.equalsIgnoreCase("speech recognize start"))
 		    {
 				try{
 					
 					recognizer.notify();
 					System.out.println("Hello again :-) ");
 					System.exit(0);}
 				catch(Exception estart ){}
 		    }
 			if(resultText.equalsIgnoreCase("stop recognize"))
 		    {
 				try{
 					
 					System.out.println("See you later!");
 					System.exit(0);}
 				catch(Exception estop ){}
 		    }
 			if (resultText.equalsIgnoreCase("Device Manager"))
 			    {
 			        try{
 			        Process p;
 			        p = Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
 			        }catch(Exception ae){}
 			     }
 		
 		    }
		    
	    	else
		   	{
						System.out.println("I can't hear what you said.\n");
		    }
       }
	   } 
        else
        {
        	System.out.println("Cannot start microphone.");
        	recognizer.deallocate();
        	System.exit(1);
	    }
            
        } catch (PropertyException e) {
            System.err.println("Problem configuring HelloWorld: " + e);
            e.printStackTrace();
        } 
    	} 
    
}

