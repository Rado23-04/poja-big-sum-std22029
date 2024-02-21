package com.poja.bigsum.endpoint.rest.controller.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.awt.Color;

import java.net.URL;
@RestController
public class image {
    @GetMapping("/noir-blanc")
    @ResponseBody
    public BufferedImage generateNoirBlancImage() {
        try {
            // Remplacez l'URL par l'URL réelle de votre image
            URL imageUrl = new URL("https://www.bing.com/images/search?view=detailV2&ccid=Z5TtqaFv&id=C0BFC66981D5B8085C5472AFE5A831D662D45CED&thid=OIP.Z5TtqaFv6e62qkU3Ye0GNQHaFj&mediaurl=https%3a%2f%2fth.bing.com%2fth%2fid%2fR.6794eda9a16fe9eeb6aa453761ed0635%3frik%3d7VzUYtYxqOWvcg%26riu%3dhttp%253a%252f%252fwww.maximumwall.com%252fwp-content%252fuploads%252f2016%252f10%252ffond-ecran-wallpaper-image-abstrait-noir-et-blanc-02.jpg%26ehk%3due4jT5mhpMX9L7i4vHRiELxpLF%252b%252fMRKj8gZSvoejpVY%253d%26risl%3d%26pid%3dImgRaw%26r%3d0&exph=1920&expw=2560&q=image+noir+et+blanc&simid=608017574220290888&FORM=IRPRST&ck=39CC4DE9271136CF4F2929DBA911EE9E&selectedIndex=5&itb=0&ajaxhist=0&ajaxserp=0");
            InputStream inputStream = imageUrl.openStream();

            // Lire l'image depuis l'entrée
            BufferedImage image = ImageIO.read(inputStream);

            // Fermer la connexion
            inputStream.close();

            // Convertir l'image en noir et blanc
            return convertirEnNoirBlanc(image);
        } catch (IOException e) {
            e.printStackTrace();
            // Gérer les erreurs de manière appropriée dans votre application
            return null;
        }
    }

    private BufferedImage convertirEnNoirBlanc(BufferedImage image) {
        int largeur = image.getWidth();
        int hauteur = image.getHeight();

        BufferedImage imageNoirBlanc = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                // Obtenir la couleur du pixel
                Color couleurPixel = new Color(image.getRGB(x, y));

                // Calculer la moyenne des composantes rouge, verte et bleue
                int moyenne = (couleurPixel.getRed() + couleurPixel.getGreen() + couleurPixel.getBlue()) / 3;

                // Créer une nouvelle couleur avec la moyenne calculée
                Color couleurNoirBlanc = new Color(moyenne, moyenne, moyenne);

                // Définir la nouvelle couleur pour le pixel dans l'image en noir et blanc
                imageNoirBlanc.setRGB(x, y, couleurNoirBlanc.getRGB());
            }
        }

        return imageNoirBlanc;
    }
}
