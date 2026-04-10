package cl.tarea.demo.controller;

import cl.tarea.demo.model.Tarea;
import cl.tarea.demo.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")

public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea>listaTareas(){
        return tareaService.getTareas();
    }

    @PostMapping
    public Tarea agregTarea(@RequestBody Tarea tarea){
        return tareaService.saveTarea(tarea);
    }

    @GetMapping("/{id}/")
    public Tarea buscarTarea(@PathVariable int id){
        return tareaService.getTareaId(id);
    }

    @PutMapping("/{id}/")
    public Tarea actualizarTarea(@PathVariable int id, @RequestBody Tarea tarea){
        return tareaService.updaTarea(tarea);
    }
    
    @DeleteMapping("/{id}/")
    public String eliminarTarea(@PathVariable int id){
        return tareaService.dalateTarea(id);
    }

    @GetMapping("/total")
    public int totalTareasV2(){
        return tareaService.totalTareasV2();
    }

}
