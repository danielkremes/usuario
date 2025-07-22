package business.service;

import business.converter.UsuarioConverter;
import business.dtos.UsuarioDTO;
import infraesctucure.entity.Usuario;
import infraesctucure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioConverter.paraUsuarioDTO(usuario);
    }


}
