package dataFactory;

import modulos.pojo.UsuarioPojo;

public class UsuarioDataFactort {
    public  static UsuarioPojo criarUsuarioConvencional()
    {
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuariologin("felipe.meyer");
        usuario.setUsuariosenha("12345");
        return usuario;
    }
}
