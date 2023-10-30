package med.voll.api.controller;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import med.voll.api.paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
		
		repository.save(new Paciente(dados));
	}

	@GetMapping
	public Page<DadosListagemPaciente> listar(Pageable pagina){
		return repository.findAll(pagina).map(DadosListagemPaciente::new);


	}
	

}
