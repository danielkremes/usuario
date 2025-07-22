package business.converter;

import business.dtos.EnderecosDTO;
import business.dtos.TelefoneDTO;
import business.dtos.UsuarioDTO;
import infraesctucure.entity.Enderecos;
import infraesctucure.entity.Telefone;
import infraesctucure.entity.Usuario;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Builder
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecos(usuarioDTO.getEnderecos()))
                .telefone(paraListaTelefone(usuarioDTO.getTelefone()))
                .build();
    }

    public List<Enderecos> paraListaEnderecos(List<EnderecosDTO> enderecosDTOS) {
        return enderecosDTOS.stream().map(
                this::paraEnderecos
        ).toList();
    }

    public Enderecos paraEnderecos(EnderecosDTO enderecosDTO) {
        return Enderecos.builder()
                .rua(enderecosDTO.getRua())
                .numero(enderecosDTO.getNumero())
                .complemento(enderecosDTO.getComplemento())
                .cidade(enderecosDTO.getCidade())
                .estado(enderecosDTO.getEstado())
                .cep(enderecosDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream()
                .map(this::paraTelefone)
                .toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    // converter entity para dtos
    public UsuarioDTO paraUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(paraListaEnderecosDTO(usuario.getEnderecos()))
                .telefone(paraListaTelefoneDTO(usuario.getTelefone()))
                .build();
    }

    public EnderecosDTO paraEnderecosDTO(Enderecos enderecos) {
        return EnderecosDTO.builder()
                .rua(enderecos.getRua())
                .numero(enderecos.getNumero())
                .complemento(enderecos.getComplemento())
                .cidade(enderecos.getCidade())
                .estado(enderecos.getEstado())
                .cep(enderecos.getCep())
                .build();
    }

    public List<EnderecosDTO> paraListaEnderecosDTO(List<Enderecos> enderecos) {
        return enderecos.stream()
                .map(this::paraEnderecosDTO)
                .toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefones) {
        return telefones.stream()
                .map(this::paraTelefoneDTO)
                .toList();
    }

}
