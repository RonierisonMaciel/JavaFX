package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Departamento;

public class DepartamentoService {
	
	public List<Departamento> findAll(){
		List<Departamento> list = new ArrayList<>();
		list.add(new Departamento(1, "�gua"));
		list.add(new Departamento(2, "Caf�"));
		list.add(new Departamento(3, "A��car"));
		
		return list;
	}

}