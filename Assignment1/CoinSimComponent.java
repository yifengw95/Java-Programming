// Name:yifeng wang
// USC NetID:3926260250
// CS 455 PA1
// Fall 2018
import java.math.*;
import javax.swing.*;
import java.awt.*;

public class CoinSimComponent extends JComponent{

	private int numbOfTwoHeads;
    private int numbOfTwoTails;
    private int numbOfAHeadAndATail;
   
    private double percentOfTwoHeads;
    private double percentOfTwoTails;
    private double percentOfAHeadAndATail;
    private int numberOfTrials;

	public CoinSimComponent(int numOfTrials){

		this.numberOfTrials = numOfTrials;
		CoinTossSimulator coin = new CoinTossSimulator();
		coin.run(numOfTrials);

		numbOfTwoHeads = coin.getTwoHeads();
        numbOfTwoTails = coin.getTwoTails();
        numbOfAHeadAndATail = coin.getHeadTails();

        percentOfTwoHeads = (double) numbOfTwoHeads / numOfTrials;
        percentOfTwoTails = (double)numbOfTwoTails / numOfTrials;
        percentOfAHeadAndATail = (double)numbOfAHeadAndATail / numOfTrials;

	}

	public void paintComponent (Graphics g){

		int panelWidth = getWidth();
        int panelHeight = getHeight();

        int bottom = (int)(panelHeight*0.618);
        int width = (int)(panelWidth*0.0618);

        int left1 = (int)(panelWidth*0.25-0.5*width);
        int left2 = (int)(panelWidth*0.5-0.5*width);
        int left3 = (int)(panelWidth*0.75-0.5*width);

        int barHeight = (int)(panelHeight*0.618);

        double scaleOfTwoHeads = percentOfTwoHeads;
        double scaleOfAHeadAndATail = percentOfAHeadAndATail;
        double scaleOfTwoTails = percentOfTwoTails;

         Graphics2D g2 = (Graphics2D) g;

        Bar bar1 = new Bar(bottom,left1,width,barHeight,
       		scaleOfTwoHeads,Color.red, "Two Heads: "+numbOfTwoHeads+"("+Math.round(percentOfTwoHeads*100)+"%)");
        bar1.draw(g2);

        Bar bar2 = new Bar(bottom,left2,width,barHeight,
            scaleOfAHeadAndATail,Color.green, "A Head and A Tail: "+numbOfAHeadAndATail+"("+Math.round(percentOfAHeadAndATail*100)+"%)");
        bar2.draw(g2);

        Bar bar3 = new Bar(bottom,left3,width,barHeight,
            scaleOfTwoTails,Color.blue, "Two Tails: "+numbOfTwoTails+"("+Math.round(percentOfTwoTails*100)+"%)");
        bar3.draw(g2);

	}


}
