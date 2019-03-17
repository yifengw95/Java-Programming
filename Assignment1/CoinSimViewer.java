// Name:yifeng wang
// USC NetID:3926260250
// CS 455 PA1
// Fall 2018
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

public class CoinSimViewer {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of trials: ");
        int number = in.nextInt();
        while(number <= 0){
        	System.out.println("ERROR: Number entered must be greater than 0");
            System.out.print("Please enter again!");
            number = in.nextInt();
        }

        JFrame frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		CoinSimComponent component = new CoinSimComponent(number);
        frame.add(component);

        frame.setVisible(true);
	}


}