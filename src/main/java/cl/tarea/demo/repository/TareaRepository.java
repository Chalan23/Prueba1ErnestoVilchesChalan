package cl.tarea.demo.repository;

import cl.tarea.demo.model.Tarea;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepository {
    private List<Tarea> listaTareas = new ArrayList<>();

    public List<Tarea> obtenerTareas(){
        return listaTareas;
    }

    public Tarea buscarPorId(int id){
        for(Tarea tarea : listaTareas){
            if(tarea.getId() == id){
                return tarea;
            }
        }
        return null;
    }

    public Tarea buscarPorDescripcion(String descripcion){
        for(Tarea tarea : listaTareas){
            if(tarea.getDescripcion().equals(descripcion)){
                return tarea;
            }
        }
        return null;
    }

    public Tarea guardar(Tarea tar){
        listaTareas.add(tar);
        return tar;
    }

    public Tarea actualizar(Tarea tar){
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i < listaTareas.size(); i++){
            if(listaTareas.get(i).getId() == tar.getId()){
                id = tar.getId();
                idPosicion = i;
            }
        }
        Tarea tarea1 = new Tarea();
        tarea1.setId(id);
        tarea1.setDescripcion(tar.getDescripcion());
        tarea1.setEstadoDeLaTarea(tar.getEstadoDeLaTarea());
        tarea1.setPrioridad(tar.getPrioridad());
        tarea1.setFechaAsociada(tar.getFechaAsociada());

        listaTareas.set(idPosicion, tarea1);
        return tarea1;
    }

    public void eliminar(int id){
        Tarea tarea = buscarPorId(id);
        if(tarea != null){
            listaTareas.remove(tarea);
        }
    }
 

    public TareaRepository(){
        Tarea t = new Tarea();
        t.setId(1);
        t.setDescripcion("web");
        t.setEstadoDeLaTarea("listo");
        t.setPrioridad("alta");
        t.setFechaAsociada(2026);
        listaTareas.add(t);
    }


    public int totalTareas(){
        return listaTareas.size();
    }

    public Tarea buscarPorDescripcionV2(String descripcion){
       for(Tarea tarea : listaTareas){
            if(tarea.getDescripcion().equals(descripcion)){
                return tarea;
            }
        }
        return null;
    }
    
    public int cantidadTareasPorAnio(int anio){
        int contador = 0;
        
        for(Tarea tarea : listaTareas){
            if(tarea.getFechaAsociada() == anio){
                contador ++;
            }
        }
        return contador;
    }    

        public List<Tarea> buscarPorPrioridad(String prioridad){
        List<Tarea> resultado = new ArrayList<>();

        for(Tarea tarea : listaTareas){
            if(tarea.getPrioridad().equals(prioridad)){
                resultado.add(tarea);
            }
        }
        return resultado;
    }
    


}
