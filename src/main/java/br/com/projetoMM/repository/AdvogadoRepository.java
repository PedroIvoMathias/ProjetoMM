package br.com.projetoMM.repository;

import br.com.projetoMM.model.Advogado;
import br.com.projetoMM.model.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvogadoRepository extends JpaRepository <Advogado, Long> {
    @Query("SELECT p FROM Pessoa p WHERE p.Nome = :Nome OR p.Email = :Email")
    public List<Pessoa> findByNomeOrEmail(@Param("Nome") String Nome,@Param("Email") String Email);
    
    //public Advogado findByCarteiraOAB(String CarteiraOAB);
    
}
