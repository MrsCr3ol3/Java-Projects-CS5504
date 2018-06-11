package edu.vt.cs5044;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import static edu.vt.cs5044.DABGuiName.*;

public class DABPanel extends JPanel {

    private final DotsAndBoxes game;

    private final JLabel p1ScoreLabel;
    private final JLabel p2ScoreLabel;
    private final JLabel turnLabel;
    private final JComboBox<Integer> xCombo;
    private final JComboBox<Integer> yCombo;
    private final JComboBox<Direction> dirCombo;
    private final JButton drawButton;
    private final DABGrid dabGrid;

    public DABPanel(JFrame frame) {

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

        drawButton = new JButton();
        // TODO: set the text to be displayed on the draw button
        // TODO: use a method reference to add handleDrawButton() as a listener to the draw button
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

    private void handleDrawButton(ActionEvent ae) {
        // TODO: the draw button click handler code goes here
    }

    private void updateStatus() {
        // TODO: read the game status via accessors; set each label component's text accordingly
        // TODO: don't forget to also disable the draw button if the game is over
    }

    private void updateCombos() {
        // TODO: update the coordinate combo box options, based on the size of the grid
    }

    private void startGame(int size) {
        // TODO: start a new game; use updateCombos() and updateStatus() to help
    }

    private void setupLayout() {
        // TODO: layout this panel and all its components
    }

    private JMenuBar setupMenuBar() {
        // TODO: create the menu bar and populate it with items
        // TODO: use lambda expressions so the new game items call startGame() when clicked
        // TODO: use lambda expressions to handle activating and deactivating interactive mode
        return null; // TODO: replace this placeholder
    }

    /**
     * Boilerplate code; no changes required.
     */
    private static void createAndShowGUI() {
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
     * @param args ignored
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            DABPanel.createAndShowGUI();
        });
    }

}
