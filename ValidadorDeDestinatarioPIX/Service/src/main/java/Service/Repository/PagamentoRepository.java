package Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Service.Model.Pagamento;
import java.util.List;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {


    Pagamento  findByChavePix(String chavePix);
    
} 
