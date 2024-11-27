package com.romulo.controlegasto.repositories;

import com.romulo.controlegasto.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, UUID> {
    //Optional<Categoria>: Retorna uma categoria opcional. Pode estar presente ou vazio.
    //Lembrete que todos os metodos criados nos repository sao personalizados findByNome(),os demais que estão sendo
    //usados no service como save;delete; findAll; etc sao metodos padrão herdados.
    Optional<CategoriaModel> findByNome(String nome);
}
