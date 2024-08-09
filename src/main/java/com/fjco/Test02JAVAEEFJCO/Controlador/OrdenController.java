package com.fjco.Test02JAVAEEFJCO.Controlador;

import com.fjco.Test02JAVAEEFJCO.Modelo.OrdenFJCO;
import com.fjco.Test02JAVAEEFJCO.Servicios.Interfaces.IOrdenService;
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
@RequestMapping("/Orden")
public class OrdenController {
    @Autowired
    private IOrdenService ordenService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<OrdenFJCO> ordenes = ordenService.buscarTodosPaginados(pageable);
        model.addAttribute("ordenes", ordenes);

        int totalPages = ordenes.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Orden/index";
    }

    @GetMapping("/create")
    public String create(OrdenFJCO orden){
        return "Orden/create";
    }

    @PostMapping("/save")
    public String save(OrdenFJCO ordenFJCO, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(ordenFJCO);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Orden/create";
        }

        ordenService.crearOEditar(ordenFJCO);
        attributes.addFlashAttribute("msg", "Orden creada correctamente");
        return "redirect:/Orden";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        OrdenFJCO ordenFJCO = ordenService.buscarPorId(id).get();
        model.addAttribute("orden", ordenFJCO);
        return "Orden/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        OrdenFJCO ordenFJCO = ordenService.buscarPorId(id).get();
        model.addAttribute("orden", ordenFJCO);
        return "Orden/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        OrdenFJCO ordenFJCO = ordenService.buscarPorId(id).get();
        model.addAttribute("orden", ordenFJCO);
        return "Orden/delete";
    }

    @PostMapping("/delete")
    public String delete(OrdenFJCO ordenFJCO, RedirectAttributes attributes){
        ordenService.eliminarPorId(ordenFJCO.getId());
        attributes.addFlashAttribute("msg", "Orden eliminada correctamente");
        return "redirect:/Orden";
    }
}
