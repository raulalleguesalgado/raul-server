package Entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="coleccion", uniqueConstraints = {@UniqueConstraint(name = "uq_coleccion_nombre", columnNames = "nombre")})


public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	 @NotBlank private String nombre;
	 @NotBlank private String publicador;
	 
}
