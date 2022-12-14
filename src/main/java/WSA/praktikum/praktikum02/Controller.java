/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WSA.praktikum.praktikum02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/next")
    public String next(@RequestParam(value = "varA") String isipertama,
            @RequestParam(value = "varB")
            @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
            @RequestParam(value = "foto") MultipartFile isiketiga,
            @RequestParam(value = "varC") String isikeempat,
            Model kurir
            
    )throws IOException{  
        SimpleDateFormat newTanggal = new SimpleDateFormat("EE-dd-MMMM-yyyy");
        String isikedua = newTanggal.format(date);
        byte[] img = isiketiga.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink= "data:image/png;base64,".concat(base64Image);
        kurir.addAttribute("paket1", isipertama);
        kurir.addAttribute("paket2", isikedua);
        kurir.addAttribute("paket3", imglink);
        kurir.addAttribute("paket4", isikeempat);
        
        return "viewpage";
    }
    
}