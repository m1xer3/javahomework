package ru.danilsibgatullin.homeworkleason8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayinField extends JFrame {

    //размер поля
    private final static int LARGE_SIZE =5;
    private final static int LARGE_SEQUENCE =4;
    private final static int SMALL_SIZE =3;
    private final static int SMALL_SEQUENCE =3;
    private int sequenceLenght = SMALL_SEQUENCE;
    private final static String DRAW_EMPTY ="#";
    private final static String DRAW_X ="X";
    private final static String DRAW_O ="O";
    private int humanPoints =0;
    private int computerPoints =0;
    private int difficyltSize =SMALL_SIZE; //по умолчанию маленькое
    public ArrayList<JButton> buttonsArray = new ArrayList<JButton>();
    TicTakToe game;


    public PlayinField() {
        setTitle("TicTacToe game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(300, 300);
        setSize(800, 800);
        setResizable(false);

        JPanel panTop = new JPanel();
        panTop.setSize(200,200);
        JPanel panCentr = new JPanel();
        panCentr.setSize(600,600);
        add(panTop, BorderLayout.NORTH);
        add(panCentr, BorderLayout.CENTER);


        JLabel text1 = new JLabel("Сложность :");
        panTop.add(text1);

        String[] difficultVar = {"Легко", "Сложно"};
        JComboBox comBox = new JComboBox(difficultVar);
        panTop.setLayout(new FlowLayout());
        panTop.add(comBox);
        JButton goButton = new JButton("Поехали!");
        panTop.add(goButton);
        JLabel text2 = new JLabel("Подсчет очков : Игрок : ");
        JLabel humanFild =new JLabel();
        humanFild.setText(""+humanPoints);
        panTop.add(text2);
        panTop.add(humanFild);
        JLabel text3 = new JLabel("Компьютер : ");
        JLabel computerFild =new JLabel();
        computerFild.setText(""+computerPoints);
        panTop.add(text3);
        panTop.add(computerFild);
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                humanFild.setText(""+humanPoints);
                computerFild.setText(""+computerPoints);
                buttonsArray.removeAll(buttonsArray);
                panCentr.removeAll();
                difficyltSize = comBox.getSelectedItem().equals(difficultVar[0]) ? SMALL_SIZE : LARGE_SIZE;
                sequenceLenght = difficyltSize== SMALL_SIZE ? SMALL_SEQUENCE : LARGE_SEQUENCE;
                for (int rowIndex=0;rowIndex<difficyltSize;rowIndex++){
                    for (int colIndex=0;colIndex<difficyltSize;colIndex++){
                        buttonsArray.add(createButton(rowIndex,colIndex));
                    }
                }
                game = new TicTakToe(difficyltSize,sequenceLenght);
                game.setGameOver(false);
                game.initializeGame();
                panCentr.setLayout(new GridLayout(difficyltSize, difficyltSize));
                    for (JButton jButton : buttonsArray) {
                        jButton.setBackground(Color.WHITE);
                        panCentr.add(jButton);
                    }
                paintComponents(panCentr.getGraphics());
            }
        });
        setVisible(true);
    }

    private JButton createButton(int rowIndex , int colIndex) {
        String buttonName = ""+rowIndex+colIndex;
        return new JButton() {
            private int rowIndexButton=rowIndex;
            private int colIndexButton=colIndex;
                {
                    setName(buttonName);
                    setActionCommand(DRAW_EMPTY);
                    addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setActionCommand(DRAW_X);
                            setEnabled(false);
                            game.turn(rowIndexButton,colIndexButton);
                            changeDrawOnButton(game.getLastComputerTurnRow(),game.getLastComputerTurnCol(),buttonsArray);
                            if(game.isGameOver()&&game.isHaveWinner()){
                                if(game.getWinner()==DRAW_X.charAt(0)) {
                                    JOptionPane.showMessageDialog(getParent(), " Победил Игрок" );
                                    humanPoints++;
                                }
                                else{
                                    JOptionPane.showMessageDialog(getParent(), " Победил искуственный разум");
                                    computerPoints++;
                                }
                            }
                            else if(game.isGameOver()){
                                JOptionPane.showMessageDialog(getParent()," Ничья");
                            }
                        }
                    });
                }

                @Override
                public void paint(Graphics graphics) {
                    super.paint(graphics);
                    if (getActionCommand().equals(DRAW_O)) {
                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.setStroke(new BasicStroke(10));
                        g2d.setColor(Color.BLACK);
                        g2d.drawOval(10, 10, this.getWidth()-15, this.getWidth()-30);
                        g2d.setColor(Color.WHITE);
                        g2d.fillOval(10, 10, this.getWidth()-15, this.getWidth()-30);
                    }
                    else if (getActionCommand().equals(DRAW_X)) {
                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.setStroke(new BasicStroke(10));
                        g2d.setColor(Color.BLACK);
                        g2d.drawLine(10, 10, this.getWidth()-10, this.getHeight()-10);
                        g2d.drawLine(this.getWidth()-10, 10,  10, this.getHeight()-10);
                    }

                }
        };
    }

    private void changeDrawOnButton(int lastComputerTurnRow,int lastComputerTurnCol,ArrayList<JButton> buttons){
        String findName = ""+lastComputerTurnRow+lastComputerTurnCol;
        for (JButton button : buttons) {
            if(button.getName().equals(findName)&&button.getActionCommand().equals(DRAW_EMPTY)){
                button.setActionCommand(DRAW_O);
                button.setEnabled(false);
                button.repaint();
                return;
            }
        }
    }
}
