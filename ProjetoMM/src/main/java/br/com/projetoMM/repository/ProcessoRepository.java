package br.com.projetoMM.repository;

import br.com.projetoMM.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo,Long>{
    
}
