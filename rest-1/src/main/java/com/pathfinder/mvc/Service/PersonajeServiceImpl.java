package com.pathfinder.mvc.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pathfinder.dao.PathfinderDao;
import com.pathfinder.dao.PathfinderDaoImp;
import com.pathfinder.model.Personaje;

@Service("personajeservice")
public class PersonajeServiceImpl implements PersonajeService {

	private PathfinderDaoImp pathDao ;

	@Override
	public List<Personaje> listAllPersonajes() throws Exception {
		pathDao = PathfinderDaoImp.getInstance();
		return pathDao.ListPersonajes();
	}

	@Override
	public List<Personaje> listAllPersonajesporID(int id) throws Exception {
		pathDao =PathfinderDaoImp.getInstance();
		return pathDao.ListPersonajeByid(id);
	}

}
