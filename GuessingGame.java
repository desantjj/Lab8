import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel promptLabel;
  JLabel highLowLabel;
  JLabel lastGuessLabel;
  Random r = new Random();
  int randomNum;

  GuessingGame() {
    randomNum = r.nextInt(101);

    JFrame frame = new JFrame("Guessing Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(240,120);

    userGuess = new JTextField(10);
    userGuess.setActionCommand("myTF");

    guessButton = new JButton("Guess");
    playAgainButton = new JButton("Play Again");

    userGuess.addActionListener(this);
    guessButton.addActionListener(this);
    playAgainButton.addActionListener(this);

    promptLabel = new JLabel("Enter your guess: ");
    highLowLabel = new JLabel("");
    lastGuessLabel = new JLabel("");

    frame.add(promptLabel);
    frame.add(userGuess);
    frame.add(guessButton);
    frame.add(highLowLabel);
    frame.add(lastGuessLabel);
    frame.add(playAgainButton);

    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae) {
    if(ae.getActionCommand().equals("Guess")) {
      int guess = Integer.parseInt(userGuess.getText());
      if(guess < randomNum) {
        highLowLabel.setText("Too Low!");
      }
      else if(guess > randomNum) {
        highLowLabel.setText("Too High!");
      }
      else {
        highLowLabel.setText("You got it!");
      }
      lastGuessLabel.setText("Last guess was " + userGuess.getText());
    }
    else if(ae.getActionCommand().equals("Play Again")) {
      randomNum = r.nextInt(101);
      promptLabel.setText("Enter your guess: ");
      highLowLabel.setText("");
      lastGuessLabel.setText("");
      userGuess.setText("");
    }
    else {
      highLowLabel.setText("You pressed Enter. Please press the Guess Button");
    }
  }
}