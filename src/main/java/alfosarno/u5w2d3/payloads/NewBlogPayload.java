package alfosarno.u5w2d3.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class NewBlogPayload {
private String categoria;
private String titolo;
private String contenuto;
private UUID authorId;
}
