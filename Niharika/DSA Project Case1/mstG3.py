import networkx as nx
import matplotlib.pyplot as plt

# Create a graph
G = nx.Graph()

# Add edges with weights to the graph
G.add_edge('0', '0', weight=1)
G.add_edge('0', '1', weight=2)
G.add_edge('0', '3', weight=6)
G.add_edge('1', '2', weight=2)
G.add_edge('1', '3', weight=4)
G.add_edge('2', '3', weight=2)
G.add_edge('3', '4', weight=2)
G.add_edge('4', '5', weight=2)
G.add_edge('2', '4', weight=5)

# Compute the minimum spanning tree
T = nx.minimum_spanning_tree(G)

# Draw the original graph
pos = nx.spring_layout(G)  # Positions of nodes
nx.draw(G, pos, with_labels=True, node_color='lightblue', node_size=500)

# Draw the minimum spanning tree
nx.draw_networkx_edges(G, pos, edgelist=T.edges(), width=2, edge_color='red')

# Add edge labels
edge_labels = nx.get_edge_attributes(G, 'weight')
nx.draw_networkx_edge_labels(G, pos, edge_labels=edge_labels)

# Show the graph
plt.show()
