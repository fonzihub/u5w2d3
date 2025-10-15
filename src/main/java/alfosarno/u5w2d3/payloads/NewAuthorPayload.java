package alfosarno.u5w2d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewAuthorPayload {
    private String nome;
    private String cognome;
    private String email;
    private String dataDiNascita;
}
