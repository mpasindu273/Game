import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class game implements ActionListener
{

    JFrame f,f1, fstrt;
    JPanel p,pu,pd,endp, strtp;
    JLabel l,sl,endl,lstrt;
    JButton b1,b2,br, bstrt;
    JComponent cir,bar1,bar2;
    Timer tim;
    static int hor=1,rep,d,u,vert=1,prevalx,prevaly,postvalx,postvaly,low,high,retry,score=0;
    Font ft=new Font("Arial Black",Font.BOLD,20);
    Font over=new Font("Arial Black",Font.BOLD,25);
    Font strt=new Font("Arial Black",Font.BOLD,30);
    
    
    public void start(){
    
             fstrt=new JFrame();
             fstrt.setLayout(null);
             fstrt.setVisible(true);
	     fstrt.setSize(296,500);     
             fstrt.setResizable(false);
	     fstrt.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
             
             strtp=new JPanel();
             strtp.setBackground(Color.gray);
             strtp.setLayout(null);
             strtp.setBounds(0,0,296,480);
             
             lstrt=new JLabel();
             lstrt.setText("welcome!");
             lstrt.setBounds(55,100,200,50);
             lstrt.setFont(strt);
             lstrt.setForeground(Color.white);
             strtp.add(lstrt);
             
             bstrt=new JButton("Start");
             bstrt.setBounds(90,325,100,40);
             bstrt.addActionListener(this);
             strtp.add(bstrt);
             
             fstrt.add(strtp);                                              
    }
    
    public void gameplay(){
        
           f1=new JFrame("Java game");
           f1.setLayout(null);
           f1.setVisible(true);
	   f1.setSize(296,500);       
           f1.setResizable(false);
	   f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                     

            b1=new JButton("<<");
            b1.setBounds(30,10,100,40);
	    b1.setFont(ft);
            b1.addActionListener(this);
            
            b2=new JButton(">>");
            b2.setBounds(160,10,100,40);
            b2.setFont(ft);
            b2.addActionListener(this);
            
            sl=new JLabel();
            sl.setText("Score:                 "+score);
            sl.setBounds(20,0,300,50);
            sl.setFont(ft);
            sl.setForeground(Color.black);
                        
            p=new JPanel();
            p.setBackground(Color.black);
            p.setLayout(null);
            p.setBounds(0,50,281,340);
            
            pu=new JPanel();
            pu.setBackground(Color.gray);
            pu.setLayout(null);
            pu.setBounds(0,0,300,50);
            
            pd=new JPanel();
            pd.setBackground(Color.gray);
            pd.setLayout(null);
            pd.setBounds(-7,390,300,200);
            
           
       cir=new JComponent(){
       public void paint(Graphics g){
            g.setColor(Color.GREEN);            
            g.fillOval(0,0,15,15);
            
        }};
            cir.setBounds(10,10,100,100);
            
       bar1=new JComponent(){
       public void paint(Graphics g){
            g.setColor(Color.WHITE);            
            g.fillRect(0,0,60,10);
            
        }}; 
            bar1.setBounds(220,0,100,100);
            
       bar2=new JComponent(){
       public void paint(Graphics g){
            g.setColor(Color.WHITE);            
            g.fillRect(0,0,60,10);
            
        }}; 
            bar2.setBounds(220,328,100,100);    
           
            
            p.add(cir);
            p.add(bar1);
            p.add(bar2);
            pu.add(sl);
            pd.add(b1);
            pd.add(b2);
            f1.add(pu);
            f1.add(pd);
            f1.add(p);    
            
            
                  
           
   tim=new Timer(100,new ActionListener()
    {
 
    public void actionPerformed(ActionEvent e)
      {
        high=bar1.getX()+60;//55
        low=bar1.getX()-8;//15
        
        prevalx=cir.getX();
        prevaly=cir.getY();
        cir.setLocation(cir.getX()+10*hor,cir.getY()+10*vert);
        postvalx=cir.getX();
        postvaly=cir.getY();
   
        sl.setText("Score:                 "+score);   
        
      //down
       if(postvaly>prevaly || retry==1){
            //moving to right
            if(prevalx<postvalx){
               //if retry is pressed the program must come here first, regardless of prevals.
               if(retry==1){
                    vert=1;
                    hor=1;
                    retry=0;
               }
                        
               if(cir.getX()>=256){
                       vert=1;
                       hor=-1;
                         
                }
                   
               if(cir.getY()>=310){
                    if(cir.getX()<=high && cir.getX()>=low ){ 
                       vert=-1;
                       hor=1;  score++;
                    }
                    
                }
              
            }//right 
            
            
            //moving to left
            else if(prevalx>postvalx){               
                   
               if(cir.getY()>=310){
                    if(cir.getX()<=high && cir.getX()>=low ){ 
                       vert=-1;
                       hor=-1;  score++;
                    }      
              }
               
               if(cir.getX()<=9){               
                       vert=1;
                       hor=1;   
                    
                   }           
            }//left            
     } //down
       
       
       //up
       else if(postvaly<prevaly && retry==0)
           {
          
                //moving to right
            if(prevalx<postvalx){
                         
               if(cir.getX()>=256){
                       vert=-1;
                       hor=-1;
                         
                   }         
               
                      
               if(cir.getY()<=19){
                     if(cir.getX()<=high && cir.getX()>=low ){ 
                       vert=1;
                       hor=1;  score++;
                    }
                }                     
            }//right 
            
            
            //moving to left
            else if(prevalx>postvalx){
               
               if(cir.getX()<=9){               
                       vert=-1;
                       hor=1;   
                    
                   }
                 
               if(cir.getY()<=19){
                    if(cir.getX()<=high && cir.getX()>=low ){ 
                       vert=1;
                       hor=-1;  score++;
                    }
               } 
            }//left              
       }  //up    
       
            //is out of bounds?
            if(cir.getY()>=340 || cir.getY()<=-20){
                 retry=1;
                 tim.stop();                   
                 f1.dispose();
                 retry();
            }
            
   }//actionperformed    
});
           tim.start();
            
     
 } //end method
                
 
    
     @Override
	public void actionPerformed(ActionEvent e)
	{
             if(e.getSource()==bstrt)
                {
                 fstrt.dispose();
                 gameplay();
                }
            
            
                if(e.getSource()==b1)
                {
                    if(bar1.getX()>0)
                    {
                 bar1.setLocation(bar1.getX()-20,bar1.getY()); 
                 bar2.setLocation(bar2.getX()-20,bar2.getY()); 
                    }
                }
                
	       if(e.getSource()==b2)
                {
                    if(bar1.getX()<220)
                    {
                 bar1.setLocation(bar1.getX()+20,bar1.getY()); 
                 bar2.setLocation(bar2.getX()+20,bar2.getY()); 
                    }
                }
               
               if(e.getSource()==br)
               {
                 f.dispose();
                 start();
               }
               
                              
        }       
   
        
        public void retry(){
             f=new JFrame();
             f.setLayout(null);
             f.setVisible(true);
	     f.setSize(296,500);     
             f.setResizable(false);
	     f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
             
             endp=new JPanel();
             endp.setBackground(Color.gray);
             endp.setLayout(null);
             endp.setBounds(0,0,296,480);
             
             l=new JLabel();
             l.setText("GAME OVER");
             l.setBounds(48,100,200,50);
             l.setFont(over);
             l.setForeground(Color.black);
             endp.add(l);
             
             endl=new JLabel();
             endl.setText("Score:  "+score);
             endl.setBounds(85,170,200,50);
             endl.setFont(ft);
             endl.setForeground(Color.black);
             endp.add(endl);
             
             br=new JButton("Retry");
             br.setBounds(90,325,100,40);
             br.addActionListener(this);
             endp.add(br);
             
             f.add(endp);
             score=0;
        }

    public static void main(String args[]){
       game a=new game();
       a.start();
    }
    }
