package com.pathfinder.mvc.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pathfinder.dao.PathfinderDao;
import com.pathfinder.dao.PathfinderDaoImp;
import com.pathfinder.model.Personaje;
import com.pathfinder.model.Raza;
import com.pathfinder.model.Usuario;

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
	
	@Override
	public List<Personaje> listPersonajesPorIdUsuario(int id) throws Exception {
		pathDao =PathfinderDaoImp.getInstance();
		return pathDao.ListPersonajeByUsuario(id);
	}
	
	@Override
	public List<Usuario> listUsuarios() throws Exception {
		pathDao =PathfinderDaoImp.getInstance();
		return pathDao.ListUsuario();
	}

	@Override
	public List<Raza> listRazas() throws Exception {
		pathDao =PathfinderDaoImp.getInstance();
		return  pathDao.ListRaza();
	}

	@Override
	public Usuario listUsuarioporID(int id) throws Exception {
		pathDao =PathfinderDaoImp.getInstance();
		return pathDao.ListUsuarioByid(id);
	}

	@Override
	public Raza listRazaporID(int id) throws Exception {
		pathDao =PathfinderDaoImp.getInstance();
		return pathDao.ListRazaByid(id);
	}

	
	
	
	

}
