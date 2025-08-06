package zielinskin.common.web;


import org.springframework.web.bind.annotation.*;
import zielinskin.common.logic.CrudService;

import java.util.List;

public abstract class AbstractCrudController<V, ID, S extends CrudService<V, ID>> {
    protected final S service;

    public AbstractCrudController(S service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody V view) {
        service.save(view);
    }

    @GetMapping()
    public List<V> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public V get(@PathVariable ID id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, value = "/bulk")
    public void saveBulk(@RequestBody List<V> view) {
        service.save(view);
    }
}
