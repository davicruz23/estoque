package dtec.com.estoque.domain;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Funcionarios extends AbstractEntity{

    String nome;
    String cpf;
    String datanasci;
    String telefone;

    @Override
    public void partialUpdate(AbstractEntity e) {
        if(e instanceof Funcionarios funcionarios){
            this.nome = funcionarios.nome;
            this.cpf = funcionarios.cpf;
            this.datanasci = funcionarios.datanasci;
            this.telefone = funcionarios.telefone;
        }
    }

    @Data
    public static class DtoRequest {
        @NotBlank(message = "Nome em Branco")
        String nome;
        @NotBlank(message = "CPF em Branco")
        String cpf;
        @NotBlank(message = "Data de Nascimento em Branco")
        String datanasci;
        @NotBlank(message = "Telefone em Branco")
        Integer telefone;

        public static Funcionarios convertToEntity(Funcionarios.DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Funcionarios.class);
        }
    }

    @Data
    public static class DtoResponse extends RepresentationModel<DtoResponse> {
        String nome;
        String cpf;
        String datanasci;
        String telefone;

        public static DtoResponse convertToDto(Funcionarios f, ModelMapper mapper){
            return mapper.map(f, DtoResponse.class);
        }
    }
}
