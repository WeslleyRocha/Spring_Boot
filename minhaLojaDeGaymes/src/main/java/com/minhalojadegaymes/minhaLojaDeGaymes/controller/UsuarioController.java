package com.minhalojadegaymes.minhaLojaDeGaymes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhalojadegaymes.minhaLojaDeGaymes.modell.Usuario;
import com.minhalojadegaymes.minhaLojaDeGaymes.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	public UsuarioRepository repositorio;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll()
	{
		return ResponseEntity.ok(repositorio.findAll());
	}

	
	@GetMapping("/id")
	public ResponseEntity<Usuario> getById(@PathVariable long id)
	{
		return repositorio.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(usuario));
	}
	
	
	@PutMapping
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario)
	{
		return ResponseEntity.ok(repositorio.save(usuario));
	}
	
	
	
	@DeleteMapping("/id")
	public void delete (@PathVariable long id)
	{
		repositorio.deleteById(id);
	}
	
}