🚇 Delhi Metro Route Planner

This project is a Java-based Delhi Metro Route Planner that models the Delhi Metro network using graph data structures and provides a GUI for users to find the shortest distance and shortest travel time between metro stations. It combines data structures like heaps and graphs with Dijkstra's algorithm to determine optimal routes.



🧾 About the Project

The Delhi Metro Route Planner provides users with:

A console interface to perform operations like viewing stations, displaying the metro map, and calculating the shortest route.

A graphical interface using Java Swing to enhance usability.

Accurate distance and time estimations using Dijkstra’s algorithm and custom heap implementation.



✨ Features

📍 List and browse all metro stations

🗺️ Visualize the entire Delhi Metro map

🔢 Calculate shortest distance between two stations

⏱️ Estimate shortest time to travel between stations

🔁 Detect and count interchanges

🖥️ Console-based and GUI-based interaction

💡 Graph and heap implementations from scratch


🛠 Technologies Used

Language: Java

UI Library: Java Swing (JFrame, JPanel, JComboBox, etc.)

Algorithms: Dijkstra’s Algorithm

Custom Data Structures: Graph, Heap

IDE Recommendation: IntelliJ IDEA / Eclipse



🔍 How It Works

The metro map is implemented as an undirected, weighted graph where:

    Vertices = Metro stations

    Edges = Direct routes with weights (in km)

Heap.java provides a custom min-heap used in Dijkstra’s algorithm.

Dijkstra’s algorithm is implemented for both distance and time optimization.

GUI allows interactive selection of source and destination stations to compute shortest paths.


