package ru.igorlo.Visualisation

import org.graphstream.graph.Edge
import org.graphstream.graph.Graph
import org.graphstream.graph.Node
import org.graphstream.graph.implementations.SingleGraph
import ru.igorlo.generation.DBConnector
import kotlin.random.Random


object GraphVisualiser {

    private val connection = DBConnector()

    fun main() {

        connection.newConnection()

        val nodes = mutableListOf<GLocation>()
        val edges = mutableListOf<GRoad>()

        val nodeSet = connection.getResultSetOfSelect("locations", 0, "", "id", "name", "x_coord", "y_coord")
        while (nodeSet.next()) {
            nodes.add(
                GLocation(
                    nodeSet.getString("name"),
                    nodeSet.getInt("id"),
                    nodeSet.getInt("x_coord"),
                    nodeSet.getInt("y_coord")
                )
            )
        }

        val edgeSet = connection.getResultSetOfSelect("connections", 0, "", "fk_from_location", "fk_to_location")
        while (edgeSet.next()) {
            edges.add(
                GRoad(
                    edgeSet.getInt("fk_from_location"),
                    edgeSet.getInt("fk_to_location")
                )
            )
        }

        val graph: Graph = SingleGraph("Map")

        graph.addAttribute("ui.quality")
        graph.addAttribute("ui.antialias")
        graph.addAttribute(
            "ui.stylesheet", "graph {" +
                    "fill-color: black;" +
                    "}" +
                    "node {" +
                    "text-color: white;" +
                    "text-size: 18px;" +
                    "}"
        )

        val viewer = graph.display(false)
        val view = viewer.defaultView
        view.resizeFrame(800, 600)

        for (node in nodes) {
            val gnode = graph.addNode<Node>(node.id.toString())
            gnode.addAttribute("ui.label", node.name)
            gnode.setAttribute("xyz", node.x_coord, node.y_coord, 0)
            gnode.addAttribute(
                "ui.style",
                "fill-color: rgb(${Random.nextInt(255)},${Random.nextInt(255)},${Random.nextInt(255)});"
            )
        }

        for (edge in edges) {
            val gedge = graph.addEdge<Edge>("${edge.from}-${edge.to}", "${edge.to}", "${edge.from}")
            gedge.addAttribute(
                "ui.style",
                "fill-color: rgb(${Random.nextInt(100)},${Random.nextInt(100)},${Random.nextInt(100)});\n"
            )
        }

        Thread.sleep(10000000)

    }
}