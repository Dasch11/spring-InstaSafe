package com.ista.springboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.models.dao.IUsuarioDao;
import com.ista.springboot.web.app.models.entity.Usuario;




@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByCedula(String cedula) {
        return usuarioDao.findByCedula(cedula).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario findByCorreo(String correo) {
        return usuarioDao.findByCorreo(correo).orElse(null);
    }

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		usuarioDao.deleteById(id);
}

	@Override
	public Usuario actualizarPlantillaFacial(Long id, String plantillaFacial) {
	    Usuario usuario = usuarioDao.findById(id).orElse(null);
	    if (usuario != null) {
	        usuario.setPlantillaFacial(plantillaFacial);
	        return usuarioDao.save(usuario);
	    }
	    return null;
	}

	@Override
	public Usuario findByCorreoAndContrasena(String correo, String contrasena) {
		return usuarioDao.findByCorreoAndContrasena(correo, contrasena).orElse(null);
	}
	
	 @Override
	  @Transactional
	  public Usuario actualizarFotoGoogle(String correo, String fotoGoogle) {
	    Usuario u = usuarioDao.findByCorreo(correo).orElse(null);
	    if (u == null) throw new RuntimeException("Usuario no encontrado");
	    u.setFotoGoogle(fotoGoogle);
	    return usuarioDao.save(u);
	  }
	
}