package cl.tarea.demo.service;

import cl.tarea.demo.model.Tarea;
import cl.tarea.demo.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getTareas(){
        return tareaRepository.obtenerTareas();
    }

    public Tarea saveTarea(Tarea tarea){
        return tareaRepository.guardar(tarea);
    }

    public Tarea getTareaId(int id){
        return tareaRepository.buscarPorId(id);
    }

    public Tarea updaTarea(Tarea tarea){
        return tareaRepository.actualizar(tarea);
    }

    public String dalateTarea(int id){
        tareaRepository.eliminar(id);
        return "Tarea Eliminada";
    }

    public int totalTareasV1(){
        return tareaRepository.obtenerTareas().size();
    }
 
    public int totalTareasV2(){
        return tareaRepository.totalTareas();
    }

}
