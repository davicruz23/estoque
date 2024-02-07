package dtec.com.estoque.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SQLDelete(sql = "UPDATE produto SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
public class Estoque extends AbstractEntity{

    String nome;
    String cor;
    String marca;
    Integer quantidade;
    float preço;


    @Override
    public void partialUpdate(AbstractEntity e) {
        if (e instanceof Estoque estoque){
            this.nome = estoque.nome;
            this.cor = estoque.cor;
            this.marca = estoque.marca;
            this.quantidade = estoque.quantidade;
            this.preço = estoque.preço;
        }

    }

    @Data
    public static class DtoRequest {
        @NotBlank(message = "Nome em Branco")
        String nome;
        @NotBlank(message = "Cor em Branco")
        String cor;
        @NotBlank(message = "Marca em Branco")
        String marca;
        @NotBlank(message = "Quantidade em Branco")
        Integer quantidade;
        @NotBlank(message = "Preço em branco")
        float preço;

        public static Estoque convertToEntity(Estoque.DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Estoque.class);
        }
    }
    @Data
    public static class DtoResponse extends RepresentationModel<Estoque.DtoResponse> {
        String nome;
        String cor;
        String marca;
        Integer quantidade;
        float preço;

        public static DtoResponse convertToDto(Estoque e, ModelMapper mapper){
            return mapper.map(e, Estoque.DtoResponse.class);
        }
    }
}
