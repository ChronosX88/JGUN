package io.github.chronosx88.GunJava;

import org.json.JSONObject;

import java.util.*;

public class Graph {

    private final HashMap<String, Node> nodes;

    public Graph(JSONObject source) {
        nodes = new LinkedHashMap<>();

        for (String soul : source.keySet())
            nodes.put(soul, new Node(source.getJSONObject(soul)));
    }

    public Graph() {
        nodes = new LinkedHashMap<>();
    }

    public Node getNode(String soul) {
        return nodes.getOrDefault(soul, null);
    }

    public void addNode(String soul, Node incomingNode) {
        nodes.put(soul, incomingNode);
    }

    public boolean hasNode(String soul) {
        return nodes.containsKey(soul);
    }

    public Set<Map.Entry<String, Node>> entries() {
        return nodes.entrySet();
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, Node> entry : nodes.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue().toJSONObject());
        }
        return jsonObject.toString();
    }

    public String toPrettyString() {
        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, Node> entry : nodes.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue().toJSONObject());
        }
        return jsonObject.toString(2);
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObject = new JSONObject();
        for(Map.Entry<String, Node> entry : nodes.entrySet()) {
            jsonObject.put(entry.getKey(), entry.getValue().toJSONObject());
        }
        return jsonObject;
    }
}