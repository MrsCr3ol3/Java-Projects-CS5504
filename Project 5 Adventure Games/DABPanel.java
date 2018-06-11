package edu.vt.cs5044;
  
 import java.awt.BorderLayout;
  
 import java.awt.FlowLayout;
  
 import java.awt.event.ActionEvent;
  
 import javax.swing.*;
  
 import static edu.vt.cs5044.DABGuiName.*;
  
 /**
  
  * This class represents the DotsAndBoxes in GUI. It defines the methods needed to manage a
  
  * two-player game of Dots And Boxes. The game is played on a matrix pattern of dots, with each dot
  
  * representing one vertex of a grid of neighboring, non-overlapping boxes. Each turn involves the
  
  * current player drawing a single line to connect any two unconnected adjacent dots, either
  
  * horizontally or vertically. Except on the outer-most grid boundaries, each line is shared between
  
  * two neighboring boxes. Players alternate the game; however if a Player completes a box then the
  
  * player who owns a box will get another turn immediately. If no box is completed then the turn
  
  * goes to the another player. The player who owns most boxes will get higher score and wins the
  
  * game.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Dec 7, 2017
  
  */
 public class DABPanel
  
     extends JPanel
  
 {
  private final DotsAndBoxes         game;
  private final JLabel               p1ScoreLabel;
  private final JLabel               p2ScoreLabel;
  private final JLabel               turnLabel;
  private final JComboBox<Integer>   xCombo;
  private final JComboBox<Integer>   yCombo;
  private final JComboBox<Direction> dirCombo;
  private final JButton              drawButton;
  private final DABGrid              dabGrid;
  /**
   * DABPanel Constructor creates the object.
   * @param frame
   *            this is the ActionEvent passed
   */
  public DABPanel(JFrame frame)
  {
      // add a menu bar to the frame that will contain this panel:
      frame.setJMenuBar(setupMenuBar());
      // create a new DotAndBoxes instance that will act as the game engine:
      game = new DABGame();
      // construct and name the user interface components; the names are needed for testing:
      xCombo = new JComboBox<>();
      xCombo.setName(X_COMBO);
      yCombo = new JComboBox<>();
      yCombo.setName(Y_COMBO);
      dirCombo = new JComboBox<>(Direction.values());
      dirCombo.setName(DIR_COMBO);
      drawButton = new JButton("Draw!");
      drawButton.setActionCommand("draw");
      drawButton.addActionListener(this::handleDrawButton);
      drawButton.setName(DRAW_BUTTON);
      turnLabel = new JLabel();
      turnLabel.setName(TURN_LABEL);
      p1ScoreLabel = new JLabel();
      p1ScoreLabel.setName(P1_SCORE_LABEL);
      p2ScoreLabel = new JLabel();
      p2ScoreLabel.setName(P2_SCORE_LABEL);
      dabGrid = new DABGrid(game);
      dabGrid.setName(DAB_GRID);
      // layout all of the user interface components:
      setupLayout();
      // begin a new 3x3 game by default:
      startGame(3);
  }
  /**
   * Handles the draw button of the Dots and Boxes. 
   * @param ae
   *            this is the ActionEvent passed
   */
  private void handleDrawButton(ActionEvent ae)
  {
      int x = xCombo.getItemAt(xCombo.getSelectedIndex());
      int y = yCombo.getItemAt(yCombo.getSelectedIndex());
      Direction dir = dirCombo.getItemAt(dirCombo.getSelectedIndex());
  
         Coordinate xy = new Coordinate(x, y);
     if (game.drawEdge(xy, dir))
     {
         updateStatus();
     }
 }
 /**
  * Updates and display the score of the player and the turn.
  */
 private void updateStatus()
 {
     p1ScoreLabel.setText("ONE: " + game.getScores().get(Player.ONE).toString());
     p2ScoreLabel.setText("TWO: " + game.getScores().get(Player.TWO).toString());
     if (game.getCurrentPlayer() == null)
     {
         turnLabel.setText("Game Over!");
         drawButton.setEnabled(false);
     }
     else
     {
         turnLabel.setText("Player " + game.getCurrentPlayer().toString() + " Go!");
     }
     repaint();
 }
 /**
  * Display the coordinates of X and Y axis according to the chosen grid size.
  */
 private void updateCombos()
 {
     if (game.getSize() == 4)
     {
         // x Coordinate
         xCombo.removeAllItems();
         xCombo.addItem(0);
         xCombo.addItem(1);
         xCombo.addItem(2);
         xCombo.addItem(3);
         // y Coordinate
         yCombo.removeAllItems();
         yCombo.addItem(0);
         yCombo.addItem(1);
         yCombo.addItem(2);
         yCombo.addItem(3);
     }
     else if (game.getSize() == 3)
     {
         // x Coordinate
         xCombo.removeAllItems();
         xCombo.addItem(0);
         xCombo.addItem(1);
         xCombo.addItem(2);
         // y Coordinate
         yCombo.removeAllItems();
         yCombo.addItem(0);
         yCombo.addItem(1);
         yCombo.addItem(2);
     }
     else
     {
         xCombo.removeAllItems();
         xCombo.addItem(0);
         xCombo.addItem(1);
         // y Coordinate
         yCombo.removeAllItems();
         yCombo.addItem(0);
  
             yCombo.addItem(1);
     }
 }
 /**
  * Initiate the size of the grid
  * 
  * @param size
  *            this is the size of the grid that is passed
  */
 private void startGame(int size)
 {
     drawButton.setEnabled(true);
     game.init(size);
     updateCombos();
     updateStatus();
 }
 /**
  * Set up the layout of the GUI Dots and Boxes
  */
 private void setupLayout()
 {
     JPanel dabPanel = new JPanel();
     dabPanel.setLayout(new BorderLayout());
     JPanel panelNorth = new JPanel();
     panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.PAGE_AXIS));
     JPanel panelSouth = new JPanel();
     panelSouth.setLayout(new BorderLayout());
     panelSouth.add(p1ScoreLabel, BorderLayout.LINE_START);
     panelSouth.add(p2ScoreLabel, BorderLayout.LINE_END);
     JPanel panelTop = new JPanel();
     panelTop.setLayout(new FlowLayout());
     panelTop.add(turnLabel);
     JPanel panelBottom = new JPanel();
     panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.LINE_AXIS));
     panelBottom.add(xCombo);
     panelBottom.add(yCombo);
     panelBottom.add(dirCombo);
     panelBottom.add(drawButton);
     panelNorth.add(panelTop);
     panelNorth.add(panelBottom);
     dabPanel.add(panelNorth, BorderLayout.PAGE_START);
     dabPanel.add(dabGrid, BorderLayout.CENTER);
     dabPanel.add(panelSouth, BorderLayout.PAGE_END);
     add(dabPanel);
 }
 /**
  * Set up the menu as per the Game mode and grid size
  * 
  * @return the menu after the setup
  */
 private JMenuBar setupMenuBar()
 {
     JMenuBar menuBar = new JMenuBar();
     JMenu gameMenu = new JMenu("Game");
     JMenu newMenu = new JMenu("New");
     JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("Interactive grid");
     JMenuItem menuItemNewGame2 = new JMenuItem("Size 2x2");
     newMenu.add(menuItemNewGame2);
     menuItemNewGame2.addActionListener(e -> startGame(2));
     JMenuItem menuItemNewGame3 = new JMenuItem("Size 3x3");
     newMenu.add(menuItemNewGame3);
     menuItemNewGame3.addActionListener(e -> startGame(3));
     JMenuItem menuItemNewGame4 = new JMenuItem("Size 4x4");
     newMenu.add(menuItemNewGame4);
     menuItemNewGame4.addActionListener(e -> startGame(4));
     gameMenu.add(newMenu);
     gameMenu.add(cbMenuItem);
     menuBar.add(gameMenu);
     cbMenuItem.addActionListener(e -> {
         if (cbMenuItem.isSelected())
         {
             dabGrid.setCallback(ea -> updateStatus());
         }
         else
         {
             dabGrid.setCallback(null);
         }
     });
     return menuBar;
 }
 /**
  * Boilerplate code; no changes required.
  */
 private static void createAndShowGUI()
 {
     JFrame frame = new JFrame("Dots And Boxes");
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     JComponent newContentPane = new DABPanel(frame);
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);
     frame.pack();
     frame.setVisible(true);
 }
 /**
  * Boilerplate code; no changes required.
  *
  * @param args
  *            ignored
  */
 public static void main(String[] args)
 {
     javax.swing.SwingUtilities.invokeLater(() -> {
         DABPanel.createAndShowGUI();
     });
 }
  
 }