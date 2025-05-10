import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetroAppGUI extends JFrame {
    private Graph_M metro;
    private JComboBox<String> sourceStation;
    private JComboBox<String> destStation;
    private JTextArea resultArea;

    public MetroAppGUI() {
        metro = new Graph_M();
        Graph_M.Create_Metro_Map(metro);
        
        setTitle("Delhi Metro App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        // Get all station names
        String[] stations = metro.vtces.keySet().toArray(new String[0]);
        
        // Create components
        sourceStation = new JComboBox<>(stations);
        destStation = new JComboBox<>(stations);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        
        // Add components to input panel
        inputPanel.add(new JLabel("Source Station:"));
        inputPanel.add(sourceStation);
        inputPanel.add(new JLabel("Destination Station:"));
        inputPanel.add(destStation);
        
        // Create buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        JButton findDistanceBtn = new JButton("Find Shortest Distance");
        JButton findTimeBtn = new JButton("Find Shortest Time");
        JButton showMapBtn = new JButton("Show Metro Map");
        
        buttonPanel.add(findDistanceBtn);
        buttonPanel.add(findTimeBtn);
        buttonPanel.add(showMapBtn);
        
        // Add action listeners
        findDistanceBtn.addActionListener(e -> findShortestDistance());
        findTimeBtn.addActionListener(e -> findShortestTime());
        showMapBtn.addActionListener(e -> showMetroMap());
        
        // Add panels to main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);
        
        // Add main panel to frame
        add(mainPanel);
        setLocationRelativeTo(null);
    }
    
    private void findShortestDistance() {
        String source = (String) sourceStation.getSelectedItem();
        String destination = (String) destStation.getSelectedItem();
        
        if (source.equals(destination)) {
            resultArea.setText("Source and destination stations are same!");
            return;
        }
        
        int distance = metro.dijkstra(source, destination, false);
        resultArea.setText("Shortest distance from " + source + " to " + destination + " is " + distance + " KM");
    }
    
    private void findShortestTime() {
        String source = (String) sourceStation.getSelectedItem();
        String destination = (String) destStation.getSelectedItem();
        
        if (source.equals(destination)) {
            resultArea.setText("Source and destination stations are same!");
            return;
        }
        
        int time = metro.dijkstra(source, destination, true);
        resultArea.setText("Shortest time from " + source + " to " + destination + " is " + (time/60) + " minutes");
    }
    
    private void showMetroMap() {
        StringBuilder map = new StringBuilder();
        map.append("Delhi Metro Map\n");
        map.append("----------------\n");
        
        for (String station : metro.vtces.keySet()) {
            map.append(station).append(" -> ");
            Graph_M.Vertex vtx = metro.vtces.get(station);
            for (String nbr : vtx.nbrs.keySet()) {
                map.append(nbr).append("(").append(vtx.nbrs.get(nbr)).append("km) ");
            }
            map.append("\n");
        }
        
        resultArea.setText(map.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MetroAppGUI app = new MetroAppGUI();
            app.setVisible(true);
        });
    }
}