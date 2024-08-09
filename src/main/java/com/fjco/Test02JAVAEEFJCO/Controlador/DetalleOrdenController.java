package com.fjco.Test02JAVAEEFJCO.Controlador;

import com.fjco.Test02JAVAEEFJCO.Modelo.DetalleOrdenFJCO;
import com.fjco.Test02JAVAEEFJCO.Modelo.OrdenFJCO;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IDetalleOrdenService;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IOrdenService;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/DetalleOrden")
public class DetalleOrdenController {
    @Autowired
    private IDetalleOrdenService detalleOrdenService;

    @Autowired
    private IOrdenService ordenService;

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<DetalleOrdenFJCO> detalles = detalleOrdenService.buscarTodosPaginados(pageable);
        model.addAttribute("detalles", detalles);

        int totalPages = detalles.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "DetalleOrden/index";
    }

    @GetMapping("/create")
    public String create(DetalleOrdenFJCO detalle, Model model){
        model.addAttribute("productos", productoService.obtenerTodos());
        model.addAttribute("ordenes", ordenService.obtenerTodos());
        return "DetalleOrden/create";
    }

    @PostMapping("/save")
    public String save(DetalleOrdenFJCO detalleFJCO, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(detalleFJCO);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "DetalleOrden/create";
        }

        detalleOrdenService.crearOEditar(detalleFJCO);
        attributes.addFlashAttribute("msg", "Detalle Orden creada correctamente");
        return "redirect:/DetalleOrden";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        DetalleOrdenFJCO detalleFJCO = detalleOrdenService.buscarPorId(id).get();
        model.addAttribute("detalle", detalleFJCO);
        model.addAttribute("productos", productoService.obtenerTodos());
        model.addAttribute("ordenes", ordenService.obtenerTodos());
        return "DetalleOrden/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        DetalleOrdenFJCO detalleFJCO = detalleOrdenService.buscarPorId(id).get();
        model.addAttribute("detalle",detalleFJCO);
        model.addAttribute("productos", productoService.obtenerTodos());
        model.addAttribute("ordenes", ordenService.obtenerTodos());
        return "DetalleOrden/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        DetalleOrdenFJCO detalleFJCO = detalleOrdenService.buscarPorId(id).get();
        model.addAttribute("detalle", detalleFJCO);
        model.addAttribute("productos", productoService.obtenerTodos());
        model.addAttribute("ordenes", ordenService.obtenerTodos());
        return "DetalleOrden/delete";
    }

    @PostMapping("/delete")
    public String delete(DetalleOrdenFJCO detalleFJCO, RedirectAttributes attributes){
        detalleOrdenService.eliminarPorId(detalleFJCO.getId());
        attributes.addFlashAttribute("msg", "Detalle Orden eliminada correctamente");
        return "redirect:/DetalleOrden";
    }
}
