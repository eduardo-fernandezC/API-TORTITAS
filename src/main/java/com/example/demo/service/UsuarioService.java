package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id).orElse(null);
        if (usuarioToUpdate != null) {
            usuarioToUpdate.setNombre(usuario.getNombre());
            usuarioToUpdate.setApellido(usuario.getApellido());
            usuarioToUpdate.setEmail(usuario.getEmail());
            usuarioToUpdate.setContrasenia(usuario.getContrasenia());
            usuarioToUpdate.setTelefono(usuario.getTelefono());
            usuarioToUpdate.setRol(usuario.getRol());
            usuarioToUpdate.setDireccionPrincipal(usuario.getDireccionPrincipal());
            return usuarioRepository.save(usuarioToUpdate);
        }
        return null;
    }

    public Usuario patch(Long id, Usuario usuario) {
        Usuario usuarioToPatch = usuarioRepository.findById(id).orElse(null);
        if (usuarioToPatch != null) {
            if (usuario.getNombre() != null) usuarioToPatch.setNombre(usuario.getNombre());
            if (usuario.getApellido() != null) usuarioToPatch.setApellido(usuario.getApellido());
            if (usuario.getEmail() != null) usuarioToPatch.setEmail(usuario.getEmail());
            if (usuario.getContrasenia() != null) usuarioToPatch.setContrasenia(usuario.getContrasenia());
            if (usuario.getTelefono() != null) usuarioToPatch.setTelefono(usuario.getTelefono());
            if (usuario.getRol() != null) usuarioToPatch.setRol(usuario.getRol());
            if (usuario.getDireccionPrincipal() != null) usuarioToPatch.setDireccionPrincipal(usuario.getDireccionPrincipal());
            return usuarioRepository.save(usuarioToPatch);
        }
        return null;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
