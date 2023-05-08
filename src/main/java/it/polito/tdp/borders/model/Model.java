package it.polito.tdp.borders.model;

import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

import org.jgrapht.graph.DefaultEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.*;
import org.jgrapht.alg.connectivity.ConnectivityInspector;

public class Model {
	
	private Graph<Country,DefaultEdge> grafo;
	private List<Border> borders;
	private BordersDAO dao;
	private Map<Integer, Country> idMap;

	public Model() {
		grafo = new SimpleGraph<>(DefaultEdge.class);
		borders = new ArrayList<>();
		dao = new BordersDAO();
		idMap = new HashMap<>();
		
	}
	
	public void loadNodes() {
		if(idMap.isEmpty()) {
			for(Country c: dao.loadAllCountries()) {
				idMap.put(c.getCCode(), c);
			}
		}
	}
	
	public void createGraph(int anno) {
		this.loadNodes();
		borders = dao.getCountryPairs(anno);
		Graphs.addAllVertices(grafo, idMap.values());
		for(Border bd: borders) {
			Graphs.addEdgeWithVertices(grafo, idMap.get(bd.getState1no()), idMap.get(bd.getState2no()));
		}
		System.out.println(grafo.vertexSet().size());
		System.out.println(grafo.edgeSet().size());
	}
	
	public Map<Country, Integer> calcolaGradoVertici(){
		Map<Country, Integer> gradiMap = new HashMap<>();
		for(Country c: grafo.vertexSet()) {
			gradiMap.put(c, grafo.degreeOf(c));
		}
		return gradiMap;
	}
	
	public int calcolaConnesse() {
		ConnectivityInspector<Country, DefaultEdge> inspector = new ConnectivityInspector<>(grafo);
		return inspector.connectedSets().size();
	}

}
