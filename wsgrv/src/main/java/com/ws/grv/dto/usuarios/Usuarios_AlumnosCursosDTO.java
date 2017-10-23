package com.ws.grv.dto.usuarios;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuarios_AlumnosCursosDTO {
    @Getter
    @Setter
    public static class ListaCursosAreas {

        private int idCurso;
        private String curso;
        private int idArea;
        private String area;

        public ListaCursosAreas() {
        }

        public ListaCursosAreas(int idCurso, String curso, int idArea, String area) {
            this.idCurso = idCurso;
            this.curso = curso;
            this.idArea = idArea;
            this.area = area;
        }

    }
    
    private String email;
    private String nivel;
    private String grado;
    private String seccion;
    private List<ListaCursosAreas> listaCursosAreas;

    public Usuarios_AlumnosCursosDTO() {
    }

    public Usuarios_AlumnosCursosDTO(String email, String nivel, String grado, String seccion, List<ListaCursosAreas> listaCursosAreas) {
        this.email = email;
        this.nivel = nivel;
        this.grado = grado;
        this.seccion = seccion;
        this.listaCursosAreas = listaCursosAreas;
    }

}
