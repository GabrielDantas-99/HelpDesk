package com.gabriel.api.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gabriel.api.domain.Chamado;
import com.gabriel.api.domain.Cliente;
import com.gabriel.api.domain.Tecnico;
import com.gabriel.api.domain.enums.Perfil;
import com.gabriel.api.domain.enums.Prioridade;
import com.gabriel.api.domain.enums.Status;
import com.gabriel.api.repositories.ChamadoRepository;
import com.gabriel.api.repositories.ClienteRepository;
import com.gabriel.api.repositories.TecnicoRepository;

@Service
public class DBService {

    @Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

    public void instanciaDB() {

        Tecnico t1 = new Tecnico(null, "Gabriel", "352.914.470-36", "gabriel@gmail.com", encoder.encode("123456"));
		t1.addPerfil(Perfil.ADMIN);
		Tecnico t2 = new Tecnico(null, "Vitor", "771.310.200-01", "vitor@gmail.com", encoder.encode("12324324"));
		Tecnico t3 = new Tecnico(null, "Ruan", "798.003.230-66", "ruan@gmail.com", encoder.encode("12354252"));
		Tecnico t4 = new Tecnico(null, "Emerson", "873.480.280-04", "emerson@gmail.com", encoder.encode("12345235"));
		Tecnico t5 = new Tecnico(null, "Thiago", "393.578.290-08", "thiago@gmail.com", encoder.encode("12352341"));

		Cliente c1 = new Cliente(null, "Rafael", "665.661.230-08", "rafael@gmail.com", encoder.encode("123345gw"));
		Cliente c2 = new Cliente(null, "Diego", "657.359.730-37", "diego@gmail.com", encoder.encode("123eg34"));
		Cliente c3 = new Cliente(null, "Kauan", "223.547.280-00", "kauan@gmail.com", encoder.encode("fgw5123"));
		Cliente c4 = new Cliente(null, "Thales", "876.501.560-60", "thales@gmail.com", encoder.encode("12343tw"));


		Chamado ch1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", t1, c1);
		Chamado ch2 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 02", "Segundo chamado", t2, c2);
		Chamado ch3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Chamado 03", "Terceiro chamado", t2, c2);
		
		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		chamadoRepository.saveAll(Arrays.asList(ch1, ch2, ch3));

    }
    
}
