package br.com.tradetechnology.testeqa.helpers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

import org.apache.commons.io.FileUtils;

import br.com.tradetechnology.testeqa.dto.Measurement;
import br.com.tradetechnology.testeqa.dto.Product;
import br.com.tradetechnology.testeqa.dto.ProductType;

public class ProductHelper {

    public Product buildProduct() throws MalformedURLException, IOException {
        Faker faker = new Faker();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Path resourceDirectory = Paths.get("src", "test", "resources");

        String productImageFilePath = resourceDirectory.toFile().getAbsolutePath() + File.separator
                + "product_image.png";

        String fakeImageUrl = faker.company().logo();

        FileUtils.copyURLToFile(new URL(fakeImageUrl), new File(productImageFilePath));

        return new Product(String.format("%1.20s", faker.commerce().productName()),
                String.format("%1.10s", faker.company().name()),
                dateFormat.format(faker.date().future(faker.number().numberBetween(60, 365), TimeUnit.DAYS)),
                faker.number().randomDouble(2, 50, 500), String.format("%1.10s", faker.food().spice()), "Bebida",
                faker.number().numberBetween(10, 100), faker.number().numberBetween(100, 200), Measurement.getRandom(),
                ProductType.getRandom(), faker.number().randomDouble(2, 1, 100), faker.number().numberBetween(1, 100),
                productImageFilePath);
    }

}
