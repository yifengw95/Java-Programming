// Name:yifeng wang
// USC NetID:3926260250
// CS 455 PA1
// Fall 2018
import java.util.*;

public class CoinTossSimulatorTester{
	
	public static void main(String[] args) {
		CoinTossSimulator coin = new CoinTossSimulator();

		boolean ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
		System.out.println("After constructor:");
		System.out.println("Number of trials [exp:0]: " + coin.getNumTrials());
		System.out.println("Two-head tosses:" + coin.getTwoHeads());
		System.out.println("TwoTails Toss: " + coin.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coin.getHeadTails());
        ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
        System.out.println("Tosses add up correcly? " + ifAddUpCorrectly);
        System.out.println();

        System.out.println("After run(1)");
        coin.run(1);
		System.out.println("Number of trials [exp:1]: " + coin.getNumTrials());
		System.out.println("Two-head tosses:" + coin.getTwoHeads());
		System.out.println("TwoTails Toss: " + coin.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coin.getHeadTails());
        ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
        System.out.println("Tosses add up correcly? " + ifAddUpCorrectly);
        System.out.println();

        System.out.println("After run(10)");
        coin.run(10);
		System.out.println("Number of trials [exp:11]: " + coin.getNumTrials());
		System.out.println("Two-head tosses:" + coin.getTwoHeads());
		System.out.println("TwoTails Toss: " + coin.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coin.getHeadTails());
        ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
        System.out.println("Tosses add up correcly? " + ifAddUpCorrectly);
        System.out.println();

        System.out.println("After run(100)");
        coin.run(100);
		System.out.println("Number of trials [exp:111]: " + coin.getNumTrials());
		System.out.println("Two-head tosses:" + coin.getTwoHeads());
		System.out.println("TwoTails Toss: " + coin.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coin.getHeadTails());
        ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
        System.out.println("Tosses add up correcly? " + ifAddUpCorrectly);
        System.out.println();

        System.out.println("After RESET");
        coin.reset();
		System.out.println("Number of trials [exp:0]: " + coin.getNumTrials());
		System.out.println("Two-head tosses:" + coin.getTwoHeads());
		System.out.println("TwoTails Toss: " + coin.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coin.getHeadTails());
        ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
        System.out.println("Tosses add up correcly? " + ifAddUpCorrectly);
        System.out.println();

        System.out.println("After run(1000)");
        coin.run(1000);
		System.out.println("Number of trials [exp:1000]: " + coin.getNumTrials());
		System.out.println("Two-head tosses:" + coin.getTwoHeads());
		System.out.println("TwoTails Toss: " + coin.getTwoTails());
        System.out.println("One Head-One Tail Toss: " + coin.getHeadTails());
        ifAddUpCorrectly = (coin.getNumTrials() == (coin.getTwoHeads()+coin.getTwoTails()+coin.getHeadTails()));
        System.out.println("Tosses add up correcly? " + ifAddUpCorrectly);
        System.out.println();




	}



}
